package com.example.backend.service.serviceCenter;

import com.example.backend.entity.Board;
import com.example.backend.entity.Center;
import com.example.backend.entity.Reservation;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CenterService {

    public void register (Center center, @RequestParam(required = false) MultipartFile file) throws Exception;
    public List<Center> list ();
    public Center read (Long centerNo);
    public void modify (Center center, @RequestParam(required = false) MultipartFile file) throws Exception;
    public void remove (Integer centerNo) throws IOException;
    public List<Center> searchIdList(String searchId);
    public Center read (Long checkBoardNo,String searchId);
    //public List<Center> searchList(String keyWord);


}
