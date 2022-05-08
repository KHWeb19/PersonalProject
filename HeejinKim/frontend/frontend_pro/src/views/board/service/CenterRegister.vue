<template>
    <v-container class="writeForm">
        <v-row>
            <center-register-form @submit="onSubmit"/>
        </v-row>
    </v-container>
</template>

<script>
import axios from 'axios'
import CenterRegisterForm from '@/components/board/service/CenterRegisterForm.vue'
export default {
    name: 'CenterRegister',
    components: { 
        CenterRegisterForm
    },
    
    methods: {
        onSubmit (payload) {
            const { title, content, writer,file} = payload
            let formData = new FormData()
            if (file != null )
            {formData.append('file', file)}
            formData.append('title',title)
            formData.append('content', content)
            formData.append('writer', writer)
           
            axios.post(`http://localhost:7777/board/center/register`,formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                    .then(() => {
                        alert('게시물 등록 성공!')
                        this.$router.push({
                            name: 'CenterList'
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