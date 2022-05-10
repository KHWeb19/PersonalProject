<template>
    <div id="register" align="center">
        <free-board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import axios from 'axios'
import FreeBoardRegisterForm from '@/components/freeBoard/FreeBoardRegisterForm.vue'


export default {
    name: 'FreeBoardRegisterPage',
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

<style scoped>

</style>