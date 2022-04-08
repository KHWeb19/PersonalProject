package com.example.demo.entity.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class MemberTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberNo;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 128, nullable = false)
    private String pw;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date lastModifiedDate;

    public MemberTest(String id, String pw){
        this.id = id;
        this.pw = pw;
    }
}
