<template>
    <div>
        <v-toolbar class="black" dense dark>
            <v-spacer></v-spacer>
            <v-toolbar-title>         
    <member-sign-up :members="memberLists"/>
    <member-login @submit="login"/>
            </v-toolbar-title>
        </v-toolbar>
    </div>
</template>

<script>

import { mapActions, mapState } from 'vuex'
import Vue from 'vue'
import axios from 'axios'
import cookies from 'vue-cookies'

Vue.use(cookies)

import MemberSignUp from '@/components/member/MemberSignUp.vue'
import MemberLogin from '@/components/member/MemberLogin.vue'

export default {  
    name: 'TopNavBar',
    data () {
        return {
            isLogin: false
        }
    },
    components: {
        MemberSignUp,
        MemberLogin
    },
    computed:{
        ...mapState(['memberLists'])
    },
     mounted () {
        this.fetchMemberList(),
        this.$store.state.userInfo = this.$cookies.get("user")

        if (this.$store.state.userInfo != null){
            this.isLogin = true
        }else {
            this.isLogin = false
        }
    },
    methods: {
        ...mapActions(['fetchMemberList']),
        login (payload) {
            if (!this.isLogin){
                const { userId, password } = payload
                axios.post('http://localhost:7777/member/login', { userId, password })
                 .then(res => {
                    if (res.data) {
                        alert('로그인 성공!')
                        this.$store.state.userInfo = res.data
                        this.$cookies.set("user", res.data, 30)
                        this.isLogin = true
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
