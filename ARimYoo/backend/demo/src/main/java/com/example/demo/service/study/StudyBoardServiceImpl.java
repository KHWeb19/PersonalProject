package com.example.demo.service.study;

import com.example.demo.entity.Member;
import com.example.demo.entity.study.Study;
import com.example.demo.entity.study.StudyBoard;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.study.StudyBoardRepository;
import com.example.demo.repository.study.StudyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class StudyBoardServiceImpl implements StudyBoardService {

    @Autowired
    private StudyBoardRepository repository;
    @Autowired
    private StudyRepository repository2;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void register (StudyBoard study, Study studyGroup, Member member, @RequestParam(required = false) MultipartFile file) throws Exception {

        if (file != null) {
            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "-" + file.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/back/studyBoard/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            study.setFileName(fileName);
        }
        repository.save(study);

        // 스터디DB에도 등록하기 위해
        studyGroup.setStudyName(study.getStudyName());
        studyGroup.setFileName(study.getFileName());
        studyGroup.setFirstMember(study.getWriter());
        studyGroup.setPeople(study.getPeople());
        studyGroup.setOpenLink(study.getOpenLink());

        repository2.save(studyGroup);

        Optional<Member> makeStudy = memberRepository.findById(Long.valueOf(member.getMemberNo()));
        Member getMember = makeStudy.get();
        getMember.addStudy(studyGroup);
        memberRepository.save(getMember);

        log.info("study" + member.getStudy());

    }

    @Override
    public List<StudyBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "studyNo"));

    }
    @Override
    public StudyBoard read(Long studyNo) {
        Optional<StudyBoard> maybeReadStudy = repository.findById(Long.valueOf(studyNo));

        if (maybeReadStudy.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        } else {
            StudyBoard study = maybeReadStudy.get();
            study.increaseViewCnt();
            repository.save(study);
            return maybeReadStudy.get();
        }
    }

    @Override
    public void remove(Integer studyNo) throws Exception {
        repository.deleteById(Long.valueOf(studyNo));
    }

    @Override
    public void modify(StudyBoard studyBoard) throws Exception {
        repository.save(studyBoard);
    }

    @Override
    public List<StudyBoard> searchList (String keyword) {
        List<StudyBoard> findList = repository.findByStudyNameContaining(keyword);
        return findList;
    }
}
