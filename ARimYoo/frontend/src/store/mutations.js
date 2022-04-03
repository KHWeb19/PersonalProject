 import {
   FETCH_MEMBER,
 } from './mutation-types'

export default {

    [FETCH_MEMBER](state, member) {
        state.member = member
    },

}
