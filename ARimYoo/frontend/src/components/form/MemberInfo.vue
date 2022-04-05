<template>
     <v-container class="align-content-center">
         <v-layout justify-center>
             <form name="MemberInfo" @submit.prevent="onSubmit">
                <table>
                    <tr>
                        <td><img src="@/assets/form/formId.png" width="110" style="margin-left:60px"> </td>
                        <td>
                            <v-text-field filled single-line width="50" :value="userInfo.id"  disabled/>
                        </td>
                    </tr>
                    <tr>
                        <td><img src="@/assets/form/formPw.png" width="140" style="margin-left:40px"> </td>
                        <td>
                            <v-text-field  color="red darken-3"  @change="check_pw()" placeholder="6~20 사이의 영문+숫자"
                            name="pw" type="password" v-model="pw" single-line  />
                            <div class="error_next_box" id="pwMsg2" aria-live="assertive"></div>
                        </td>
                    </tr>
                    <tr>
                        <td><img src="@/assets/form/formPw2.png" width="140" style="margin-left:40px"> </td>
                        <td>
                            <v-text-field color="red darken-3" @change="check_pw()" name="pwConfirm" type="password" single-line  />
                            <div class="error_next_box" id="pwMsg3" aria-live="assertive"></div> <p/>
                        </td>
                    </tr>
                    <tr>
                    <td><img src="@/assets/form/formName.png" width="110" style="margin-left:50px"> </td>
                        <td>
                        <v-text-field color="red darken-3" name="name" outlined v-model="name" />
                        </td>
                    </tr>
                    <tr>
                        <td><img src="@/assets/form/formBirth.png" width="100" style="margin-left:50px"> </td>
                        <td>
                            <v-text-field color="red darken-3" outlined type="date" single-line v-model="birth" />
                        </td>
                    </tr>
                    <tr>
                        <td><img src="@/assets/form/formIntro.png" width="96" style="margin-left:48px"> </td>
                        <td>
                            <v-textarea color="red darken-3" outlined cols="40" rows="5" v-model="intro" >
                            </v-textarea>
                        </td>
                    </tr>
                </table>
                <br/>
                <v-flex class="infoBtn">
                    <v-btn @click="isCorrect()" width="150" height="50" type="button" color="red darken-3" dark>Modify</v-btn>
                </v-flex>
                <br/>
             </form>
         </v-layout>
     </v-container>
</template>
<script>
export default {
    name: 'MemberInfo',
    props: {
        userInfo: {
            type: Object,
            required: true
        },
    },
    methods: {
        isCorrect () {
            var MemberInfo = document.MemberInfo
            var pw = MemberInfo.pw.value
            var pw2 =MemberInfo.pwConfirm.value

            var name = MemberInfo.name.value

            if (pw != pw2) {
                alert ("비밀번호가 일치하지 않습니다.")
                pw2.value=''
                pw2.focus()
            } else if ( pw == null) {
                alert ("비밀번호를 확인해주세요.")
            }
            else if (name == null ) {
                alert ("이름을 입력해주세요.")

            }else { 
                const { pw, name, birth, intro} = this
                this.$emit('submit', { pw, name, birth, intro })

            }
        },
        check_pw (){
            var pwCk = /^(?=.*[a-zA-Z])(?=.*[0-9]).{6,20}$/

            var MemberInfo = document.MemberInfo;
            var pw = MemberInfo.pw.value;
            var pw2 =MemberInfo.pwConfirm.value;

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
        }
    },
    created () {
        this.pw = this.userInfo.pw
        this.name = this.userInfo.name
        this.birth = this.userInfo.birth
        this.intro = this.userInfo.intro
    }
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');

td{
    padding-right: 35px;
}
.v-text-field {
    width:300px;
    font-family: 'Noto Sans KR', sans-serif;
}
.infoBtn {
    margin-left:35%;
}
.error_next_box {
    font-size: 10pt;
    font-family: 'Noto Sans KR', sans-serif;
}
</style>