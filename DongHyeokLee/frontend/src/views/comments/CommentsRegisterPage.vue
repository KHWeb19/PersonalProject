<template>
    <div align="center">
        <h2>댓글</h2>
        <comments-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import axios from 'axios'
import CommentsRegisterForm from '@/components/comments/CommentsRegisterForm.vue'


export default {
    name: 'CommentsRegisterPage',
    components: {
        CommentsRegisterForm
        
    },
    
    methods: {
        onSubmit (payload) {
            const {boardNo,content, writer } = payload
            axios.post('http://localhost:7777/comments/register', { boardNo, writer, content })
                    .then(() => {
                        alert('댓글 등록 성공!')

                        this.$router.push({
                            name: 'FreeReadPage'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}

</script>