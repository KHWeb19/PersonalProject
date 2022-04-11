<template>
    <div>
        <free-board-comment-form :freeBoardComments="freeBoardComments" :boardNo="boardNo" @submit="onSubmit"/>
    </div>
</template>

<script>

import FreeBoardCommentForm from '@/components/freeBoard/FreeBoardCommentForm.vue'
import { mapActions, mapState } from 'vuex'
import axios from 'axios'

export default {
      props: {
        boardNo: {
            type: String,
            required: true
        }
    },

    components: {
        FreeBoardCommentForm
    },
        computed: {
        ...mapState(['freeBoardComments'])
    },
      created () {
        this.fetchFreeBoardCommentsList(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
         
    },
       methods: {
        ...mapActions(['fetchFreeBoardCommentsList']),
         onSubmit (payload) {
            const { writer, content } = payload
            const boardNo = this.boardNo
            axios.post(`http://localhost:7777/freeBoardComments/register/${boardNo}`, { writer, content })
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