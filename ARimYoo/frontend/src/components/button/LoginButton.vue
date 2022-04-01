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

Vue.use(cookies)

export default {
  components: { LoginForm },

    name: 'LoginButton',
    data () {
      return {
        loginForm: { 
          dialog : false,
        },
        isLogin: false
      }
    },
    mounted() {
      this.$store.state.userInfo = this.$cookies.get("user")

      if (this.$store.state.userInfo != null) {
        this.isLogin = true
      } else {
        this.isLogin = false
      }
    },
    methods: {
      open(){
        this.loginForm.dialog = true
      
        
      },
      close () {
        this.loginForm.dialog = false
      },
      onSubmit (payload) {
        if(!this.isLogin){
          const {id,pw} = payload
          axios.post ('http://localhost:7777/Member/login', {id, pw})
            .then(res => {
              if (res.data) {
                alert ('Welcome!')
                this.$store.state.userInfo = res.data
                this.$cookies.set("user", res.data, 30)
                this.isLogin = true
              }
            })
            .catch(res => {
              alert(res.response.data.message)
            })
        } else {
          alert ('이미 로그인이 되어 있습니다!')
        }

      }
    },

}

</script>
