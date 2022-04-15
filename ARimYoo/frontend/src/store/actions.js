 import { 
    FETCH_MEMBER,
    FETCH_COMMUNITY_BOARD_LIST,
    FETCH_COMMUNITY_BOARD,
    FETCH_COMMUNITY_COMMENTS_LIST,
 } from './mutation-types'

import axios from 'axios'

export default {

    fetchMember({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/Member/${memberNo}`)
            .then((res) => {
                commit(FETCH_MEMBER, res.data)
        })
    },
    fetchCommunityBoardList({ commit }) {
        return axios.get('http://localhost:7777/board/community/list')
            .then((res) => {
                commit(FETCH_COMMUNITY_BOARD_LIST, res.data)
        })
    },
    fetchCommunityBoard({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/community/${boardNo}`)
            .then((res) => {
                commit(FETCH_COMMUNITY_BOARD, res.data)
                console.log(res.data)
        })
        
    },
    fetchCommunityCommentsList({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/community/${boardNo}/comment/list`)
            .then((res) => {
                commit(FETCH_COMMUNITY_COMMENTS_LIST, res.data)
        })
    },
}