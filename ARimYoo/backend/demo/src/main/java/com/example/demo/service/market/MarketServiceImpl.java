package com.example.demo.service.market;

import com.example.demo.entity.market.Market;
import com.example.demo.repository.market.MarketRepository;
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
public class MarketServiceImpl implements MarketService {

    @Autowired
    MarketRepository repository;

    @Override
    public void register(Market market, @RequestParam(required = false) List<MultipartFile> file) throws Exception {

        try {
            if (file != null) {
                    for (MultipartFile multipartFile : file) {
                        UUID uuid = UUID.randomUUID();
                        String fileName = uuid + "_" + multipartFile.getOriginalFilename();
                        FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/back/market/" + fileName);

                        saveFile.write(multipartFile.getBytes());
                        saveFile.close();

                        if (multipartFile == file.get(0)) {
                            market.setFileName1(fileName);
                        } else if ( multipartFile == file.get(1)){
                            market.setFileName2(fileName);
                        } else if (multipartFile == file.get(2)) {
                            market.setFileName3(fileName);
                        } else if (multipartFile == file.get(3)) {
                            market.setFileName4(fileName);
                        } else {
                            market.setFileName5(fileName);
                        }
                    }
            }
        } catch (Exception e) {
            log.info("Upload Fail!!!");
        }

        repository.save(market);
    }

    @Override
    public List<Market> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public Market read(Long boardNo) {
        Optional<Market> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        } else {
            Market market = maybeReadBoard.get();
            market.increaseViewCnt();
            repository.save(market);
            return maybeReadBoard.get();
        }
    }

    @Override
    public void modify(Market market, @RequestParam(required = false) List<MultipartFile> file) throws Exception {

        try {
            if (file != null) {
                for (MultipartFile multipartFile : file) {
                    UUID uuid = UUID.randomUUID();
                    String fileName = uuid + "_" + multipartFile.getOriginalFilename();
                    FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/back/market/" + fileName);

                    saveFile.write(multipartFile.getBytes());
                    saveFile.close();

                    if (multipartFile == file.get(0)) {
                        market.setFileName1(fileName);
                    } else if ( multipartFile == file.get(1)){
                        market.setFileName2(fileName);
                    } else if (multipartFile == file.get(2)) {
                        market.setFileName3(fileName);
                    } else if (multipartFile == file.get(3)) {
                        market.setFileName4(fileName);
                    } else {
                        market.setFileName5(fileName);
                    }
                }
            }
        } catch (Exception e) {
            log.info("Upload Fail!!!");
        }
        repository.save(market);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {

        repository.deleteById(Long.valueOf(boardNo));
    }

    @Override
    public List<Market> searchList (String keyword) {
        List<Market> findList = repository.findByTitleContaining(keyword);
        return findList;
    }

}

