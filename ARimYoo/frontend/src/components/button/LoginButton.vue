<template>
    <div>
          <login-form :loginForm="this.loginForm" @close="close" @submit="onSubmit"/>
          <v-btn
            color="white"
            height="20"
            @click="open"
          >
            Login
          </v-btn>
  </div>
</template>

<script>
import LoginForm from '../form/LoginForm.vue'
import Vue from 'vue'
import axios from 'axios'
import cookies from 'vue-cookies'
import { mapState } from 'vuex'

Vue.use(cookies)

export default {
  components: { LoginForm },

    name: 'LoginButton',
    data () {
      return {
        loginForm: { 
          dialog : false,
        }
      }
    },
    computed: {
        ...mapState(['isLogin'])
    },
    methods: {
      open(){
        this.loginForm.dialog = true
        
      },
      close () {
        this.loginForm.dialog = false
      },
      onSubmit (payload) {
          if( localStorage.getItem("token") == null){
          const {id,pw} = payload
          axios.post ('http://localhost:7777/Member/login', {id, pw})
            .then(res => {
              if (res.data) {
                 console.log(res.data)
                 localStorage.setItem("userInfo", JSON.stringify(res.data))
                 localStorage.setItem("token", res.data.token)
                 alert ('Welcome!')
                 history.go(0)
              }
            })
            .catch(res => {
              alert(res.response.data.message)
            })
        } else {
            alert('이미 로그인 되었습니다 !')
        }
      }
    }
}
</script>
