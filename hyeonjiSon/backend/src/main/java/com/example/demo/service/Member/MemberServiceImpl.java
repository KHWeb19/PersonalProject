package com.example.demo.service.Member;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) {
        log.info("register() " + memberRequest);
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);
        Member memberEntity = new Member(
                memberRequest.getId(), memberRequest.getSn() , memberRequest.getPw(),
                memberRequest.getCity(), memberRequest.getDong(), memberRequest.getAddress(),

                memberRequest.getPwConfirm(), memberRequest.getAuth()
        );

        memberRepository.save(memberEntity);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if(maybeMember.equals(Optional.empty())){
            log.info("There are no person who has this id!");
            return null;
        }

        Member loginMember =maybeMember.get();

        if(!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPassword())) {
            log.info("Entered wrong password!");
            return null;
        }

        if (loginMember.getUserId().equals(memberRequest.getId())) {

            memberRequest.setMemberNo(loginMember.getMemberNo());
            memberRequest.setSn(loginMember.getStoreName());
            memberRequest.setCity(loginMember.getCity());
            memberRequest.setDong(loginMember.getDong());
            memberRequest.setAddress(loginMember.getAddress());
        }

        MemberRequest response = new MemberRequest(
                memberRequest.getMemberNo(), memberRequest.getId(), memberRequest.getSn(), null,
                memberRequest.getCity(), memberRequest.getDong(), memberRequest.getAddress(), memberRequest.getAuth(),
                memberRequest.getPwConfirm() );

        return response;
    }

    @Override
    public Member read(Long memberNo) {
        Optional<Member> getMemberInfo = memberRepository.findById(Long.valueOf(memberNo));

        return getMemberInfo.get();
    }

    @Transactional //동작을 멈추지 않도록 하는데 사용한다. service에 사용.
    @Override
    public List<Member> findBusiness() {
        List<Member> businessMember = memberRepository.selectMemberWithRole("사업자");

        // JPA 에서 연관 관계 사용시 쓸대없이 다 출력하지 말자!
        // 필요한 정보만 산출해서 가져가도록 한다.
        for (Member member : businessMember) {
            log.info("B-Member: " + member.getStoreName());
        }

        return businessMember;
    }

/*
    @Transactional //동작을 멈추지 않도록 하는데 사용한다. service에 사용.
    @Override
    public List<Member> findDong(String auth, String keyWord) {
        List<Member> dongMember = memberRepository.selectMemberWithDong("사업자", keyWord);

        // JPA 에서 연관 관계 사용시 쓸대없이 다 출력하지 말자!
        // 필요한 정보만 산출해서 가져가도록 한다.
        for (Member member : dongMember) {
            log.info("dong-Member: " + member.getStoreName());
        }

        return dongMember;
    }
 */

    @Override
    public List<Member> searchList (String keyWord) {
        List<Member> searchResults = memberRepository.findByDongContaining(keyWord);

        return searchResults;
    }

    /*
        @Override
    public void modify(JpaBoard board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
     */

    @Override
    public void modify(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void remove(Long memberNo){
        memberRepository.deleteById(Long.valueOf(memberNo));
    }

}
