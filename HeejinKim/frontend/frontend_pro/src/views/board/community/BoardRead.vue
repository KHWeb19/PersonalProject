<template>
  
    <v-container>
        <v-row>
            <board-read-form v-if="board" :board="board"/>            
        </v-row>
        <v-row>
            <board-comment-form @submit="onSubmit" :boardComments="boardComments" :boardNo="boardNo" />
                       
        </v-row>
    </v-container>
</template>

<script>
import BoardReadForm from '@/components/board/community/BoardReadForm.vue' 
import BoardCommentForm from '@/components/board/community/BoardCommentForm.vue'
import axios from 'axios'

import { mapActions, mapState } from 'vuex'

export default {
    name:'BoardRead',
   
    props: {
        boardNo: {
            type: String,
            required: true
        },
         
    },
    
    
    computed: {
        ...mapState(['board','boardComments'])
    },

    components: {  
       BoardReadForm,
       BoardCommentForm
    },
    created () {
        this.fetchBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    console.log(this.boardNo)
                    this.$router.push()
                })
    },
    
    methods: {
        ...mapActions(['fetchBoard','fetchBoardCommentsList']),

        onSubmit (payload) {

            const { comment, commentWriter } = payload
            const boardNo = this.boardNo

            axios.post(`http://localhost:7777/boardComments/register/${boardNo}`, { commentWriter, comment })
                .then(() => {
                    alert('댓글 등록')
                    this.$router.push('/communityBoard')
                })
                .catch(() => {
                    alert('문제 발생!')
                })
        }
        
              
    },
    mounted() {
        this.fetchBoardCommentsList(this.boardNo)
    },
}
</script>

<style scoped>
.title{
    margin-top:5%;
    margin-bottom: 5%;
}
</style>
