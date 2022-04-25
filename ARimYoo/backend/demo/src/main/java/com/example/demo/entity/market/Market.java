package com.example.demo.entity.market;

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
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String title;

    @Column (nullable = false)
    private String writer;

    @Column (nullable = false)
    private int price;

    @Column (nullable = false)
    private String usedCondition;

    @Lob
    private String content;

    @Column (nullable = false)
    private String category;

    @Column (nullable = false)
    private String fileName1;

    @Column
    private String fileName2;

    @Column
    private String fileName3;

    @Column
    private String fileName4;

    @Column
    private String fileName5;

    @Column
    private int viewCnt = 0;

    @Formula("(SELECT count(1) FROM market_comment m WHERE m.market_board_no = board_no)")
    private int commentCnt;

    @CreatedDate
    private String regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));

    @UpdateTimestamp
    private LocalDateTime upDate;

    @OneToMany(mappedBy = "market", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<MarketComment> comment;

    public void increaseViewCnt() {
        this.viewCnt++;
    }

    public Market(String fileName1, String fileName2){
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
    }
}
