package com.example.demo.service.board;

import com.example.demo.dto.request.BoardRequest;
import com.example.demo.dto.request.LikeRequest;
import com.example.demo.dto.response.BoardResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

public abstract class BaseBoardService {

    public abstract void register(BoardRequest board, MultipartFile file) throws Exception;

    //public abstract List<BoardResponse> list();
    public abstract Object list();
    //public abstract BoardResponse read(Integer boardNo);
    public abstract Object read(Integer boardNo);

    public abstract void modify (Integer boardNo, BoardRequest board, MultipartFile files) throws Exception;

    public abstract void remove (Integer boardNo);

    public abstract void doLike(LikeRequest like);

    public abstract void unDoLike(LikeRequest like);

    public abstract void likeCheck(String writer);

    //이런게 구현이 완료 됐다는건가??
    public void fileUpload(BoardRequest board, MultipartFile files, String path) throws Exception{

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

    public void fileRemove(String fileName, String path){

        File file = new File("../../frontend/src/assets/" + path + "/" + fileName);

        if (file.exists()) {
            file.delete();
        }
    }

}
