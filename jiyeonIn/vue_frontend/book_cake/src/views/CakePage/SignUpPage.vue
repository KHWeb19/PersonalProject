<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="signUp" align="center">
            <sign-up-page-form @submit="onSubmit" :members="members"/>
        </div>
        
        <footer-form></footer-form>
    </div>
</template>

<script>
import SignUpPageForm from '@/components/mainPage/SignUpPageForm.vue'
import MainPageForm from '@/components/layout/MainPageForm.vue'
import axios from 'axios'
import FooterForm from '@/components/layout/FooterForm.vue'
import { mapState, mapActions } from 'vuex'

    export default {
        name: 'SignUpPage',
        components: {
            SignUpPageForm,
            MainPageForm,
            FooterForm
        },
        computed: {
            ...mapState(['members'])
        },
        mounted () {
            this.fetchMemberList()
        },
        methods: {
            ...mapActions(['fetchMemberList']),
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
    background: #ffbaba;
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