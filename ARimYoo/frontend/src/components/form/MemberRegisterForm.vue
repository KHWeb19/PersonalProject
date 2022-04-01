<template>
    <v-container>
        <form name ="loginForm" @submit.prevent="onSubmit">
            <v-row class="formD">
                <v-col class="label" cols="6" >
                    <v-img src="@/assets/form/formId.png" width="100"/> 
                </v-col>
                <v-col wrap cols="12" sm="4">
                <v-text-field name="id" @change="check_id()" solo dense placeholder="6~12 사이의 영문or숫자" v-model="id"/>
                <div class="error_next_box" id="pwMsg1" aria-live="assertive"></div>
                </v-col>
            </v-row>
            <v-row class="formD">
                <v-col class="label" cols="6">
                    <v-img src="@/assets/form/formPw.png" width="130"/>
                </v-col>
                <v-col  cols="12" sm="4">
                <v-text-field type="password" name="pw"  @change="check_pw()" solo dense placeholder="6~20 사이의 영문+숫자" v-model="pw"/>
                <div class="error_next_box" id="pwMsg2" aria-live="assertive"></div>
                </v-col>
            </v-row>
            <v-row class="formD">
                <v-col class="label" cols="6">
                    <img src="@/assets/form/formPw2.png" width="130"/>
                </v-col>
                <v-col cols="12" sm="4">
                <v-text-field type="password" name="pwConfirm" @change="check_pw()" solo dense />
                <div class="error_next_box" id="pwMsg3" aria-live="assertive"></div> <p/>
                </v-col>
            </v-row>
            <v-row class="formD">
                <v-col class="label" cols="6">
                    <img src="@/assets/form/formName.png" width="100"/>
                </v-col>
                <v-col cols="12" sm="4">
                <v-text-field name="name" solo dense v-model="name"/>
                </v-col>
            </v-row>
             <v-row class="formD">
                <v-col class="label" cols="6">
                    <img src="@/assets/form/formBirth.png" width="90"/>
                </v-col>
                <v-col cols="12" sm="4">
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
export default {
    name: 'MemberRegisterForm',
    data () {
        return {
            id: '',
            pw: '',
            name: '',
            birth: ''
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
        isCorrect() {
        
            var loginForm = document.loginForm
            var pw = loginForm.pw.value
            var pw2 =loginForm.pwConfirm.value

            var id = loginForm.id.value
            var name = loginForm.name.value
            var birth = loginForm.birth.value

            if (pw != pw2) {
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
.label {
    position: relative;
    left:20%;
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
    font-size: 13px;
}
</style>>

