<template>
    <div align="center">
        <h2>생일관리 등록</h2>
        <jpa-board-register-form-3 @submit="onSubmit"/>
    </div>
</template>

<script>
import JpaBoardRegisterForm3 from '@/components/jpaBoard3/JpaBoardRegisterForm3.vue'
import axios from 'axios'

export default {
    name: 'BoardRegisterPage3',
    components: {
        JpaBoardRegisterForm3
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer, writer1 } = payload
            axios.post('http://localhost:7777/62th/board3/register3', { title, writer, writer1, content })
                    .then(() => {
                        alert('게시물 등록 성공!')
                        this.$router.push({
                            name: 'JpaBoardListPage3'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}
</script>