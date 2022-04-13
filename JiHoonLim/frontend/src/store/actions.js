import axios from 'axios'
import {
    FETCH_MEMBER,

    FETCH_FOOD_BOARD_LIST,
    FETCH_FOOD_BOARD,
    
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
    }
    
}