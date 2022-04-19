package com.example.demo.service.plan;

import com.example.demo.entity.Hate;
import com.example.demo.entity.Like;
import com.example.demo.entity.Plan;
import com.example.demo.entity.PlanDay;
import com.example.demo.repository.HateRepository;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.MakePlanRepository;
import com.example.demo.repository.PlanDayRepository;
import com.example.demo.request.CountRequest;
import com.example.demo.request.PlanDayListRequest;
import com.example.demo.request.PlanDayRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class PlanDayServiceImpl implements PlanDayService{

    @Autowired
    private PlanDayRepository planDayRepository;

    @Autowired
    private MakePlanRepository makePlanRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private HateRepository hateRepository;

    @Transactional
    @Override
    public void saveContent(PlanDayRequest planDayRequest) {

        Plan plan = makePlanRepository.findByPlan(planDayRequest.getPlanNo());

        PlanDay planDayEntity = PlanDay.createPlanDay(planDayRequest.getId(), planDayRequest.getContent(), planDayRequest.getDay(), plan);
        planDayRepository.save(planDayEntity);
    }

    @Override
    public List<PlanDay> list(PlanDayListRequest planDayListRequest) {

        List<PlanDay> planDayList = planDayRepository.findByDayContent(planDayListRequest.getPlanNo(), planDayListRequest.getDay());


        log.info("여기까지 와?");
        for(PlanDay memberPlan : planDayList){
            log.info("여기!");
            log.info("PlanDay Content: " + memberPlan.getContent());
            log.info("PlanDay Id: " + memberPlan.getId());
            log.info("PlanDay likeContent: " + memberPlan.getLikeCount());
        }

        return planDayList;
    }

    @Override
    public Boolean remove(CountRequest countRequest) {
        PlanDay planDay = planDayRepository.findByPlan(countRequest.getPlanDayNo());

        if(Objects.equals(planDay.getId(), countRequest.getId())) {

            List<Like> likeMember = likeRepository.findByLike(countRequest.getPlanDayNo());

            for(Like member: likeMember){
                likeRepository.deleteById(member.getLikeNo());
            }

            List<Hate> hateMember = hateRepository.findByLike(countRequest.getPlanDayNo());

            for(Hate member: hateMember){
                hateRepository.deleteById(member.getHateNo());
            }

            planDayRepository.deleteById(countRequest.getPlanDayNo());

            return true;

        }else{
            return false;
        }
    }

    @Override
    public void like(CountRequest countRequest) {

        Optional<Like> likeMember = likeRepository.findByDayLike(countRequest.getPlanDayNo());
        PlanDay planDay = planDayRepository.findByPlan(countRequest.getPlanDayNo());

        // likeMember가 비워있으면 좋아요 누른 사람이 없다.
        // null이 아닐 경우 누른 사람과 like entity 에 있는 id를 비교해
        // 없을 경우 planDay count planDayNo로 찾아서 +1 을 한다.
        log.info("얍! 여기까지 오니?! ");

        if(likeMember.equals(Optional.empty())){
            log.info("아무것도 없어요! ");
            Like like = Like.createLikeMember(countRequest.getId(), planDay);

            likeRepository.save(like);
            planDay.likeCount(planDay, true);

            planDayRepository.save(planDay);
            log.info("planDay Count!: " + planDay.getLikeCount());

        }else{
            log.info("여기까지 empty가 아냐 ");
            List<Like> likeMembers = likeRepository.findByMembers(countRequest.getPlanDayNo());

            for(Like member: likeMembers){
                //log.info("여기까지는 안들어오는것 같은데? ");
                log.info(member.getId());

                //log.info(member.getId()+ ", " + countRequest.getId());
                if(member.getId().equals(countRequest.getId())){
                    log.info("둘이 같을 경우"+ countRequest.getPlanDayNo());
                    likeRepository.deleteById(countRequest.getPlanDayNo());
                    planDay.likeCount(planDay, false);
                    log.info("planDay Count!: " + planDay.getLikeCount());
                }else{
                    log.info("둘이 다른 경우 "+ countRequest.getPlanDayNo());
                    planDay.likeCount(planDay, true);
                    log.info("planDay Count!: " + planDay.getLikeCount());
                }

                planDayRepository.save(planDay);
                log.info("planDay Count!: " + planDay.getLikeCount());
            }
        }

    }

    @Override
    public void hate(CountRequest countRequest) {
        Optional<Hate> hateMember = hateRepository.findByDayHate(countRequest.getPlanDayNo());
        PlanDay planDay = planDayRepository.findByPlan(countRequest.getPlanDayNo());

        log.info("얍! 여기까지 오니?! ");

        if(hateMember.equals(Optional.empty())){
            log.info("아무것도 없어요! ");
            Hate hate = Hate.createHateMember(countRequest.getId(), planDay);

            hateRepository.save(hate);
            planDay.hateCount(planDay, true);

            planDayRepository.save(planDay);
            log.info("planDay HateCount!: " + planDay.getHateCount());

        }else{
            log.info("여기까지 empty가 아냐 ");
            List<Hate> hateMembers = hateRepository.findByMembers(countRequest.getPlanDayNo());

            for(Hate member: hateMembers){
                log.info(member.getId());

                if(member.getId().equals(countRequest.getId())){
                    hateRepository.deleteById(countRequest.getPlanDayNo());
                    planDay.hateCount(planDay, false);
                    log.info("planDay HateCount!: " + planDay.getHateCount());
                }else{
                    planDay.hateCount(planDay, true);
                    log.info("planDay HateCount!: " + planDay.getHateCount());
                }

                planDayRepository.save(planDay);
                log.info("planDay HateCount!: " + planDay.getHateCount());
            }
        }
    }


}
