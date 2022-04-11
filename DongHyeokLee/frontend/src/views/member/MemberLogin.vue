<template>
    <member-login @submit="login"/>
</template>

<script>

import MemberLogin from '@/components/member/MemberLoginForm.vue'
import axios from 'axios'

import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)


export default {
    components: {
        MemberLogin
    },
    date () {
        return {
            isLogin: ''
        }
    },
     mounted () {
        this.$store.state.userInfo = this.$cookies.get("user")

        if (this.$store.state.userInfo != null){
            this.$store.state.isLogin = true
        }else {
            this.$store.state.isLogin = false
        }
    },
    methods: {
         login (payload) {
            if (!this.isLogin){
                const { userId, password } = payload
                axios.post('http://localhost:7777/member/login', { userId, password })
                 .then(res => {
                    if (res.data) {
                        alert('로그인 성공!')
                        this.$store.state.userInfo = res.data
                        this.$cookies.set("user", res.data, 900)
                        this.$store.state.isLogin = true
                    }else{
                        alert('잘못 입력 하였습니다')
                    }
            })
            .catch(res => {
                alert(res.response.data.message)  
            })
      } else {
        alert('이미 로그인이 되어 있습니다!')
      }
            
        }
    }
}
</script>