import {
    FETCH_BOARD_COMMENT,
    FETCH_BOARD_LIST,
    FETCH_BOARD_READ,
    FETCH_BOARD_READ_IMG,
    FETCH_DAY_CONTENT, FETCH_DAY_CONTENT_IMG, FETCH_DIARY, FETCH_DIARY_IMG, FETCH_DIARY_LIST,
    FETCH_INVITE_MEMBER,
    FETCH_LIKE_PLACE_LIST,
    FETCH_MAP_MARK_LIST,
    FETCH_PLACE_LIST,
    FETCH_PLACE_LIST_DAY, FETCH_SAVE_PLACE,
    FETCH_SEARCH_LIKE_PLACE_LIST, FETCH_USER_INFO,
    FETCH_USER_PLANS,
    FETCH_VOTE_CONTENT
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
    },
    [FETCH_SEARCH_LIKE_PLACE_LIST](state, likePlaceList){
        state.searchLikePlaceList = likePlaceList;
    },
    [FETCH_LIKE_PLACE_LIST](state, likePlaceList){
        state.mapLikePlaceList = likePlaceList;
    },
    [FETCH_MAP_MARK_LIST](state, likePlaceMarkList){
        state.markLikePlaceList = likePlaceMarkList;
    },
    [FETCH_PLACE_LIST_DAY](state, placeLikeDayList) {
        state.placeLikeDayList = placeLikeDayList;
    },
    [FETCH_PLACE_LIST](state, placeList){
        state.placeList = placeList;
    },
    [FETCH_DAY_CONTENT_IMG](state, dayContentImg){
        state.dayContentImg = dayContentImg;
    },
    [FETCH_USER_INFO](state, myPage) {
        state.myPage = myPage;
    },
    [FETCH_SAVE_PLACE](state, savePlace){
        state.savePlace = savePlace;
    },
    [FETCH_DIARY_LIST](state, diaryList){
        state.diaryList = diaryList;
    },
    [FETCH_DIARY](state, diary){
        state.diary = diary;
    },
    [FETCH_DIARY_IMG](state, diaryImg){
        state.diaryImg = diaryImg;
    }

}