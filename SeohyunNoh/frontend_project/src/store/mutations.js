// import axios from "axios"
import {
    //MEMBER
    USER_LOGIN,
    FETCH_USER_INFO,
    FETCH_SESSION,

    //NOTICE
    FETCH_NOTICE_BOARD_LIST,
    FETCH_NOTICE,

    //QNA
    FETCH_QNA_BOARD_LIST,
    FETCH_QNA,

    //COMMENT
    FETCH_COMMENTS,
    FETCH_COMMENT,

    //PRODUCT
    FETCH_CATEGORIES,
    FETCH_CATEGORY,

    FETCH_PRODUCTS,
    FETCH_PRODUCT,
   
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

    //QNA
    [FETCH_QNA_BOARD_LIST] (state, qnaBoards) {
        state.qnaBoards = qnaBoards
    },
    [FETCH_QNA] (state, qnaBoard) {
        state.qnaBoard = qnaBoard
    },

    //COMMENT
    [FETCH_COMMENTS] (state, comments) {
        state.comments = comments
    },
    [FETCH_COMMENT] (state, comment) {
        state.comment = comment
    },

    //PRODUCT
    [FETCH_CATEGORY] (state, category) {
        state.category = category
    },
    [FETCH_CATEGORIES] (state, categories) {
        state.categories = categories
    },

    [FETCH_PRODUCT] (state, product) {
        state.product = product
    },
    [FETCH_PRODUCTS] (state, products) {
        state.products = products
    }
}