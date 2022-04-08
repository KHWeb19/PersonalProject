package com.example.demo.entity.board;

import com.example.demo.entity.board.CommunityBoard;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "file")
public class CommunityPhoto {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    @ManyToOne
    private CommunityBoard board;

    @Column(nullable = false)
    private String origFileName;

    @Column(nullable = false)
    private String filePath;

    private Long fileSize;

    @Builder
    public CommunityPhoto(String origFileName, String filePath, Long fileSize){
        this.origFileName = origFileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

//    public void setBoard (CommunityBoard board) {
//        this.board = board;
//
//        if (!board.getPhoto().contains(this))
//            board.getPhoto().add(this);
//    }

}
