package com.example.demo.repository;

import com.example.demo.entity.Member;
import com.example.demo.entity.TipBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipBoardRepository extends JpaRepository<TipBoard, Long> {

    List<TipBoard> findByWriterContaining(String keyWord);

}
