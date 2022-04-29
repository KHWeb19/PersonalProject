import{
    FETCH_BOARD,
    FETCH_BOARD_LIST,
    FETCH_BOARD_COMMENTS_LIST,

    FETCH_RESERVATION,
    FETCH_RESERVATION_LIST



    //FETCH_MEMBER_LIST,
    //FETCH_MEMBER,
    
    
    //REMOVE_IS_LOGIN,
    //REMOVE_SESSION,
    

    
    //SET_MEMBER_NO


} from './mutation-types'

import Vue from "vue";
import axios from 'axios'
import cookies from 'vue-cookies'
//import router from '@/router'

Vue.use(cookies)

export default {

    fetchBoardList ({ commit }) {
        return axios.get(`http://localhost:7777/board/community/list`)
            .then((res) => {
                commit(FETCH_BOARD_LIST, res.data)
            })
    },
    fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/community/${boardNo}`)
            .then((res) => {
                commit(FETCH_BOARD, res.data)
            })
    },
    fetchBoardCommentsList({ commit }, boardNo ) {
        return axios.get(`http://localhost:7777/boardComments/list/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD_COMMENTS_LIST, res.data)
                })
    },
    fetchReservation ({ commit }, reservationNo) {
        return axios.get(`http://localhost:7777/reservation/checkBooking/${reservationNo}`)
            .then((res) => {
                commit(FETCH_RESERVATION, res.data)
            })
    },
    fetchReservationList ({ commit }) {
        return axios.get(`http://localhost:7777/reservation/reservationList`)
            .then((res) => {
                commit(FETCH_RESERVATION_LIST, res.data)
            })
    },




    /*
    fetchMemberList ({ commit }) {
        return axios.get(`http://localhost:7777/jpaMember/register/${memberNo}`)
                .then((res) => {
                    commit(FETCH_MEMBER_LIST, res.data)
                })
    },
    fetchMember ({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/jpaMember/register/${memberNo}`)
                .then((res) => {
                    commit(FETCH_MEMBER, res.data)
                })
    }, 
    cookieSession({ commit }) {

        let data;
        let member;
    
        if (Vue.$cookies.get("user") !== null) {
          data = Vue.$cookies.get("user");
          member = data.userId;
        } 
        else {
          data = null;
        }

        commit(COOKIE_SESSION, member);
      
        if (Vue.$cookies.get("userNo") !== null) {
          commit(SET_MEMBER_NO, Vue.$cookies.get("userNo"));
          
        }
        else  {
          return null;
        }
       
    },
    setIsLogin({ commit }) {

        let loginTemp;

            if (Vue.$cookies.get("user") !== null) {
                loginTemp = true;
            } else {
                loginTemp = false;
            }
        commit(SET_IS_LOGIN, loginTemp);
        },


    setAuth({ commit }) {
        
    let data;

    if (Vue.$cookies.get("userAuth") !== null) {
        data = Vue.$cookies.get("userAuth");
    }
    commit(SET_AUTH, data);
    },


    logout({ commit }) {
        Vue.$cookies.remove("userAuth");
        Vue.$cookies.remove("userNo");
        Vue.$cookies.remove("user");
        commit(SET_AUTH, null);
        commit(REMOVE_SESSION, null);
        commit(REMOVE_IS_LOGIN, false);
    }*/
}