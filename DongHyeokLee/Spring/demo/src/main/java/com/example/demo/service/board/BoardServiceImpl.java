package com.example.demo.service.board;

import com.example.demo.dto.Board;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

public class BoardServiceImpl {

    public void fileUpload(Board board, MultipartFile files,String path) throws Exception{

        if (files != null) {
            UUID uuid = UUID.randomUUID();

            String fileName = uuid + "_" + files.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream(
                    "../../frontend/src/assets/" + path +"/" + fileName);

            saveFile.write(files.getBytes());
            saveFile.close();

            board.setFileName(fileName);
        }
    }

    public void fileChange(Board board, MultipartFile files, String path) throws Exception {


            File file = new File("../../frontend/src/assets/" + path + "/" + board.getFileName());

            if (file.exists()) {
                file.delete();
            }

    }

    public void fileRemove(String fileName, String path){
        File file = new File("../../frontend/src/assets/" + path + "/" + fileName);

        if (file.exists()) {
            file.delete();
        }
    }
}
