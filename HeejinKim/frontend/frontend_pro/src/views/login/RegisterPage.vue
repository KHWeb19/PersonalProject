<!--<template>
    <div align ="center">
          <register-form @submit="onSubmit" :memberList="memberList"/>
        

    </div>

</template>

<script>


import RegisterForm from '@/components/login/RegisterForm.vue'
import axios from 'axios'
import {mapActions, mapState } from 'vuex';

export default {
   name: "RegisterPage",
   components: {
       RegisterForm
   },
    computed:{
        ...mapState(['memberList'])
    },
   methods:{
       ...mapActions(['fetchMemberList']),
       onSubmit(payload){
            const { userId, password, passwordCheck, email ,auth } = payload


            if(password == passwordCheck) {
                
            axios.post('http://localhost:7777/jpaMember/register',{userId, password, passwordCheck, email, auth})
                .then(res => {
                    if(res.data != null ) {
                        alert('회원가입 성공' + res)
                        this.$router.push({
                            name: 'Home'
                        })
                    } else { 
                        alert('중복된 아이디입니다')
                    }
                })
                .catch(res => {
                    alert(res.response.data.message)
                })
            }else {
                alert('비밀번호가 일치하지 않습니다.')
                return false
            }        
        } 
   },
   created() {
        this.fetchMemberList()

    }
}
</script>-->

