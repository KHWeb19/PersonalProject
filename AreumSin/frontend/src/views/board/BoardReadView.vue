<template>
  <v-container>
    <MainCategory/>

    <board-read-page v-if="boardRead" :boardRead="boardRead" :boardReadImg="boardReadImg" :isMember="isMember" @onDelete="onDelete" @onModify="onModify"></board-read-page>

    <board-comment :boardNo="boardNo" @sendComment="sendComment" :boardListComment="boardListComment" @sendReply="sendReply"></board-comment>
  </v-container>
</template>

<script>
import BoardReadPage from "@/components/board/BoardReadPage";
import {mapActions, mapState} from "vuex";
import MainCategory from "@/components/MainCategory";
import axios from "axios";
import BoardComment from "@/components/board/BoardComment";

export default {
  name: "BoardReadView",
  components: {BoardComment, MainCategory, BoardReadPage},
  props:{
    boardNo: {
      type: String,
      default: ''
    },
    isMember: {
      type: Boolean,
      default: false
    },
  },
  data(){
    return{
      removeOk: false,
      user: localStorage.getItem('session')
    }
  },
  methods:{
    ...mapActions(['fetchBoardRead','fetchBoardReadImg','fetchBoardComment']),
    onDelete(){
      const {boardNo} = this.boardRead

      axios.delete(`http://localhost:7777/board/${boardNo}`)
          .then(() => {
            //alert('삭제 성공!')
            this.$router.push({ name: 'BoardView' })
          })
          .catch(() => {
            alert('삭제 실패! 문제 발생!')
          })
    },
    onModify(){
      this.$router.push({name: 'BoardModifyView', params: {boardNo: this.boardNo}})
    },
    sendComment(payload){
      const {comment} = payload;
      let boardNo = this.boardNo;
      let writer = this.user

      axios.post('http://localhost:7777/board/comment', {comment, writer, boardNo})
        .then(() => {
          this.$router.push({name: 'BoardReadView'});
        })

    },
    sendReply(payload){
      const {reply, commentNo} = payload;
      let writer = this.user;

      axios.post('http://localhost:7777/board/reply', {reply, commentNo, writer})
        .then(() => {
          alert("성공!")
        })
    }
  },
  created() {
    console.log(this.boardNo)
    this.fetchBoardRead(this.boardNo)
    this.fetchBoardReadImg(this.boardNo)
    this.fetchBoardComment(this.boardNo)

  },
  computed: {
    ...mapState(['boardRead','boardReadImg','boardListComment']),

  }

}
</script>

<style scoped>

</style>