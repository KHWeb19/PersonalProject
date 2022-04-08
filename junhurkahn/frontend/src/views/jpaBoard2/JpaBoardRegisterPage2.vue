<template>
    <div align="center">
        <h2>장보기 작성</h2>
        <jpa-board-register-form-2 @submit="onSubmit"/>
    </div>
</template>

<script>
import JpaBoardRegisterForm2 from '@/components/jpaBoard2/JpaBoardRegisterForm2.vue'
import axios from 'axios'

export default {
    name: 'BoardRegisterPage2',
    components: {
        JpaBoardRegisterForm2
    },
    methods: {
        onSubmit (payload) {
            const { title, content,} = payload
            axios.post('http://localhost:7777/62th/board2/register2', { title, content })
                    .then(() => {
                        alert('게시물 등록 성공!')
                        this.$router.push({
                            name: 'JpaBoardListPage2'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}
</script>