package com.example.backend.controller.serviceBoard;

import com.example.backend.controller.board.request.KeyWordRequest;
import com.example.backend.entity.Board;
import com.example.backend.entity.Center;
import com.example.backend.entity.Reservation;
import com.example.backend.service.board.BoardService;
import com.example.backend.service.serviceCenter.CenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/center")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class CenterController {

    @Autowired
    private CenterService service;


    @PostMapping("/register")
    public void centerRegister (@Validated Center center, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info("boardRegister()" + center + "file" + file);

        service.register(center, file);
    }

    @GetMapping("/list")
    public List<Center> boardList () {
        log.info("BoardList()");

        return service.list ();
    }

    @GetMapping("/{centerNo}")
    public Center boardRead (
            @PathVariable("centerNo") Long centerNo) {
        log.info("boardRead()");
        return service.read(centerNo);
    }


    @PutMapping("/{centerNo}")
    public Center boardModify (
            @PathVariable("centerNo") Integer centerNo,
            Center center, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info("boardModify(): " + center + "centerNo" + centerNo);

        center.setCenterNo(Long.valueOf(centerNo));
        service.modify(center, file);

        return center;
    }


    @DeleteMapping("/{centerNo}")
    public void boardRemove(
            @PathVariable("centerNo") Integer centerNo, Center center) throws Exception{
        log.info("boardRemove()");

        service.remove(centerNo);
    }

    @GetMapping("/list/{searchId}")
    public List<Center> centerPerList (@PathVariable("searchId") String searchId) {
        log.info("centerPerList()");


        return service.searchIdList(searchId);
    }

    @RequestMapping(value = "/read",  method = RequestMethod.GET)
    public Center centerReadBoard (@RequestParam(value = "checkBoardNo", required = false) Long checkBoardNo,
                                         @RequestParam(value = "searchId", required = false) String searchId) {


        log.info("checkReservationNo:" +checkBoardNo + "id:" +searchId);

        return service.read(checkBoardNo,searchId);
    }

}
