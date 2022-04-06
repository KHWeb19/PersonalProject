import {
    FETCH_MEMBER_LIST
} from './mutation-types'
import axios from "axios";

export default {
    fetch_board_list({commit}){
        axios.get('http://localhost:7777/join/memberList')
            .then((res) => {
                commit(FETCH_MEMBER_LIST, res.data)
            })
    }
}