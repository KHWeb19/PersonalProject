import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueCookies from "vue-cookies"
import './interceptors/axios'

Vue.config.productionTip = false

export const eventBus = new Vue()
Vue.use(VueCookies)

Vue.$cookies.config("7d")

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
