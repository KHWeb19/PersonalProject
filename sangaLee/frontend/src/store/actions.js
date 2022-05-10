import {
    FETCH_JPA_BOARD_LIST,
    FETCH_JPA_BOARD,

    FETCH_QUESTION_BOARD_LIST,
    FETCH_QUESTION_BOARD,

    FETCH_MEMBER,

    FETCH_DATA_BOARD_LIST,
    FETCH_DATA_BOARD
} from './mutation-types'

import axios from 'axios'

export default {
    fetchJpaBoardList ({ commit }) {
        return axios.get('http://localhost:7777/board/list')
            .then((res) => {
                commit(FETCH_JPA_BOARD_LIST, res.data)
            })
    },
    fetchJpaBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/${boardNo}`)
            .then((res) => {
                commit(FETCH_JPA_BOARD, res.data)
            })
    },
    fetchQuestionBoardList ({ commit }) {
        return axios.get('http://localhost:7777/board/list')
            .then((res) => {
                commit(FETCH_QUESTION_BOARD_LIST, res.data)
            })
    },
    fetchQuestionBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/${boardNo}`)
            .then((res) => {
                commit(FETCH_QUESTION_BOARD, res.data)
            })
    },
    fetchMember ({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/member/${memberNo}`)
                .then((res) => {
                    commit(FETCH_MEMBER, res.data)
                })
    },
    fetchDataBoardList ({ commit }) {
        return axios.get('http://localhost:7777/databoard/list')
            .then((res) => {
                commit(FETCH_DATA_BOARD_LIST, res.data)
            })
    },
    fetchDataBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/databoard/${boardNo}`)
            .then((res) => {
                commit(FETCH_DATA_BOARD, res.data)
            })
    },
}