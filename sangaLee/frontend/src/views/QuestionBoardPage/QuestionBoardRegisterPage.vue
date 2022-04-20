<template>
    <div align="center">
        <h2>게시물 작성</h2>
        <question-board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import QuestionBoardRegisterForm from '@/components/QuestionBoard/QuestionBoardRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'BoardRegisterPage',
    components: {
        QuestionBoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:7777/QuestionBoard/register', { title, writer, content })
                    .then(() => {
                        alert('게시물 등록 성공!')

                        this.$router.push({
                            name: 'BoardListPage'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}

</script>