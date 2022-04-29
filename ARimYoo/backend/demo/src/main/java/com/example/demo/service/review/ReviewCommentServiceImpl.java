package com.example.demo.service.review;

import com.example.demo.entity.Member;
import com.example.demo.entity.review.Review;
import com.example.demo.entity.review.ReviewComment;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.review.ReviewCommentRepository;
import com.example.demo.repository.review.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ReviewCommentServiceImpl implements ReviewCommentService {

    @Autowired
    ReviewRepository boardRepository;

    @Autowired
    ReviewCommentRepository repository;

    @Autowired
    MemberRepository memberRepository;

   @Override
    public void register (Long viewNo, ReviewComment reviewComment){
       Optional<Review> boardItem = boardRepository.findById(Long.valueOf(viewNo));
       reviewComment.setReview(boardItem.get());

       Optional<Member> getProfile =  memberRepository.findByName(reviewComment.getCommentWriter());
       Member member = getProfile.get();

       reviewComment.setCommentProfile(member.getProfilePic());
       repository.save(reviewComment);
    }

    @Override
    public List<ReviewComment> list (Long viewNo) {
       Review review = boardRepository.findById(viewNo).get();
        return repository.findReviewCommentByReview(review);
    }

    @Override
    public void delete (Long commentId) {
        repository.deleteById(Long.valueOf(commentId));
    }
}
