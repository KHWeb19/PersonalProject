package com.example.demo.entity.Board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Data
@Entity
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @NotNull
    @Column
    private String commentWriter;

    @NotNull
    @Column
    private String comment;

    @CreatedDate
    private String regDate;

    @PrePersist
    public void onPrePersist () {
        this.regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "boardNo")
    private Board board;


}
