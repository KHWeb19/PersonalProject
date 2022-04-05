import {
    FETCH_MEMBER,
    FETCH_MEMBER_LIST,

} from './mutation-types'

import axios from 'axios'

export default {
    fetchMemberList ({ commit }) {
        return axios.get('http://localhost:7777/member/list')
                .then((res) => {
                    commit(FETCH_MEMBER_LIST, res.data)
                })
    },
    fetchMember ({ commit }, memberId) {
        return axios.get(`http://localhost:7777/member/${memberId}`)
                .then((res) => {
                    commit(FETCH_MEMBER, res.data)
                })
    },
}