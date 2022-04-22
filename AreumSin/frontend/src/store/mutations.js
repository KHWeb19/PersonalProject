import {
    FETCH_DAY_CONTENT,
    FETCH_INVITE_MEMBER,
    FETCH_USER_PLANS, FETCH_VOTE_CONTENT
} from './mutation-types'

export default {
    [FETCH_USER_PLANS] (state, plan){
        state.userPlans = plan;
    },
    [FETCH_INVITE_MEMBER] (state, memberId){
        state.inviteMember = memberId;

        for(let i = 0; i < state.inviteMember.length; i++){
            localStorage.setItem(state.inviteMember[i].memberId, state.inviteMember[i].memberColor);
        }
    },
    [FETCH_DAY_CONTENT] (state, dayContent) {

        state.dayContent = dayContent;
    },
    [FETCH_VOTE_CONTENT] (state, voteContent) {
        state.voteContents = voteContent;
    }

}