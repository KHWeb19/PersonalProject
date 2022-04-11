import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,

    FETCH_AUTH,
    FETCH_AUTH_LIST,
    FETCH_MEMBERAUTH,
    FETCH_MEMBERAUTH_LIST,
/*
    COOKIE_SESSION,
    REMOVE_IS_LOGIN,
    REMOVE_SESSION,
    SET_IS_LOGIN,

    SET_MEMBER_NO,
    SET_AUTH*/


}from './mutation-types'

export default {
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
    [FETCH_MEMBERAUTH_LIST] (state, memberAuths) {
        state.memberAuths = memberAuths;
    },
    [FETCH_MEMBERAUTH] (state, memberAuth) {
        state.memberAuth = memberAuth
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