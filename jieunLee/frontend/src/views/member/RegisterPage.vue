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
        const { memberName, memberId, password, passwordHint } = payload
        axios.post('http://localhost:7777/member/register', { memberName, memberId, password, passwordHint })
            .then(res => {
                if(res.data) {
                    alert(memberName + '님 가입이 완료 되었습니다!')
                    this.$router.push({name: 'LoginPage'})
                } else {
                    alert('아이디 중복!')
                }
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
