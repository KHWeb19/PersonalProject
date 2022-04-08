import {
    FETCH_MEMBER_LIST,
    FETCH_LOGIN_MEMBER,

} from './mutation-types'
import axios from "axios";

export default {
    fetch_board_list({commit}){
        axios.get('http://localhost:7777/join/memberList')
            .then((res) => {
                commit(FETCH_MEMBER_LIST, res.data)
            })
    },
    fetchLoginMember({commit}, id){
        axios.post(`http://localhost:7777/join/loginSuccess/${id}`)
            .then((res) => {
                commit(FETCH_LOGIN_MEMBER, res.data)
            })
    }
}