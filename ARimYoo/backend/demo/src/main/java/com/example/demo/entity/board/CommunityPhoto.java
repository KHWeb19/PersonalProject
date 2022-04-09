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

    @Column
    private String origFileName;

    @Column
    private String fileName;

    @Column
    private String filePath;


    @Builder
    public CommunityPhoto(Long id, String origFileName, String filePath, String fileName){
        this.id = id;
        this.origFileName = origFileName;
        this.filePath = filePath;
        this.fileName = fileName;
    }

}
