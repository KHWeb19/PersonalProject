<template>
    <div align ="center">
          <login-form v-if="session ==null" @submit="onSubmit"/>
    </div>

</template>

<script>

import Vue from 'vue'
import cookies from 'vue-cookies'
import LoginForm from '@/components/login/LoginForm.vue'
import axios from 'axios'
import {mapActions, mapState } from 'vuex';

Vue.use(cookies)

export default {

   name: "LoginPage",

   components: {
       LoginForm
   },
   data () {
        return {
            res:''
        }
    },
   computed: { 
    //값이 들어있음
    ...mapState(["isLogin", "session", "auth"])
    },
    
   methods:{
       //작동
        ...mapActions(['cookieSession', 'setIsLogin','setAuth']),

        onSubmit (payload) {

            const {userId, password,auth } = payload

            axios.post(`http://localhost:7777/jpaMember/login`, {userId, password})
                .then(res => {
                    if (res.data =="") {

                        alert('로그인 성공')

                        this.res = res.data
                        this.$cookies.set("user", res.data, 30)
                        this.$cookies.set("userNo", res.data.memberNo, 30)
                        this.cookieSession()
                        this.setIsLogin()

                        this.$router.push('/main') 
                    }
                    else{
                    alert('아이디나 비번이 틀림')
                    }      
                })

            axios.post(`http://localhost:7777/jpaMember/login`,{auth})
                .then( (res) =>{
                    if(res.data ==""){
                        const user  = "개인"
                        this.$cookies.set("userAuth",user,30 )
                        this.setAuth()
                    }
                    else{
                        this.$cookies.set("userAuth", res.data, 30)
                        this.setAuth()
                    }
                
                })
        }   

    },         
}

//할 일 
//로그인 연결
// 쿠키 
//로그아웃
//뷰에서 아이디와 비번이 일치하지 않습니다
//로그인을 했을 때 메뉴바 변하기 

</script> 