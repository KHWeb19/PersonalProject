import {
    FETCH_COOKIE_MEMBER,
} from './mutation-types'

export default {
    [FETCH_COOKIE_MEMBER](state, payload){
        state.members = payload;
    }
}