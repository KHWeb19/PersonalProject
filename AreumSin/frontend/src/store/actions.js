import {
    FETCH_INVITE_MEMBER,
    FETCH_USER_PLANS

} from './mutation-types'
import axios from "axios";

export default {
    fetchUserPlans ({commit}, id) {
        return axios.post(`http://localhost:7777/plan/list/${id}`)
            .then((res) => {
                commit(FETCH_USER_PLANS, res.data)
            })
    },
    fetchInviteMember ({commit}, planNo){
        return axios.post(`http://localhost:7777/plan/friendList/${planNo}`)
            .then((res) => {
                commit(FETCH_INVITE_MEMBER, res.data)
            })
    }
}