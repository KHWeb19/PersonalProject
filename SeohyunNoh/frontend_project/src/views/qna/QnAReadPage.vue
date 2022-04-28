<template>
    <div align="center">
        <qn-a-read-form v-if="qnaBoard" :qnaBoard="qnaBoard"/>
        <p v-else>로딩중 ....... </p>

        <!-- 문의사항은 본인이 작성한 것만 수정/삭제 가능 --> 
        <div v-if="this.qnaBoard.writer === this.userInfo.id">
            <v-btn plain class="basil--text" router-link :to="{ name: 'QnAModifyPage', params: { qnaNo } }">
                수정
            </v-btn>

            <v-btn plain class="basil--text" @click="onDelete">
                삭제
            </v-btn>
        </div>

        <!-- <v-btn plain class="basil--text" router-link :to="{ name: 'QnAListPage' }">
            돌아가기
        </v-btn> -->

        <comment-read-form :qnaNo="qnaNo" class="mt-6"/>

    </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'

import QnAReadForm from '@/components/qna/QnAReadForm.vue'
import CommentReadForm from '@/components/comment/CommentReadForm.vue'


export default {
    name: 'QnAReadPage',
    data() {
        return{
            myqnaNo: '',
            id: ''
        }
    },
    props: {
        qnaNo: {
            type: String,
            required: true
        }
    },
    components: {
        QnAReadForm,
        CommentReadForm

    },
    created () {
        this.myqnaNo = this.$route.params.qnaNo

        this.fetchQnA(this.qnaNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    console.log(this.qnaNo)
                    // this.$router.push()
                })
    },
    mounted() {
        this.fetchComments(this.qnaNo)
    },
    computed: {
        ...mapState(['qnaBoard','userInfo'])
    },
    methods: {
        ...mapActions(['fetchQnA','fetchComments']),
        onDelete () {
            const { qnaNo } = this.qnaBoard

            axios.delete(`http://localhost:7777/qna/${qnaNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'QnAListPage' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }
    }
}

</script>