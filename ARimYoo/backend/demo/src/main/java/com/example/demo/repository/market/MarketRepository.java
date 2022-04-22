package com.example.demo.repository.market;

import com.example.demo.entity.market.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketRepository extends JpaRepository<Market, Long> {
    List<Market> findByTitleContaining(String keyword);
}
