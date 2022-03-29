<template>
    <div class="Main">
       <header>
            <router-link style="text-decoration: none;" :to="{name: 'MainHomepage'}">            
                <v-img class="MainLogo"
                max-height="200" max-width="250" 
                src="@/assets/img/check.png"/>
            </router-link>
            
        </header>
        <hr>
         <v-container >
            <v-row no-gutters class="menu">
                <v-col class="col-12 col-sm-3"></v-col>
                <v-col class="col-12 col-sm-2">
                    <router-link :to="{name: 'BookingPage'}">
                        <p>예약하기</p>
                    </router-link>
                </v-col>
                <v-col class="col-12 col-sm-2">
                    <router-link :to="{name: 'BookingListPage'}">
                        <p>주문서 보기</p>
                    </router-link>
                </v-col>
                <v-col class="col-12 col-sm-2">
                    <router-link :to="{name: 'PreviewCakeImg'}">
                        <p>케이크 보기</p>
                    </router-link>
                </v-col>
                <v-col class="col-12 col-sm-2">
                   <router-link :to="{name: 'ReviewPage'}">
                        <p>후기</p>
                    </router-link>
                </v-col>
            </v-row>
        </v-container>
        <div>
            <div class="login" align="center">
                <login-page-form @submit="onSubmit"/>
            </div>
        </div>
        
    </div>
</template>

<script>

import LoginPageForm from '@/components/mainPage/LoginPageForm.vue'
import axios from 'axios'

    export default {
        name: 'LoginPage',
        components: {
            LoginPageForm
        },
        methods: {
            onSubmit (payload) {
                const {id, pw} = payload
                axios.post('http://localhost:7777/bookCake/login',{id, pw})
                    .then(() => {
                        alert('안녕하세요! {{id}}님!')
                    })
                    .catch (() => {
                        alert('아이디 및 비밀번호를 잘못 입력하였습니다.')
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

.login {
    margin:0% 10% 0% 10%;
    padding: 15px;
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