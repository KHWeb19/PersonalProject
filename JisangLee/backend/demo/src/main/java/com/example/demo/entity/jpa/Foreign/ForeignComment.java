package com.example.demo.entity.jpa.Foreign;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Data
@Entity
@NoArgsConstructor
public class ForeignComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long commentId;

    @NotNull
    @Column
    private String comment;

    @NotNull
    @Column
    private String commentWriter;

    @CreatedDate
    private String date = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="foreignBoard_boardNo")
    private ForeignBoard foreignBoard;

    public ForeignComment(String comment, String commentWriter){
        this.comment = comment;
        this.commentWriter = commentWriter;
    }
}
