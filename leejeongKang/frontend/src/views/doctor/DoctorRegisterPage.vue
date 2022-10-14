<template>
    <div align="center">
      <main-form/>
      <doctor-register @submit="onSubmit"/>
    </div>
</template>

<script>

import DoctorRegister from '@/components/doctor/DoctorRegister.vue'
import axios from 'axios'
import MainForm from '@/components/main/MainForm.vue'

export default {
  name: 'DoctorRegisterPage',
  components: {
    DoctorRegister,
    MainForm
  },
  methods: {
    onSubmit (payload) {
      const { major, doctorName, information } = payload
      axios.post('http://localhost:7777/doctor/register', { major, doctorName, information })
        .then(() => {
          alert('게시물 등록 성공')
          this.$router.replace({
            name: 'MainPage'
          })
        })
        .catch(() => {
          alert('문제 발생')
        })
    }
  }
}
</script>
