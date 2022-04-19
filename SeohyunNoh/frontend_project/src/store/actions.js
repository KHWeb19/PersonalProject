import {
    //MEMBER
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
    FETCH_COMMENT
   
} from './mutation-types'

import Vue from 'vue'
import axios from 'axios'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
    //MEMBER
    fetchUserInfo ({ commit }, id) {
        return axios.get(`http://localhost:7777/member/mypage/${id}`)
            .then(res => {
            cookies.set('session', res.data.id)

            console.log("아이디체크: " + res.data.id)
            
            commit(FETCH_USER_INFO, res.data)
        })
    },
      fetchSession ({ commit }, session) {
        commit(FETCH_SESSION, session)
    },
    

    //NOTICE
    fetchNoticeBoardList ({ commit }) {
        return axios.get('http://localhost:7777/notice/list')
            .then((res) => {
                commit(FETCH_NOTICE_BOARD_LIST, res.data)
            })
    },
    fetchNoticeBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/notice/${boardNo}`)
            .then((res) => {
                commit(FETCH_NOTICE, res.data)
            })
    },

    //QNA
    fetchQnABoardList ({ commit }) {
        return axios.get('http://localhost:7777/qna/list')
            .then((res) => {
                commit(FETCH_QNA_BOARD_LIST, res.data)
            })
    },
    fetchQnA ({ commit }, qnaNo) {
        return axios.get(`http://localhost:7777/qna/${qnaNo}`)
            .then((res) => {
                commit(FETCH_QNA, res.data)
            })
    },

    //COMMENT
    fetchComments ({commit}, qnaNo) {
        return axios.get(`http://localhost:7777/comment/read/${qnaNo}`)
                    .then(res => {
                        commit(FETCH_COMMENTS, res.data)
                    })
    },
    fetchComment ({commit}, commentNo) {
        return axios.get(`http://localhost:7777/comment/read/only/${commentNo}`)
                    .then((res) => {
                        commit(FETCH_COMMENT, res.data)
                    })
    }

}