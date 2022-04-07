<template>
    <div>
        <photo-board-comment-form :photoBoardComments="photoBoardComments" :boardNo="boardNo" @submit="onSubmit"/>
    </div>
</template>

<script>

import PhotoBoardCommentForm from '@/components/photoBoard/PhotoBoardCommentForm.vue'
import { mapActions, mapState } from 'vuex'
import axios from 'axios'

export default {
      name:'PhotoBoardComment',  
      props: {
        boardNo: {
            type: String,
            required: true
        }
    },

    components: {
        PhotoBoardCommentForm
    },
        computed: {
        ...mapState(['photoBoardComments'])
    },
      created () {
        this.fetchPhotoBoardCommentsList(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
         
    },
       methods: {
        ...mapActions(['fetchPhotoBoardCommentsList']),
         onSubmit (payload) {
            const { writer, content } = payload
            const boardNo = this.boardNo
            axios.post(`http://localhost:7777/photoBoardComments/register/${boardNo}`, { writer, content })
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