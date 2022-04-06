<template>
        <v-container fill-height stlye="max-width:600px;">
        <form @submit.prevent="onSubmit">
            <v-layout align-center row wrap>
                <v-flex xs12>
                        <v-toolbar flat>
                            <v-toolbar-title>회원가입</v-toolbar-title>
                        </v-toolbar>
                        
                        <!-- 권한 설정 --> 
                        <div class="row">
                            <v-radio-group v-model="radioGroup" row required>
                                <v-radio :label="`${kindsOfMember[0]}`" :value="`${kindsOfMember[0]}`"></v-radio>
                                <v-radio :label="`${kindsOfMember[1]}`" :value="`${kindsOfMember[1]}`"></v-radio>
                                <v-radio :label="`${kindsOfMember[2]}`" :value="`${kindsOfMember[2]}`"></v-radio>
                            </v-radio-group>
                        </div>

                        <div class="pa-3">
                            <!-- 이름 --> 
                            <v-text-field type="text" v-model="name" label="이름" required>
                            </v-text-field>
                            <!-- 성별 --> 
                           <div class="row">
                            <v-radio-group v-model="radioGender" row required>
                                <v-radio :label="`${genderCheck[0]}`" :value="`${genderCheck[0]}`"></v-radio>
                                <v-radio :label="`${genderCheck[1]}`" :value="`${genderCheck[1]}`"></v-radio>
                            </v-radio-group>
                            </div>
                            <!-- 생년월일 --> 
                            <v-text-field type="date" v-model="birthDay" style="width: 100%;" required >
                            </v-text-field>
                            <!-- 아이디 --> 
                            <v-text-field type="text" v-model="id" label="아이디" required>
                            </v-text-field>
                            <!-- 패스워드 --> 
                            <v-text-field type="password" v-model="pw" label="패스워드" required>
                            </v-text-field>
                            <!-- 주소 --> 
                            <address-api v-model="address" @address="addrSelected" required/>

                            <br>

                            <!-- 회원가입 버튼 클릭 --> 
                            <v-btn color="basil" depressed block type="submit">
                                회원가입
                            </v-btn>
                        </div>
                </v-flex>
            </v-layout>
        </form>
    </v-container>
</template>

<script>

import AddressApi from '@/components/project/AddressApi.vue'

export default {
    name: "JoinPageForm.vue",
    components: {
        AddressApi
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
        async onSubmit () {
            const { radioGroup, name, radioGender, birthDay, id, pw, address } = this

            const auth = (radioGroup == '개인' ? '개인' :
            radioGroup == '판매자' ? '판매자' :
            '관리자')

            const gender = (radioGender == '남성' ? '남성' : '여성')

            this.$emit('submit', { auth, name, gender, birthDay, id, pw, address })

            console.log(auth, name, gender, birthDay, id, pw, address)
        },
        search(){
            
        },
        addrSelected(detail) {  // 주소 확인
            console.log("선택된 주소", detail);
            this.address = detail
        },
    }
}
</script>