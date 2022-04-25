package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class TipBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String title;

    @Column(length = 32, nullable = false)
    private String writer;

    @Lob
    //@Lob은 일반적인 데이터베이스에서 저장하는 길이인 255개 이상의 문자를 저장하고 싶을 때 지정한다.
    private String content;

    @Formula("(SELECT count(1) FROM tip_board_like c WHERE c.tip_board_board_no = board_no)")
    private int likeCnt;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude@OneToMany(mappedBy = "tipBoard", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<TipBoardLike> likes = new HashSet<>();
}
