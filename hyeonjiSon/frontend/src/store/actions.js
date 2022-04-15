import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,

    FETCH_TIP_BOARD_LIST,
    FETCH_TIP_BOARD,
    
    FETCH_STORE_BOARD_LIST,
    FETCH_STORE_BOARD
} from './mutation-types'

import axios from 'axios'

export default {
    fetchMemberList ({ commit }) {
        return axios.get('http://localhost:7777/jpamember/list')
                .then((res) => {
                    commit(FETCH_MEMBER_LIST, res.data)
                })
    },
    fetchMember ({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/jpamember/${memberNo}`)
                .then((res) => {
                    commit(FETCH_MEMBER, res.data)
                })
    },

    fetchTipBoardList ({ commit }) {
        return axios.get('http://localhost:7777/tipboard/list')
            .then((res) => {
                commit(FETCH_TIP_BOARD_LIST, res.data)
            })
    },
    fetchTipBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/tipboard/${boardNo}`)
            .then((res) => {
                commit(FETCH_TIP_BOARD, res.data)
            })
    },

    fetchStoreBoardList ({ commit }) {
        return axios.get('http://localhost:7777/storeboard/list')
            .then((res) => {
                commit(FETCH_STORE_BOARD_LIST, res.data)
            })
    },
    fetchStoreBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/storeboard/${boardNo}`)
            .then((res) => {
                commit(FETCH_STORE_BOARD, res.data)
            })
    },
}