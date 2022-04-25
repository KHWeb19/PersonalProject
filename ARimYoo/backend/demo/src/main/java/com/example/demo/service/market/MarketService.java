package com.example.demo.service.market;

import com.example.demo.entity.market.Market;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MarketService {

    public void register (Market market, @RequestParam(required = false) List<MultipartFile> file) throws Exception;
    public List<Market> list ();
    public Market read (Long boardNo);
    public void modify ( Market market, @RequestParam(required = false) List<MultipartFile> file) throws Exception;
    public void remove (Integer boardNo) throws Exception ;
    public List<Market> searchList (String keyword);
}
