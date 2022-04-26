package com.example.demo.service.board;

import com.example.demo.entity.Board;
import com.example.demo.request.BoardCommentRequest;
import com.example.demo.response.BoardCommentResponse;
import com.example.demo.response.BoardImgResponse;

import java.util.List;

public interface BoardService {
    void register(List<String> fileList, String title, String place, String writer, String boardContent);

    List<Board> list();
    Board read(Integer boardNo);
    List<BoardImgResponse> imgList(Integer boardNo);
    void remove(Integer boardNo);
    void modify(Board board);
    void modifyImg(Integer boardNo, List<String> boardImgNo);
    List<Board> searchPlace(String searchBoard);

    void saveComment(BoardCommentRequest boardCommentRequest);
    List<BoardCommentResponse> commentList(Integer boardNo);
}

