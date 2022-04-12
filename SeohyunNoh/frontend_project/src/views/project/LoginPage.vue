<template>
    <div>
        <div>
            <Header/>
        </div>

         <v-container fluid fill-height stlye="max-width:600px;">
            <form ref="form" @submit.prevent="login">
                <v-layout align-content-center>
                    <v-flex md12>               
                            <v-toolbar flat>
                                <v-toolbar-title>로그인</v-toolbar-title>
                            </v-toolbar>

                            <div class="row">
                                <v-radio-group ref="auth" v-model="auth" row>
                                    <v-radio :label="`${kindsOfMember[0]}`" :value="`${kindsOfMember[0]}`"></v-radio>
                                    <v-radio :label="`${kindsOfMember[1]}`" :value="`${kindsOfMember[1]}`"></v-radio>
                                    <v-radio :label="`${kindsOfMember[2]}`" :value="`${kindsOfMember[2]}`"></v-radio>
                                </v-radio-group>
                            </div>

                            <div class="pa-3">
                                <v-text-field ref="id" v-model="id" :rules="idRules" label="아이디">
                                </v-text-field>
                                <v-text-field ref="pw" v-model="pw" type="password" :rules="pwRules" label="패스워드">
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

import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: "LoginPage.vue",
    components: {

    },
    data () {
        return {
           auth: 0,
            kindsOfMember : [
                '개인',
                '판매자',
                '관리자'
            ],
            id: '',
            pw: '',
            formError: false
        }
    },
    mounted() {
        this.fetchSession(this.$cookies.get('session'))

        if (this.session != null) {
            this.$store.state.isLogin = true
            this.$store.state.userInfo = this.fetchUserInfo(this.$cookies.get('session')) 
        }
    },
    computed: {
        form() {
            return {
                auth: this.auth,
                id: this.id,
                pw: this.pw
            }
        },
        ...mapState([ 'idRules', 'pwRules', 'session' ])
    },
    methods: {
        ...mapActions([ 'fetchUserInfo', 'fetchSession' ]),
        login(){
            this.formError = false

             Object.keys(this.form).forEach(f => {
                if (!this.form[f]) this.formError = true
                this.$refs[f].validate(true)
            })

            const auth = this.auth
            const id = this.id
            const pw = this.pw

             axios.post('http://localhost:7777/member/login', { auth, id, pw }).then(res => {
        
                if (res.data) {
                
                this.$store.commit('USER_LOGIN', res.data)
                
                this.fetchUserInfo(id)
                alert('로그인이 완료되었습니다!')
                
                // recommend(together) 로 보냄
                this.$emit('onLogin')
                } else if (res.data == false) {
                alert('아이디와 비밀번호를 확인해주세요!')
                console.log('isLogin: ' + res.data)
                }
                
            }).catch(err => {
                alert(err)
            })

        }

    }
}

</script>