<template>
    <div>
        <board-comment-form 
        :commentList="boardComments" 
        :boardNo="boardNo"
        :boardName="`${this.boardName}`"
        @submit="onSubmit"/>
    </div>
</template>

<script>
import BoardCommentForm from '@/components/board/community/BoardCommentForm.vue'
import { mapActions, mapState } from 'vuex'
import axios from 'axios'

export default {

    data () {
        return {
              boardName: "boardComments"
        }
    },
      props: {
        boardNo: {
            type: String,
            required: true
        }
    },
     
    components: {
        BoardCommentForm
    },

    computed: {
        ...mapState(['boardComments'])
    },

      created () {
        this.fetchBoardCommentsList(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
         
    },
       methods: {
        ...mapActions(['fetchBoardCommentsList']),
        
         onSubmit (payload) {
            const { commentWriter, comment } = payload
            const boardNo = this.boardNo
            axios.post(`http://localhost:7777/boardComments/register/${boardNo}`, { commentWriter, comment })
                    .then(() => {
                        alert('댓글 등록')
                        this.$router.push({ name: 'BoardList' })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    },
}
</script>
