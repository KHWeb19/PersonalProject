package com.example.demo.repository.jpa.order63;




import com.example.demo.entity.jpa.JpaBoards2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaBoardRepositorys2 extends JpaRepository<JpaBoards2, Long> {

    List<JpaBoards2> findByTitleOrContent(String title, String content);
}