package com.example.demo.repository.jpa.order63;

import com.example.demo.entity.jpa.JpaMemberAuthBoth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBmAuthRepository extends JpaRepository<JpaMemberAuthBoth, Long> {
}
