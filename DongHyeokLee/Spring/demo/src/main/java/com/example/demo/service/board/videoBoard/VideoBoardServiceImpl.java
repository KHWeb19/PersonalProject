package com.example.demo.service.board.videoBoard;

import com.example.demo.dto.request.BoardRequest;
import com.example.demo.dto.request.LikeRequest;
import com.example.demo.dto.response.BoardResponse;

import com.example.demo.entity.board.videoBoard.VideoBoard;
import com.example.demo.entity.board.videoBoard.VideoBoardLike;
import com.example.demo.repository.board.videoBoard.VideoBoardLikeRepository;
import com.example.demo.repository.board.videoBoard.VideoBoardRepository;
import com.example.demo.service.board.BaseBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Slf4j
@Service
public class VideoBoardServiceImpl extends BaseBoardService {

    @Autowired
    private VideoBoardRepository repository;

    @Autowired
    private VideoBoardLikeRepository likeRepository;

    @Override
    public void register(BoardRequest board,
                         MultipartFile files, String path) throws Exception {
        fileUpload(board,files,path);

        VideoBoard videoBoard = VideoBoard.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .fileName(board.getFileName())
                .build();

        repository.save(videoBoard);
    }

    @Override
    public List<BoardResponse> list() {
        List<VideoBoard> photo = repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
        List<BoardResponse> response = new ArrayList<>();
        for(VideoBoard board : photo){
            response.add(new BoardResponse(board.getTitle(), board.getContent(), board.getWriter(),
                    board.getFileName(), board.getBoardNo(), board.getRegDate(), board.getReadCnt(),
                    board.getLikeCnt(), board.getLikeCheck(), board.getCommentCnt()));
        }

        return response;
    }

    @Override
    public BoardResponse read(Integer boardNo) {
        Optional<VideoBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!!");
            return null;
        }

        VideoBoard readBoard = maybeReadBoard.get();
        readBoard.readCnt();
        repository.save(readBoard);

        BoardResponse response = new BoardResponse(readBoard.getTitle(), readBoard.getContent(),
                readBoard.getWriter(), readBoard.getFileName(), readBoard.getBoardNo(), readBoard.getRegDate(),
                readBoard.getReadCnt(), readBoard.getLikeCnt(), readBoard.getLikeCheck(), readBoard.getCommentCnt());

        return response;
    }

    @Override
    public void modify(Integer boardNo, BoardRequest board, MultipartFile files,  String path) throws Exception {

        List<VideoBoardLike> likes= likeRepository.findByBoardNo(Long.valueOf(boardNo));

        VideoBoard videoBoard = VideoBoard.builder()
                .boardNo(Long.valueOf(boardNo))
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .fileName(board.getFileName())
                .regDate(board.getRegDate())
                .likes(likes)
                .build();
        //파일도 변경 시
        if(files != null) {
            String fileName = files.getOriginalFilename();
            fileRemove(fileName, path);
            fileUpload(board,files,path);
            videoBoard.setFileName(board.getFileName());
        }

        repository.save(videoBoard);
    }

    @Override
    public void remove(Integer boardNo,String path) {
        Optional<VideoBoard> findFileName = repository.findFileName(Long.valueOf(boardNo));
        String fileName = String.valueOf(findFileName.get());

        fileRemove(fileName,path);

        repository.deleteById(Long.valueOf(boardNo));
    }

    @Override
    public void doLike(LikeRequest like) {
        //like 테이블에 추가
        Optional<VideoBoard> maybeBoard = repository.findById(like.getBoardNo());
        VideoBoard board = maybeBoard.get();
        //board.setLikeCheck(like.getLikeCheck());

        log.info("*********" +  like.getLikeCheck());

        VideoBoardLike doLike = VideoBoardLike.builder()
                .videoBoard(board)
                .writer(like.getWriter())
                .build();

        likeRepository.save(doLike);
    }

    @Override
    public void unDoLike(LikeRequest like) {
        //like 테이블에서 삭제
        Optional<VideoBoardLike> id = likeRepository.findId(like.getBoardNo(), like.getWriter());
        log.info("id " + id);
        VideoBoardLike likeRemove = id.get();

        likeRepository.deleteById(likeRemove.getLikeNo());
    }


    @Override
    public void likeCheck(String writer) {

        //로그인 아이디로 좋아요 누른 boardNo 가져오기
        List<VideoBoardLike> checkLike = likeRepository.findByWriter(writer);

        //로그아웃 되도 likeCnt 1로 유지 되서한번 likeCnt를 0으로 해주는 작업이 필요함
        List<VideoBoard> photoBoard = repository.findAll();
        for (VideoBoard board : photoBoard) {
            board.likeCheckZero();
            repository.save(board);
        }
        //boardNo 같은 게시판 likeCheck 1(true) 만들어주기
        for (VideoBoardLike likeCheck : checkLike){
            Optional<VideoBoard> findLike =
                    repository.findById(Long.valueOf(likeCheck.getVideoBoard().getBoardNo()));

            VideoBoard likeTrue = findLike.get();
            if (likeTrue.getLikeCheck() == 0) {
                likeTrue.setLikeCheck(likeTrue.getLikeCheck() + 1);
            }
            //내용 저장
            repository.save(likeTrue);
        }

    }


}
