<template>
    <div align="center">
        <h2>게시물 작성</h2>
        <free-board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import axios from 'axios'
import FreeBoardRegisterForm from '@/components/freeBoard/FreeBoardRegisterForm.vue'


export default {
    name: 'BoardRegisterPage',
    components: {
        FreeBoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:7777/freeBoard/register', { title, writer, content })
                    .then(() => {
                        alert('게시물 등록 성공!')

                        this.$router.push({
                            name: 'FreeBoardListPage'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}

</script>