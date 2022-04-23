package com.example.demo.service.search;

import com.example.demo.entity.Member;
import com.example.demo.repository.JoinMemberRepository;
import com.example.demo.request.search.ChangePwRequest;
import com.example.demo.request.search.SearchIdRequest;
import com.example.demo.request.search.SearchPwRequest;
import com.example.demo.response.search.SearchIdResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    JoinMemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public SearchIdResponse searchId(SearchIdRequest searchIdRequest) {

        Optional<Member> memberId = memberRepository.findIdByNameBirth(searchIdRequest.getName(), searchIdRequest.getBirth());

        if(memberId.equals(Optional.empty())){
            log.info("No id!");

            return new SearchIdResponse(null);
        }else{
            log.info(memberId.get().getId());
        }

        return new SearchIdResponse(memberId.get().getId());
    }

    @Override
    public Boolean searchPw(SearchPwRequest searchPwRequest) {

        Optional<Member> memberPw = memberRepository.findPwByNameId(searchPwRequest.getName(), searchPwRequest.getId());

        if(memberPw.equals(Optional.empty())){
            log.info("No id!");

            return false;
        }

        return true;
    }

    @Override
    public void changePw(ChangePwRequest changePwRequest) {

        Member member = memberRepository.findByMemberNo(changePwRequest.getId());

        String encodePassword = passwordEncoder.encode(changePwRequest.getPw());
        member.setPw(encodePassword);

        memberRepository.save(member);
    }


}
