import {
    FETCH_CAKE_LISTS
}from './mutation-types'

export default {
    [FETCH_CAKE_LISTS] (state, cakeLists) {
        state.cakeLists = cakeLists
    }
}