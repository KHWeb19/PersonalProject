<template>
    <v-container>
        <v-row justify="center">
            <img class="titleImg" src="@/assets/title/reviewTitle.png" width=170 >
        </v-row>
        <v-row>
            <review-modify :review="review" @submit="onSubmit"/>
        </v-row>
    </v-container>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import ReviewModify from '@/components/board/review/ReviewModify.vue'

export default {
  components: {ReviewModify },
    name:'ReviewModifyPage',
    props: {
        reviewNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['review'])
    },
    methods: {
        ...mapActions(['fetchReview']),
        onSubmit (payload) {
            const { formData} = payload

            axios.put(`http://localhost:7777/board/review/${this.reviewNo}`, formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'ReviewReadPage',
                            params: { reviewNo: res.data.reviewNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created() {
        this.fetchReview(this.reviewNo)
        .catch(() => {
            alert('게시물 DB조회 실패!')
        })
    }

}
</script>

<style scoped>
.titleImg{
    margin-top:3%;
    margin-bottom: 5%;
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