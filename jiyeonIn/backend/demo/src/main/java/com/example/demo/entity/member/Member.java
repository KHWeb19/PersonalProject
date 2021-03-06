package com.example.demo.entity.member;

import com.example.demo.entity.booking.BookingInfo;
import com.example.demo.entity.review.Review;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cake_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(length = 32, nullable = false)
    private String userId;

    @Column(length = 128, nullable = false)
    private String password;

    @Column(length = 32, nullable = false)
    private String userName;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "member",fetch = FetchType.EAGER , cascade = CascadeType.REMOVE)
    private Set<MemberAuth> authList = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "memberInfo", fetch = FetchType.EAGER  , cascade = CascadeType.REMOVE)
    private Set<BookingInfo> bookingInfo = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "memberReview", fetch = FetchType.EAGER , cascade = CascadeType.REMOVE)
    private Set<Review> review = new HashSet<>();

    public Member (String userId, String password, String userName) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
    }

    public Member (String userId, String password, String userName, MemberAuth auth) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;

        if(auth != null) {
            changeAuth(auth);
        }
    }
    public Member (Long memberNo,String userId, String password, String userName, Date regDate) {
        this.memberNo = memberNo;
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.regDate = regDate;
    }
    public Member (Long memberNo, String userId, String password, String userName,Date regDate, MemberAuth auth) {
        this.memberNo = memberNo;
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.regDate = regDate;

        if(auth != null) {
            changeAuth(auth);
        }
    }

    public void changeAuth(MemberAuth auth) {}

    public void addAuth (MemberAuth auth) {
        if (authList == null) {
            authList = new HashSet();
        }

        authList.add(auth);
    }

    public void clearAuthList () {
        authList.clear();
    }
}
