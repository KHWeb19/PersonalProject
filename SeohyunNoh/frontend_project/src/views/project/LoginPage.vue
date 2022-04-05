<template>
    <div>
        <div>
            <Header/>
        </div>

        <login-form @submit="onSubmit"/>
        
        <!-- <v-btn tile color="teal lighten" @click="logout">
            <v-icon left>
                mdi-logout
            </v-icon>
            로그아웃
        </v-btn> -->
    </div>
</template>

<script>

import Header from '@/components/layout/Header.vue'
import LoginForm from '@/components/project/LoginForm.vue'

import Vue from 'vue'
import axios from 'axios'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
    name: "LoginPage.vue",
    components: {
        Header,
        LoginForm
    },
    data () {
        return {
            isLogin: false
        }
    },
    mounted() {
        this.$store.state.userInfo = this.$cookies.get("user")

        if(this.$store.state.userInfo != null) {
            this.isLogin = true
        } else {
            this.isLogin = false
        }
    },
    methods: {
        async onSubmit(payload) {
            if(!this.isLogin) {
                const { id, pw, auth } = payload
                axios.post('http://localhost:7777/memberAuth/login', { id, pw, auth })
                    .then(res => {
                        if(res.data) {
                            alert('반갑습니다' + id + ' 님')
                            this.$store.state.userInfo = res.data
                            this.$cookies.set("user", res.data, 30)
                            this.isLogin = true
                        }
                    })
                    .catch(res =>{
                        alert(res.response.data.message)
                    })
            } else {
                alert('이미 로그인 되어 있습니다.')
            }
        },
        logout() {
            this.$cookies.remove("user")
            this.isLogin = false
            this.$store.state.userInfo = null

            alert('로그아웃 되었습니다.')
        }
    }
}
</script>