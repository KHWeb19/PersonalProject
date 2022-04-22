package com.example.demo.service.project;

import com.example.demo.entity.project.Project;
import com.example.demo.entity.project.ProjectBoard;
import com.example.demo.repository.project.ProjectBoardRepository;
import com.example.demo.repository.project.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ProjectBoardServiceImpl implements ProjectBoardService {

    @Autowired
    private ProjectBoardRepository repository;
    @Autowired
    private ProjectRepository repository2;

    @Override
    public void register (ProjectBoard projectBoard, Project project, @RequestParam(required = false) MultipartFile file) throws Exception {

        if (file != null) {
            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "-" + file.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/back/projectBoard/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            projectBoard.setFileName(fileName);
        }
        repository.save(projectBoard);

        // 스터디DB에도 등록하기 위해
        project.setFileName(projectBoard.getFileName());
        project.setFirstMember(projectBoard.getWriter());
        project.setPeople(projectBoard.getPeople());
        project.setOpenLink(projectBoard.getOpenLink());

        repository2.save(project);
    }

    @Override
    public List<ProjectBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "projectNo"));

    }
    @Override
    public ProjectBoard read(Long projectNo) {
        Optional<ProjectBoard> maybeReadProject = repository.findById(Long.valueOf(projectNo));

        if (maybeReadProject.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        } else {
            ProjectBoard projectBoard = maybeReadProject.get();
            projectBoard.increaseViewCnt();
            repository.save(projectBoard);
            return maybeReadProject.get();
        }
    }

    @Override
    public void remove(Integer projectNo) throws Exception {
        Optional<ProjectBoard> selectFile = repository.findById(Long.valueOf(projectNo));
        ProjectBoard deleteFile = selectFile.get();
        System.out.println(deleteFile.getFileName());

        if (deleteFile.getFileName() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\projectBoard\\" + deleteFile.getFileName());
            Files.delete(filePath);
        }

        repository.deleteById(Long.valueOf(projectNo));
    }

    @Override
    public void modify(ProjectBoard projectBoard) throws Exception {
        repository.save(projectBoard);
    }

    @Override
    public List<ProjectBoard> searchList (String keyword) {
        List<ProjectBoard> findList = repository.findByProjectNameContaining(keyword);
        return findList;
    }
}
