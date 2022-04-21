package com.example.demo.service.study;

import com.example.demo.entity.communityBoard.CommunityCommentBox;
import com.example.demo.entity.study.StudyComment;

import java.util.List;

public interface StudyCommentService {

    public void register (Long studyNo, StudyComment studyComment);
    public List<StudyComment> list (Long studyNo);
    public void delete (Long commentId);
}
