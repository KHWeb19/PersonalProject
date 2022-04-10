package com.example.demo.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Data
@NoArgsConstructor
public class MemberRequest {

    private Long memberNo;
    private String auth;
    private String id;
    private String pw;
    private Date regDate;
    private Date updDate;
//    private String name;
//    private String gender;
//    private String address;
//    private Date birthDay;

}
