package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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

//    @Column(name = "member_no")
//    private Long memberNo;

    @Column(length = 64, nullable = false)
    private String boardImage;

    @Column(length = 32, nullable = false)
    private String writer;

    @Lob
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @JsonBackReference(value="member-board")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "member_no")
    private Member member;

    @JsonManagedReference(value="board-comment")
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference(value="board-likes")
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private Set<Likes> likes = new HashSet<>();
}

