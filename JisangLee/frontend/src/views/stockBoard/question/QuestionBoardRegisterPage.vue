<template>
<div align="center">
        <br><br>
        <span id="shadow" class="shadow">질문</span>
        <br><br>
        <question-board-register-form @submit="onSubmit"/>
</div>
</template>

<script>
import swal from 'sweetalert';
import QuestionBoardRegisterForm from '@/components/stockBoard/question/QuestionBoardRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'QuestionBoardRegisterPage',
    components: {
        QuestionBoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:7777/questionboard/register', { title, writer, content })
                    .then(() => {
                        swal({                                                                              
                            text: "게시물이 등록되었습니다!",
                            icon: "success"
                            })

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