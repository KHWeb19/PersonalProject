package com.example.demo.service.study;

import com.example.demo.entity.study.Study;
import com.example.demo.repository.study.StudyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.UUID;

@Service
@Slf4j
public class StudyServiceImpl implements StudyService{

    @Autowired
    private StudyRepository repository;

    @Autowired
    private StudyMemberRepository memberRepository;



}
