package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Column(name = "member_no")
    private Long memberNo;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();
}
