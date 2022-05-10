import {
    //자유게시판
    FETCH_FREE_BOARD_LIST,
    FETCH_FREE_BOARD,
    FETCH_FREE_BOARD_COMMENTS_LIST,
    //사진게시판
    FETCH_PHOTO_BOARD_LIST,
    FETCH_PHOTO_BOARD,
    FETCH_PHOTO_BOARD_COMMENTS_LIST,
    //영상게시판
    FETCH_VIDEO_BOARD_LIST,
    FETCH_VIDEO_BOARD,
    FETCH_VIDEO_BOARD_COMMENTS_LIST
   
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
    fetchPhotoBoardList ({ commit } , writer) {
        return axios.post('http://localhost:7777/photoBoard/list', { writer })
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
    //영상게시판
    fetchVideoBoardList ({ commit } , writer) {
        return axios.post('http://localhost:7777/videoBoard/list', { writer })
                .then((res) => {
                    commit(FETCH_VIDEO_BOARD_LIST, res.data)
                })
    },
    fetchVideoBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/videoBoard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_VIDEO_BOARD, res.data)
                })
    },
    fetchVideoBoardCommentsList({ commit }, boardNo ) {
        return axios.get(`http://localhost:7777/videoBoardComments/list/${boardNo}`)
                .then((res) => {
                    commit(FETCH_VIDEO_BOARD_COMMENTS_LIST, res.data)
                })
    }
}