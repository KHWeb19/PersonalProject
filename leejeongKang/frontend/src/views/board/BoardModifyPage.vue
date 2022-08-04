<template>
    <div>
      <main-form/>
        <board-modify v-if="board" :board="board" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
      <main-bottom/>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import BoardModify from '@/components/board/BoardModify.vue'
import MainForm from '@/components/main/MainForm.vue'
import MainBottom from '@/components/main/MainBottom.vue'
export default {
  name: 'BoardModifyPage',
  components: {
    BoardModify,
    MainForm,
    MainBottom
  },
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['board'])
  },
  methods: {
    ...mapActions(['fetchBoard']),
    onSubmit (payload) {
      const { title, content } = payload
      axios.put(`http://localhost:7777/board/${this.boardNo}`,
        { title, writer: this.board.writer, content, regDate: this.board.regDate })
        .then(res => {
          alert('게시물 수정 성공!')
          this.$router.replace({
            name: 'BoardReadPage',
            params: { boardNo: res.data.boardNo.toString() }
          })
        })
        .catch(() => {
          alert('게시물 수정 실패!')
        })
    }
  },
  created () {
    this.fetchBoard(this.boardNo)
      .catch(() => {
        alert('게시물 DB 조회 실패!')
        this.$router.back()
      })
  }
}
</script>
