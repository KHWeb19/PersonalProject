package com.example.demo.service.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoard;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FoodBoardService {
    public void register (FoodBoard foodBoard, @RequestParam(required = false)MultipartFile file) throws IOException, Exception;
    public List<FoodBoard> list();
    public List<FoodBoard> getFoodList();

    public FoodBoard read(Integer boardNo);
    public void updateViewCount(Integer boardNo);
    public void modify (FoodBoard foodBoard, @RequestParam(required = false)MultipartFile file) throws Exception;
    public void remove(Integer boardNo) throws Exception;
}
