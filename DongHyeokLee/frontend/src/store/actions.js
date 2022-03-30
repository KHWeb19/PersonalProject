import {
    FETCH_FREE_BOARD_LIST,
    FETCH_FREE_BOARD
   
} from './mutation-types'

import axios from 'axios'

export default {
    fetchFreeBoardList ({ commit }) {
        return axios.get('http://localhost:7777/freeBoard/list')
                .then((res) => {
                    commit(FETCH_FREE_BOARD_LIST, res.data)
                })
    },
    fetchFreeBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/freeBoard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_FREE_BOARD, res.data)
                })
    }    
}