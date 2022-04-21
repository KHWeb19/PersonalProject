package com.example.demo.repository.Member;

import com.example.demo.entity.Member.MemberCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberCartRepository extends JpaRepository<MemberCart, Long> {
}
