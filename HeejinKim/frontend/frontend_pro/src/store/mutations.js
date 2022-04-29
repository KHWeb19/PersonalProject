import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,

    FETCH_AUTH,
    FETCH_AUTH_LIST,
   

    FETCH_BOARD,
    FETCH_BOARD_LIST,

    FETCH_BOARD_COMMENTS_LIST,

    FETCH_RESERVATION,
    FETCH_RESERVATION_LIST,


/*
    COOKIE_SESSION,
    REMOVE_IS_LOGIN,
    REMOVE_SESSION,
    SET_IS_LOGIN,

    SET_MEMBER_NO,
    SET_AUTH*/


}from './mutation-types'

export default {

    [FETCH_BOARD_LIST] (state,boards) {
        state.boards = boards;
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
    [FETCH_BOARD_COMMENTS_LIST] (state, boardComments) {
        state.boardComments = boardComments
    },




    [FETCH_MEMBER_LIST] (state, members) {
        state.boards = members
    },
    [FETCH_MEMBER] (state, member) {
        state.board = member
    },
    [FETCH_AUTH] (state, auth) {
        state.auth = auth;
    },
    [FETCH_AUTH_LIST] (state, auths) {
        state.auths = auths;
    },

    [FETCH_RESERVATION] (state, reservation) {
        state.reservation = reservation
    },
    [FETCH_RESERVATION_LIST] (state, reservations) {
        state.reservations = reservations
    },
  

/*
    [COOKIE_SESSION](state, payload) {
        state.session = payload;
    },
    [SET_IS_LOGIN](state, payload) {
    state.isLogin = payload;
    },
    [SET_MEMBER_NO](state, payload) {
    state.loginMemberNo = payload;
    },
    [REMOVE_SESSION](state, payload) {
    state.session = payload;
    },
    [SET_AUTH](state, payload) {
    state.auth = payload;
    },
    [REMOVE_IS_LOGIN](state, payload) {
    state.isLogin = payload;
    }*/
  
}