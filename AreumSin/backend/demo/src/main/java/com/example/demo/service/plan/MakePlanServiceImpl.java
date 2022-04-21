package com.example.demo.service.plan;

import com.example.demo.entity.Member;
import com.example.demo.entity.MemberPlan;
import com.example.demo.entity.Plan;
import com.example.demo.entity.Vote;
import com.example.demo.repository.JoinMemberRepository;
import com.example.demo.repository.MakePlanRepository;
import com.example.demo.repository.MemberPlanRepository;
import com.example.demo.repository.VoteRepository;
import com.example.demo.request.MemberPlanRequest;
import com.example.demo.request.MemberRequest;
import com.example.demo.request.PlanFriend;
import com.example.demo.request.VoteRequest;
import com.example.demo.response.FriendMemberResponse;
import com.example.demo.response.PlanResponse;
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

    @Transactional
    @Override
    public void make(MemberPlanRequest memberPlanRequest) { // 계획을 db에 저장을함.
        log.info(String.valueOf(memberPlanRequest));

        Member member = memberRepository.findByMemberNo(memberPlanRequest.getId());

        MemberPlan memberPlan = MemberPlan.createMemberPlan(member);

        Plan planEntity = Plan.createPlan(memberPlanRequest.getPlanName(), memberPlanRequest.getPlanDate(), memberPlanRequest.getPlaceName(), memberPlan);

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
