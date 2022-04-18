package com.example.demo.repository.jpa.order63;


import com.example.demo.entity.jpa.JpaBoards3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaBoardRepositorys3 extends JpaRepository<JpaBoards3, Long> {

    List<JpaBoards3> findAllByTitleContainingOrWriterContainingOrWriter1Containing(String title, String writer, String writer1);
}