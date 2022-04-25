package com.example.demo.service.project;

import com.example.demo.entity.project.ProjectBoard;
import com.example.demo.entity.project.ProjectComment;
import com.example.demo.repository.project.ProjectBoardRepository;
import com.example.demo.repository.project.ProjectCommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProjectCommentServiceImpl implements ProjectCommentService {

    @Autowired
    ProjectBoardRepository boardRepository;

    @Autowired
    ProjectCommentRepository repository;

   @Override
    public void register (Long projectNo, ProjectComment projectComment){
       Optional<ProjectBoard> boardItem = boardRepository.findById(Long.valueOf(projectNo));
       projectComment.setProjectBoard(boardItem.get());
       repository.save(projectComment);
    }

    @Override
    public List<ProjectComment> list (Long projectNo) {
        ProjectBoard projectBoard = boardRepository.findById(projectNo).get();
        return repository.findProjectCommentByProjectBoard(projectBoard);
    }

    @Override
    public void delete (Long commentId) {
        repository.deleteById(Long.valueOf(commentId));
    }
}
