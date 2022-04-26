package com.example.demo.service.project;

import com.example.demo.entity.project.Project;

import java.util.List;

public interface ProjectService {

    public List<Project> list (Long memberNo);
    public boolean join (Long memberNo, Project project);
    public Project read (Long projectNo);
    public void toDoRegister (Project project);
}
