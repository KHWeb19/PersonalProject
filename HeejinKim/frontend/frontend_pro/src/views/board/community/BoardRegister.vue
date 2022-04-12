<template>
    <v-container class="writeForm">
        <v-row>
            <board-register-form @submit="onSubmit"/>
        </v-row>
    </v-container>
</template>

<script>

import axios from 'axios'
import BoardRegisterForm from '@/components/board/community/BoardRegisterForm.vue'


export default {

    name: 'BoardRegister',

    components: { 
        BoardRegisterForm
    },
    
    methods: {
        onSubmit (payload) {
            const { title, content, writer} = payload
            axios.post('http://localhost:7777/board/community/register', { title, content, writer })
                    .then(() => {
                        alert('게시물 등록 성공!')
                        this.$router.push({
                            name: 'BoardList'
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
.writeForm{
    margin-top:2.5%;
    margin-bottom: 5%;
}
</style>