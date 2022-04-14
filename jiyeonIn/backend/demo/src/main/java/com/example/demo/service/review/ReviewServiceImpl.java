package com.example.demo.service.review;

import com.example.demo.controller.reviewController.request.RequestDelete;
import com.example.demo.controller.reviewController.request.ReviewRequest;
import com.example.demo.entity.review.Review;
import com.example.demo.repository.review.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    ReviewRepository repository;

    @Transactional
    @Override
    public void includeImgReview(ReviewRequest info, String originalFilename) {
        String file = info.getId() +"."+ originalFilename;

        Review review = new Review(info.getId(), info.getContent(), file);
        repository.save(review);
    }

    @Transactional
    @Override
    public void exceptImgReview(ReviewRequest info) {
        Review review = new Review(info.getId(), info.getContent());
        repository.save(review);
    }

    @Transactional
    @Override
    public List<Review> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC,"reviewNo"));
    }

    @Transactional
    @Override
    public void includeImgModify(Review info, String originalFilename) throws IOException {
        String file1 = info.getId() +"."+ originalFilename;

        log.info("reviewInfo: " +info.getReviewNo());

        Optional<Review> maybeReviewInfo = repository.findInfo(info.getReviewNo());
        Review findImg = maybeReviewInfo.get();

        if(findImg.getReviewFile() != null){
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\jiyeonIn\\vue_frontend\\book_cake\\src\\assets\\review\\" + findImg.getReviewFile());
            Files.delete(filePath);

            info.setReviewFile(file1);
            repository.save(info);
        }else if(findImg.getReviewFile() == null) {
            info.setReviewFile(file1);
            repository.save(info);
        }
    }

    @Transactional
    @Override
    public void exceptImgModify(Review info) throws IOException {
        Optional<Review> maybeReviewInfo1 = repository.findInfo(info.getReviewNo());
        Review findImg1 = maybeReviewInfo1.get();

        if(findImg1.getReviewFile() != null){

            info.setReviewFile(findImg1.getReviewFile());
            repository.save(info);
        }else if(findImg1.getReviewFile() == null) {
            repository.save(info);
        }
    }

    @Transactional
    @Override
    public void remove(RequestDelete request) throws IOException {
        Long reviewNo = request.getReviewNo();

        Optional<Review> maybeReviewInfo = repository.findInfo(reviewNo);
        Review findImg = maybeReviewInfo.get();

        if(findImg.getReviewFile() != null){
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\jiyeonIn\\vue_frontend\\book_cake\\src\\assets\\review\\" + findImg.getReviewFile());
            Files.delete(filePath);

            repository.deleteById(reviewNo);

        }else if(findImg.getReviewFile() == null) {

            repository.deleteById(reviewNo);
        }
    }

}
