import {
    FETCH_MEMBER_LIST
} from './mutation-types'

import axios from 'axios'

export default {
    fetchMemberList ({ commit }) {
        return axios.get('http://localhost:7777/Member/list')
                .then((res) => {
                    commit(FETCH_MEMBER_LIST, res.data)
                })
    }
}