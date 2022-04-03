<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="signUp" align="center">
            <sign-up-page-form @submit="onSubmit"/>
        </div>
        

    </div>
</template>

<script>
import SignUpPageForm from '@/components/mainPage/SignUpPageForm.vue'
import MainPageForm from '@/components/mainPage/MainPageForm.vue'
import axios from 'axios'

    export default {
        name: 'SignUpPage',
        components: {
            SignUpPageForm,
            MainPageForm
        },
        methods: {
            onSubmit (payload) {
                const { id, pw, name, auth } = payload
                axios.post('http://localhost:7777/Member/register',{ id, pw, name, auth })
                    .then(() => {
                        alert('환영합니다!')
                        
                        this.$router.push({
                            name: 'LoginPage'
                        })
                    })
                    .catch(() => {
                        alert('다시 한번 확인해주세요!')
                    })
            }
        }

    }
</script>

<style scoped>

.Main {
    background: rgb(255, 186, 186);
}
.MainLogo {
    display: block; margin: 0px auto;
}

.signUp {
    margin:2% 10% 3% 10%;
    padding: 15px;
    border: 3px ;
}
a {
    text-decoration: none;
    font: 300;
}

p {
    color: rgb(0, 0, 0);
    font-weight: 600;
}
hr{ 
    background: #e69191;
    height: 3px;
}
</style>