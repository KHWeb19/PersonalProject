package com.example.demo.service.jpa.Complaint;

import com.example.demo.entity.jpa.Complaint.ComplaintBoard;
import com.example.demo.repository.jpa.Complaint.ComplaintBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ComplaintBoardServiceImpl implements ComplaintBoardService {

    @Autowired
    ComplaintBoardRepository repository;

    @Override
    public void register(ComplaintBoard board) {
        repository.save(board);
    }

    @Override
    public List<ComplaintBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public ComplaintBoard read(Integer boardNo) {
        Optional<ComplaintBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        } else {
            ComplaintBoard localBoard = maybeReadBoard.get();
            localBoard.increaseViewCnt();
            repository.save(localBoard);
            return maybeReadBoard.get();
        }
    }

    @Override
    public void modify(ComplaintBoard board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
}