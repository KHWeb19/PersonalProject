package com.example.demo.controller.board.photoBoard;




import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import com.example.demo.service.board.photoBoard.PhotoBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/photoBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class PhotoBoardController {

    @Autowired
    private PhotoBoardService service;

    //등록
    @PostMapping("/register")
    public void PhotoBoardRegister (@Validated @RequestBody PhotoBoard photoBoard) {
        log.info("PhotoBoardRegister()");
        LocalDate now = LocalDate.now();
        String fileName = now + photoBoard.getFileName();
        photoBoard.setFileName(fileName);
        service.register(photoBoard);
    }
    //목록
    @GetMapping("/list")
    public List<PhotoBoard> PhotoBoardList () {
        log.info("PhotoBoardList()");

        return service.list();
    }
    //읽기
    @GetMapping("/{boardNo}")
    public PhotoBoard photoBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("photoBoardRead()");

        return service.read(boardNo);
    }
    //파일 업로드
    @ResponseBody
    @PostMapping("/uploadImg")
    public String requestUploadFile (
            @RequestParam("fileList") List<MultipartFile> fileList) {

        log.info("requestUploadFile(): " + fileList);

        try {
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile() - Make file: " +
                        multipartFile.getOriginalFilename());

                //일단 저장된 위치에 이름 중복 될까봐 앞에 날짜 붙였는데 더좋은 방법 없나
                //혹시 하루에 똑같은 이름 될 수도 있으니 시간까지 할려다가 너무 길어져서 일단 보류 함함
               LocalDate now = LocalDate.now();
                //LocalTime now = LocalTime.now();


                FileOutputStream writer = new FileOutputStream(
                        "../../frontend/src/assets/uploadImg/"+ now + multipartFile.getOriginalFilename());


                log.info("디렉토리에 파일 배치 성공!");

                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";
    }
    //수정
    @PutMapping("/{boardNo}")
    public PhotoBoard photoBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody PhotoBoard photoBoard) {
        log.info("freeBoardModify(): " + photoBoard);

        photoBoard.setBoardNo(Long.valueOf(boardNo));

        String checkFileName = photoBoard.getFileName();

            if(checkFileName != null){
            LocalDate now = LocalDate.now();
            String fileName = now + photoBoard.getFileName();
            photoBoard.setFileName(fileName);

            }

            service.modify(photoBoard,boardNo);

        return photoBoard;
    }

    @DeleteMapping("/{boardNo}")
    public void photoBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("freeBoardRemove()");

        service.remove(boardNo);
    }

}
