package com.example.demo.service.project;

import com.example.demo.entity.project.ProjectComment;

import java.util.List;

public interface ProjectCommentService {

    public void register (Long projectNo, ProjectComment projectComment);
    public List<ProjectComment> list (Long projectNo);
    public void delete (Long commentId);
}
