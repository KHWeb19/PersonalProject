package com.example.demo.service.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.repository.FoodBoard.FoodBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    public List<FoodBoard> getFoodList() {
        return repository.findAll();
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


}
