<template>
    <div>
        <register-form @submit="onSubmit"/>
    </div>        
</template>

<script>
import RegisterForm from '@/components/member/RegisterForm'
import axios from 'axios'
export default {
    components: {
        RegisterForm
    },
    methods: {
        onSubmit (payload) {
        const { name, id, pw } = payload
        axios.post('http://localhost:7777/member/register', { name, id, pw })
            .then(res => {
            alert('등록 성공! - ' + res)
            })
            .catch(res => {
            alert(res.response.data.message)
            })
        }
    }
}
</script>

<style scoped>
/* #app {
  text-align: center;
} */



</style>
