import Vue from 'vue'
import Vuex from 'vuex'

//import createPersistedState from 'vuex-persistedstate'

import state from './states'
import actions from './actions'
import mutations from './mutations'
import getters from './getters'

Vue.use(Vuex)

//const plugins= [createPersistedState({
 //   paths: []
//})]

export default new Vuex.Store({
  state,
  actions,
  mutations,
  getters,
 // plugins
})
