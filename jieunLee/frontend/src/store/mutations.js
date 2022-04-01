import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,
    FETCH_MEMBER_ID
} from './mutation-types'

export default {
    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members
    },
    [FETCH_MEMBER] (state, member) {
        state.member = member
    },
    [FETCH_MEMBER_ID] (state, memberId) {
        state.memberId = memberId
    },
}