package com.example.demo.repository;

import com.example.demo.entity.Member;
import com.example.demo.entity.MemberPlan;
import com.example.demo.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MemberPlanRepository extends JpaRepository<MemberPlan, Long> {

    //@Query("SELECT member.user_name FROM member_plan LEFT JOIN member ON member_plan.user_no = member.user_no JOIN plan ON member_plan.plan_no = plan.plan_no;")
    //select plan.plan_name from member_plan join member on member_plan.user_no = member_plan.user_no join plan on member_plan.plan_no = plan.plan_no where member.user_no = 1;
    //select p.plan_name, p.place_name from member_plan mp join plan p on mp.plan_no = p.plan_no join member m on mp.user_no = m.user_no where m.user_no = 1;
    //select p.plan_name from member_plan mp join plan p on mp.plan_no = p.plan_no join member m on mp.user_no = m.user_no where m.user_no = :userNo
    //@Transactional
    //@Query(value = "SELECT p.* FROM member_plan mp JOIN plan p ON mp.plan.plan_no = p.plan_no WHERE mp.user_no = :userNo", nativeQuery = true)
    //@Query(value = "select mp.* from member_plan mp join fetch mp.plan.plan_no where mp.member.user_no = :memberNo", nativeQuery = true)
    //@Query("select mp from MemberPlan mp left join mp.plan.planNo where mp.member.memberNo = :memberNo")
    //@Query(value = "select plan from member_plan mp join fet")
    //@Query(value = "select mp from MemberPlan as mp join mp.plan.planNo where mp.plan.planNo = :memberNo")
    //@Query("select mp from MemberPlan mp join fetch mp.plan.planNo join fetch mp.member.memberNo m where m = :memberNo")
    //List<MemberPlan> selectUserPlan(@Param("memberNo") Integer memberNo); // memberNo와 같은 번호를 memberPlan 을 전부 가지고 온 후 Plan 에서 planNo를 보여준다.

    @Transactional
    @Query("select mp from MemberPlan mp join mp.plan p join mp.member m where m.memberNo = :memberNo")
    List<MemberPlan> findAll(@Param("memberNo") Integer memberNo);
}
