<template>
    <div class="singup">
        <form @submit.prevent="onSubmit">
        <br>
        <h4>아이디, 비밀번호 찾기</h4>
        
        <p>아이디 찾기</p>
        <v-container>
            <v-col class="col-12 col-sm-5">
            <v-text-field flat v-model="name" type="text"  dense required placeholder="이름 입력" :rules="rules_name" style="width: 60%;"></v-text-field>
            <v-btn color="black" text type="button" @click="checkId"><v-icon>mdi-check</v-icon> 찾아보기</v-btn>
            </v-col>
        </v-container>
        <br>
        
        </form>

    </div>
    
</template>

<script>
    export default {
        name: 'FindIdPwForm',
        data() {
            return {
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
            
            checkId () { 
                for(const userId of this.memberId){
                    if(userId == this.id) {
                        alert('중복된 아이디가 있습니다!')
                    }
                }
                
            }
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