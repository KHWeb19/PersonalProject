<template>
    <div align="center">
        <h2>사이트 아이디 등록</h2>
        <jpa-board-register-form-4 @submit="onSubmit"/>
    </div>
</template>

<script>
import JpaBoardRegisterForm4 from '@/components/jpaBoard4/JpaBoardRegisterForm4.vue'
import axios from 'axios'

export default {
    name: 'BoardRegisterPage4',
    components: {
        JpaBoardRegisterForm4
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer,  writer1 } = payload
            axios.post('http://localhost:7777/62th/board4/register4', { title, writer,writer1, content })
                    .then(() => {
                        alert('게시물 등록 성공!')
                        this.$router.push({
                            name: 'JpaBoardListPage4'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}
</script>