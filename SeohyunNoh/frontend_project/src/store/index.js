import Vue from 'vue'
import Vuex from 'vuex'

import state from './states'
import actions from './actions'
import mutations from './mutations'
import getters from './getters'

import router from '../router/index.js'

import axios from 'axios'

//새로고침 후에도 로그인 유지하게 함 
import createPersistedState from "vuex-persistedstate";


Vue.use(Vuex)

export default new Vuex.Store({
  state,
  actions,
  mutations,
  getters,
  router,
  axios,
  plugins: [createPersistedState()]
})
