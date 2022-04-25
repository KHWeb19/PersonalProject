package com.example.demo.service.project;

import com.example.demo.entity.project.Project;
import com.example.demo.repository.project.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.UUID;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Override
    public void register (Project project, @RequestParam(required = false) MultipartFile file) throws Exception {

        if (file != null) {
            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "-" + file.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/back/project/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            project.setFileName(fileName);

        }
        repository.save(project);
    }
}
