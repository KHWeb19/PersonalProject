<template>
    <v-container fluid fill-height stlye="max-width:600px;">
        <form @submit.prevent="onSubmit">
            <v-layout align-content-center>
                <v-flex md12>               
                        <v-toolbar flat>
                            <v-toolbar-title>로그인</v-toolbar-title>
                        </v-toolbar>

                         <div class="row">
                            <v-radio-group v-model="radioGroup" row>
                                <v-radio :label="`${kindsOfMember[0]}`" :value="`${kindsOfMember[0]}`"></v-radio>
                                <v-radio :label="`${kindsOfMember[1]}`" :value="`${kindsOfMember[1]}`"></v-radio>
                                <v-radio :label="`${kindsOfMember[2]}`" :value="`${kindsOfMember[2]}`"></v-radio>
                            </v-radio-group>
                        </div>

                        <div class="pa-3">
                            <v-text-field v-model="id" label="아이디">
                            </v-text-field>
                            <v-text-field v-model="pw" type="password" label="패스워드">
                            </v-text-field>
                            <v-btn color="basil" depressed block type="submit">
                                로그인
                            </v-btn>
                            <br>
                            <v-btn color="basil" depressed block @click="joinPageForm">
                                회원가입
                            </v-btn>
                            <!-- <v-btn color="grey" depressed>
                                <router-link :to="{ name: 'MainPage' }">
                                    취소
                                </router-link>
                            </v-btn> -->
                        </div>
                </v-flex>
            </v-layout>
        </form>
    </v-container>
</template>

<script>
export default {
    name: "LoginForm.vue",
    data() {
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
    methods: {
        onSubmit() {
           const { id, pw, radioGroup } = this
            
            const auth = (radioGroup == '개인' ? '개인' :
            radioGroup == '판매자' ? '판매자' :
            '관리자')

            this.$emit('submit', { id, pw, auth })
        },
        joinPageForm () {
        this.$router.push({ path: 'joinPage' })
        }
    }
}
</script>