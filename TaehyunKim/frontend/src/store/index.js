import axios from 'axios'
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    users: []
  },
  getters: {
  },
  mutations: {
    READ_USERS(state, payload){
      state.users = payload
    }
  },
  actions: {
    read_users({commit}){
      axios.get("http://localhost:1234/api/users")
      .then((res) => commit("READ_USERS",res.data))
      .catch(()=>alert("Failed Reading Users"))
    }
  },
  modules: {
  }
})
