<template>
  <div>
    <div style="z-index: 1; position: fixed; top: 0; left: 0; right: 0;">
      <menu-bar/>
      <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
    </div>
    <board-read :board="board" :boardNo="boardNo" :comments="comments" @click="onDelete" @submit="onSubmit"/>
  </div>
</template>

<script>
import MenuBar from '@/components/MenuBar.vue'
import BoardRead from '@/components/board/BoardRead'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'BoardReadPage',
    components: {
        MenuBar,
        BoardRead
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),

        }
    },
    computed: {
        ...mapState(['board']),
        ...mapState(['comments']),
    },
    created() {
        this.fetchBoard(this.boardNo)
            .catch(()=>{
                alert('게시물 요청 실패')
                this.$router.push()
            })
        this.fetchCommentList(this.boardNo)
            .catch(()=>{
                alert('댓글 요청 실패')
                this.$router.push()
            })
    },
    mounted () {
        this.fetchCommentList(this.boardNo)
  },
    methods: {
        ...mapActions(['fetchBoard']),
        ...mapActions(['fetchCommentList']),
        onDelete() {
            const {boardNo} = this.board
            axios.delete(`http://localhost:7777/board/${boardNo}`)
                .then(()=> {
                    alert('삭제 성공')
                    this.$router.push({name: 'HomeView'})
                })
                .catch(()=> {
                    alert('삭제실패 문제발생')
                })
        },
        onSubmit(payload) {
            const boardNo = this.boardNo
            const {content} = payload
            axios.post(`http://localhost:7777/comment/register/${boardNo}`, {writer: this.loginInfo.memberId, content})
                .then(() => {
                    alert('댓글 등록 성공!')
                        history.go(0);
                    })
                    .catch(() => {
                        
                        alert('문제 발생!')
                    })
        },
        
    },
}
</script>

<style>


</style>