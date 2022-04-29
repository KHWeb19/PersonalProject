package com.example.demo.service.market;

import com.example.demo.entity.Member;
import com.example.demo.entity.market.Market;
import com.example.demo.entity.market.MarketComment;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.market.MarketCommentRepository;
import com.example.demo.repository.market.MarketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MarketCommentServiceImpl implements MarketCommentService {

    @Autowired
    MarketRepository boardRepository;

    @Autowired
    MarketCommentRepository repository;

    @Autowired
    MemberRepository memberRepository;

   @Override
    public void register (Long viewNo, MarketComment marketComment){
       Optional<Market> boardItem = boardRepository.findById(Long.valueOf(viewNo));
       marketComment.setMarket(boardItem.get());

       Optional<Member> getProfile =  memberRepository.findByName(marketComment.getCommentWriter());
       Member member = getProfile.get();

       marketComment.setCommentProfile(member.getProfilePic());

       repository.save(marketComment);
    }

    @Override
    public List<MarketComment> list (Long viewNo) {
       Market market = boardRepository.findById(viewNo).get();
        return repository.findMarketCommentByMarket(market);
    }

    @Override
    public void delete (Long commentId) {
        repository.deleteById(Long.valueOf(commentId));
    }
}
