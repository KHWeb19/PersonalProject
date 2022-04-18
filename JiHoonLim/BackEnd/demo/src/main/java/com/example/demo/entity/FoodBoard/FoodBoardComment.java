package com.example.demo.entity.FoodBoard;

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
public class FoodBoardComment {

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
    private String regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));

    @UpdateTimestamp
    private LocalDateTime updDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "foodBoard_boardNo")
    private FoodBoard foodBoard;

    public FoodBoardComment(String comment, String commentWriter){
        this.comment = comment;
        this.commentWriter= commentWriter;
    }

}
