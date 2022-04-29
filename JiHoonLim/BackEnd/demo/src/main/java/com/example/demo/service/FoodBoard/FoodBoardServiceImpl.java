package com.example.demo.service.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.entity.Member.MemberCart;
import com.example.demo.repository.FoodBoard.FoodBoardRepository;
import com.example.demo.repository.Member.MemberCartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class FoodBoardServiceImpl implements FoodBoardService{

    @Autowired
    FoodBoardRepository repository;




    @Override
    public void register(FoodBoard foodBoard, MultipartFile file) throws Exception {

        if (file != null) {
            UUID uuid = UUID.randomUUID();

            String fileName = uuid + "_" + file.getOriginalFilename();

            FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/uploadImg/foodBoard/" +fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            foodBoard.setFilename(fileName);
            foodBoard.setFilepath("/files/" + fileName);
        }

        repository.save(foodBoard);
    }

    @Override
    public List<FoodBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }



    @Override
    public List<FoodBoard> bestFoodList() {

        return repository.findTop10ByOrderByRankScoreDesc();
    }


    @Override
    public FoodBoard read(Integer boardNo) {
        Optional<FoodBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())){
            log.info("No Read");
            return null;
        }


        return maybeReadBoard.get();
    }

    @Override
    public void updateViewCount(Integer boardNo) {
        repository.updateViewCount(Long.valueOf(boardNo));
        repository.setRankScore(Long.valueOf(boardNo));
    }

    @Override
    public void modify(FoodBoard foodBoard, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info("fileName: " +foodBoard.getFilename());

        if (!foodBoard.getFilename().isEmpty()){
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\JiHoonLim\\frontend\\src\\assets\\uploadImg\\foodBoard\\" + foodBoard.getFilename());
            Files.delete(filePath);
        }

        if (file != null) {
            UUID uuid = UUID.randomUUID();

            String fileName = uuid + "_" + file.getOriginalFilename();

            FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/uploadImg/foodBoard/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            foodBoard.setFilename(fileName);
            foodBoard.setFilepath("/files/" + fileName);

            /*MemberCart memberCart = new MemberCart();
            memberCart.setFilename(fileName);
            memberCart.setFilepath("/files/" +fileName);*/
        }

        repository.save(foodBoard);
    }

    @Override
    public void remove(Integer boardNo) throws Exception{
        Optional<FoodBoard> selectFile = repository.findById(Long.valueOf(boardNo));
        FoodBoard deleteFile = selectFile.get();

        if (deleteFile.getFilename() != null){
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\JiHoonLim\\frontend\\src\\assets\\uploadImg\\foodBoard\\" + deleteFile.getFilename());
            Files.delete(filePath);
        }
        repository.deleteById(Long.valueOf(boardNo));

    }

    @Override
    public List<FoodBoard> search(String keyWord) {
        List<FoodBoard> searchResults = repository.findByNameContaining(keyWord);

        return searchResults;
    }

}
