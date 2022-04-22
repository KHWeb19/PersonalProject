package com.example.demo.repository.market;

import com.example.demo.entity.market.Market;
import com.example.demo.entity.market.MarketComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketCommentRepository extends JpaRepository<MarketComment, Long> {
    List<MarketComment> findMarketCommentByMarket(Market market);
}
