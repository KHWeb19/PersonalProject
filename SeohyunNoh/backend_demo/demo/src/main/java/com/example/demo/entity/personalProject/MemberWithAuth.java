package com.example.demo.entity.personalProject;

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
public class MemberWithAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 32, nullable = false)
    private String userId;

    @Column(length = 128, nullable = false)
    private String password;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<MemberAuth> authList;

    public MemberWithAuth (String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public void addAuth (MemberAuth auth) {
        if (authList == null) {
            authList = new ArrayList<MemberAuth>();
        }

        authList.add(auth);
    }

    public void clearAuthList () {
        authList.clear();
    }
}
