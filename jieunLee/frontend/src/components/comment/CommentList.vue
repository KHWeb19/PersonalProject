<template>
    <td>
        <div v-for="comment in twoComments" :key="comment.commentNo">
            <span style="font-weight: bold;">{{ comment.writer }}&nbsp;</span>
            {{ comment.content }}
        </div>
    </td>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
    name: 'CommentList',
    props: {
        boardNo: {
            type: Number,
            required: true
        },
    },
    computed: {
        ...mapState(['twoComments']),
    },
    created() {
        this.fetchTwoCommentList(this.boardNo)
        .then(()=>{
            console.log(this.twoComments)
        })
            .catch(()=>{
              console.log(this.boardNo)
                alert('댓글 요청 실패')
                this.$router.push()
            })
    },
        mounted () {
        this.fetchTwoCommentList(this.boardNo)
    },
        methods: {
            
        ...mapActions(['fetchTwoCommentList']),
        }
}
</script>>
