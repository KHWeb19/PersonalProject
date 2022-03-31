import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER
}from './mutation-types'

export default {
    [FETCH_MEMBER_LIST] (state, members) {
        state.boards = members
    },
    [FETCH_MEMBER] (state, member) {
        state.board = member
    }
}