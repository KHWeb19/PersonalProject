<template>
    <div>
        <div>
            <div>
                <Header/>
            </div>
        </div>

        <join-page-form @submit="onSubmit"/>
    </div>
</template>

<script>

import Header from '@/components/layout/Header.vue'
import JoinPageForm from '@/components/project/JoinPageForm.vue'
import axios from 'axios'

export default {
    name: "JoinPage",
    components: {
        Header,
        JoinPageForm
    },
    methods: {
       async onSubmit (payload) {
            const { auth, name, gender, birthDay, id, pw, address } = payload

                axios.post('http://localhost:7777/member/register', {  auth, name, gender, birthDay, id, pw, address })
                    .then(res => {
                        alert('회원가입 성공 -' + res)
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>