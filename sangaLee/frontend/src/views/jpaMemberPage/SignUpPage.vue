<template>
  <div>
    <vuetify-member-register-form @submit="onSubmit"/>
  </div>
</template>

<script>

import VuetifyMemberRegisterForm from '@/components/jpaMember/SignUpForm.vue'
import axios from 'axios'

export default {
  name: "VuetifyMemberRegisterPage.vue",
  components: {
    // eslint-disable-next-line vue/no-unused-components
    VuetifyMemberRegisterForm
  },
  methods: {
    onSubmit (payload) {
      const { id, pw, email } = payload
      axios.post('http://localhost:7777/member/register', { id, pw, email })
        .then(res => {
          alert('등록 성공! - ' + res)
            this.$router.push({ name: 'LoginPage' })
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