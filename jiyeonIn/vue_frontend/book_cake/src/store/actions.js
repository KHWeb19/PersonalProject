import {
    FETCH_CAKE_LISTS,
    FETCH_BOOKING_LISTS,
    FETCH_BOOKING_BOARD,
    FETCH_BOARD_COMMENTS,
    FETCH_REVIEWS,
    FETCH_MEMBER_INFO,
    BOOKING_ID_LISTS,
    FETCH_REVIEWS_LISTS
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
    fetchBookingBoard ({ commit }, bookingNo) {
        return axios.get(`http://localhost:7777/booking/${bookingNo}`)
                .then ((res) => {
                    commit(FETCH_BOOKING_BOARD, res.data)
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
    },
    fetchMemberInfo ({ commit }, id) {
        return axios.get(`http://localhost:7777/Member/${id}`)
                .then ((res) => {
                    commit(FETCH_MEMBER_INFO, res.data)
                })
    },
    fetchBookingIdLists ({commit}, id) {
        return axios.get(`http://localhost:7777/booking/list/${id}`)
                .then((res) => {
                    commit(BOOKING_ID_LISTS, res.data)
                })
    },
    fetchReviewsIdLists ({commit}, id) {
        return axios.get(`http://localhost:7777/review/list/${id}`)
                .then((res) => {
                    commit(FETCH_REVIEWS_LISTS, res.data)
                })
    },
    
}

