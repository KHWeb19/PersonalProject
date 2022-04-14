import {
    FETCH_MEMBER,
    FETCH_MEMBER_LIST,
    FETCH_BOARD,
    FETCH_BOARD_LIST,
    FETCH_BOARD_MY_LIST,
    FETCH_COMMENT,
    FETCH_COMMENT_LIST
} from './mutation-types'

export default {
    [FETCH_MEMBER] (state, member) {
        state.member = member
    },
    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards
    },
    [FETCH_BOARD_MY_LIST] (state, myBoards) {
        state.myBoards = myBoards
    },
    [FETCH_COMMENT] (state, comment) {
        state.comment = comment
    },
    [FETCH_COMMENT_LIST] (state, comments) {
        state.comments = comments
    },
}