package com.example.demo.service.Board;

import com.example.demo.controller.request.BoardRequest;
import com.example.demo.entity.Board.Board;
import com.example.demo.repository.Board.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public void register (Board board) {
        boardRepository.save(board);
    }

    @Override
    @Transactional
    public List<Board> list() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public Board read (Integer boardNo){
        Optional<Board> maybeReadBoard = boardRepository.findById(Long.valueOf(boardNo));

        if(maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board");
            return null;
        }

        return maybeReadBoard.get();
    }

    @Override
    public void modify (Board board) {
        boardRepository.save(board);
    }

    @Override
    public void remove(Long boardNo) {
        boardRepository.deleteById(Long.valueOf(boardNo));
    }
}
