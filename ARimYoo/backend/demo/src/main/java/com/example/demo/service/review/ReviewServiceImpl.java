package com.example.demo.service.review;

import com.example.demo.entity.review.Review;
import com.example.demo.repository.review.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository repository;

    @Override
    public void register(Review review, @RequestParam(required = false) List<MultipartFile> file) throws Exception {

        try {
            if (file != null) {
                    for (MultipartFile multipartFile : file) {
                        UUID uuid = UUID.randomUUID();
                        String fileName = uuid + "_" + multipartFile.getOriginalFilename();
                        FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/back/review/" + fileName);

                        saveFile.write(multipartFile.getBytes());
                        saveFile.close();

                        if (multipartFile == file.get(0)) {
                            review.setFileName1(fileName);
                        } else if ( multipartFile == file.get(1)){
                            review.setFileName2(fileName);
                        } else if (multipartFile == file.get(2)) {
                            review.setFileName3(fileName);
                        } else if (multipartFile == file.get(3)) {
                            review.setFileName4(fileName);
                        } else {
                            review.setFileName5(fileName);
                        }
                    }
            }
        } catch (Exception e) {
            log.info("Upload Fail!!!");
        }

        repository.save(review);
    }

    @Override
    public List<Review> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "reviewNo"));
    }

    @Override
    public Review read(Long reviewNo) {
        Optional<Review> maybeReadBoard = repository.findById(Long.valueOf(reviewNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        } else {
            Review review = maybeReadBoard.get();
            review.increaseViewCnt();
            repository.save(review);
            return maybeReadBoard.get();
        }
    }

    @Override
    public void modify(Review review, @RequestParam(required = false) List<MultipartFile> file) throws Exception {

        try {
            if (file != null) {
                for (MultipartFile multipartFile : file) {
                    UUID uuid = UUID.randomUUID();
                    String fileName = uuid + "_" + multipartFile.getOriginalFilename();
                    FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/back/review/" + fileName);

                    saveFile.write(multipartFile.getBytes());
                    saveFile.close();

                    if (multipartFile == file.get(0)) {
                        review.setFileName1(fileName);
                    } else if ( multipartFile == file.get(1)){
                        review.setFileName2(fileName);
                    } else if (multipartFile == file.get(2)) {
                        review.setFileName3(fileName);
                    } else if (multipartFile == file.get(3)) {
                        review.setFileName4(fileName);
                    } else {
                        review.setFileName5(fileName);
                    }
                }
            }
        } catch (Exception e) {
            log.info("Upload Fail!!!");
        }
        repository.save(review);
    }

    @Override
    public void remove(Integer reviewNo) throws Exception {

        repository.deleteById(Long.valueOf(reviewNo));
    }

    @Override
    public List<Review> searchList (String keyword) {
        List<Review> findList = repository.findByTitleContaining(keyword);
        return findList;
    }

    @Override
    public List<Review> popularList () {
        return repository.findTop5ByOrderByLikeCntDesc();
    }

}

