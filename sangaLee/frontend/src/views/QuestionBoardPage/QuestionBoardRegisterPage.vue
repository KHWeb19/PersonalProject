<template>
<div class="main">
    <h2>질문을 작성해주세요.</h2>
        <question-board-register-form @submit="onSubmit"/>
</div>
</template>

<script>

import QuestionBoardRegisterForm from '@/components/QuestionBoard/QuestionBoardRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'QuestionBoardRegisterPage',
    components: {
        QuestionBoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, writer, content } = payload
            axios.post('http://localhost:7777/QuestionBoard/register', { title, writer, content })
                    .then(() => {
                        alert('게시물 등록 성공!')

                        this.$router.push({
                            name: 'QuestionBoardListPage'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}

</script>
<style scoped>
.main {
background-color: #EBECF0;
height: 100vh;
}
h2 {
    text-align: center;
    padding: 60px;
    color: #6768ab;
}
</style>