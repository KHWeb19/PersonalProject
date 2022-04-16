import {
    FETCH_CAKE_LISTS,
    FETCH_BOOKING_LISTS,
    FETCH_BOOKING_BOARD,
    FETCH_BOARD_COMMENTS,
    FETCH_REVIEWS
} from './mutation-types'

import axios from 'axios'

export default {
    fetchCakeLists ({ commit }) {
        return axios.get('http://localhost:7777/upload/list')
                .then(res => {
                    commit(FETCH_CAKE_LISTS, res.data)
                })
    },
    fetchBookingLists ({ commit }) {
        return axios.get('http://localhost:7777/booking/list')
            .then(res => {
                commit(FETCH_BOOKING_LISTS, res.data)
            })
    },
    fetchBookingBoard ({ commit }, payload) {
        const { bookingNo, id } = payload
        return axios.get('http://localhost:7777/booking/read',{ bookingNo, id })
                .then ((res) => {
                    if(res.data){
                    commit(FETCH_BOOKING_BOARD, res.data)
                    }else {
                        alert('작성자만 확인 가능합니다!')
                        this.$router.go()
                    } 
                })
    },
    fetchBoardComments ({commit}) {
        return axios.get('http://localhost:7777/boardComment/list')
                .then((res) => {
                    commit(FETCH_BOARD_COMMENTS, res.data)
                })
    },
    fetchReviews({commit}) {
        return axios.get('http://localhost:7777/review/list')
                .then((res) => {
                    commit(FETCH_REVIEWS, res.data)
                })
    }
}

