import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,
} from './mutation-types'

export default {
    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members
    },
    [FETCH_MEMBER](state, userInfo) {
        state.userInfo = userInfo
    },
}