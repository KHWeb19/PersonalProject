package com.example.demo.repository.jpa.order63;



import com.example.demo.entity.jpa.JpaBoards4;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaBoardRepositorys4 extends JpaRepository<JpaBoards4, Long> {

    List<JpaBoards4> findAllByTitleContainingOrWriterContainingOrWriter1Containing(String title, String writer, String writer1);
}