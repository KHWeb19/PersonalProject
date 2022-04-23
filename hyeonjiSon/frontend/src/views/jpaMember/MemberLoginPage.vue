<template>
  <div>
    <div align="center">
    <br><br>
      <h1>로그인</h1>
      <!--v-icon대신할 이미지 필요함 -->
    </div>
    <login-form @submit="onSubmit"/>
  </div>
</template>

<script>
import LoginForm from '@/components/jpaMember/LoginForm.vue'
import axios from 'axios'
import { mapState } from 'vuex'
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
   name: "MemberLoginPage",
   components: {
      LoginForm
    },
    mounted() {
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.$store.state.isLogin = true
        } else {
          this.isLogin = false
        }
    },
    computed: {
      ...mapState(['isLogin']),
      ...mapState(['session'])
    },
    methods: {
      onSubmit (payload) {
        if(!this.Login) {
          const { id, pw } = payload
          axios.post('http://localhost:7777/jpaMember/login', { id, pw }) //Spring Controller에 연동하여 전달
          .then(res => { //then 정상적으로 데이터를 받았을 경우 동작
            alert(' 로그인 성공! ' + res.data.userId)
              this.$store.state.userInfo = res.data
              this.$cookies.set("user", res.data, 60*60*12)// 12 시간
              //"토큰", "input_value", 만료 시간
              this.isLogin = true
          })
          .catch(res => { //에러 캐치한 경우 동작
            alert('로그인 실패!' + res.data)
          })
          //finally 동작 여부와 무관하게 무조건 실행됨
        } else {
          alert('이미 로그인되어 있습니다!')
        }
      },

    }
}
</script>