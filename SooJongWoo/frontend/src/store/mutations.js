import {
    ALREADYS,
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    FETCH_AUTH_LIST,
    FETCH_DATES_LIST,
    FETCH_BOOK_LIST,
    FETCH_BOOK,
    FETCH_BOOK_READ,
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,
    FETCH_MEMBERAUTH_LIST,
    FETCH_MEMBERAUTH,
    FETCH_RESERVE_LIST,
    FETCH_ROOM_LIST,
    FETCH_ROOM,
    FETCH_USER_LIST,
    FETCH_USER,
    LOGIN_SUCCESS,
    LOGIN_ERROR,
    LOGOUT,
    CRAWL_START
} from './mutation-types'

export default {
    [ALREADYS](state, alreadyCheckIn) {
        state.alreadyCheckIn = alreadyCheckIn;
    },
    [FETCH_BOARD_LIST](state, boards) {
        state.boards = boards;
    },
    [FETCH_BOARD](state, board) {
        state.board = board
    },
    [FETCH_DATES_LIST](state, dates) {
        state.dates = dates;
    },
    [FETCH_BOOK_READ](state, bookReadDates) {
        state.bookReadDates = bookReadDates;
    },
    [FETCH_AUTH_LIST](state, auths) {
        state.auths = auths;
    },
    [FETCH_RESERVE_LIST](state, reserveDate) {
        state.reserveDate = reserveDate;
    },
    [FETCH_BOOK_LIST](state, books) {
        state.books = books;
    },
    [FETCH_BOOK](state, book) {
        state.book = book
    },
    [FETCH_ROOM_LIST](state, rooms) {
        state.rooms = rooms;
    },
    [FETCH_ROOM](state, room) {
        state.room = room
    },
    [FETCH_USER_LIST](state, users) {
        state.users = users;
    },
    [FETCH_USER](state, user) {
        state.user = user
    },
    [LOGIN_ERROR](state) {
        state.isManagerLogin = false
        state.isManagerLoginError = true
    },
    [LOGOUT](state) {
        state.isManagerLogin = false
        state.isManagerLoginError = false
        state.userInfo = null
    },
    [FETCH_MEMBER_LIST](state, members) {
        state.members = members;
    },
    [FETCH_MEMBER](state, member) {
        state.member = member
    },
    [FETCH_MEMBERAUTH_LIST](state, memberAuths) {
        state.memberAuths = memberAuths;
    },
    [FETCH_MEMBERAUTH](state, memberAuth) {
        state.memberAuth = memberAuth
    },
    // 로그인이 성공했을 때,
    [LOGIN_SUCCESS](state) {
        state.isLogin = true
        state.isLoginError = false
        // state.userInfo = payload
    },
    // 로그인 실패했을때
    [LOGIN_ERROR](state) {
        state.isLogin = false
        state.isLoginError = true
    },
    // 로그아웃
    [LOGOUT](state) {
        state.isLogin = false
        state.isLoginError = false
        state.session = null
    },
    // 크롤링
    [CRAWL_START](state, payload) {
        state.lists = payload
    }
}