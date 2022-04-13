package com.example.demo.service.plan;

import com.example.demo.entity.Member;
import com.example.demo.entity.MemberPlan;
import com.example.demo.entity.Plan;
import com.example.demo.repository.JoinMemberRepository;
import com.example.demo.repository.MakePlanRepository;
import com.example.demo.repository.MemberPlanRepository;
import com.example.demo.request.MemberPlanRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class MakePlanServiceImpl implements MakePlanService{

    @Autowired
    MakePlanRepository planRepository;

    @Autowired
    JoinMemberRepository memberRepository; // 계획을 만든 사람을 가지고 온다.

    @Autowired
    MemberPlanRepository memberPlanRepository;

    @Transactional
    @Override
    public void make(MemberPlanRequest memberPlanRequest) { // 계획을 db에 저장을함.
        log.info(String.valueOf(memberPlanRequest));

        Member member = memberRepository.findByMemberNo(memberPlanRequest.getId());

        MemberPlan memberPlan = MemberPlan.createMemberPlan(member);

        Plan planEntity = Plan.createPlan(memberPlanRequest.getPlanName(), memberPlanRequest.getPlanDate(), memberPlanRequest.getPlaceName(), memberPlan);

        //Member memberEntity = Member.createPlan(member, memberPlan);

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
