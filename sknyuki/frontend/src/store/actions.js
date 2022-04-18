import {
    FETCH_BRAND_CHECK_BOARD_LIST,
    FETCH_BRAND_CHECK_BOARD,

    FETCH_QUESTION_BOARD_LIST,
    FETCH_QUESTION_BOARD,

    FETCH_USER_INFO,
    FETCH_SESSION,

} from './mutation-types'

import axios from 'axios'
import cookies from 'vue-cookies'

//import router from '@/router'
// npm install axios --save-dev

export default {
    fetchBrandCheckBoardList ({ commit }) {
        return axios.get('http://localhost:7777/BrandCheckBoard/list')
            .then((res) => {
                commit(FETCH_BRAND_CHECK_BOARD_LIST, res.data)
               //console.log(res)
            })
    },
    fetchBrandCheckBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/BrandCheckBoard/${boardNo}`)
            .then((res) => {
                commit(FETCH_BRAND_CHECK_BOARD, res.data)
            })
    },
    fetchQuestionBoardList ({ commit }) {
        return axios.get('http://localhost:7777/QuestionBoard/list')
            .then((res) => {
                commit(FETCH_QUESTION_BOARD_LIST, res.data)
               console.log(res)
            })
    },
    fetchQuestionBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/QuestionBoard/${boardNo}`)
            .then((res) => {
                commit(FETCH_QUESTION_BOARD, res.data)
            })
    },

    fetchUserInfo ({ commit }, id) {
        return axios.get(`http://localhost:7777/member/mypage/${id}`).then(res => {
          cookies.set('session', res.data.id)
          commit(FETCH_USER_INFO, res.data)
        })
      },
      fetchSession ({ commit }, session) {
        commit(FETCH_SESSION, session)
        console.log(session)
      },
}
