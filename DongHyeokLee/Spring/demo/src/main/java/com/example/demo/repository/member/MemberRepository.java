package com.example.demo.repository.member;

import com.example.demo.entitiy.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MemberRepository extends JpaRepository<Member, Long> {

}
