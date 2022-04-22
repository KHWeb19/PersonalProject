<template>
    <div>
        <div align="center">
           <qn-a-register-form @submit="onSubmit"/> 
        </div>
    </div>
</template>

<script>

import QnARegisterForm from '@/components/qna/QnARegisterForm.vue'
import axios from 'axios'

export default {
    name: 'QnARegisterPage',
    components: {
       QnARegisterForm,
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:7777/qna/register', { title, writer, content })
                    .then(() => {
                        alert('게시물 등록 성공!')

                        this.$router.push({
                            name: 'QnAListPage'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}

</script>