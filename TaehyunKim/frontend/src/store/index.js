import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import router from '../router/index'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: null,
    users: [],
    isLoggedIn: false,
    errorLoggingIn: false
  },
  getters: {
  },
  mutations: {
    READ_USERS(state, payload){
      state.users = payload
    },
    LOGIN_SUCCESSFUL(state){
      state.isLoggedIn = true
    },
    NOT_LOGGEDIN(state){
      state.isLoggedIn = false
    },
    UPDATE_USER(state, payload){
      state.user = payload
    }
  },
  actions: {
    attempt_login({commit}, payload){
      const params = new URLSearchParams()
      params.append('username', payload.username)
      params.append('password', payload.password)


      axios.post("login", params, {withCredentials: true})
            .then((res) => {
                localStorage.setItem("access_token", res.data.access_token)
                commit('LOGIN_SUCCESSFUL')
                router.push({name: "home"})
            })
            .catch(()=>alert('Invalid username or password'))
        },

    validate_login({commit}){
          localStorage.getItem('access_token') ? commit('LOGIN_SUCCESSFUL') : commit('NOT_LOGGEDIN')
    },

    user_logout({commit}){
      axios.post('/logout', {},{withCredentials: true})
      .then(() => {
        localStorage.removeItem('access_token')
        commit('NOT_LOGGEDIN')
      })
      .catch(() => alert("error logging out"))
    },

    get_user({commit}){
      axios.get("user")
      .then((res) => {
        commit('UPDATE_USER', res.data)})
      .catch(() => alert("유저정보를 가져오는데 실패했습니다"))
      
    }

  }

  
})