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

export default {
   name: "MemberLoginPagee",
   components: {
      LoginForm
    },
    methods: {
       onSubmit (payload) {
          const { id, pw } = payload
         axios.post('http://localhost:7777/vueJpaMember/login', { id, pw }) //Spring Controller에 연동하여 전달
        .then(res => { //then 정상적으로 데이터를 받았을 경우 동작
          alert(' 로그인 성공! ' + res)
        })
        .catch(res => { //에러 캐치한 경우 동작
          alert(res.response.data.message)
        })
        //finally 동작 여부와 무관하게 무조건 실행됨
       }
    }
}
</script>