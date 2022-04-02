<template>
    <div>
        <menu-bar />
        <login-form @submit="onSubmit"/>
                <v-btn tile color="teal lighten-4" @click="logout">
            <v-icon left>
                mdi-logout
            </v-icon>
            로그아웃
        </v-btn>
    </div>        
</template>

<script>
import MenuBar from '@/components/MenuBar'
import LoginForm from '@/components/member/LoginForm'
import axios from 'axios'
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
    name: 'LoginPage',
    components: {
        LoginForm,
        MenuBar
    },
    data() {
        return {
            isLogin: false
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
                            this.$store.state.userInfo = res.data
                            this.$cookies.set("user", res.data, 300)
                            this.isLogin = true
                            this.$router.push({
                                name: 'HomeView'
                                })
                            this.$store.state.memberId = memberId
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
        },
        logout() {
            this.$cookies.remove("user")
            this.isLogin = false
            this.$store.state.userInfo = null

            alert('로그아웃 성공!')
        }
    }
}
</script>

<style scoped>
/* #app {
  text-align: center;
} */



</style>
