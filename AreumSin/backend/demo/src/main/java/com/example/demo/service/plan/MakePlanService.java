package com.example.demo.service.plan;

import com.example.demo.entity.Member;
import com.example.demo.entity.MemberPlan;
import com.example.demo.entity.Vote;
import com.example.demo.request.DecisionMakingRequest;
import com.example.demo.request.MemberPlanRequest;
import com.example.demo.request.PlanFriend;
import com.example.demo.request.VoteRequest;
import com.example.demo.response.FriendMemberResponse;

import java.util.List;


public interface MakePlanService {
    void make(List<String> fileName, String planName, String planDate, String placeName, String id);
    List<MemberPlan> listPlan(Integer id);
    FriendMemberResponse searchMember(String friendId);
    void addFriend(PlanFriend planFriend);
    List<MemberPlan> showInviteMember(Integer planNo);

    void voteSave(VoteRequest voteRequest);

    List<Vote> voteList(Integer planNo);

    void voteGood(DecisionMakingRequest decisionMakingRequest);

    void voteBad(DecisionMakingRequest decisionMakingRequest);


    void deletePlan(Integer planNo);
}
