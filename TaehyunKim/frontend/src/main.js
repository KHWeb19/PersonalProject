import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './interceptors/axios'
import vuetify from './plugins/vuetify'
import {library} from '@fortawesome/fontawesome-svg-core'
import {faBold, faItalic, faUnderline, faImage, faStrikethrough} from '@fortawesome/free-solid-svg-icons'
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'

library.add(faBold, faItalic, faUnderline, faImage, faStrikethrough)

Vue.component('font-awesome-icon', FontAwesomeIcon)
Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
