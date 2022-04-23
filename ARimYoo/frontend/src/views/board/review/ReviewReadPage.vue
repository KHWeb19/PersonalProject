<template>
    <v-container>
        <v-row justify="center">
            <img class="titleImg" src="@/assets/title/reviewTitle.png" width=170 >
        </v-row>
        <v-row>
            <review-reading v-if="review" :review="review"/>
            <review-comment-list @submit="onCommentSubmit" :reviewComments="reviewComments" />
        </v-row>
    </v-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import axios from 'axios'
import ReviewReading from '@/components/board/review/ReviewReading.vue'
import ReviewCommentList from '@/components/board/review/ReviewCommentList.vue'

export default {
    name:'ReviewReadPage',
        props: {
        reviewNo: {
            type: String,
            required: true
        }
    },
    mounted() {
        this.fetchReviewCommentsList(this.reviewNo)
    },
    computed: {
        ...mapState(['review' ,'reviewComments'])
    },
    components: {
        ReviewReading,
        ReviewCommentList,

    },
    created () {
        this.fetchReview(this.reviewNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    console.log(this.reviewNo)
                    this.$router.push()
                })
    },
    
    methods: {
        ...mapActions(['fetchReview', 'fetchReviewCommentsList']),
         onCommentSubmit (payload) {

            const { comment, commentWriter } = payload

            let formData = new FormData()

            formData.append('comment', comment)
            formData.append('commentWriter', commentWriter)
            console.log(formData)
            
            axios.post(`http://localhost:7777/board/review/${this.reviewNo}/comment/register`, formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                   .then(() => {
                alert('댓글이 작성되셨습니다.')
                history.go(0)
            })
            .catch (() => {
                console.log(this.reviewNo)
                alert('문제 발생!')
             })
        }
        
    }

}
</script>

<style scoped>

.titleImg{
    margin-top:5%;
    margin-bottom: 6%;
}

@media (max-width:700px){
    .titleImg {
        margin-top:10%;
        margin-left:20px;
        margin-bottom:10%;
        width:200px;
    }
}

</style>