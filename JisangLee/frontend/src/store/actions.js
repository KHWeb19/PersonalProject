import {
    FETCH_LOCAL_BOARD_LIST,
    FETCH_LOCAL_BOARD,
    FETCH_LOCAL_COMMENTS_LIST,
    FETCH_FOREIGN_BOARD_LIST,
    FETCH_FOREIGN_BOARD,
    FETCH_FOREIGN_COMMENTS_LIST,
    FETCH_QUESTION_BOARD_LIST,
    FETCH_QUESTION_BOARD,
    FETCH_QUESTION_COMMENTS_LIST, 
    FETCH_COMPLAINT_BOARD_LIST,
    FETCH_COMPLAINT_BOARD,
    FETCH_COMPLAINT_COMMENTS_LIST,  
} from './mutation-types'

import axios from 'axios'
// npm install axios --save-dev

export default {   
    fetchLocalBoardList ({ commit }) {
        return axios.get('http://localhost:7777/localboard/list')
            .then((res) => {
                commit(FETCH_LOCAL_BOARD_LIST, res.data)
            })
    },
    fetchLocalBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/localboard/${boardNo}`)
            .then((res) => {
                commit(FETCH_LOCAL_BOARD, res.data)
            })
    },
    fetchLocalCommentsList({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/localboard/${boardNo}/comment/list`)
            .then((res) => {
                commit(FETCH_LOCAL_COMMENTS_LIST, res.data)
        })
    },
    fetchForeignBoardList ({ commit }) {
        return axios.get('http://localhost:7777/foreignboard/list')
            .then((res) => {
                commit(FETCH_FOREIGN_BOARD_LIST, res.data)
            })
    },
    fetchForeignBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/foreignboard/${boardNo}`)
            .then((res) => {
                commit(FETCH_FOREIGN_BOARD, res.data)
            })
    },
    fetchForeignCommentsList({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/foreignboard/${boardNo}/comment/list`)
            .then((res) => {
                commit(FETCH_FOREIGN_COMMENTS_LIST, res.data)
        })
    },
    fetchQuestionBoardList ({ commit }) {
        return axios.get('http://localhost:7777/questionboard/list')
            .then((res) => {
                commit(FETCH_QUESTION_BOARD_LIST, res.data)
            })
    },
    fetchQuestionBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/questionboard/${boardNo}`)
            .then((res) => {
                commit(FETCH_QUESTION_BOARD, res.data)
            })
    },
    fetchQuestionCommentsList({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/questionboard/${boardNo}/comment/list`)
            .then((res) => {
                commit(FETCH_QUESTION_COMMENTS_LIST, res.data)
        })
    },
    fetchComplaintBoardList ({ commit }) {
        return axios.get('http://localhost:7777/complaintboard/list')
            .then((res) => {
                commit(FETCH_COMPLAINT_BOARD_LIST, res.data)
            })
    },
    fetchComplaintBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/complaintboard/${boardNo}`)
            .then((res) => {
                commit(FETCH_COMPLAINT_BOARD, res.data)
            })
    },
    fetchComplaintCommentsList({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/complaintboard/${boardNo}/comment/list`)
            .then((res) => {
                commit(FETCH_COMPLAINT_COMMENTS_LIST, res.data)
        })
    },
}