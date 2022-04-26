package com.example.demo.service.study;

import com.example.demo.entity.study.Study;

import javax.persistence.Id;
import java.util.List;

public interface StudyService {

    public List<Study> list (Long memberNo);
    public int join (Long memberNo, Study study);
    public Study read (Long studyNo);
    public void toDoRegister (Study study);
}
