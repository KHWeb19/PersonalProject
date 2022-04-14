import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    FETCH_BOARD_MY_LIST
} from './mutation-types'

export default {
    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members
    },
    [FETCH_MEMBER] (state, member) {
        state.member = member
    },
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
    [FETCH_BOARD_MY_LIST] (state, myBoards) {
        state.myBoards = myBoards
    }
}