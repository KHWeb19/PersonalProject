import {
    LOGIN_SUCCESS,
    LOGIN_ERROR,
    LOGOUT,
} from './mutation-types'

import axios from 'axios'
import router from '../router'
import cookies from 'vue-cookies'

export default {
    async login({ commit }, { userId, password }) {
        axios.post('http://localhost:7777/jpamember/login', { userId, password })
            .then(res => {
                if (res.data != "") {
                    alert("로그인이 완료되었습니다.")
                    cookies.set("user", userId, '1h')
                    cookies.set("auth", res.data.authList[0], '1h')
                    this.state.session = res.data
                    commit(LOGIN_SUCCESS)
                    router.push({ name: "MainPage" })
                } if (res.data == "") {
                    alert("아이디와 비밀번호를 확인해주세요.")
                    commit(LOGIN_ERROR)
                }
            })
            .catch(res => {
                console.log(res)
            })
    },

    logout({ commit }) {
        cookies.remove("user")
        cookies.remove("auth")
        commit(LOGOUT)
        alert("로그아웃")
        location.href = "/home"
    },
}