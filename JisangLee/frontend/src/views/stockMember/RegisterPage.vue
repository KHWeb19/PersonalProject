<template>
  <div>
    <div align="center">
    </div>
    <register-form @submit="onSubmit"/>
  </div>
</template>

<script>

import RegisterForm from '@/components/stockMember/RegisterForm.vue'
import axios from 'axios'

export default {
  name: "RegisterPage.vue",
  components: {
    // eslint-disable-next-line vue/no-unused-components
    RegisterForm
  },
  methods: {
    onSubmit (payload) {
      const { id, pw, nickname, email, phonenumber } = payload
      axios.post('http://localhost:7777/vueJpaMember/register', { id, pw, nickname, email, phonenumber })
        .then(res => {
          alert('회원가입이 완료되었습니다.' + res)
        })
        .catch(res => {
          alert(res.response.data.message)
        })
    }
  }
}

</script>

<style scoped>

</style>