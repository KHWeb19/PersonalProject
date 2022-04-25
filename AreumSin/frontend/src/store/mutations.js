import {
    FETCH_BOARD_COMMENT,
    FETCH_BOARD_LIST, FETCH_BOARD_READ, FETCH_BOARD_READ_IMG,
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
    },
    addUser (state, userInfo) {
        console.log(userInfo);
        //state.userInfo = state.userInfo.concat(userInfo);
        /*for(let i = 0; i < userInfo.length; i++){
            //state.userInfo[i] = userInfo[i];
            console.log("addUser() " + state.userInfo);
        }*/

        state.userInfo = userInfo;
        for(let i = 0; i < userInfo.length; i++){
            //state.userInfo[i] = userInfo[i];
            console.log("addUser() " + state.userInfo[i]);
        }
    },
    [FETCH_BOARD_LIST] (state, boardList) {
        state.boardList = boardList;
    },
    [FETCH_BOARD_READ] (state, boardRead){
        state.boardRead = boardRead;
    },
    [FETCH_BOARD_READ_IMG] (state, boardReadImg){
        state.boardReadImg = boardReadImg;
    },
    [FETCH_BOARD_COMMENT](state, boardListComment) {
        state.boardListComment = boardListComment;
    }

}