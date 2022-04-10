import axios from "axios"

export default {
    SET_USER_DATA(state, userData) {
        state.userInfo = userData
        state.isLogin = true
        state.isLoginError = false
        // localStorage.setItem('user',JSON.stringify(userData))
        // axios.defaults.headers.common['Authorization'] = `Bearer${userData.token}`
    },
    loginSuccess(state, payload) {
        state.isLogin = true
        state.isLoginError = false
        state.userInfo = payload
    },
    loginError(state) {
        state.isLogin = false
        state.isLoginError = true
    },
    logout(state) {
        state.isLogin = false
        state.isLoginError = false
        state.userInfo = null
        localStorage.removeItem('user')
        axios.defaults.headers.common['Authorization'] = null
    }
}