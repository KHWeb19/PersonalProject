<template>
  <v-container>
    <board-modify-page :boardRead="boardRead" :boardReadImg="boardReadImg" @onModify="onModify"></board-modify-page>
  </v-container>
</template>

<script>
import BoardModifyPage from "@/components/board/BoardModifyPage";
import {mapActions, mapState} from "vuex";
import axios from "axios";
export default {
  name: "BoardModifyView",
  components: {BoardModifyPage},
  props: {
    boardNo: {
      type: Number,
      required: true
    }
  },
  computed: {
    ...mapState(['boardRead', 'boardReadImg'])
  },
  methods: {
    ...mapActions(['fetchBoardRead', 'fetchBoardReadImg']),
    async onModify(payload){
      const {title, place, boardContent, board} = payload;

      console.log(title, place, boardContent)

      await axios.put(`http://localhost:7777/board/${this.boardNo}`, {title, place, boardContent})
        .then(() => {
          //alert('게시물 수정 성공' + res)
        })

      let formData = new FormData;

      for(let i = 0; i < board.length; i++) {
        formData.append('boardNo', board[i]);
      }

      /*alert(board[0])
      alert(typeof board);
      alert(board.length)*/
      await axios.post(`http://localhost:7777/board/img/${this.boardNo}`, formData)
        .then(() => {
          //alert('이미지 게시물 수정 성공' + res)
          this.$router.push({ name: 'BoardView' })
        })
    }
  },
  created() {
    this.fetchBoardRead(this.boardNo);
    this.fetchBoardReadImg(this.boardNo);
  }
}
</script>

<style scoped>

</style>