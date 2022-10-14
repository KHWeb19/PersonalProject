<template>
  <div>
    <main-form/>
    <member-register @submit="onSubmit"></member-register>
    <main-bottom/>
  </div>
</template>

<script>
import MemberRegister from '@/components/member/MemberRegister.vue'
import axios from 'axios'
import MainForm from '@/components/main/MainForm.vue'
import MainBottom from '@/components/main/MainBottom.vue'
export default {
  name: "MemberRegisterPage.vue",
  components: {
    MemberRegister,
    MainForm,
    MainBottom
  },
  methods: {
    onSubmit (payload) {
      const { id, password, name, birth, phone, auth } = payload
      axios.post('http://localhost:7777/member/register', { id, password, name, birth, phone, auth })
        .then(res => {
          alert('회원가입 Success!')
          this.$router.replace({
            name: 'LoginPage'
          })
        })
        .catch(res => {
          alert('회원가입 Fail')
        })
    }
  }
}
</script>
<style scoped>
</style>
