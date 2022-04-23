import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,

} from './mutation-types'

import axios from 'axios'

export default {
    fetchMemberList ({ commit }) {
        return axios.get('http://localhost:7777/jpamember/list')
                .then((res) => {
                    commit(FETCH_MEMBER_LIST, res.data)
                })
    },
    fetchMember ({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/jpamember/${memberNo}`)
                .then((res) => {
                    commit(FETCH_MEMBER, res.data)
                })
    },
}