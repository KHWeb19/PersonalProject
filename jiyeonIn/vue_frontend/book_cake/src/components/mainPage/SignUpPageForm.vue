<template>
    <div class="singup">
        <form @submit.prevent="onSubmit">
        <br>
        <h4>회원가입</h4>
        <br><br>
        <table border="0">
            <tr>
                <td style="font-size: 15px;">아이디*</td>
                <td><input type="text" v-model="id"/><v-btn color="black" text type="submit"><v-icon>mdi-check</v-icon></v-btn></td>
            </tr>
            <tr>
                <td></td>
                <td><p>id는 3~20자 사이의 영문+숫자로 작성 되어야 합니다.</p></td>
            </tr>
            <tr>
                <td style="font-size: 15px;">비밀번호*</td>
                <td><input type="password" v-model="password"/></td>
            </tr>
            <tr>
                <td></td>
                <td><p>비밀번호는 6~20자로 되어야 합니다.</p></td>
            </tr>
            <tr>
                <td style="font-size: 15px;">비밀번호 확인*</td>
                <td><input type="password" v-model="password1"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td style="font-size: 15px;">이름*</td>
                <td><input type="text" v-model="name"/></td>
            </tr>
            
            <tr>
                <td></td>
                <td><p>이름은 2~40자 이내여야 합니다.</p></td>
            </tr>
            <tr>
                <td style="font-size: 15px;">닉네임*</td>
                <td><input type="text" v-model="nickname"/><v-btn color="black" text type="submit"><v-icon>mdi-check</v-icon></v-btn></td>
            </tr>
            <tr>
                <td></td>
                <td><p>닉네임은 2~40자 이내여야 합니다.</p></td>
            </tr>
            <tr>
                <td style="font-size: 15px;">이메일 주소*</td>
                <td><input type="text" v-model="email"/></td>
            </tr>
            <tr>
                <td></td>
                <td><p>메일주소는 비밀번호 찾기 등에 사용됩니다.</p></td>
            </tr>
        </table>

        <div>
            <v-btn color="black" text type="submit" width="210">
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
            id: '',
            pw: '',
            name:'',
            nickname:'',
            email:''
        }
    }
    }
</script>

<style scoped>
.signup {
    padding: 10%;
}



p {
    font-size: 13px;
    color: gray;
}

v-text-field {
    width: 5%;
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