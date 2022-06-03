<template>
  <div>
    <div align="center">
    </div>
    <register-form @submit="onSubmit"/>
  </div>
</template>

<script>

import swal from 'sweetalert';
import RegisterForm from '@/components/stockMember/RegisterForm.vue'
import axios from 'axios'

export default {
  name: "RegisterPage.vue",
  components: {
    RegisterForm
  },
  methods: {
    onSubmit (payload) {
      const { id, pw, nickname, email, phonenumber, auth } = payload
      axios.post('http://localhost:7777/vueJpaMember/register', { id, pw, nickname, email, phonenumber, auth })
        .then(() => {
          swal({
                text: "회원가입이 완료되었습니다!",
                icon: "success"
                })
          this.$router.push({
                            name: 'LoginPage'
                        })
        })
        .catch(res => {
          swal(res.response.data.message)
        })
    }
  }
}

</script>

<style scoped>

</style>