package com.example.demo.service.board;

import com.example.demo.entity.Board;
import com.example.demo.entity.BoardComment;
import com.example.demo.entity.BoardImg;
import com.example.demo.repository.BoardCommentRepository;
import com.example.demo.repository.BoardImgRepository;
import com.example.demo.repository.BoardRepository;
import com.example.demo.request.BoardCommentRequest;
import com.example.demo.request.BoardReplyRequest;
import com.example.demo.response.BoardCommentResponse;
import com.example.demo.response.BoardImgResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardImgRepository boardImgRepository;

    @Autowired
    private BoardCommentRepository boardCommentRepository;

    @Override
    public void register(List<String> fileList, String title, String place, String writer, String boardContent) {

        Board board = new Board(title, place, writer, boardContent, fileList.get(0));

        boardRepository.save(board);

        if(fileList.size() > 0) {
            for (String file : fileList) {
                BoardImg boardImg = new BoardImg(file, board);
                boardImgRepository.save(boardImg);
            }
        }
    }

    @Override
    public List<Board> list() {
        List<Board> board = boardRepository.findAll();

        for(Board board1 : board){
            log.info(board1.getTitle());
        }

        return board;
    }

    @Override
    public Board read(Integer boardNo) {

        Optional<Board> board = boardRepository.findById(boardNo);

        if(board.equals(Optional.empty())){
            log.info("board 가 없어요!");
            return null;
        }
        log.info(board.get().getTitle());
        return board.get();
    }

    @Override
    public List<BoardImgResponse> imgList(Integer boardNo) {

        List<BoardImg> boardImg = boardImgRepository.findImageByBoardNo(boardNo);

        if (boardImg.isEmpty()){
            log.info("board에 이미지가 없어요");
            return null;
        }

        List<BoardImgResponse> boardImgResponses = new ArrayList<>();

        for(BoardImg image : boardImg){
            log.info(image.getBoardImgNo()+image.getImgSrc());

            boardImgResponses.add(new BoardImgResponse(image.getImgSrc(), image.getBoardImgNo()));
        }

        return boardImgResponses;
    }

    @Override
    public void remove(Integer boardNo) {
        List<BoardImg> boardImg = boardImgRepository.findImageByBoardNo(boardNo);

        boardImgRepository.deleteAll(boardImg);
        boardRepository.deleteById(boardNo);
    }

    @Override
    public void modify(Board board) {
        log.info("boardNo: "+board.getBoardNo() +", boardContent: " + board.getBoardContent());
        Board boardEntity = boardRepository.findBoardByBoardNo(board.getBoardNo());
        log.info(boardEntity.getImgSrc());
        board.setImgSrc(boardEntity.getImgSrc());
        board.setWriter(boardEntity.getWriter());

        boardRepository.save(board);
    }

    @Override
    public void modifyImg(Integer boardNo, List<String> boardImgNo) {

        log.info(boardImgNo.size() + "size!");
        log.info(boardImgNo.get(0) + "boardNo");
        log.info(Integer.valueOf(boardImgNo.get(0)) + "boardNo");

        for(int i = 0; i < boardImgNo.size(); i++) {
            BoardImg boardImgEntity = boardImgRepository.findByBoardImgNo(Integer.valueOf(boardImgNo.get(i)));
            log.info("123123"+boardImgEntity.getBoardImgNo());
            boardImgRepository.deleteById(boardImgEntity.getBoardImgNo());
        }

        List<BoardImg> boardImgList = boardImgRepository.findImageByBoardNo(boardNo);

        if(!boardImgList.isEmpty()) {
            Board board = boardRepository.findBoardByBoardNo(boardNo);
            board.setImgSrc(boardImgList.get(0).getImgSrc());
            boardRepository.save(board);
        }

    }

    @Override
    public List<Board> searchPlace(String searchBoard) {
        List<Board> board = boardRepository.findPlaceByPlace(searchBoard);

        for(Board board1 : board){
            log.info(board1.getTitle());
        }

        if(board.isEmpty()){
            return null;
        }

        return board;
    }

    @Override
    public void saveComment(BoardCommentRequest boardCommentRequest) {

        Board board = boardRepository.findBoardByBoardNo(boardCommentRequest.getBoardNo());

        List<BoardComment> boardComments = boardCommentRepository.findByBoardNo(boardCommentRequest.getBoardNo());

        //log.info("board 크기!!!!!!!!! "+boardComments.size());
        //String boardComment, Integer ref, String writer, Integer deep, Integer deepOrder, Integer commentNum, Integer parent, Board board)
        BoardComment boardCommentEntity = new BoardComment(boardCommentRequest.getComment(), boardComments.size()+1,
                boardCommentRequest.getWriter(), 0, 0, 0, 0,  board);

        boardCommentRepository.save(boardCommentEntity);
    }

    @Override
    public List<BoardCommentResponse> commentList(Integer boardNo) {

        List<BoardComment> boardCommentList = boardCommentRepository.findByBoardNo(boardNo);

        if (boardCommentList.isEmpty()){
            log.info("댓글 없어요!");

            return null;
        }

        List<BoardCommentResponse> boardCommentResponses = new ArrayList<>();

        for(BoardComment boardComment : boardCommentList){
            log.info(boardComment.getBoardCommentNo() + "");

            boardCommentResponses.add(new BoardCommentResponse(boardComment.getBoardComment(), boardComment.getWriter(), boardComment.getBoardCommentNo(), boardComment.getDeep(), boardComment.getParent()));
        }

        return boardCommentResponses;
    }

    @Override
    public void saveReply(BoardReplyRequest boardReplyRequest) {

        BoardComment boardComment = boardCommentRepository.findByCommentNo(boardReplyRequest.getCommentNo());

        boardComment.setCommentNum(boardComment.getCommentNum()+1);

        boardCommentRepository.save(boardComment);

        //public void reply(String boardComment, String writer, Board board, Integer parent, Integer deep)

        List<BoardComment> boardComments = boardCommentRepository.findByParentNo(boardComment.getParent());

       /* BoardComment reply = new BoardComment();
        reply.reply(boardReplyRequest.getReply(), boardReplyRequest.getWriter(), boardComment.getBoard(), boardReplyRequest.getCommentNo(), boardComments.size());*/

        //String boardComment, Integer ref, String writer, Integer deep, Integer deepOrder, Integer commentNum, Integer parent, Board board)
        log.info("여기까지 안들어와?");
        BoardComment reply = new BoardComment(boardReplyRequest.getReply(), boardComment.getRef(), boardReplyRequest.getWriter(), boardComment.getDeep()+1,
                boardComment.getDeepOrder()+1, 0, boardReplyRequest.getCommentNo(), boardComment.getBoard());
        boardCommentRepository.save(reply);


    }


}
