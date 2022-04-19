<template>
    <div>
       <board-comment-form :commentList="videoBoardComments" 
                            :boardNo="boardNo"
                            :boardName="`${this.boardName}`"
                             @submit="onSubmit"/>
    </div>
</template>

<script>

import BoardCommentForm from '@/components/common/comment/BoardCommentForm.vue'
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
    data () {
    return {
        boardName: 'videoBoardComments'
    }
    },
    components: {
        BoardCommentForm
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
            const { writer, comment } = payload
            const boardNo = this.boardNo
            axios.post(`http://localhost:7777/videoBoardComments/register/${boardNo}`, { writer, comment })
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