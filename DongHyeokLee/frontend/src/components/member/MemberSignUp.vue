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
                <v-row>
                    <v-text-field  class="pl-3 pr-3" :rules="userIdRules" v-model="userId"
                        label="아이디" type="text" prepend-icon="mdi-account" flat solo>
                    </v-text-field>
                    <v-text-field  class="pl-3 pr-3"  :rules="passwordRules" required  v-model="password"
                        label="비밀번호" type="password" prepend-icon="mdi-lock" flat solo>
                    </v-text-field>
                    <v-text-field  class="pl-3 pr-3"  :rules="passwordCheck" required  v-model="passwordChecking"
                        label="비밀번호확인" type="password" prepend-icon="mdi-lock" flat solo>
                    </v-text-field>
                    <v-text-field class="pl-3 pr-3" :rules="emailRules" required v-model="email"
                        label="이메일" type="text" prepend-icon="mdi-email-multiple" flat solo>
                    </v-text-field>
                    <v-text-field class="pl-3 pr-3" :rules="nicknameRules"  required v-model="nickname"
                        label="닉네임" type="text" prepend-icon="mdi-account" flat solo>
                    </v-text-field>
                </v-row>
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
import { mapState } from 'vuex'

export default {  
    name: 'MemberSignUp',
    props: {
        members: {
            type: Array
        }
    },
    data () {
        return {
            signUpDialog: false,
            userId: '',
            password: '',
            nickname: '',
            email: '', 
            passwordChecking: '',
            passwordCheck: [
            v => this.password ===v || '비밀번호가 일치하지않습니다'
            ]
        }
    },
    computed:{
        ...mapState(['userIdRules','passwordRules','nicknameRules','emailRules'])

    },
    methods: {
        
        signUp () {
        const { userId, password, email, nickname } = this
        if((userId.length >= 5 && userId.length <=15) && ( password.length >= 8 && password.length <= 15) &&
            (nickname.length >= 3 && nickname.length <= 10) && email.length>= 10){
                let coin = null;
        for(var i = 0; i < this.members.length; i++){
            if(this.members[i].userId === userId){
                alert('중복 된 아이디 입니다')
                coin = 1;
            }else if(this.members[i].nickname === nickname){
                alert('중복 된 닉네임 입니다')
                coin = 1;
            }else if(this.members[i].email === email){
                alert('중복 된 이메일 입니다.')
                coin = 1;
            }
                
            
        }
            if(coin === null){ 
                axios.post('http://localhost:7777/member/register', { userId, password, email, nickname })
                .then(res => {
                alert('등록 성공! - ' + res)
                this.$router.go()
                })
                .catch(res => {
                alert(res.response.data.message)
                    })
                }
            }else{
            alert('다시 입력 해주세요')
            }
        }

    }
}
</script>