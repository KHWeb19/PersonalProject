package com.example.demo.repository.jpa.order63;

import com.example.demo.entity.jpa.JpaBoards;
import com.example.demo.entity.jpa.JpaBoards1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaBoardRepositorys1 extends JpaRepository<JpaBoards1, Long> {

    List<JpaBoards1> findAllByTitleContainingOrWriterContainingOrWriter1Containing(String title, String writer, String writer1);
}