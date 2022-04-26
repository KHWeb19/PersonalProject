package com.example.demo.service.study;

import com.example.demo.entity.Member;
import com.example.demo.entity.study.Study;
import com.example.demo.entity.study.StudyBoard;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.study.StudyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class StudyServiceImpl implements StudyService{

    @Autowired
    private StudyRepository repository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Study> list (Long memberNo) {
         Member member = memberRepository.findById(Long.valueOf(memberNo)).get();

         log.info("study List" + member.getStudy());
         return member.getStudy();
    }

    @Override
    public boolean join (Long memberNo, Study study) {
        Optional<Member> findMember = memberRepository.findById(Long.valueOf(memberNo));
        Member getMember = findMember.get();
        log.info("member" + findMember.get());

        Optional<Study> findStudy = repository.findById(Long.valueOf(study.getStudyNo()));
        Study getStudy = findStudy.get();
        log.info("member" + findStudy.get());

        if (getStudy.getPeople() == getStudy.getJoinCnt()) {
            log.info("정원을 모두 초과 !" + getStudy.getPeople() + getStudy.getJoinCnt());

            return false;

        } else {
            getStudy.increaseJoinCnt();
            repository.save(getStudy);
            getMember.addStudy(getStudy);
            memberRepository.save(getMember);

            log.info("study" + getMember.getStudy());

            return true;
        }

    }
    @Override
    public Study read (Long studyNo){
        Optional<Study> maybeReadStudy = repository.findById(Long.valueOf(studyNo));

        if (maybeReadStudy.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        } else {
            Study study = maybeReadStudy.get();
            log.info("Study" + study);
            return maybeReadStudy.get();
        }
    }

    @Override
    public void toDoRegister (Study study){
        repository.save(study);
    }


}
