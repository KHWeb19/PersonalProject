import {
    //자유게시판
    FETCH_FREE_BOARD_LIST,
    FETCH_FREE_BOARD,
    FETCH_FREE_BOARD_COMMENTS_LIST,
    //사진게시판
    FETCH_PHOTO_BOARD_LIST,
    FETCH_PHOTO_BOARD,
    FETCH_PHOTO_BOARD_COMMENTS_LIST
   
} from './mutation-types'

import axios from 'axios'

export default {
    //자유게시판
    fetchFreeBoardList ({ commit }) {
        return axios.get('http://localhost:7777/freeBoard/list')
                .then((res) => {
                    commit(FETCH_FREE_BOARD_LIST, res.data)
                })
    },
    fetchFreeBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/freeBoard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_FREE_BOARD, res.data)
                })
    },
    fetchFreeBoardCommentsList({ commit }, boardNo ) {
        return axios.get(`http://localhost:7777/freeBoardComments/list/${boardNo}`)
                .then((res) => {
                    commit(FETCH_FREE_BOARD_COMMENTS_LIST, res.data)
                })
    },
    //사진게시판
    fetchPhotoBoardList ({ commit }) {
        return axios.get('http://localhost:7777/photoBoard/list')
                .then((res) => {
                    commit(FETCH_PHOTO_BOARD_LIST, res.data)
                })
    },
    fetchPhotoBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/photoBoard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_PHOTO_BOARD, res.data)
                })
    },
    fetchPhotoBoardCommentsList({ commit }, boardNo ) {
        return axios.get(`http://localhost:7777/photoBoardComments/list/${boardNo}`)
                .then((res) => {
                    commit(FETCH_PHOTO_BOARD_COMMENTS_LIST, res.data)
                })
    },
}