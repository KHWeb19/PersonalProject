package com.example.demo.service.plan;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.request.*;
import com.example.demo.response.FriendMemberResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MakePlanServiceImpl implements MakePlanService{

    @Autowired
    MakePlanRepository planRepository;

    @Autowired
    JoinMemberRepository memberRepository; // 계획을 만든 사람을 가지고 온다.

    @Autowired
    MemberPlanRepository memberPlanRepository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    VoteResultGoodRepository voteResultGoodRepository;

    @Autowired
    VoteResultBadRepository voteResultBadRepository;

    @Transactional
    @Override
    public void make(List<String> fileName, String planName, String planDate, String placeName, String id) { // 계획을 db에 저장을함.
        //log.info(String.valueOf(memberPlanRequest));

        Member member = memberRepository.findByMemberNo(id);

        MemberPlan memberPlan = MemberPlan.createMemberPlan(member);

        Plan planEntity = Plan.createPlan(planName, planDate, placeName, fileName.get(0), memberPlan);

        //Member memberEntity = Member.c(member, memberPlan);

        // 넘어온 plan db에 저장.
        planRepository.save(planEntity);
        //memberRepository.save(memberEntity);

        // 엔티티 조회

        //Plan plan = planRepository.findByPlan(planEntity.getPlanNo());

        // MemberPlan memberPlanEntity = new MemberPlan(member, plan);

        // Member memberPlan = Member.createMember(memberPlanEntity);

        // memberRepository.save(memberPlan);

        // Optional<Plan> planNo = planRepository.findByPlanNo(memberPlanRequest.get) // 여기서 planNo를 찾을수가 없음. @GeneratedValue(strategy = GenerationType.IDENTITY)
        // 넘어온 id를 가지고 memberNo를 찾음.
        // 만든 계획 번호 planNo를 가지고와야할까 ..? 응 가져와야함. 가지고 온걸 가지고 memberEntity를 만듬.

        //MemberPlan memberPlanEntity = new MemberPlan(memberPlanRequest.getId() )
        //planRepository.save(memberPlanRequest);
    }


    @Transactional
    @Override
    public List<MemberPlan> listPlan(Integer id) {

        List<MemberPlan> userPlanList = memberPlanRepository.findAll(id);

        for(MemberPlan memberPlan : userPlanList){
            log.info("memberPlanList: " + memberPlan.getPlan().getPlanName());
            log.info("memberPlanList: " + memberPlan.getPlan().getPlanDate());
            log.info("memberPlanList: " + memberPlan.getPlan().getPlaceName());
        }

        return userPlanList;
    }

    @Override
    public FriendMemberResponse searchMember(String friendId) {

        log.info(friendId);

        Optional<Member> maybeFriend = memberRepository.findById(friendId);

        if(maybeFriend.equals(Optional.empty())){
            log.info("No id!");
            return new FriendMemberResponse(null, "x");
        }

        Member members = maybeFriend.get();

        System.out.println("members = " + members.getId());
        return new FriendMemberResponse(members.getId(), members.getName());
    }

    @Override
    public void addFriend(PlanFriend planFriend) {

        Member member = memberRepository.findByMemberNo(planFriend.getFriendId());
        Plan plan = planRepository.findByPlan(planFriend.getPlanNo());

        MemberPlan memberPlan = MemberPlan.inviteMember(member, plan);

        memberPlanRepository.save(memberPlan);

    }

    @Transactional
    @Override
    public List<MemberPlan> showInviteMember(Integer planNo) {

        List<MemberPlan> listMember = memberPlanRepository.findAllMember(planNo);

        for(MemberPlan memberPlan : listMember){
            log.info("memberPlanList: " + memberPlan.getMember().getId());
            log.info("memberPlanList: " + memberPlan.getMember().getName());
            log.info("memberPlanList: " + memberPlan.getMember().getColor());
        }

        return listMember;
    }

    @Override
    public void voteSave(VoteRequest voteRequest) {
        Plan plan = planRepository.findByPlan(voteRequest.getPlanNo());

        Vote vote = Vote.voteCreate(voteRequest.getVoteContent(), plan);

        voteRepository.save(vote);
    }

    @Override
    public List<Vote> voteList(Integer planNo) {

        List<Vote> voteLists = voteRepository.findAllVote(planNo);

        for(Vote voteList : voteLists){
            log.info("voteNo" + voteList.getVoteNo());
        }

        return voteLists;
    }

    @Override
    public void voteGood(DecisionMakingRequest decisionMakingRequest) {
        log.info("여기까지 왔니..? ");
        Optional<VoteResultGood> maybeVotedGood = voteResultGoodRepository.findByMaybeVotedMember(decisionMakingRequest.getVoteNo(), decisionMakingRequest.getId());
        Optional<VoteResultBad> maybeVotedBad = voteResultBadRepository.findByMaybeVotedMember(decisionMakingRequest.getVoteNo(), decisionMakingRequest.getId());

        Vote vote = voteRepository.findVoteByVoteNo(decisionMakingRequest.getVoteNo());

        if(maybeVotedGood.equals(Optional.empty()) && maybeVotedBad.equals(Optional.empty())){
            log.info("이 사람은 처음 투표하는 사람입니다!");

            VoteResultGood voteResultGoodEntity = VoteResultGood.voteResultCreate(decisionMakingRequest.getId(), vote);
            voteResultGoodRepository.save(voteResultGoodEntity);

            vote.voteResultAgreement(vote, true);
            voteRepository.save(vote);

            log.info("찬성한 사람은 몇명?" + vote.getAgreement());
        }else if(!maybeVotedGood.equals(Optional.empty())){
            log.info("이 사람은 투표를 한 사람입니다.");
            VoteResultGood voteGoodResult = voteResultGoodRepository.findByVoteMember(decisionMakingRequest.getVoteNo(), decisionMakingRequest.getId());
            voteResultGoodRepository.delete(voteGoodResult);

            log.info("찬성한 사람은 몇명?" + vote.getAgreement());
            vote.voteResultAgreement(vote, false);

            voteRepository.save(vote);
        } else{
            log.info("이미 투표를 했습니다!!!!!!!");
        }

    }

    @Override
    public void voteBad(DecisionMakingRequest decisionMakingRequest) {
        Optional<VoteResultBad> maybeVotedBad = voteResultBadRepository.findByMaybeVotedMember(decisionMakingRequest.getVoteNo(), decisionMakingRequest.getId());
        Optional<VoteResultGood> maybeVotedGood = voteResultGoodRepository.findByMaybeVotedMember(decisionMakingRequest.getVoteNo(), decisionMakingRequest.getId());

        Vote vote = voteRepository.findVoteByVoteNo(decisionMakingRequest.getVoteNo());

        if(maybeVotedGood.equals(Optional.empty()) && maybeVotedBad.equals(Optional.empty())){
            log.info("이 사람은 처음 투표하는 사람입니다!");

            VoteResultBad voteResultBadEntity = VoteResultBad.voteResultCreate(decisionMakingRequest.getId(), vote);
            voteResultBadRepository.save(voteResultBadEntity);

            vote.voteResultOpposition(vote, true);
            voteRepository.save(vote);

            log.info("찬성한 사람은 몇명?" + vote.getAgreement());
        }else if(!maybeVotedBad.equals(Optional.empty())){
            log.info("이 사람은 투표를 한 사람입니다.");
            VoteResultBad voteResult = voteResultBadRepository.findByVoteMember(decisionMakingRequest.getVoteNo(), decisionMakingRequest.getId());
            voteResultBadRepository.delete(voteResult);

            log.info("찬성한 사람은 몇명?" + vote.getAgreement());
            vote.voteResultOpposition(vote, false);
            voteRepository.save(vote);
        } else{
            log.info("이미 투표를 했습니다");
        }

    }


    /*
    @Transactional
    @Override
    public List<MemberPlan> list(String id) {

        Member member = memberRepository.findByMemberNo(id);
        System.out.println(member.getMemberNo());

        List<MemberPlan> userPlanList = memberPlanRepository.selectUserPlan(member.getMemberNo());

        //for(MemberPlan memberPlan : userPlanList){
        //    log.info("memberPlanList: " + memberPlan);
        //}
        return userPlanList;
        //return null;
    }
     */



}
