<template>
  <div>
    <menu-bar/>
    <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
    <board-read :board="board" @click="onDelete"/>
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
    computed: {
        ...mapState(['board']),
    },
    created() {
        this.fetchBoard(this.boardNo)
            .catch(()=>{
                alert('게시물 요청 실패')
                this.$router.push()
            })
    },
    methods: {
        ...mapActions(['fetchBoard']),
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
        }
    },
}
</script>

<style>


</style>