package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_no")
    private Long boardNo;

    @Column(length = 64, nullable = false)
    private String boardImage;

    @Column(length = 64)
    private String boardImage2;

    @Column(length = 64)
    private String boardImage3;

    @Lob
    private String content;

    @CreatedDate
    private String regDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));

    @UpdateTimestamp
    private Date updDate;

    @JsonIgnoreProperties({"boards"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "member_no")
    private Member member;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference(value="board-comment")
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private Set<Comment> comments = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties({"boards"})
//    @JsonIgnoreProperties({"boards", "member"})
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private Set<Likes> likes = new HashSet<>();
}

