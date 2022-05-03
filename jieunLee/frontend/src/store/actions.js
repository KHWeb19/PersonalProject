import {
    FETCH_MEMBER,
    FETCH_MEMBER_LIST,
    FETCH_SEARCH_MEMBER_LIST,
    FETCH_BOARD,
    FETCH_BOARD_LIST,
    FETCH_BOARD_MY_LIST,
    FETCH_COMMENT,
    FETCH_COMMENT_LIST,
    FETCH_TWO_COMMENT_LIST,
    FETCH_LIKES_LIST,
    FETCH_MY_LIKES_LIST,
    FETCH_LIKE,
    FETCH_MY_FOLLOW_LIST
} from './mutation-types'

import axios from 'axios'

export default {
    fetchMember ({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/member/${memberNo}`)
                .then((res) => {
                    commit(FETCH_MEMBER, res.data)
                })
    },
    fetchMemberList ({ commit }) {
        return axios.get('http://localhost:7777/member/list')
                .then((res) => {
                    commit(FETCH_MEMBER_LIST, res.data)
                })
    },
    fetchSearchMemberList ({ commit }) {
        //스프링에서 Post니까 바꿔줬는데 문제안생기나?
        return axios.post('http://localhost:7777/member/search')
                .then((res) => {
                    commit(FETCH_SEARCH_MEMBER_LIST, res.data)
                })
    },
    fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
    },
    fetchBoardList ({ commit }) {
        return axios.get('http://localhost:7777/board/list')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
    },
    fetchBoardMyList ({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/board/list/${memberNo}`)
                .then((res) => {
                    commit(FETCH_BOARD_MY_LIST, res.data)
                })
    },
    fetchComment ({ commit }, commentNo) {
        return axios.get(`http://localhost:7777/comment/${commentNo}`)
                .then((res) => {
                    commit(FETCH_COMMENT, res.data)
                })
    },
    fetchCommentList ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/comment/list/${boardNo}`)
                .then((res) => {
                    commit(FETCH_COMMENT_LIST, res.data)
                })
    },
    fetchTwoCommentList ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/comment/twoList/${boardNo}`)
                .then((res) => {
                    commit(FETCH_TWO_COMMENT_LIST, res.data)
                })
    },
    fetchLikesList({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/likes/list/${boardNo}`)
                .then((res) => {
                    commit(FETCH_LIKES_LIST, res.data)
                })
    },
    fetchMyLikesList({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/likes/list/my/${memberNo}`)
                .then((res) => {
                    commit(FETCH_MY_LIKES_LIST, res.data)
                })
    },
    fetchLike ({ commit }, {boardNo, memberNo}) {
        return axios.get(`http://localhost:7777/likes/${boardNo}/${memberNo}`)
                .then((res) => {
                    commit(FETCH_LIKE, res.data)
                })
    },
    fetchMyFollowList({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/follow/list/my/${memberNo}`)
                .then((res) => {
                    commit(FETCH_MY_FOLLOW_LIST, res.data)
                })
    },
}