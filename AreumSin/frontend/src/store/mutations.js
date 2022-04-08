import {
    FETCH_LOGIN_MEMBER,

} from './mutation-types'

export default {
    [FETCH_LOGIN_MEMBER](state, payload) {
        state.userPlans = payload;
    },
}