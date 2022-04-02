<template>
    <div>
        <register-form @submit="onSubmit"/>
    </div>        
</template>

<script>
import RegisterForm from '@/components/member/RegisterForm'
import axios from 'axios'
export default {
    name: 'RegisterPage.',
    components: {
        RegisterForm
    },
    methods: {
        onSubmit (payload) {
        const { memberName, memberId, password } = payload
        axios.post('http://localhost:7777/member/register', { memberName, memberId, password })
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
