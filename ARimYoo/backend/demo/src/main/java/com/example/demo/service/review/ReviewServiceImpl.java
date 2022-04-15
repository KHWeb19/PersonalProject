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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository repository;

    @Override
    public void register(Review review, @RequestParam(required = false) MultipartFile file) throws Exception {

        if (file != null) {
            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "_" + file.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/back/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            review.setFileName(fileName);
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
    public void modify(Review review, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info(review.getFileName());

        if (review.getFileName().equals(Optional.empty())) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\review\\" + review.getFileName());
            Files.delete(filePath);
        }

        if (file != null) {

            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "_" + file.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/back/review/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            review.setFileName(fileName);
        }

        repository.save(review);
    }

    @Override
    public void remove(Integer reviewNo) throws Exception {
        Optional<Review> selectFile = repository.findById(Long.valueOf(reviewNo));
        Review deleteFile = selectFile.get();
        System.out.println(deleteFile.getFileName());

        if (deleteFile.getFileName() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\review\\" + deleteFile.getFileName());
            Files.delete(filePath);
        }

        repository.deleteById(Long.valueOf(reviewNo));
    }

    @Override
    public List<Review> searchList (String keyword) {
        List<Review> findList = repository.findByTitleContaining(keyword);
        return findList;
    }


}
