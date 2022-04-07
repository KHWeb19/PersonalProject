package com.example.demo.repository.board;

import com.example.demo.entity.board.CommunityPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<CommunityPhoto, Long> {
}
