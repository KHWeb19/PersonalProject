import axios from 'axios'
import {
    FETCH_MEMBER,

    FETCH_FOOD_BOARD_LIST,
    FETCH_FOOD_BOARD,

    FETCH_BEST_FOOD_LIST,
    FETCH_FOOD_BOARD_COMMENTS_LIST,
    FETCH_MY_CART_FOOD_LIST,
    
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
}