 import { 
    FETCH_MEMBER
 } from './mutation-types'

import axios from 'axios'

export default {

    fetchMember({ commit }, memberNo) {
        return axios.get(`http://localhost:8080/Member/read/${memberNo}`)
            .then((res) => {
                commit(FETCH_MEMBER, res.data)
        })
    }
}