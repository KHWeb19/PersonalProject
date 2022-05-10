<template>
    <div align="center">
    <br><br><br>
    <span id="shadow" class="shadow">질문</span>
    <br><br><br>
    <question-board-modify-form v-if="questionBoard" :questionBoard="questionBoard" @submit="onSubmit"/>    
    </div>
</template>

<script>
import swal from 'sweetalert';
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import QuestionBoardModifyForm from '@/components/stockBoard/question/QuestionBoardModifyForm.vue'

export default {
    name: 'QuestionBoardModifyPage',
    components: {
        QuestionBoardModifyForm
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['questionBoard'])
    },
    methods: {
        ...mapActions(['fetchQuestionBoard']),
        onSubmit (payload) {
            const { title, content, viewCnt } = payload

            axios.put(`http://localhost:7777/questionboard/${this.boardNo}`,
                { title, writer: this.questionBoard.writer, content, createdDate: this.questionBoard.createdDate, viewCnt })
                    .then(res => {
                        swal({                                                                              
                            text: "게시물이 수정되었습니다!",
                            icon: "success"
                            })
                        this.$router.push({
                            name: 'QuestionBoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created () {
        this.fetchQuestionBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })
    }
}
</script>