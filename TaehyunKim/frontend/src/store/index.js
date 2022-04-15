import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    users: [],
    isLoggedIn: false
  },
  getters: {
  },
  mutations: {
    READ_USERS(state, payload){
      state.users = payload
    },
    LOGIN_SUCCESSFUL(state){
      state.isLoggedIn = true
    }
  },
  actions: {
    login_successful({commit}){
      commit('LOGIN_SUCCESSFUL')
    }
  }
})