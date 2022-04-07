import {
    FETCH_CAKE_LISTS
} from './mutation-types'

import axios from 'axios'

export default {
    fetchCakeLists ({ commit }) {
        return axios.get('http://localhost:7777/upload/list')
                .then(res => {
                    commit(FETCH_CAKE_LISTS, res.data)
                })
    }
}