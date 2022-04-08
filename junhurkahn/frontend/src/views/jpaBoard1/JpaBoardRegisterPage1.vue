<template>
    <div align="center">
        <h2>계좌번호 작성</h2>
        <jpa-board-register-form-1 @submit="onSubmit"/>
    </div>
</template>

<script>
import JpaBoardRegisterForm1 from '@/components/jpaBoard1/JpaBoardRegisterForm1.vue'
import axios from 'axios'

export default {
    name: 'BoardRegisterPage1',
    components: {
        JpaBoardRegisterForm1
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer,writer1 } = payload
            axios.post('http://localhost:7777/62th/board1/register1', { title, writer, content, writer1 })
                    .then(() => {
                        alert('게시물 등록 성공!')
                        this.$router.push({
                            name: 'JpaBoardListPage1'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}
</script>