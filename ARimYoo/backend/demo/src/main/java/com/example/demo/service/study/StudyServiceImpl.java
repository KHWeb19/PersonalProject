package com.example.demo.service.study;

import com.example.demo.entity.study.Study;
import com.example.demo.repository.study.StudyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class StudyServiceImpl implements StudyService {

    @Autowired
    private StudyRepository repository;

    @Override
    public void register (Study study, @RequestParam(required = false) MultipartFile file) throws Exception {

        if (file != null) {
            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "-" + file.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/back/study/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            study.setFileName(fileName);

        }
        repository.save(study);
    }

    @Override
    public List<Study> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "studyNo"));

    }
}
