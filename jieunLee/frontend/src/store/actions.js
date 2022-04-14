import {
    FETCH_MEMBER,
    FETCH_MEMBER_LIST,
    FETCH_BOARD,
    FETCH_BOARD_LIST,
    FETCH_BOARD_MY_LIST
} from './mutation-types'

import axios from 'axios'

export default {
    fetchMemberList ({ commit }) {
        return axios.get('http://localhost:7777/member/list')
                .then((res) => {
                    commit(FETCH_MEMBER_LIST, res.data)
                })
    },
    fetchMember ({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/member/${memberNo}`)
                .then((res) => {
                    commit(FETCH_MEMBER, res.data)
                })
    },
    fetchBoardList ({ commit }) {
        return axios.get('http://localhost:7777/board/list')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
    },
    fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
    },
    fetchBoardMyList ({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/board/list/${memberNo}`)
                .then((res) => {
                    commit(FETCH_BOARD_MY_LIST, res.data)
                })
    },
}