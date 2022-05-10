package com.example.demo.service.jpa.Complaint;

import com.example.demo.entity.jpa.Complaint.ComplaintBoard;

import java.util.List;

public interface ComplaintBoardService {
    public void register (ComplaintBoard board);
    public List<ComplaintBoard> list ();
    public ComplaintBoard read (Integer boardNo);
    public void modify (ComplaintBoard board);
    public void remove (Integer boardNo);
}
