package com.example.demo.repository.personalProject;

import com.example.demo.entity.personalProject.Cart;
import com.example.demo.entity.personalProject.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByMember(Member member);

}
