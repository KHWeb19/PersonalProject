package com.example.demo.service.board.photoBoard;

import com.example.demo.dto.BoardResponse;
import com.example.demo.dto.BoardRequest;
import com.example.demo.dto.LikeRequest;
import com.example.demo.entity.board.photoBoard.PhotoBoard;
import com.example.demo.entity.board.photoBoard.PhotoBoardLike;
import com.example.demo.repository.board.photoBoard.PhotoBoardLikeRepository;
import com.example.demo.repository.board.photoBoard.PhotoBoardRepository;

import com.example.demo.service.board.BoardService;
import com.example.demo.service.board.BoardServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PhotoBoardServiceImpl extends BoardServiceImpl implements BoardService {

    String path = "uploadImg";

    @Autowired
    private PhotoBoardRepository repository;

    @Autowired
    private PhotoBoardLikeRepository likeRepository;

    @Override
    public void register(BoardRequest board, MultipartFile files) throws Exception {

        fileUpload(board, files, path);

        PhotoBoard photoBoard = PhotoBoard.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .fileName(board.getFileName())
                .likeCheck(0)
                .build();

        repository.save(photoBoard);
    }

    @Transactional
    @Override
    public  List<BoardResponse> list() {
                List<PhotoBoard> photo = repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
                List<BoardResponse> responses = new ArrayList<>();
                 for(PhotoBoard board : photo){
                     responses.add(new BoardResponse(board));
                 }

                 return responses;


    }

   @Override
    public BoardResponse read(Integer boardNo) {
        Optional<PhotoBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!!");
            return null;
        }

        PhotoBoard readBoard = maybeReadBoard.get();
        readBoard.readCnt();
        repository.save(readBoard);

        BoardResponse response = new BoardResponse(readBoard);

        return response;
    }

    @Override
    public void modify(Integer boardNo, BoardRequest board, MultipartFile files) throws Exception {
        log.info(board + " " );

        //참조 할 수 있도록 boardNo으로 가져오는데 likee에는 boardNo이 중복가능 그럼 결국 writer랑 boardNo으로 가져와야하나?
        //아닌가 애초에 PhotoBoard에 like는 boardNo을 외래키로두고 참조하는것인가 이 게시판에 참조하는걸 다 가져오는게 맞는건가!
        List<PhotoBoardLike> likes= likeRepository.findByBoardNo(Long.valueOf(boardNo));

        PhotoBoard photoBoard = PhotoBoard.builder()
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
            photoBoard.setFileName(board.getFileName());
        }

        repository.save(photoBoard);
    }

    @Override
    public void remove(Integer boardNo) {
        //파일삭제
        Optional<PhotoBoard> findFileName = repository.findFileName(Long.valueOf(boardNo));

        String fileName = String.valueOf(findFileName.get());

        fileRemove(fileName, path);
        //db삭제
        repository.deleteById(Long.valueOf(boardNo));
    }

    @Override
    public void doLike(LikeRequest like) {

        Optional<PhotoBoard> maybeBoard = repository.findById(like.getBoardNo());
        PhotoBoard board = maybeBoard.get();
        //board.setLikeCheck(like.getLikeCheck());

        log.info("*********" +  like.getLikeCheck());

        PhotoBoardLike doLike = PhotoBoardLike.builder()
                        .photoBoard(board)
                        .writer(like.getWriter())
                        .build();


                 likeRepository.save(doLike);
    }

    @Override
    public void unDoLike(LikeRequest like) {
        Optional<PhotoBoardLike> id = likeRepository.findId(like.getBoardNo(), like.getWriter());
            log.info("id " + id);
            PhotoBoardLike likeRemove = id.get();

          likeRepository.deleteById(likeRemove.getLikeNo());
    }

    @Transactional
    @Override
    public void likeCheck(String writer) {
        //작성자가 좋아요 했는지 찾는다
        //지금 상당히 비효율적임
        //애초에 좋아요 눌렀다는게 있으면 좋아요 들어오게??
        //그럼 좋아요 정보 보내주면 그아이디랑 , 라이터가 같으면 좋아요 들어오는쪽으로???
        //
        List<PhotoBoardLike> checkLike = likeRepository.findByWriter(writer);
        log.info("checkLike" + checkLike);
        //로그아웃 되도 likeCnt 1로 유지 되서한번 likeCnt를 0으로 해주는 작업이 필요함
        List<PhotoBoard> photoBoard = repository.findAll();
        for (PhotoBoard board : photoBoard) {
            board.likeCheckZero();
            repository.save(board);
        }

        log.info("hoto" + photoBoard.size());
        for (PhotoBoardLike likeCheck : checkLike) {
            for (int i = 1; i <= photoBoard.size(); i++) {
                //몇번보드에 좋아요 눌렀는지 체크
                if (likeCheck.getPhotoBoard().getBoardNo() == i) {
                    //여기는 좋아요 하면 들어 오게되어있음 좋아요 했던게 있으면
                    // 그럼 좋아요가 1(true)가 되어야함
                    log.info("또 머선일이고 ㅠㅠ");
                    //그 보드 찾아서 좋아요로 바꿔줌
                    Optional<PhotoBoard> findLike = repository.findById(Long.valueOf(i));
                    PhotoBoard likeTrue = findLike.get();

                    if (likeTrue.getLikeCheck() == 0) {
                        likeTrue.setLikeCheck(likeTrue.getLikeCheck() + 1);
                    }
                    //내용 저장
                    repository.save(likeTrue);
                }
            }
        }
    }
}
