package com.example.demo.repository;

import com.example.demo.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MakePlanRepository extends JpaRepository<Plan, Long> {
    // memberPlanRequest로 변경해서 id값을 member_id를 통해 memberNo를 찾고 그 값을 입력해야함.
    //void findMember

    @Query("select m from Plan m where m.planNo = :planNo")
    Plan findByPlan(Integer planNo);

    // 친구 검색
    // public List<Member> findAll()


}
