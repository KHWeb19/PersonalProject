package com.example.demo.entity.FoodBoard;

import com.example.demo.entity.Member.MemberCart;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor

public class FoodBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Fetch(value = FetchMode.SUBSELECT)
    private List<FoodBoardComment> comments;


    @Formula("(SELECT count(1) FROM food_board_comment c WHERE c.food_board_board_no = board_no)")
    private int commentCnt;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "foodBoard",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<FoodBoardLike> likes = new HashSet<>();

    @Column
    private Integer likeCount = 0;

    @Column
    private Integer rankScore = 0;


    @OneToMany(mappedBy = "foodBoard",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<MemberCart> myCarts;

}
