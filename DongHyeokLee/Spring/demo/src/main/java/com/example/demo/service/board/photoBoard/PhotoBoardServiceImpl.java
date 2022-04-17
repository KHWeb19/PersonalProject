package com.example.demo.service.board.photoBoard;

import com.example.demo.dto.BoardRequest;
import com.example.demo.dto.LikeRequest;
import com.example.demo.entity.board.photoBoard.PhotoBoard;
import com.example.demo.entity.board.photoBoard.PhotoBoardLike;
import com.example.demo.repository.board.photoBoard.PhotoBoardLikeRepository;
import com.example.demo.repository.board.photoBoard.PhotoBoardRepository;

import com.example.demo.service.board.BoardServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.codec.multipart.PartHttpMessageWriter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PhotoBoardServiceImpl extends BoardServiceImpl implements PhotoBoardService {

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

    @Override
    public List<PhotoBoard> list(String writer) {
                //boardNo을 가져옴
                //그 보드넘에 likeCheck = 0을 넣어줌
                // 그걸 어케하노 , 와꾸가 잘못됐낭
                //좋아요 엔티티
                //id 	boardNo	 user
                //1	       1	도동자
                //2	       1	달빛
                //그럼 이거 boardNo이랑 조인컬럼 해야겠네
                //기존 보드 엔티티에
                //boardNo 	likeCnt	 like
                //1	         100	false
                //like cnt는 좋아요 엔티티에 보드넘 새가지고 넣어주면 될듯 fomula?!
                //list접속 -> 로그인 아이디 스프링 전달 -> 아이디로 좋아요 누른 BoadNo 찾아 내기
                //-> 그 넘버 게시판 like=true처리 -> list vue로 보내주기?! 하면 쌉가능???
                //근데 이게 리스트 접속이면 리스트 불러오는 것도 동시에 일어나나??
                //true false로 하려했는데 엔티티에 boolean안되드라

                List<PhotoBoardLike> checkLike = likeRepository.findByWriter(writer);
                //작성자로 boardLike에 몇번보드에 좋아요 했는지 찾는다( 보느넘버는 무조건 각 하나씩임 )
                // 보느 넘버랑 i돌면서 같은게 있으면 그 보드 넘버에 좋아요 했다는 뜻이니깐
                //그 보드넘버 likeCheck를 1로 변경 ( 0 = unlike 1 = like)
                //이래도 되나
                //한번 likeCnt를 0으로 해주는 작업이 필요함
                PhotoBoard board = new PhotoBoard();
                board.likeCheckZero();

                for(PhotoBoardLike likeCheck : checkLike ){
                    for(int i = 1; i <= checkLike.size(); i++){
                        if(likeCheck.getPhotoBoard().getBoardNo() == i){
                            //여기는 좋아요 하면 들어 오게되어있음 좋아요 했던게 있으면 !
                            // 그럼 좋아요가 true가 되어야함
                            Optional<PhotoBoard> photoBoard = repository.findById(Long.valueOf(i));
                             board = photoBoard.get();

                            log.info("boardNo" + likeCheck.getPhotoBoard().getBoardNo());

                            log.info("board " + board);
                            if(board.getLikeCheck() == 0) {
                                board.setLikeCheck(board.getLikeCheck() + 1);
                            }

                            repository.save(board);
                        }
                    }
                }
        //최종적으로 로그아웃하면 1이 0으로 되게해야함 근데 그러면 로그인 했다해서 1이되지않음

                return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));

    }

   @Override
    public PhotoBoard read(Integer boardNo) {
        Optional<PhotoBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!!");
            return null;
        }

        PhotoBoard readBoard = maybeReadBoard.get();
        readBoard.setReadCnt(readBoard.getReadCnt() + 1);
        repository.save(readBoard);

        return readBoard;
    }

    @Override
    public void modify(Integer boardNo, BoardRequest board, MultipartFile files) throws Exception {
        log.info(board + " " );

        PhotoBoard photoBoard = PhotoBoard.builder()
                .boardNo(Long.valueOf(boardNo))
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .fileName(board.getFileName())
                .regDate(board.getRegDate())
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
        PhotoBoard photoBoard = findFileName.get();

        String fileName = photoBoard.getFileName();

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

                repository.save(board);
                 likeRepository.save(doLike);
    }

    @Override
    public void unDoLike(LikeRequest like) {
        Optional<PhotoBoard> maybeBoard = repository.findById(like.getBoardNo());
        PhotoBoard board = maybeBoard.get();
        board.setLikeCheck(like.getLikeCheck());
        repository.save(board);

        Optional<PhotoBoardLike> id = likeRepository.findId(like.getBoardNo(), like.getWriter());
            log.info("id " + id);
            PhotoBoardLike likeRemove = id.get();

          likeRepository.deleteById(likeRemove.getLikeNo());
    }
}
