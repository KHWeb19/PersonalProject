package com.example.backend.repository.member;

import com.example.backend.entity.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface MemberAuthRepository extends JpaRepository<MemberAuth,Long> {


}
