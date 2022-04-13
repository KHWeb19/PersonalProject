import {
    //MEMBER
    FETCH_USER_INFO,
    FETCH_SESSION,

    //NOTICE
    FETCH_NOTICE_BOARD_LIST,
    FETCH_NOTICE
   
} from './mutation-types'

import axios from 'axios'
import cookies from 'vue-cookies'

export default {
    //MEMBER
    fetchUserInfo ({ commit }, id) {
        return axios.get(`http://localhost:7777/member/mypage/${id}`).then(res => {
          cookies.set('session', res.data.id)
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
    }
}