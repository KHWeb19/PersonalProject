package com.example.demo.service.board.photoBoard;

import com.example.demo.dto.response.PhotoBoardResponse;
import com.example.demo.dto.request.BoardRequest;
import com.example.demo.dto.request.LikeRequest;
import com.example.demo.entity.board.photoBoard.PhotoBoard;
import com.example.demo.entity.board.photoBoard.PhotoBoardLike;
import com.example.demo.repository.board.photoBoard.PhotoBoardLikeRepository;
import com.example.demo.repository.board.photoBoard.PhotoBoardRepository;

import com.example.demo.service.board.BoardImpl;
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
public class PhotoBoardServiceImpl extends BoardImpl implements PhotoBoardService {

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
    public  List<PhotoBoardResponse> list() {
                List<PhotoBoard> photo = repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
                List<PhotoBoardResponse> response = new ArrayList<>();
                 for(PhotoBoard board : photo){
                     response.add(new PhotoBoardResponse(board.getTitle(), board.getContent(), board.getWriter(),
                             board.getFileName(), board.getBoardNo(), board.getRegDate(), board.getReadCnt(),
                             board.getLikeCnt(), board.getLikeCheck(), board.getCommentCnt()));
                 }

                 return response;
    }

   @Override
    public PhotoBoardResponse read(Integer boardNo) {
        Optional<PhotoBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!!");
            return null;
        }

        PhotoBoard readBoard = maybeReadBoard.get();
        readBoard.readCnt();
        repository.save(readBoard);

        PhotoBoardResponse response = new PhotoBoardResponse(readBoard.getTitle(), readBoard.getContent(), readBoard.getWriter(),
                readBoard.getFileName(), readBoard.getBoardNo(), readBoard.getRegDate(), readBoard.getReadCnt(),
                                        readBoard.getLikeCnt(), readBoard.getLikeCheck(), readBoard.getCommentCnt());

        return response;
    }

    @Override
    public void modify(Integer boardNo, BoardRequest board, MultipartFile files) throws Exception {

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
        //like 테이블에 추가
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
        //like 테이블에서 삭제
        Optional<PhotoBoardLike> id = likeRepository.findId(like.getBoardNo(), like.getWriter());
            log.info("id " + id);
            PhotoBoardLike likeRemove = id.get();

          likeRepository.deleteById(likeRemove.getLikeNo());
    }


    @Override
    public void likeCheck(String writer) {
        //작성자가 좋아요 했는지 찾는다
        //지금 상당히 비효율적인 것 같음...
        //애초에 좋아요 눌렀다는게 있으면 좋아요 들어오게??
        //그럼 좋아요 정보 보내주면 그아이디랑 , 라이터가 같으면 좋아요 들어오는쪽으로???

        //로그인 아이디로 좋아요 누른 boardNo 가져오기
        List<PhotoBoardLike> checkLike = likeRepository.findByWriter(writer);

        //로그아웃 되도 likeCnt 1로 유지 되서한번 likeCnt를 0으로 해주는 작업이 필요함
        List<PhotoBoard> photoBoard = repository.findAll();
        for (PhotoBoard board : photoBoard) {
            board.likeCheckZero();
            repository.save(board);
        }
        //boardNo 같은 게시판 likeCheck 1(true) 만들어주기
        for (PhotoBoardLike likeCheck : checkLike){
            Optional<PhotoBoard> findLike =
                    repository.findById(Long.valueOf(likeCheck.getPhotoBoard().getBoardNo()));

            PhotoBoard likeTrue = findLike.get();
                if (likeTrue.getLikeCheck() == 0) {
                    likeTrue.setLikeCheck(likeTrue.getLikeCheck() + 1);
                }
                //내용 저장
                repository.save(likeTrue);
            }

        }

}
