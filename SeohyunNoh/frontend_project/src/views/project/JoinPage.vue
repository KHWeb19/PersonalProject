<template>
        <div>
         <v-container fill-height stlye="max-width:600px;">
            <form ref="form" @submit.prevent="register">
                <v-layout align-center row wrap>
                    <v-flex xs12>
                            <v-toolbar flat>
                                <v-toolbar-title>회원가입</v-toolbar-title>
                            </v-toolbar>
                            
                            <!-- 권한 선택 --> 
                            <div class="row">
                                <v-radio-group ref="auth" v-model="auth"  row required>
                                    <v-radio :label="`${kindsOfMember[0]}`" :value="`${kindsOfMember[0]}`"></v-radio>
                                    <v-radio :label="`${kindsOfMember[1]}`" :value="`${kindsOfMember[1]}`"></v-radio>
                                    <v-radio :label="`${kindsOfMember[2]}`" :value="`${kindsOfMember[2]}`"></v-radio>
                                </v-radio-group>
                            </div>

                            <div class="pa-3">
                                <!-- 이름 --> 
                                <v-text-field type="text" ref="name" v-model="name" label="이름" :rules="nameRules" required>
                                </v-text-field>
                                <!-- 성별 --> 
                            <div class="row">
                                <v-radio-group ref="gender" v-model="gender" :rules="genderRules" row required>
                                    <v-radio :label="`${genderCheck[0]}`" :value="`${genderCheck[0]}`"></v-radio>
                                    <v-radio :label="`${genderCheck[1]}`" :value="`${genderCheck[1]}`"></v-radio>
                                </v-radio-group>
                                </div>
                                <!-- 생년월일 --> 
                                <v-text-field ref="birth" type="date" v-model="birth" :rules="birthRules" style="width: 100%;" required >
                                </v-text-field>
                                <!-- 아이디 --> 
                                <v-text-field ref="id" type="text" v-model="id" label="아이디" :rules="idRules" required>
                                </v-text-field>
                                <!-- 패스워드 --> 
                                <v-text-field  ref="pw" type="password" v-model="pw" name="pw" label="패스워드" :rules="pwRules" required>
                                </v-text-field>
                                <!-- 주소 --> 
                                <v-text-field  ref="address" type="address" v-model="address" name="address" label="주소" :rules="addrRules" required>
                                </v-text-field>

                                <br>

                                <!-- 회원가입 버튼 클릭 --> 
                                <v-btn color="basil" type="submit" depressed block>
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

import { mapState } from 'vuex'
import axios from 'axios'

export default {
    name: "JoinPage",
    components: {

    },
    data() {
        return {
            auth: 0,
            kindsOfMember : [
                '개인',
                '판매자',
                '관리자'
            ],
            gender: 0,
            genderCheck: [
                '남성',
                '여성'
            ],
            name: '',
            id: '',
            pw: '',
            birth: '',
            address:'',
            formError: false
        }
    },
    computed: {
        form() {
            return {
                auth: this.auth,
                id: this.id,
                pw: this.pw,
                name: this.name,
                gender: this.gender,
                birth: this.birth,
                address: this.address
            }
        },
        ...mapState([
            'idRules',
            'pwRules',
            'nameRules',
            'birthRules',
            'addrRules'
         ])
    },
    methods: {
        register() {
            this.formError = false

            Object.keys(this.form).forEach(f => {
                if(!this.form[f]) this.formError = true

                this.$refs[f].validate(true)
            })

            axios.post('http://localhost:7777/member/register', this.form)
            .then(() => {
                alert('회원가입이 완료되었습니다!')
            }).catch(res => {
                alert(res)
            })
        }
 
    }
}
</script>