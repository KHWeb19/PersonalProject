<template>
    <div>
        <forget-password-form @submit="onSubmit"/>
    </div>        
</template>

<script>
import ForgetPasswordForm from '@/components/member/ForgetPasswordForm'
import axios from 'axios'
export default {
    name: 'ForgetPasswordPage',
    components: {
        ForgetPasswordForm,
    },
    methods: {
        onSubmit(payload) {
            const {memberId, passwordHint} = payload
                axios.post('http://localhost:7777/member/fogetPassword', {memberId, passwordHint})
                    .then(res => {
                        if(res.data) {
                            this.$router.push({name: 'LoginPage'})
                        }else {
                            alert('다시 확인해주세요')
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>