package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.jpa.MemberTest;

public interface MemberTestRepository extends JpaRepository<MemberTest, Long>{
}
