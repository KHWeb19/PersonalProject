package com.example.demo.entity.Member;

import com.example.demo.entity.FoodBoard.FoodBoardComment;
import com.example.demo.entity.FoodBoard.FoodBoardLike;
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

    @Column(name = "member_no")
    private Long memberNo;

    @Column(nullable = false)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 32, nullable = false)
    private String writer;

    @Column(nullable = false)
    private String material;

    @Column(nullable = false)
    private String des;

    @Column
    private String tip;

    @Column(nullable = false)
    private String kind;

    @Column(nullable = false)
    private String mat;

    @Column(nullable = false)
    private String way;

    @Lob
    private String content;

    @Column
    private String filename;

    @Column
    private String filepath;

    @Column
    private Integer viewCount = 0;


    @CreatedDate
    private String regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));

    @UpdateTimestamp
    private LocalDateTime upDate;

    @OneToMany(mappedBy = "foodBoard",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<FoodBoardComment> comments;


    @Formula("(SELECT count(1) FROM food_board_comment c WHERE c.food_board_board_no = board_no)")
    private int commentCnt;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "foodBoard",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<FoodBoardLike> likes = new HashSet<>();

    @Formula("(SELECT count(1) FROM food_board_like c WHERE c.food_board_board_no = board_no)")
    private int likeCnt;
}
