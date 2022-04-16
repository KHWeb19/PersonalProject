 import {
    FETCH_MEMBER,
    FETCH_COMMUNITY_BOARD_LIST,
    FETCH_COMMUNITY_BOARD,
    FETCH_COMMUNITY_COMMENTS_LIST,
    FETCH_REVIEW_LIST,
    FETCH_REVIEW,
    FETCH_REVIEW_COMMENTS_LIST
 } from './mutation-types'

export default {

    [FETCH_MEMBER](state, userInfo) {
        state.userInfo = userInfo
    },
    [FETCH_COMMUNITY_BOARD_LIST](state, communityBoards) {
        state.communityBoards = communityBoards 
    },
    [FETCH_COMMUNITY_BOARD](state, communityBoard) {
        state.communityBoard = communityBoard
    },
    [FETCH_COMMUNITY_COMMENTS_LIST](state, communityComments) {
        state.communityComments = communityComments
    },
    [FETCH_REVIEW_LIST](state, reviews) {
        state.reviews = reviews
    },
    [FETCH_REVIEW](state, review) {
        state.review = review
    },
    [FETCH_REVIEW_COMMENTS_LIST](state, reviewComments) {
        state.reviewComments = reviewComments
    }

}
