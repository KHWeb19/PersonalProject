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
            if (!memberName || !memberId || !password || !passwordHint) {
                alert('모든 항목을 입력해주세요')
            } else {
                axios.post('http://localhost:7777/member/register', { memberName, memberId, password, passwordHint })
                    .then(res => {
                        if(res.data) {
                            alert(memberName + '님 가입이 완료 되었습니다!')
                            this.$router.push({name: 'LoginPage'})
                        } else {
                            alert('아이디 중복입니다!')
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
            }
            }
            
    }
}
</script>