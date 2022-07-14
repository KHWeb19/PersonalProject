package com.example.backend.service.jpa;

import com.example.backend.entity.jpa.Board;
import com.example.backend.repository.jpa.JpaBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JpaBoardServiceImpl implements JpaBoardService {

    @Autowired
    private JpaBoardRepository boardRepository;


    @Override
    public void register(Board board) throws Exception {
        boardRepository.save(board);
    }

    @Override
    public List<Board> list() throws Exception {
        return boardRepository.findAll();

    }

    @Override
    public Board read(Long boardNo) throws Exception {
        Optional<Board> optional = boardRepository.findById(boardNo);
        if(optional.isPresent()) {
            Board board = optional.get();
            boardRepository.save(board);

            return board;
        } else {
            throw new NullPointerException();
        }

    }

    @Override
    public void remove(Long boardNo) throws Exception {
        boardRepository.deleteById(boardNo);
    }

}
