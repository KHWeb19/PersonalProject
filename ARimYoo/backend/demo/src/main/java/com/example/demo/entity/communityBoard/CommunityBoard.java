package com.example.demo.entity.communityBoard;

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
public class CommunityBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String title;

    @Column (nullable = false)
    private String writer;

    @Lob
    private String content;

    @Column (nullable = false)
    private String brackets;

    @Column
    private String fileName;

    @Column
    private int viewCnt = 0;

    @Formula("(SELECT count(1) FROM community_comment_box c WHERE c.community_board_board_no = board_no)")
    private int commentCnt;

    @Formula("(SELECT count(1) FROM community_board_like c WHERE c.community_board_board_no = board_no)")
    private int likeCnt;

    @CreatedDate
    private String regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));

    @UpdateTimestamp
    private LocalDateTime upDate;

    @OneToMany(mappedBy = "communityBoard", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<CommunityCommentBox> commentBoxes;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "communityBoard", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CommunityBoardLike> likes = new HashSet<>();

    public void increaseViewCnt() {
        this.viewCnt++;
    }

    public CommunityBoard (String fileName){
        this.fileName = fileName;
    }

//    public CommunityBoard (Long boardNo, String title, String writer, String content, String brackets,
//                   String viewCnt) {
//        this.boardNo = boardNo;
//        this.title = title;
//        this.writer = writer;
//        this.content = content;
//        this.brackets = brackets;
//        this.viewCnt = viewCnt;
//
//    }

}
