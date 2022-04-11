<template>
    <div>
        <video-board-comment-form :videoBoardComments="videoBoardComments" :boardNo="boardNo" @submit="onSubmit"/>
    </div>
</template>

<script>

import VideoBoardCommentForm from '@/components/videoBoard/VideoBoardCommentForm.vue'
import { mapActions, mapState } from 'vuex'
import axios from 'axios'

export default {
      name:'VideoBoardComment',  
      props: {
        boardNo: {
            type: String,
            required: true
        }
    },

    components: {
        VideoBoardCommentForm
    },
        computed: {
        ...mapState(['videoBoardComments'])
    },
      created () {
        this.fetchVideoBoardCommentsList(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
         
    },
       methods: {
        ...mapActions(['fetchVideoBoardCommentsList']),
         onSubmit (payload) {
            const { writer, content } = payload
            const boardNo = this.boardNo
            axios.post(`http://localhost:7777/videoBoardComments/register/${boardNo}`, { writer, content })
                    .then(() => {
                        alert('댓글 등록')
                        this.$router.go()
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    },
}
</script>