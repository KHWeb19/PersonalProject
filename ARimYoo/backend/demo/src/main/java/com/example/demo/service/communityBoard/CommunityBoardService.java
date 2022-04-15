package com.example.demo.service.communityBoard;

import com.example.demo.entity.communityBoard.CommunityBoard;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CommunityBoardService {

    public void register (CommunityBoard board, @RequestParam(required = false) MultipartFile file) throws Exception;
    public List<CommunityBoard> list ();
    public CommunityBoard read (Long boardNo);
    public void modify (CommunityBoard communityBoard, @RequestParam(required = false) MultipartFile file) throws Exception;
    public void remove (Integer boardNo) throws Exception ;
    public List<CommunityBoard> searchList (String keyword);
}
