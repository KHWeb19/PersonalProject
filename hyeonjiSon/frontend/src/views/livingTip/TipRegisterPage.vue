<template>
<div align="center">
       <h1> Register Page </h1>
       <br>
       <tip-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import TipRegisterForm from '@/components/livingTip/TipRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'TipRegisterPage',
    components: {
        TipRegisterForm
    },
    methods: {
      onSubmit (payload) {
        const { title, writer, password, content } = payload
        axios.post('http://localhost:7777/tipboard/register', { title, writer, password, content })
                .then(() => {
                    alert('게시물 등록 성공!')
                    this.$router.push({
                        name: 'livingTipBoardList'
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