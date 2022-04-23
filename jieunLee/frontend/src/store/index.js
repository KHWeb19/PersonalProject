import Vue from 'vue'
import Vuex from 'vuex'


import state from './states'
import actions from './actions'
import mutations from './mutations'
import getters from './getters'

import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

const plugins= [createPersistedState({
  paths: []
})]

export default new Vuex.Store({
  state,
  mutations,
  actions,
  getters,
  plugins
})
