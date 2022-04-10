<template>
    <div>
        <div>
            <Header/>
        </div>

         <v-container fill-height stlye="max-width:600px;">
            <form @submit.prevent="register">
                <v-layout align-center row wrap>
                    <v-flex xs12>
                            <v-toolbar flat>
                                <v-toolbar-title>회원가입</v-toolbar-title>
                            </v-toolbar>
                            
                            <!-- 권한 선택 --> 
                            <div class="row">
                                <v-radio-group v-model="radioGroup" name="auth" row required>
                                    <v-radio :label="`${kindsOfMember[0]}`" :value="`${kindsOfMember[0]}`"></v-radio>
                                    <v-radio :label="`${kindsOfMember[1]}`" :value="`${kindsOfMember[1]}`"></v-radio>
                                    <v-radio :label="`${kindsOfMember[2]}`" :value="`${kindsOfMember[2]}`"></v-radio>
                                </v-radio-group>
                            </div>

                            <div class="pa-3">
                                <!-- 이름 --> 
                                <v-text-field type="text" v-model="name" name="name" label="이름" required>
                                </v-text-field>
                                <!-- 성별 --> 
                            <div class="row">
                                <v-radio-group v-model="radioGender" name="gender" row required>
                                    <v-radio :label="`${genderCheck[0]}`" :value="`${genderCheck[0]}`"></v-radio>
                                    <v-radio :label="`${genderCheck[1]}`" :value="`${genderCheck[1]}`"></v-radio>
                                </v-radio-group>
                                </div>
                                <!-- 생년월일 --> 
                                <v-text-field type="date" v-model="birthDay" name="birthDay" style="width: 100%;" required >
                                </v-text-field>
                                <!-- 아이디 --> 
                                <v-text-field type="text" v-model="id" name="id" label="아이디" required>
                                </v-text-field>
                                <!-- 패스워드 --> 
                                <v-text-field type="password" v-model="pw" name="pw" label="패스워드" required>
                                </v-text-field>
                                <!-- 주소 --> 
                                <v-text-field type="address" v-model="address" name="address" label="주소" required>
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

import Header from '@/components/layout/Header.vue'

export default {
    name: "JoinPage",
    components: {
        Header
    },
    data() {
        return {
             radioGroup: 0,
            kindsOfMember : [
                '개인',
                '판매자',
                '관리자'
            ],
            radioGender: 0,
            genderCheck: [
                '남성',
                '여성'
            ],
            name: '',
            id: '',
            pw: '',
            birthDay: '',
            address:''
        }
    },
    methods: {
        register() {
            this.$store.dispatch('register', {
                auth: this.radioGroup,
                gender: this.radioGender,
                name: this.name,
                id: this.id,
                pw: this.pw,
                birthDay: this.birthDay,
                address: this.address
            })
            .then(() => {
                this.$router.push({path: '/loginPage'})
            })
        }
 
    }
}
</script>