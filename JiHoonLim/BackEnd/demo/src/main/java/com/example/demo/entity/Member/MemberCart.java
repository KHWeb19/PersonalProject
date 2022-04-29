package com.example.demo.entity.Member;

import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.entity.FoodBoard.FoodBoardComment;
import com.example.demo.entity.FoodBoard.FoodBoardLike;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class MemberCart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartNo;

    @NotNull
    @Column
    private Long memberNo;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "food_board_board_no")
    private FoodBoard foodBoard;



    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(nullable = false)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 32, nullable = false)
    private String writer;


    @Column(nullable = false)
    private String des;


    @Column(nullable = false)
    private String kind;

    @Column(nullable = false)
    private String mat;

    @Column(nullable = false)
    private String way;

    @Column
    private String filename;

    @Column
    private String filepath;



    public MemberCart(Long cartNo, Long memberNo, Long boardNo, String name, String writer, String des, String kind, String mat, String way, String filename, String filepath){
        this.cartNo = cartNo;
        this.memberNo = memberNo;
        this.boardNo = boardNo;
        this.name = name;
        this.writer = writer;
        this.des = des;
        this.kind = kind;
        this.mat = mat;
        this.way = way;
        this.filename = filename;
        this.filepath = filepath;
    }

     */


}
