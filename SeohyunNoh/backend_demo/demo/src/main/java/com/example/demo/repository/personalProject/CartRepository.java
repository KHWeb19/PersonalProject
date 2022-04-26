package com.example.demo.repository.personalProject;

import com.example.demo.entity.personalProject.Cart;
import com.example.demo.entity.personalProject.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByMemberOrderByCreatedDateDesc(Member member);
}
