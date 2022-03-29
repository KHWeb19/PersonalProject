<template>
    <div class="singup">
        <form @submit.prevent="onSubmit">
        <br>
        <h4>회원가입</h4>
        <br><br>
        <v-radio-group class="radio" v-model="radioGroup" row >
            <v-radio :label="`${kindsOfMember[0]}`" :value="`${kindsOfMember[0]}`"></v-radio>
            <v-radio :label="`${kindsOfMember[1]}`" :value="`${kindsOfMember[1]}`"></v-radio>
        </v-radio-group>
        

        <table border="0">
            <tr>
                <td style="font-size: 15px;">아이디</td>
                <td><input type="text" v-model="id"/>
                <v-btn color="black" text type="button" onclick="checkId"><v-icon>mdi-check</v-icon></v-btn></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><p class="noticeId" hidden>중복된 아이디 입니다.</p></td>
            </tr>
            <tr>
                <td style="font-size: 15px;">비밀번호</td>
                <td><input type="password" v-model="pw" /></td>
            </tr>
            <tr>
                <td></td>
                <td><p>비밀번호는 6~20자로 되어야 합니다.</p></td>
            </tr>
            <tr>
                <td style="font-size: 15px;">비밀번호 확인</td>
                <td><input type="password" v-model="pw1" @blur="checkDuplicate"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td style="font-size: 15px;">이름</td>
                <td><input type="text" v-model="name"/></td>
            </tr>
            
            <tr>
                <td></td>
                <td><p></p></td>
            </tr>
        </table>
        <br>
        

        <div>
            <v-btn color="black" text type="submit" width="210" >
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
            }
        },
        methods: {
            onsubmit () {
                const { id, pw, name } = this
                const auth = (this.radioGroup == '회원' ? '회원' : '관리자')
                this.$emit('submit', {id, pw, name, auth})
            },
            checkDuplicate() {
                if(this.pw != this.pw1 ){
                    alert('비밀번호 불일치')
                    return false;
                }
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

.radio {
    display: flex;
    justify-content: center;
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
    width: 420px;
    text-align: left;
}
form {
    border: 3px solid rgb(243, 180, 180);
    width: 500px;
    height: 500px;
}
</style>