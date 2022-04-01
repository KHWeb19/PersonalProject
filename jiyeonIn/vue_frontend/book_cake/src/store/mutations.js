import {
    FETCH_MEMBER_LIST
} from './mutation-types'

export default {
    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members
    }
}