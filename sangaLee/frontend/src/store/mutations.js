import {
    FETCH_JPA_BOARD_LIST,
    FETCH_JPA_BOARD,

    FETCH_QUESTION_BOARD_LIST,
    FETCH_QUESTION_BOARD,

    FETCH_MEMBER,

    FETCH_DATA_BOARD_LIST,
    FETCH_DATA_BOARD
} from './mutation-types'

export default {
    [FETCH_JPA_BOARD_LIST] (state, boards) {
        state.jpaBoards = boards
    },
    [FETCH_JPA_BOARD] (state, board) {
        state.jpaBoard = board
    },
    [FETCH_QUESTION_BOARD_LIST] (state, Questionboards) {
        state.jpaBoards = Questionboards
    },
    [FETCH_QUESTION_BOARD] (state, Questionboard) {
        state.jpaBoard = Questionboard
    },
    [FETCH_MEMBER] (state, member) {
        state.member = member
    },
    [FETCH_DATA_BOARD_LIST] (state, databoards) {
        state.dataBoards = databoards
    },
    [FETCH_DATA_BOARD] (state, databoard) {
        state.dataBoard = databoard
    },
}