<template>
    <div>
        <login-form @submit="onSubmit"/>
        <footer-bar style="padding-top: 280px; text-align: center;"/>
    </div>        
    
</template>

<script>
import LoginForm from '@/components/member/LoginForm'
import FooterBar from '@/components/FooterBar'
import axios from 'axios'
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
    name: 'LoginPage',
    components: {
        LoginForm,
        FooterBar
    },
    data() {
        return {
            isLogin: false,
        }
    },
    mounted() {
        this.$store.state.userInfo = this.$cookies.get("user")
        if (this. $store.state.userInfo != null) {
            this.isLogin = true
        } else {
            this.isLogin = false
        }
    },
    methods: {
        onSubmit(payload) {
            if (!this.isLogin) {
                const {memberId, password} = payload
                axios.post('http://localhost:7777/member/login', {memberId, password})
                    .then(res => {
                        if(res.data) {
                            this.$cookies.set("user", res.data, 300)
                            this.isLogin = true
                            this.$router.push({name: 'HomeView'})
                            history.go(0);
                            localStorage.setItem("loginInfo", JSON.stringify(res.data))
                        } else {
                            alert('로그인 실패!')
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

<style scoped>
/* #app {
  text-align: center;
} */



</style>
