<template>
    <div class="singup">
        <form @submit.prevent="onSubmit">
        <br>
        <h4>회원가입</h4>
        <br><br>
        <v-radio-group style="width: 60%;" class="radio" v-model="radioGroup" row >
            <v-radio :label="`${kindsOfMember[0]}`" :value="`${kindsOfMember[0]}`"></v-radio>
            <v-radio :label="`${kindsOfMember[1]}`" :value="`${kindsOfMember[1]}`"></v-radio>
        </v-radio-group>
        
        <v-container>
            <v-row style="width: 60%; height: 20%;">
            <v-text-field flat v-model="id" type="text"  dense required placeholder="아이디 입력" :rules="rules_id" ></v-text-field>
            <v-btn color="black" text type="button" onclick="checkId"><v-icon>mdi-check</v-icon></v-btn>
            </v-row>
            <v-text-field flat v-model="pw" type="password"  dense required placeholder="비밀번호 입력" :rules="rules_pw" style="width: 60%; padding: 15px 0 0 0;"></v-text-field>
            <v-text-field flat v-model="pw1" type="password"  dense required placeholder="비밀번호 확인" :rules="rules_pw1" style="width: 60%;"></v-text-field>
            <v-text-field flat v-model="name" type="text"  dense required placeholder="이름 입력" :rules="rules_name" style="width: 60%;"></v-text-field>
        </v-container>
        <br>
        
        <div>
            <v-btn color="black" text type="submit" width="260" >
                <v-icon>mdi-login</v-icon>회원가입</v-btn>
        </div>
    </form>


    </div>
    
</template>

<script>
    export default {
        name: 'SignUpPageForm',
        data() {
            return {
                radioGroup: 1,
                kindsOfMember: [
                    '회원',
                    '관리자'
                ],
                id:'',
                pw: '',
                name:'',
                pw1:'',                
                rules_id: [
                    v => !!v || '아이디를 입력해주세요'
                ],
                rules_pw: [
                    v => !!v || '비밀번호를 입력해주세요',
                    v => v.length >= 6 || '비밀번호를 6자리 이상 입력해주세요'
                ],
                rules_pw1: [
                    v => !!v || '비밀번호를 입력해주세요',
                    v => v === this.pw || '비밀번호가 일치하지 않습니다'
                ],
                rules_name: [
                    v => !!v || '이름을 입력해주세요'
                ]
            }
        },
        methods: {
            onSubmit () {
                const { id, pw, name } = this
                const auth = (this.radioGroup == '회원' ? '회원' : '관리자')
                this.$emit('submit', {id, pw, name, auth})
            },
            


            // checkId () {
            //     for(member m : members) //멤버 정보를 어차피 가지고 와야하니까. 그거를 들고와서 for문으로 리스트 돌리고. db id값과 작성한 id값이 동일한지 체크
            //     if(m.id = this.id) {
            //         alert('중복된 아이디가 있습니다!')
            //         break;
            //     }
            //}
        }   
    }
</script>

<style scoped>
.signup {
    text-align: right;
}


p {
    font-size: 13px;
    color: gray;
}


input {
    border: double 1px black;
    background-color: rgb(245, 190, 190);
}

h4 {
    display: inline-block;
    height: 30px;
    width: 300px;
    text-align: left;
}
form {
    border: 3px solid rgb(243, 180, 180);
    width: 460px;
    height: 450px;
}
</style>