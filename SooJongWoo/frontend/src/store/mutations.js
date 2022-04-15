import {
    LOGIN_SUCCESS,
    LOGIN_ERROR,
    LOGOUT,
} from './mutation-types'

export default {
    [LOGIN_SUCCESS](state) {
        state.isLogin = true
        state.isLoginError = false
    },
    [LOGIN_ERROR](state) {
        state.isManagerLogin = false
        state.isManagerLoginError = true
    },
    [LOGOUT](state) {
        state.isManagerLogin = false
        state.isManagerLoginError = false
        state.session = null
    }
}