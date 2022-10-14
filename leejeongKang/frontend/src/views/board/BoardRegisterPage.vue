<template>
    <div align="center">
      <main-form/>
      <board-register @submit="onSubmit"/>
      <main-bottom/>
    </div>
</template>

<script>

import BoardRegister from '@/components/board/BoardRegister.vue'
import axios from 'axios'
import MainForm from '@/components/main/MainForm.vue'
import MainBottom from '@/components/main/MainBottom.vue'

export default {
  name: 'BoardRegisterPage',
  components: {
    BoardRegister,
    MainForm,
    MainBottom
  },
  methods: {
    onSubmit (payload) {
      const { title, writer, content } = payload
      axios.post('http://localhost:7777/board/register', { title, writer, content })
        .then(() => {
          alert('게시물 등록 성공')
          this.$router.replace({
            name: 'BoardListPage'
          })
        })
        .catch(() => {
          alert('문제 발생')
        })
    }
  }
}
</script>
