<template>
    <div>
        <v-img class="mx-auto" src ="@/assets/main/banner.png" width="370"/>
        <v-layout class="mx-auto">
            <member-register-form @submit="onSubmit"/>
        </v-layout>
    </div>
</template>

<script>

import MemberRegisterForm from '@/components/form/MemberRegisterForm.vue'
import axios from 'axios'

export default {
    components: { MemberRegisterForm },
    name: 'JoinPage2',
    methods: {
        onSubmit (payload) {
            const { id, pw, name, birth } = payload
            axios.post('http://localhost:7777/Member/register', { id, pw, name, birth })
            .then(res => {
                alert ('환영합니다 !' + res)
                location.href="/main"
            })
            .catch(res => {
                alert(res.response.data.message)
            })
        }
    }
    
}
</script>

<style scoped>
.mx-auto {
     position: relative;
     margin-top:30px;
     width:50%;
}

</style>