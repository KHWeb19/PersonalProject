import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,
    FETCH_TIP_BOARD_LIST,
    FETCH_TIP_BOARD,
    FETCH_STORE_BOARD_LIST,
    FETCH_STORE_BOARD,    
    FETCH_BUSINESS_MEMBER,
} from './mutation-types'

export default {
    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members
    },
    [FETCH_MEMBER](state, userInfo) {
        state.userInfo = userInfo
    },

    [FETCH_TIP_BOARD_LIST] (state, boards) {
        state.tipBoards = boards
    },
    [FETCH_TIP_BOARD] (state, board) {
        state.tipBoard = board
    },

    [FETCH_STORE_BOARD_LIST] (state, boards) {
        state.storeBoards = boards
    },
    [FETCH_STORE_BOARD] (state, board) {
        state.storeBoard = board
    },
    [FETCH_BUSINESS_MEMBER] (state, businessMembers) {
        state.businessMembers = businessMembers
    },
}