import {
    FETCH_MEMBER,
    FETCH_MEMBER_LIST,
    FETCH_SEARCH_MEMBER_LIST,
    FETCH_BOARD,
    FETCH_BOARD_LIST,
    FETCH_BOARD_MY_LIST,
    FETCH_COMMENT,
    FETCH_COMMENT_LIST,
    FETCH_TWO_COMMENT_LIST,
    FETCH_LIKES_LIST,
    FETCH_MY_LIKES_LIST,
    FETCH_LIKE
} from './mutation-types'

export default {
    [FETCH_MEMBER] (state, member) {
        state.member = member
    },
    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members
    },
    [FETCH_SEARCH_MEMBER_LIST] (state, searchMembers) {
        state.searchMembers = searchMembers
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
    [FETCH_TWO_COMMENT_LIST] (state, twoComments) {
        state.twoComments = twoComments
    },
    [FETCH_LIKES_LIST] (state, likes) {
        state.likes = likes
    },
    [FETCH_MY_LIKES_LIST] (state, myLikes) {
        state.myLikes = myLikes
    },
    [FETCH_LIKE] (state, like) {
        state.like = like
    },
}