package com.example.demo.repository;

import com.example.demo.entity.JpaMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<JpaMemberEntity, Long> {

}
