 import {
    FETCH_MEMBER,
    FETCH_COMMUNITY_BOARD_LIST,
    FETCH_COMMUNITY_BOARD
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
    }

}
