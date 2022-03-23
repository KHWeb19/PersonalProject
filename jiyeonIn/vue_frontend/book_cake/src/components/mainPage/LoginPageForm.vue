<template>
    <div class="loginForm">
        <form @submit.prevent="onSubmit">
            <h4>로그인</h4>
            <table>
                    <tr>
                        <v-icon>mdi-account</v-icon> 
                        <td><input type="text" v-model="id" /></td>
                    </tr>
                    <tr>
                        <v-icon>mdi-lock</v-icon>
                        <td><input type="password" v-model="pw"></td>
                    </tr>
                
            </table>

            <div>
                <v-btn color="black" text type="submit" width="210">
                    <v-icon>mdi-login</v-icon>login</v-btn>
                <br>
                <span>
                    <router-link :to="{ name : 'HomeView'}">
                        아이디, 비밀번호 찾기
                    </router-link>
                    <router-link :to="{ name : ''}">
                        /회원가입
                    </router-link>
                </span>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name : 'LoginPageForm',
    data() {
        return {
            id: '',
            pw: ''
        }
    },
    methods: {
        onSubmit () {
            const {id,pw} = this
            this.$emit('submit',{id,pw})
        }
    }
}
    
</script>

<style scoped>

.loginForm {
    padding: 8%;
    margin: 2%;
}


input {
    border: double 1px black;
    border-radius:5px;
    outline: none;
    background-color: rgb(245, 190, 190);
}

span {
    text-decoration: none;
    display: inline-block;
    height: 20px;
    width: 200px;
    font-size: 10pt;
    text-align: right;
    color: rgb(5, 3, 3);
}

a {
    text-decoration: none;
}

h4 {
    display: inline-block;
    height: 30px;
    width: 200px;
    text-align: left;
}

form {
    border: 3px solid rgb(243, 180, 180);
    width: 306px;
    height: 170px;
}

</style>