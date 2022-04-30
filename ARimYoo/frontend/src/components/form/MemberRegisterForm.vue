<template>
    <v-container>
        <form name ="loginForm" @submit.prevent="onSubmit">
            <v-row class="formD" justify="end">
                <v-col class="label" cols="3" aria-rowspan="2">
                    <v-img src="@/assets/form/formId.png" width="100"/> 
                </v-col>
                <v-col cols="5">
                    <v-text-field name="id" @change="check_id()" solo dense placeholder="6~12 사이의 영문or숫자" v-model="id"/>
                    <v-row>
                        <p class="error_next_box" id="pwMsg1" aria-live="assertive"></p>
                    </v-row>
                </v-col>
                <v-col cols="2">
                    <v-btn class="mt-1" rounded small  :color="this.checkCondition == true ? 'red darken-3' : 'black'"  dark @click="checkId">
                    check
                </v-btn>
                </v-col>
            </v-row>
            <v-row class="formD" justify="center">
                <v-col class="label" cols="3">
                    <v-img src="@/assets/form/formPw.png" width="130"/>
                </v-col>
                <v-col  cols="5">
                    <v-text-field type="password" name="pw"  @change="check_pw()" solo dense placeholder="6~20 사이의 영문+숫자" v-model="pw"/>
                    <v-row>
                        <p class="error_next_box" id="pwMsg2" aria-live="assertive"></p>
                    </v-row>
                </v-col>
            </v-row>
            <v-row class="formD" justify="center">
                <v-col class="label" cols="3">
                    <img src="@/assets/form/formPw2.png" width="130"/>
                </v-col>
                <v-col cols="12" sm="5">
                <v-text-field type="password" name="pwConfirm" @change="check_pw()" solo dense />
                <div class="error_next_box" id="pwMsg3" aria-live="assertive"></div> <p/>
                </v-col>
            </v-row>
            <v-row class="formD" justify="center">
                <v-col class="label" cols="3">
                    <img src="@/assets/form/formName.png" width="100"/>
                </v-col>
                <v-col cols="4">
                <v-text-field name="name" solo dense v-model="name"/>
                </v-col>
            </v-row>
             <v-row class="formD" justify="center">
                <v-col class="label" cols="3">
                    <img src="@/assets/form/formBirth.png" width="90"/>
                </v-col>
                <v-col cols="4">
                <v-text-field name="birth" solo type="date" v-model="birth"/>
                </v-col>
            </v-row>
            <v-layout row wrap class="mx-auto" >
                <v-flex class="btnSet">
                    <router-link to="/main"><v-btn id ="m" color="black" dark>CANCLE</v-btn></router-link> 
                    <v-btn @click="isCorrect()" type="button" color="red darken-3" dark>JOIN</v-btn>
                </v-flex>
            </v-layout>
        </form>

    </v-container>

</template>

<script>
import axios from 'axios';
export default {
    name: 'MemberRegisterForm',
    data () {
        return {
            id: '',
            pw: '',
            name: '',
            birth: '',
            idPass: false,
            checkCondition:false
        }
    },
    methods: {
        check_id () {
            var pwId = /^[a-zA-Z0-9]{6,12}$/

            var loginForm = document.loginForm;
            var id = loginForm.id.value;

            if(id != ""){
                if (!pwId.test(id)){
                    document.getElementById("pwMsg1").innerHTML = "아이디는 6~12자리의 영문과 숫자만 사용해야 합니다.";
                    document.getElementById("pwMsg1").style.color = "red";
                    document.getElementById("pwMsg1").style.display= "inline";

                } else {
                    document.getElementById("pwMsg1").style.display="none"
                }

            }
            

        },
        check_pw (){
            var pwCk = /^(?=.*[a-zA-Z])(?=.*[0-9]).{6,20}$/

            var loginForm = document.loginForm;
            var pw = loginForm.pw.value;
            var pw2 =loginForm.pwConfirm.value;

             if (!pwCk.test(pw)){
                    document.getElementById("pwMsg2").innerHTML = "비밀번호는 6~20 자리 영문과 숫자의 조합을 사용해야 합니다.";
                    document.getElementById("pwMsg2").style.color = "red";
                    document.getElementById("pwMsg2").style.display= "inline";

                } else {
                    document.getElementById("pwMsg2").style.display="none"
                }
            
            if (pw != "" && pw2 != ""){

                if(pw != pw2){
                    document.getElementById("pwMsg3").innerHTML = "비밀번호가 일치하지 않습니다.";
                    document.getElementById("pwMsg3").style.color = "red";
                } else {
                    document.getElementById("pwMsg3").innerHTML = "비밀번호가 일치합니다.";
                    document.getElementById("pwMsg3").style.color = "black";
                }
            }
            
        },
        checkId() {
            const { id } = this;
            axios.get(`http://localhost:7777/Member/checkId/${id}`)
            .then((res) => {
                this.temp = res.data;
                if (res.data) {
                alert("사용 가능한 아이디 입니다.");
                this.idPass = true;
                this.checkCondition =true
                } else {
                alert("중복된 아이디 입니다.");
                this.idPass = false;
        }
      });
    },
        isCorrect() {
        
            var loginForm = document.loginForm
            var pw = loginForm.pw.value
            var pw2 =loginForm.pwConfirm.value

            var id = loginForm.id.value
            var name = loginForm.name.value
            var birth = loginForm.birth.value

            if(this.idPass ==false) {
                alert('아이디 중복체크를 해주세요.')
            } else if (pw != pw2) {
                alert ("비밀번호가 일치하지 않습니다.")
                pw2.value=''
                pw2.focus()
            } else if (id == ""  || pw == "" || name == "" || birth == ""){
                alert ("모든 항목을 입력해주세요.")
            } else if (id.length <6 || id.length > 12) {
                alert ("아이디값을 확인해주세요")
                id.focus()
            } else if (pw.length < 6 || pw.length > 20) {
                alert ("비밀번호 값을 확인해주세요")
                pw.focus()
            } else {
                const { id, pw, name, birth } = this
                this.$emit('submit', { id, pw, name, birth })
            }
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');
.label {
    position: relative;
}
.formD {
    margin-top: 5%;

}
input {
    border : 2px solid black;
}
.btnSet{
    padding-top:5%;
    margin-bottom:50px;
    margin-left:13%;
    zoom: 1.2;
}
#m {
    margin-right:56%;
}
.error_next_box{
    font-size: 14px;
    font-family: 'Noto Sans KR', sans-serif;
}
.v-text-field , .v-btn{
     font-family: 'Noto Sans KR', sans-serif;
}
</style>>

