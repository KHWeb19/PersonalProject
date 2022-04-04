import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,

    COOKIE_SESSION,
    REMOVE_IS_LOGIN,
    REMOVE_SESSION,
    SET_IS_LOGIN,

    SET_MEMBER_NO,
    SET_AUTH


}from './mutation-types'

export default {
    [FETCH_MEMBER_LIST] (state, members) {
        state.boards = members
    },
    [FETCH_MEMBER] (state, member) {
        state.board = member
    },


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
    }
  
}