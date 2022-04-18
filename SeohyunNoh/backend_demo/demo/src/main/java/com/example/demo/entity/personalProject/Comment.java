package com.example.demo.entity.personalProject;

import com.example.demo.controller.request.CommentDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_no")
    private Long commentNo;

    private Long qnaNo;

    private String id;
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public void updateContent(CommentDto commentDto) {
        this.content = commentDto.getContent();
    }
}
