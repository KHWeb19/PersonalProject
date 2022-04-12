import {
    FETCH_CAKE_LISTS,
    FETCH_BOOKING_LISTS,
    FETCH_BOOKING_BOARD,
    FETCH_BOARD_COMMENTS
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
    }
}

