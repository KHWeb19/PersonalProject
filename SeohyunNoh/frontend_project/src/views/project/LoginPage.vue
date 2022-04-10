<template>
    <div>
        <div>
            <Header/>
        </div>

         <v-container fluid fill-height stlye="max-width:600px;">
            <form @submit.prevent="login">
                <v-layout align-content-center>
                    <!-- 경고창 --> 
                    <!-- <v-alert :value="isLoginError" type="error">
                        아이디와 비밀번호를 다시 확인해주세요. 
                    </v-alert> -->
                    <v-flex md12>               
                            <v-toolbar flat>
                                <v-toolbar-title>로그인</v-toolbar-title>
                            </v-toolbar>

                            <div class="row">
                                <v-radio-group v-model="radioGroup" name="auth" row>
                                    <v-radio :label="`${kindsOfMember[0]}`" :value="`${kindsOfMember[0]}`"></v-radio>
                                    <v-radio :label="`${kindsOfMember[1]}`" :value="`${kindsOfMember[1]}`"></v-radio>
                                    <v-radio :label="`${kindsOfMember[2]}`" :value="`${kindsOfMember[2]}`"></v-radio>
                                </v-radio-group>
                            </div>

                            <div class="pa-3">
                                <v-text-field v-model="id" name="id" label="아이디">
                                </v-text-field>
                                <v-text-field v-model="pw" name="pw" type="password" label="패스워드">
                                </v-text-field>

                                <v-btn color="basil" depressed block type="submit">
                                    로그인
                                </v-btn>
                                <br>
                                <v-btn color="basil" depressed block router :to="{path: '/joinPage'}">
                                    회원가입
                                </v-btn>
                            </div>
                    </v-flex>
                </v-layout>
            </form>
    </v-container>


    </div>
</template>

<script>

import Header from '@/components/layout/Header.vue'

// import { mapState } from 'vuex'

//import Vue from 'vue'
//import axios from 'axios'
//import cookies from 'vue-cookies'

//Vue.use(cookies)

export default {
    name: "LoginPage.vue",
    components: {
        Header,
    },
    data () {
        return {
           radioGroup: 0,
            kindsOfMember : [
                '개인',
                '판매자',
                '관리자'
            ],
            id: '',
            pw: ''
        }
    },
    // computed: {
    //     ...mapState(["isLogin", "isLoginError"])
    // },
    methods: {
        login(){
            this.$store.dispatch('login', { auth: this.radioGroup, id: this.id, pw: this.pw})
            .then(() => {
                this.$router.push({ path: '/mainPage' })
            })
        }

    }
}
</script>