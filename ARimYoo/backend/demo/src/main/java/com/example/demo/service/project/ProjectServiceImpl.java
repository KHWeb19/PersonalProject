package com.example.demo.service.project;

import com.example.demo.entity.Member;
import com.example.demo.entity.project.Project;
import com.example.demo.entity.study.Study;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.project.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Project> list (Long memberNo) {
        Member member = memberRepository.findById(Long.valueOf(memberNo)).get();

        log.info("study List" + member.getProject());
        return member.getProject();
    }

    @Override
    public int join (Long memberNo, Project project) {
        Optional<Member> findMember = memberRepository.findById(Long.valueOf(memberNo));
        Member getMember = findMember.get();
        log.info("member" + findMember.get());

        Optional<Project> findProject = repository.findById(Long.valueOf(project.getProjectNo()));
        Project getProject = findProject.get();
        log.info("member" + findProject.get());

        if (getProject.getPeople() == getProject.getJoinCnt()) {
            log.info("정원을 모두 초과 !" + getProject.getPeople() + getProject.getJoinCnt());

            return 1;

        } else if (getMember.getProject().contains(getProject)) {
            log.info("이미 가입하셨습니다");
            return 2;
        }else {
            getProject.increaseJoinCnt();
            repository.save(getProject);
            getMember.addProject(getProject);
            memberRepository.save(getMember);

            log.info("project" + getMember.getProject());

            return 3;
        }

    }
    @Override
    public Project read (Long projectNo){
        Optional<Project> maybeReadProject = repository.findById(Long.valueOf(projectNo));

        if (maybeReadProject.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        } else {
            Project project = maybeReadProject.get();
            log.info("Project" + project);
            return maybeReadProject.get();
        }
    }

    @Override
    public void toDoRegister (Project project){
        repository.save(project);
    }
}
