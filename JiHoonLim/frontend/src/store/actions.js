import axios from 'axios'
import {
    FETCH_MEMBER,

    FETCH_FOOD_BOARD_LIST,
    FETCH_FOOD_BOARD,

    FETCH_BEST_FOOD_LIST,
    FETCH_FOOD_BOARD_COMMENTS_LIST,
    FETCH_MY_CART_FOOD_LIST,

    FETCH_NOTICE_BOARD_LIST,
    FETCH_NOTICE_BOARD,

    FETCH_REGISTER_MEMBERS,
    FETCH_REGISTER_MEMBER,
    FETCH_REGISTER_MEMBER_AUTHS,
    FETCH_REGISTER_MEMBER_AUTH,
    
} from './mutation-types'


//import router from '@/router'

export default {
   fetchMember({commit}, memberNo) {
       return axios.get(`http://localhost:7777/member/${memberNo}`)
       .then(res => {
           commit(FETCH_MEMBER, res.data)
       })
   },
    fetchFoodBoardList({commit}) {
        return axios.get("http://localhost:7777/foodBoard/list")
        .then((res)=>{
            commit(FETCH_FOOD_BOARD_LIST, res.data)
        })
    },
    fetchFoodBoard({commit},boardNo) {
        return axios.get(`http://localhost:7777/foodBoard/${boardNo}`)
        .then((res)=>{
            commit(FETCH_FOOD_BOARD,res.data)
        })
    },
    fetchBestFoodList({commit}) {
        return axios.get("http://localhost:7777/foodBoard/bestFood")
        .then((res)=>{
            commit(FETCH_BEST_FOOD_LIST,res.data)
        })
    },
    fetchFoodBoardCommentList({commit},boardNo) {
        return axios.get(`http://localhost:7777/foodBoard/comment/list/${boardNo}`)
        .then((res)=>{
            commit(FETCH_FOOD_BOARD_COMMENTS_LIST,res.data)
        })
    },
    fetchMyCartFoodList({commit},memberNo) {
        return axios.get(`http://localhost:7777/member/myCart/list/${memberNo}`)
        .then((res)=>{
            commit(FETCH_MY_CART_FOOD_LIST, res.data)
        })
    },
    fetchNoticeBoardList({commit}) {
        return axios.get("http://localhost:7777/noticeBoard/list")
        .then((res)=>{
            commit(FETCH_NOTICE_BOARD_LIST, res.data)
        })
    },
    fetchNoticeBoard({commit},boardNo) {
        return axios.get(`http://localhost:7777/noticeBoard/${boardNo}`)
        .then((res)=>{
            commit(FETCH_NOTICE_BOARD,res.data)
        })
    },
    fetchRegisterMembers({commit}) {
        return axios.get("http://localhost:7777/memberManage/list")
        .then((res)=>{
            commit(FETCH_REGISTER_MEMBERS, res.data)
        })
    },
    fetchRegisterMember({commit},memberNo) {
        return axios.get(`http://localhost:7777/memberManage/member/${memberNo}`)
        .then((res)=>{
            commit(FETCH_REGISTER_MEMBER,res.data)
        })
    },
    fetchRegisterMemberAuths({commit}) {
        return axios.get("http://localhost:7777/memberManage/authList")
        .then((res)=>{
            commit(FETCH_REGISTER_MEMBER_AUTHS, res.data)
        })
    },
    fetchRegisterMemberAuth({commit},memberNo) {
        return axios.get(`http://localhost:7777/memberManage/memberAuth/${memberNo}`)
        .then((res)=>{
            commit(FETCH_REGISTER_MEMBER_AUTH,res.data)
        })
    },
}