package com.example.demo.controller.market;

import com.example.demo.controller.Request.keywordRequest;
import com.example.demo.entity.market.Market;
import com.example.demo.repository.market.MarketRepository;
import com.example.demo.service.market.MarketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/board/market")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class MarketController {

    @Autowired
    private MarketService service;
    @Autowired
    private MarketRepository repository;

    @PostMapping("/register")
    public void MarketRegister (@Validated Market market, @RequestParam(required = false) List<MultipartFile> file) throws Exception {
        log.info ("MarketRegister();" + file);
        service.register(market, file);

    }

    @GetMapping("/list")
    public List<Market> marketList () {
        log.info("MarketList");

        return service.list ();
    }

    @GetMapping("/{boardNo}")
    public Market read (
            @PathVariable("boardNo") Long boardNo) {
        log.info("read()");
        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public Market modify (
            @PathVariable("boardNo") Integer boardNo,
            Market market, @RequestParam(required = false) List<MultipartFile> file) throws Exception  {

        Optional<Market> getFileName = repository.findById(Long.valueOf(boardNo));
        Market getFile = getFileName.get();


        if (getFile.getFileName1() != null ) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\market\\" + getFile.getFileName1());
            Files.delete(filePath);
        }
        if (getFile.getFileName2() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\market\\" + getFile.getFileName2());
            Files.delete(filePath);
        }
        if (getFile.getFileName3() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\market\\" + getFile.getFileName3());
            Files.delete(filePath);
        }
        if (getFile.getFileName4() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\market\\" + getFile.getFileName4());
            Files.delete(filePath);
        }
        if (getFile.getFileName5() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\review\\" + getFile.getFileName5());
            Files.delete(filePath);
        }

        log.info("modify(): " + market);
        market.setBoardNo(Long.valueOf(boardNo));
        service.modify(market, file);

        return market;
    }

    @DeleteMapping("/{boardNo}")
    public void remove(
            @PathVariable("boardNo") Integer boardNo, Market market) throws Exception  {
        log.info("remove()");

        Optional<Market> selectFile = repository.findById(Long.valueOf(boardNo));
        Market deleteFile = selectFile.get();

        if (deleteFile.getFileName1() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\market\\" + deleteFile.getFileName1());
            Files.delete(filePath);
        }

        if (deleteFile.getFileName2() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\market\\" + deleteFile.getFileName2());
            Files.delete(filePath);
        }
        if (deleteFile.getFileName3() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\market\\" + deleteFile.getFileName3());
            Files.delete(filePath);
        }
        if (deleteFile.getFileName4() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\market\\" + deleteFile.getFileName4());
            Files.delete(filePath);
        }
        if (deleteFile.getFileName5() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\market\\" + deleteFile.getFileName5());
            Files.delete(filePath);
        }

        service.remove(boardNo);

    }

    @PostMapping("/search")
    public List<Market> searchList (@RequestBody keywordRequest keyword) {
        log.info("searchList! " + keyword);
        String key = keyword.getKeyword();
        return service.searchList(key);
    }


}
