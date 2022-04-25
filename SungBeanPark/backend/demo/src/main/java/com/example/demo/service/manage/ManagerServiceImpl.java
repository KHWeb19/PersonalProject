//package com.example.demo.service.manage;
//
//
//import com.example.demo.entity.member.Member;
//import com.example.demo.entity.member.MemberAuth;
//import com.example.demo.repository.MemberAuthRepository;
//import com.example.demo.repository.MemberRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@Service
//public class ManagerServiceImpl implements ManagerService {
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired
//    private MemberAuthRepository memberAuthRepository;
//
//    @Override
//    public List<Member> list() throws Exception {
//        return memberRepository.findAll();
//    }
//
//    @Override
//    public Member read(Long memberNo) throws Exception {
//        Optional<Member> memberDetail = memberRepository.findById(memberNo);
//        if(memberDetail.isPresent()) {
//            Member member = memberDetail.get();
//            memberRepository.save(member);
//
//            return member;
//        } else {
//            throw new NullPointerException();
//        }
//
//    }
//
//    @Override
//    public void remove(Long memberNo) throws Exception {
//        memberRepository.deleteById(memberNo);
//    }
//
//    //auth
//    public List<MemberAuth> authList( ) throws Exception {
//        return memberAuthRepository.findAll();
//    }
//}
