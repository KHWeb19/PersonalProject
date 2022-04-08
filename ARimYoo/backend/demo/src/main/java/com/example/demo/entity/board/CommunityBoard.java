package com.example.demo.entity.board;

import com.example.demo.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class CommunityBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String title;

    @Column
    private String writer;

    @Lob
    private String content;

    @Column
    private String brackets;

//    @OneToMany(
//            mappedBy = "board",
//            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
//            orphanRemoval = true
//    )
//    private List<CommunityPhoto> photo = new ArrayList<>();

    @Column
    private String viewCnt;

    @CreationTimestamp
    private LocalDateTime regDate = LocalDateTime.now();

    @UpdateTimestamp
    private LocalDateTime upDate;

//    public void addPhoto(CommunityPhoto photo) {
//        this.photo.add(photo);
//
//        if(photo.getBoard() != this)
//            photo.setBoard(this);
//    }

}
