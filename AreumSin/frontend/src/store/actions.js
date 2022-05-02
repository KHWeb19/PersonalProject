import {
    FETCH_BOARD_COMMENT,
    FETCH_BOARD_LIST,
    FETCH_BOARD_READ,
    FETCH_BOARD_READ_IMG,
    FETCH_INVITE_MEMBER,
    FETCH_LIKE_PLACE_LIST,
    FETCH_MAP_MARK_LIST, FETCH_SAVE_PLACE,
    FETCH_SEARCH_LIKE_PLACE_LIST, FETCH_USER_INFO,
    FETCH_USER_PLANS,
    FETCH_VOTE_CONTENT

} from './mutation-types'
import axios from "axios";

export default {
    fetchUserPlans ({commit}, id) {
        return axios.post(`http://localhost:7777/plan/list/${id}`)
            .then((res) => {
                commit(FETCH_USER_PLANS, res.data);
            })
    },
    fetchInviteMember ({commit}, planNo){
        return axios.post(`http://localhost:7777/plan/friendList/${planNo}`)
            .then((res) => {
                commit(FETCH_INVITE_MEMBER, res.data);
            })
    },
    fetchVoteContent ({commit}, planNo){
        return axios.get(`http://localhost:7777/plan/vote/${planNo}`)
            .then((res) => {
                commit(FETCH_VOTE_CONTENT, res.data);
            })
    },
    fetchBoardList ({commit}){
        return axios.post('http://localhost:7777/board/list')
            .then((res) => {
                commit(FETCH_BOARD_LIST, res.data);
            })
    },
    fetchBoardRead ({commit}, boardNo) {
        return axios.get(`http://localhost:7777/board/read/${boardNo}`)
            .then((res) => {
                commit(FETCH_BOARD_READ, res.data)
            })

    },
    fetchBoardReadImg({commit}, boardNo){
        return axios.get(`http://localhost:7777/board/read/img/${boardNo}`)
            .then((res) => {
                commit(FETCH_BOARD_READ_IMG, res.data)
            })
    },
    fetchBoardComment({commit}, boardNo){
        return axios.get(`http://localhost:7777/board/read/comment/${boardNo}`)
            .then((res) => {
                commit(FETCH_BOARD_COMMENT, res.data)
            })
    },
    fetchSearchLikePlaceList({commit}, id){
        return axios.get(`http://localhost:7777/map/searchList/${id}`)
            .then((res) => {
                commit(FETCH_SEARCH_LIKE_PLACE_LIST, res.data)
            })
    },
    fetchLikePlaceList({commit}, planNo){
        return axios.get(`http://localhost:7777/planDay/mapLikeList/${planNo}`)
            .then((res) => {
                commit(FETCH_LIKE_PLACE_LIST, res.data)
            })
    },
    fetchMapMarkList({commit}, planNo){
        return axios.get(`http://localhost:7777/planDay/mapLikeMarkList/${planNo}`)
            .then((res) => {
                commit(FETCH_MAP_MARK_LIST, res.data)
            })
    },
    fetchUserInfo({commit}, memberId){
        return axios.post(`http://localhost:7777/myPage/${memberId}`)
            .then((res) => {
                commit(FETCH_USER_INFO, res.data)
            })
    },
    fetchSavePlace({commit}, memberId){
        return axios.post(`http://localhost:7777/myPage/savePlace/${memberId}`)
            .then((res) => {
                commit(FETCH_SAVE_PLACE, res.data)
            })
    }
}