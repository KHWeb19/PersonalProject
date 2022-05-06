package com.example.backend.service.serviceCenter;

import com.example.backend.entity.Board;
import com.example.backend.entity.Center;
import com.example.backend.repository.Board.BoardRepository;
import com.example.backend.repository.centerBoard.CenterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
public class CenterServiceImpl implements CenterService {

    @Autowired
    CenterRepository repository;


    @Transactional
    @Override
    public void register(Center center, @RequestParam(required = false) MultipartFile file) throws Exception {

        if (file != null) {


            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "_" +file.getOriginalFilename();

            FileOutputStream saveFile = new FileOutputStream("../../frontend/frontend_pro/src/assets/uploadImg/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            center.setFileName(fileName);
        }

        repository.save(center);
    }

    @Transactional
    @Override
    public void modify(Center center,  @RequestParam(required = false) MultipartFile file) throws Exception {

        if (center.getFileName().equals(Optional.empty())) {

            Path filePath = Paths.get("c:\\PersonalProject\\PersonalProject-1\\HeejinKim\\frontend\\frontend_pro\\src\\assets\\uploadImg\\" + center.getFileName());
            Files.delete(filePath);
        }

        if (file != null) {

            UUID uuid = UUID.randomUUID();

            String fileName =  uuid + "_" + file.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream("../../frontend/frontend_pro/src/assets/uploadImg/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            center.setFileName(fileName);

        }

        repository.save(center);
    }


    @Transactional
    @Override
    public List<Center> list() {

        return repository.findAll(Sort.by(Sort.Direction.DESC, "centerNo"));

    }

    @Transactional
    @Override
    public Center read(Long centerNo) {

        Optional<Center> maybeReadBoard = repository.findById(Long.valueOf(centerNo));
        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;

        } else {
            Center center = maybeReadBoard.get();
            repository.save(center);
            return maybeReadBoard.get();
        }
    }

    @Transactional
    @Override
    public void remove(Integer centerNo) throws IOException {

        Optional<Center> selectFile = repository.findById(Long.valueOf(centerNo));
        Center deleteFile = selectFile.get();

        if (deleteFile.getFileName() != null){
            Path filePath = Paths.get("c:\\PersonalProject\\PersonalProject-1\\HeejinKim\\frontend\\frontend_pro\\src\\assets\\uploadImg\\" + deleteFile.getFileName());
            Files.delete(filePath);
        }

        repository.deleteById(Long.valueOf(centerNo));
    }

}
