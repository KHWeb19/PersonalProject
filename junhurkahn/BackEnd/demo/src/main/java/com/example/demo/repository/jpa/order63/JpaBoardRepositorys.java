package com.example.demo.repository.jpa.order63;

import com.example.demo.entity.jpa.JpaBoards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaBoardRepositorys extends JpaRepository<JpaBoards, Long> {

    List<JpaBoards> findByTitleOrWriterOrContent(String title, String writer, String keyword);
}