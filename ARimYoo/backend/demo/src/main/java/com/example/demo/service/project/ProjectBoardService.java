package com.example.demo.service.project;

import com.example.demo.entity.Member;
import com.example.demo.entity.project.Project;
import com.example.demo.entity.project.ProjectBoard;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectBoardService {

    public void register (ProjectBoard projectBoard, Project project, Member member, @RequestParam(required = false) MultipartFile file) throws Exception;
    public List<ProjectBoard> list ();
    public ProjectBoard read (Long projectNo);
    public void modify (ProjectBoard projectBoard) throws Exception;
    public void remove (Integer projectNo) throws Exception ;
    public List<ProjectBoard> searchList (String keyword);
}
