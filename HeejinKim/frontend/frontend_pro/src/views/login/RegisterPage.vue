<template>
    <div align ="center">
          <register-form @submit="onSubmit"/>
        

    </div>

</template>

<script>
import RegisterForm from '@/components/login/RegisterForm.vue'
import axios from 'axios'

export default {
   name: "RegisterPage",
   components: {
       RegisterForm
   },
   methods:{
       onSubmit(payload){
           const { userId, password, passwordCheck, email ,auth } = payload
         
           axios.post('http://localhost:7777/jpaMember/register',{userId, password, passwordCheck, email, auth})
                .then(res => {
                    alert('회원가입 성공' + res)
                    this.$router.push({
                        name: 'Home'
                    }) 
                }).catch(res => {
                    alert(res.response.data.message)
                })
                
                
        }
    }
}
</script>