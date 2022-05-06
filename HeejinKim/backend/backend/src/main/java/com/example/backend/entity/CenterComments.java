package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CenterComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comNo;

    @Column(length = 32, nullable = false)
    private String commentWriter;

    @Column(length = 128, nullable = false)
    private String comment;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="center_no")
    private Center center;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @UpdateTimestamp
    private Date updDate;

    public CenterComments(Long comNo, String comment, Date regDate) {

        this.comment = comment;
        this.comNo = comNo;

    }
}
