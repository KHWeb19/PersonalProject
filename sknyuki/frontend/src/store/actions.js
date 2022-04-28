import {
    FETCH_BRAND_CHECK_BOARD_LIST,
    FETCH_BRAND_CHECK_BOARD,

    FETCH_QUESTION_BOARD_LIST,
    FETCH_QUESTION_BOARD,

    FETCH_USER_INFO,
    FETCH_SESSION,

    FETCH_CHECK_BRAND_COMMENTS,
    FETCH_CHECK_BRAND_COMMENT,

    FETCH_QUESTION_COMMENTS,
    FETCH_QUESTION_COMMENT,
    
    FETCH_PRODUCT_BOARDS_LIST,
    FETCH_PRODUCT_BOARDS,

    FETCH_PRODUCT_BOARDB_LIST,
    FETCH_PRODUCT_BOARDB,

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


      fetchCheckBrandComments ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/BrandCheck/comment/read/${boardNo}`).then(res => {
          commit(FETCH_CHECK_BRAND_COMMENTS, res.data)
        })
      },
      fetchCheckBrandComment ({ commit }, commentNo) {
        return axios.get(`http://localhost:7777/BrandCheck/comment/read/only/${commentNo}`).then(res => {
          commit(FETCH_CHECK_BRAND_COMMENT, res.data)
        })
      },

      fetchQuestionComments ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/Question/comment/read/${boardNo}`).then(res => {
          commit(FETCH_QUESTION_COMMENTS, res.data)
        })
      },
      fetchQuestionComment ({ commit }, commentNo) {
        return axios.get(`http://localhost:7777/Question/comment/read/only/${commentNo}`).then(res => {
          commit(FETCH_QUESTION_COMMENT, res.data)
        })
      },


      fetchProductBoardsList ({ commit }) {
        return axios.get('http://localhost:7777/ProductBoardS/list')
            .then((res) => {
                commit(FETCH_PRODUCT_BOARDS_LIST, res.data)
              // console.log(res)
            })
    },
    fetchProductBoards ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/ProductBoardS/${boardNo}`)
            .then((res) => {
                commit(FETCH_PRODUCT_BOARDS, res.data)
            })
    },


    fetchProductBoardbList ({ commit }) {
      return axios.get('http://localhost:7777/ProductBoardB/list')
          .then((res) => {
              commit(FETCH_PRODUCT_BOARDB_LIST, res.data)
             // console.log("액션 보드비")
              //console.log(res)
          })
  },
  fetchProductBoardb ({ commit }, boardNo) {
      return axios.get(`http://localhost:7777/ProductBoardB/${boardNo}`)
          .then((res) => {
              commit(FETCH_PRODUCT_BOARDB, res.data)
              //console.log("액션 보드비")
              //console.log(res)
          })
  },
}
