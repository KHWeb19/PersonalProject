<template>
<!-- 회원 가입 -->
    <v-dialog v-model="signUpDialog" persisten max-width="400px">
        <template v-slot:activator="{ on }">
            <v-btn color="cyan lighten-3" style="font-size: 0.7em;" dark v-on="on">
                <v-icon style="font-size: 1.3em;">
                mdi-account-plus
                </v-icon>
                    회원가입
            </v-btn>
        </template>
    <v-card dark>
            <v-card-title class="headline">
        <span>
            회원가입
        </span>
            </v-card-title>
    </v-card>
        <v-card-text class="grey lighten-5" dense dark>
            <v-container>
                <v-form ref="form" lazy-validation>
                  <v-radio-group v-if="this.$store.state.userInfo != null" v-model="radioGroup" row>
                     <v-radio label="사용자"></v-radio>
                  </v-radio-group>
                <v-row>
                    <v-text-field  class="pl-3 pr-3" :rules="userIdRules" v-model="userId"
                        label="아이디" type="text" prepend-icon="mdi-account" flat solo>
                    </v-text-field>
                    <v-text-field  class="pl-3 pr-3"  :rules="passwordRules" required  v-model="password"
                        label="비밀번호" type="password" prepend-icon="mdi-lock" flat solo>
                    </v-text-field>
                    <v-text-field  class="pl-3 pr-3"  :rules="passwordCheckRules" required  v-model="passwordChecking"
                        label="비밀번호확인" type="password" prepend-icon="mdi-lock" flat solo>
                    </v-text-field>
                    <v-text-field class="pl-3 pr-3" :rules="emailRules" required v-model="email"
                        label="이메일" type="text" prepend-icon="mdi-email-multiple" flat solo>
                    </v-text-field>
                    <v-text-field class="pl-3 pr-3" :rules="nicknameRules"  required v-model="nickname"
                        label="닉네임" type="text" prepend-icon="mdi-account" flat solo>
                    </v-text-field>
                </v-row>
                </v-form>
            </v-container>
        </v-card-text>
        <v-card-actions class="grey lighten-5">
                    <v-spacer></v-spacer> 
            <v-btn class="grey--text" text @click="signUpDialog = false">
                    취소
                </v-btn>
                <v-btn text @click="signUp()">
                가입
            </v-btn>    
            </v-card-actions>
    </v-dialog>     
</template>

<script>

import axios from 'axios'


export default {  
    name: 'MemberSignUp',
    data () {
        return {
            signUpDialog: false,
            userId: '',
            password: '',
            nickname: '',
            email: '', 
            auth: '',
            radioGroup: '사용자',
            passwordChecking: '',
            passwordCheckRules: [v => this.password ===v || '비밀번호가 일치하지않습니다' ],
            userIdRules:[
                            v => !!v || 'ID를 작성해주세요',
                            v =>  /^[a-zA-Z0-9]*$/.test(v) || '영문+숫자로만 입력해주세요',
                            v => !(v && v.length > 15) || 'ID는 15자를 넘길수없습니다.'

            ],
            emailRules: [
                            v => !! v || '이메일을 작성해주세요.',
                            v => /.+@.+\..+/.test(v) || '이메일 형식으로 작성해주세요',
            ],
            nicknameRules: [
                            v => !!v || '닉네임을 작성해주세요',
                            v => !/[~!@#$%^&*()_+{}]/.test(v) || '특수문자를 넣을수없습니다.',
                            v => !(v && v.length > 10) || '10자리를 넘길수없습니다.',
                            v => !(v && v.length < 2) || '2자리이상으로해주세요'

            ],
            passwordRules: [
                            v => !! v || '비밀번호를 작성해주세요.',
                            v =>  /^[a-zA-Z0-9]*$/.test(v) || '영문+숫자로만 입력해주세요',
                            v => !(v && v.length < 8) || '8자리이상으로해주세요' ,
                            v => !(v && v.length > 15) || '15자리를 넘길수없습니다.' 
            ]
        }
    },
    methods: {
        signUp () {
        const { userId, password, email, nickname } = this
        const auth = this.radioGroup
        const validate = this.$refs.form.validate();
            if (validate){
                axios.post('http://localhost:7777/member/register', { userId, password, email, nickname, auth })
                    .then(res => {
                        if(res.data.message == "가입 되었습니다"){
                        alert(res.data.message)
                        this.signUpDialog = false
                        this.$router.go()
                        }else{
                        alert(res.data.message)        
                        }
                        })
                    
                        .catch(() => {
                        alert('오류발생')
                            })
             
            }
        }

    }
}
</script>