package com.example.demo.service.plan;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.request.*;
import com.example.demo.response.PlanDayResponse;
import com.example.demo.response.map.MapLikeListResponse;
import com.example.demo.response.map.MapLikeMarkListResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    @Autowired
    private SaveFavoritePlaceRepository saveFavoritePlaceRepository;

    @Autowired
    private PlanDayImgRepository planDayImgRepository;

    @Transactional
    @Override
    public void saveContent(List<String> fileList, String id, Integer planNo, Integer day, String content) {

        Plan plan = makePlanRepository.findByPlan(planNo);

        log.info("day!!! 123123123 : "+ day);
        log.info("planNo!!! 123123123 : "+ planNo);

        PlanDay planDayEntity = PlanDay.createPlanDay(id, content, day, plan);
        planDayRepository.save(planDayEntity);

        if(fileList.size() > 0) {
            for(String file : fileList){
                PlanDayImg planDayImg = new PlanDayImg(file, planDayEntity);
                planDayImgRepository.save(planDayImg);
            }
        }
    }

    @Override
    public void saveContentNoImg(PlanDayRequest planDayRequest) {

        Plan plan = makePlanRepository.findByPlan(planDayRequest.getPlanNo());

        PlanDay planDayEntity = PlanDay.createPlanDay(planDayRequest.getId(), planDayRequest.getContent(), planDayRequest.getDay(), plan);
        planDayRepository.save(planDayEntity);

        PlanDayImg planDayImg = new PlanDayImg(planDayEntity);
        planDayImgRepository.save(planDayImg);
    }

    @Override
    public List<PlanDayResponse> list(PlanDayListRequest planDayListRequest) {

        log.info("day!: "+planDayListRequest.getDay() + ", planNo: "+ planDayListRequest.getPlanNo());

        List<PlanDay> planDayList = planDayRepository.findByDayContent(planDayListRequest.getPlanNo(), planDayListRequest.getDay());

        List<PlanDayResponse> planDayResponses = new ArrayList<>();

        log.info("???????????? ????" + planDayList.size());
        for(PlanDay planDay : planDayList){
            planDayResponses.add(new PlanDayResponse(planDay.getId(), planDay.getPlanDayNo(), planDay.getContent(), planDay.getLikeCount(), planDay.getHateCount(), null));
        }

        List<PlanDayImg> planDayImgList = planDayImgRepository.findByPlanDay(planDayListRequest.getDay());

        int i = 0;

        for(PlanDayResponse planDay : planDayResponses) {
            for (PlanDayImg planDayImg : planDayImgList) {

                if(Objects.equals(planDay.getPlanDayNo(), planDayImg.getPlanDay().getPlanDayNo())){
                    PlanDayResponse test = planDayResponses.get(i);
                    System.out.println(test);
                    test.setImgSrc(planDayImg.getImgSrc());

                    planDayResponses.set(i, test);
                }

                /*PlanDayResponse test = planDayResponses.get(i);
                System.out.println(test);*/

            }
            i++;
        }

        return planDayResponses;
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
    public List<MapLikeListResponse> likePlaceList(Integer planNo) {

        List<SaveFavoritePlace> saveFavoritePlaceList = saveFavoritePlaceRepository.findMemberPlaceByPlanNo(planNo);

        List<MapLikeListResponse> likePlaceList = new ArrayList<>();

        for(SaveFavoritePlace saveFavoritePlace : saveFavoritePlaceList){
            likePlaceList.add(new MapLikeListResponse(saveFavoritePlace.getTitle(), saveFavoritePlace.getFavoritePlace()));
        }

        return likePlaceList;
    }

    @Override
    public List<MapLikeMarkListResponse> likePlaceMarkList(Integer planNo) {

        List<SaveFavoritePlace> saveFavoritePlaceList = saveFavoritePlaceRepository.findMemberPlaceByPlanNo(planNo);

        List<MapLikeMarkListResponse> likePlaceList = new ArrayList<>();

        for(SaveFavoritePlace saveFavoritePlace : saveFavoritePlaceList){
            likePlaceList.add(new MapLikeMarkListResponse(saveFavoritePlace.getX(), saveFavoritePlace.getY(), saveFavoritePlace.getTitle()));
        }

        return likePlaceList;
    }

    @Override
    public void savePlaceDay(SaveFavoritePlaceDay saveFavoritePlaceDay) {

        SaveFavoritePlace SFPD = saveFavoritePlaceRepository.findPlaceByNo(saveFavoritePlaceDay.getFavoritePlaceNo());
        SFPD.setDay(saveFavoritePlaceDay.getDay());

        saveFavoritePlaceRepository.save(SFPD);
    }

    @Override
    public List<MapLikeListResponse> listPlaceDay(SaveFavoritePlaceDayList saveFavoritePlaceDayList) {

        List<SaveFavoritePlace> likePlaceList = saveFavoritePlaceRepository.findPlaceByDay(saveFavoritePlaceDayList.getDay(), saveFavoritePlaceDayList.getPlanNo());

        List<MapLikeListResponse> likeListResponses = new ArrayList<>();

        for(SaveFavoritePlace saveFavoritePlace : likePlaceList){
            likeListResponses.add(new MapLikeListResponse(saveFavoritePlace.getTitle(), saveFavoritePlace.getFavoritePlace()));
        }

        return likeListResponses;
    }

    @Override
    public void like(CountRequest countRequest) {

        Optional<Like> likeMember = likeRepository.findByDayLike(countRequest.getPlanDayNo(), countRequest.getId());
        PlanDay planDay = planDayRepository.findByPlan(countRequest.getPlanDayNo());

        // likeMember??? ??????????????? ????????? ?????? ????????? ??????.
        // null??? ?????? ?????? ?????? ????????? like entity ??? ?????? id??? ?????????
        // ?????? ?????? planDay count planDayNo??? ????????? +1 ??? ??????.
        log.info("???! ???????????? ???????! ");

        if(likeMember.equals(Optional.empty())){
            log.info("???????????? ?????????! ");
            Like like = Like.createLikeMember(countRequest.getId(), planDay);

            likeRepository.save(like);
            planDay.likeCount(planDay, true);

            planDayRepository.save(planDay);
            log.info("planDay Count!: " + planDay.getLikeCount());

        }else{
            log.info("???????????? empty??? ?????? ");
            List<Like> likeMembers = likeRepository.findByMembers(countRequest.getPlanDayNo());

            for(Like member: likeMembers){
                //log.info("??????????????? ?????????????????? ?????????? ");
                log.info(member.getId());

                //log.info(member.getId()+ ", " + countRequest.getId());
                if(member.getId().equals(countRequest.getId())){
                    log.info("?????? ?????? ??????: "+ countRequest.getPlanDayNo()+"????????? : "+ countRequest.getId());

                    //likeRepository.deleteById(countRequest.getPlanDayNo());

                    Like like = likeRepository.findBYLikeForRemove(countRequest.getId(), countRequest.getPlanDayNo());

                    System.out.println("::: like ::: " + like.getId());
                    likeRepository.delete(like);

                    planDay.likeCount(planDay, false);
                    log.info("planDay Count!: " + planDay.getLikeCount());
                }else{
                    log.info("?????? ?????? ?????? "+ countRequest.getPlanDayNo());
                    Like like = Like.createLikeMember(countRequest.getId(), planDay);

                    likeRepository.save(like);

                    planDay.likeCount(planDay, true);

                    planDayRepository.save(planDay);
                    log.info("planDay Count!: " + planDay.getLikeCount());
                }

                planDayRepository.save(planDay);
                log.info("planDay Count!: " + planDay.getLikeCount());
            }
        }

    }

    @Override
    public void hate(CountRequest countRequest) {
        Optional<Hate> hateMember = hateRepository.findByDayHate(countRequest.getPlanDayNo(), countRequest.getId());
        PlanDay planDay = planDayRepository.findByPlan(countRequest.getPlanDayNo());

        log.info("???! ???????????? ???????! ");

        if(hateMember.equals(Optional.empty())){
            log.info("???????????? ?????????! ");
            Hate hate = Hate.createHateMember(countRequest.getId(), planDay);

            hateRepository.save(hate);
            planDay.hateCount(planDay, true);

            planDayRepository.save(planDay);
            log.info("planDay HateCount!: " + planDay.getHateCount());

        }else{
            log.info("???????????? empty??? ?????? ");
            List<Hate> hateMembers = hateRepository.findByMembers(countRequest.getPlanDayNo());

            for(Hate member: hateMembers){
                log.info(member.getId());

                if(member.getId().equals(countRequest.getId())){

                    Hate hate = hateRepository.findBYHateForRemove(countRequest.getId(), countRequest.getPlanDayNo());
                    hateRepository.delete(hate);

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
