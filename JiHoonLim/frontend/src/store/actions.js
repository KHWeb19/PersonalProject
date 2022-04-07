import axios from 'axios'
import {
    FETCH_MEMBER
    
} from './mutation-types'


//import router from '@/router'

export default {
   fetchMember({commit}, memberNo) {
       return axios.get(`http://localhost:7777/member/${memberNo}`)
       .then(res => {
           commit(FETCH_MEMBER, res.data)
       })
   }
    
}