import {
    FETCH_MEMBER
    
} from './mutation-types'

export default {
    [FETCH_MEMBER](state, userInfo){
        state.userInfo = userInfo
    }

}