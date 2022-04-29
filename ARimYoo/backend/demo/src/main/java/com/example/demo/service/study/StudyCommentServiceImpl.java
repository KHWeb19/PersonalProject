package com.example.demo.service.study;

import com.example.demo.entity.Member;
import com.example.demo.entity.study.StudyBoard;
import com.example.demo.entity.study.StudyComment;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.study.StudyBoardRepository;
import com.example.demo.repository.study.StudyCommentRepository;
import com.example.demo.service.communityBoard.CommunityCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudyCommentServiceImpl implements StudyCommentService {

    @Autowired
    StudyBoardRepository boardRepository;

    @Autowired
    StudyCommentRepository repository;

    @Autowired
    MemberRepository memberRepository;

   @Override
    public void register (Long studyNo, StudyComment studyComment){
       Optional<StudyBoard> boardItem = boardRepository.findById(Long.valueOf(studyNo));
       studyComment.setStudyBoard(boardItem.get());

       Optional<Member> getProfile =  memberRepository.findByName(studyComment.getCommentWriter());
       Member member = getProfile.get();

       studyComment.setCommentProfile(member.getProfilePic());
       repository.save(studyComment);
    }

    @Override
    public List<StudyComment> list (Long studyNo) {
        StudyBoard studyBoard = boardRepository.findById(studyNo).get();
        return repository.findStudyCommentByStudyBoard(studyBoard);
    }

    @Override
    public void delete (Long commentId) {
        repository.deleteById(Long.valueOf(commentId));
    }
}
