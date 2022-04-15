import {
    FETCH_BRAND_CHECK_BOARD_LIST,
    FETCH_BRAND_CHECK_BOARD,
} from './mutation-types'

import axios from 'axios'
//import router from '@/router'
// npm install axios --save-dev

export default {
    fetchBrandCheckBoardList ({ commit }) {
        return axios.get('http://localhost:7777/BrandCheckBoard/list')
            .then((res) => {
                commit(FETCH_BRAND_CHECK_BOARD_LIST, res.data)
               // console.log(res)
            })
    },
    fetchBrandCheckBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/BrandCheckBoard/${boardNo}`)
            .then((res) => {
                commit(FETCH_BRAND_CHECK_BOARD, res.data)
            })
    },
}
