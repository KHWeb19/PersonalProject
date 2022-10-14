<template>
    <div>
      <main-form/>
        <board-read v-if="board" :board="board"></board-read>
        <p v-else>로딩중 .......</p>
        <comment-register @submit="onSubmit" :comments="comments"/><br>
        <div id = "menu" v-if="this.$store.state.userInfo.id === board.writer">
        <v-col>
        <router-link style="color: blue" :to="{ name: 'BoardModifyPage', params: { boardNo } }">
            <b>게시물을 수정하시겠습니까?</b>&emsp;&emsp;&emsp;
        </router-link>
        <a style="color:blue" @click="onDelete(board.boardNo)">
          <v-icon right>
          mdi-delete
      </v-icon>
          <b>게시물 삭제</b></a><br><br><br>
        </v-col>
        </div>
        <main-bottom/>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import BoardRead from '@/components/board/BoardRead.vue'
import MainForm from '@/components/main/MainForm.vue'
import MainBottom from '@/components/main/MainBottom.vue'
import CommentRegister from '@/components/comment/CommentRegister.vue'
export default {
  name: 'BoardReadPage',
  components: {
    BoardRead,
    MainForm,
    MainBottom,
    CommentRegister
  },
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['board', 'comments'])
  },
  mounted () {
    this.fetchCommentList(this.boardNo)
  },
  created () {
    this.fetchBoard(this.boardNo)
      .catch(() => {
        alert('게시물 요청 실패')
        this.$router.back()
      })
  },
  methods: {
    ...mapActions(['fetchBoard', 'fetchCommentList']),
    onSubmit (payload) {
      const { comment, commentWriter } = payload
      axios.post(`http://localhost:7777/comment/${this.boardNo}`, { comment, commentWriter })
        .then(() => {
          alert('댓글 작성 성공!')
          this.$router.go()
        })
        .catch(() => {
          alert('문제 발생')
        })
    },
    onDelete (boardNo) {
      axios.delete(`http://localhost:7777/board/delete/${boardNo}`, { boardNo })
        .then(() => {
          alert('게시물 삭제 성공!!')
          this.$router.replace({
            name: 'BoardListPage'
          })
        })
        .catch(() => {
          alert('게시물 삭제 실패!')
        })
    }
  }
}
</script>

<style scoped>
#menu { text-align: center; }
a { text-decoration: none; font-size: 18px; }
</style>
