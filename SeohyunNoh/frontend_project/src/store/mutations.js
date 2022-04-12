// import axios from "axios"
import {
    //MEMBER
    USER_LOGIN,
    FETCH_USER_INFO,
    FETCH_SESSION,

    //NOTICE
    FETCH_NOTICE_BOARD_LIST,
    FETCH_NOTICE
   
} from './mutation-types'

export default {
    // MEMBER
    [USER_LOGIN] (state, isLogin) {
        state.isLogin = isLogin
        console.log('isLogin: ' + isLogin)
    },
    [FETCH_USER_INFO] (state, userInfo) {
        state.userInfo = userInfo
        console.log('userInfo' + userInfo)
    },
    [FETCH_SESSION] (state, session) {
        state.session = session
    },
    
    //NOTICE
    [FETCH_NOTICE_BOARD_LIST] (state, noticeBoards) {
        state.noticeBoards = noticeBoards
    },
    [FETCH_NOTICE] (state, noticeBoard) {
        state.noticeBoard = noticeBoard
    },
}