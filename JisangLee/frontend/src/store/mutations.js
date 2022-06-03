import {
    FETCH_LOCAL_BOARD_LIST,
    FETCH_LOCAL_BOARD,
    FETCH_LOCAL_COMMENTS_LIST,
    FETCH_FOREIGN_BOARD_LIST,
    FETCH_FOREIGN_BOARD,
    FETCH_FOREIGN_COMMENTS_LIST,
    FETCH_QUESTION_BOARD_LIST,
    FETCH_QUESTION_BOARD,
    FETCH_QUESTION_COMMENTS_LIST,
    FETCH_COMPLAINT_BOARD_LIST,
    FETCH_COMPLAINT_BOARD,
    FETCH_COMPLAINT_COMMENTS_LIST
} from './mutation-types'

export default {
    [FETCH_LOCAL_BOARD_LIST] (state, localBoards) {
        state.localBoards = localBoards
    },
    [FETCH_LOCAL_BOARD] (state, localBoard) {
        state.localBoard = localBoard
    },
    [FETCH_LOCAL_COMMENTS_LIST](state, localComments) {
        state.localComments = localComments
    },
    [FETCH_FOREIGN_BOARD_LIST] (state, foreignBoards) {
        state.foreignBoards = foreignBoards
    },
    [FETCH_FOREIGN_BOARD] (state, foreignBoard) {
        state.foreignBoard = foreignBoard
    },
    [FETCH_FOREIGN_COMMENTS_LIST](state, foreignComments) {
        state.foreignComments = foreignComments
    },
    [FETCH_QUESTION_BOARD_LIST] (state, questionBoards) {
        state.questionBoards = questionBoards
    },
    [FETCH_QUESTION_BOARD] (state, questionBoard) {
        state.questionBoard = questionBoard
    },
    [FETCH_QUESTION_COMMENTS_LIST](state, questionComments) {
        state.questionComments = questionComments
    },
    [FETCH_COMPLAINT_BOARD_LIST] (state, complaintBoards) {
        state.complaintBoards = complaintBoards
    },
    [FETCH_COMPLAINT_BOARD] (state, complaintBoard) {
        state.complaintBoard = complaintBoard
    },
    [FETCH_COMPLAINT_COMMENTS_LIST](state, complaintComments) {
        state.complaintComments = complaintComments
    },
}