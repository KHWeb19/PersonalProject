<template>
     <v-container class="align-content-center">
         <v-row justify="center">
             <form name="MemberInfo" @submit.prevent="onSubmit">
                <table>
                    <tr>
                        <td rowspan='2'>
                            <img v-if="userInfo.profilePic" :src="require(`@/assets/back/member/${this.userInfo.profilePic}`)"  id="imageBefore" style="width:220px">
                            <img v-else class="mt-7" src="@/assets/profile.png" id="imageBefore"  style="width:220px">
                            <img :src="image" class="preview" alt=""/>
                        </td>
                        <td> <img src="@/assets/form/formId.png" class="mr-15 ml-10" width="100" style="float:left" > 
                            <v-text-field filled :value="userInfo.id"  style="width:200px" disabled/>
                        </td>
                    </tr>
                    <tr>
                            <img src="@/assets/form/formPw.png" width="120"  class="mr-10 ml-10" style="float:left">
                            <v-text-field  color="red darken-3"  @change="check_pw()" placeholder="6~20 사이의 영문+숫자"
                            name="pw" type="password" v-model="pw" single-line style="width:200px" />
                            <p class="error_next_box" id="pwMsg2" style="text-align:center"></p>
                    </tr>
                    <tr>
                        <td>
                        <input type="file" id="files" ref="files"  dense style="width:300px; zoom:0.8;" class="ml-7"
                                multiple v-on:change="handleFileUpload()"/>
                        </td>
                        <td><img src="@/assets/form/formPw2.png"  class="mr-10 ml-10" width="120"  style="float:left">
                            <v-text-field color="red darken-3" @change="check_pw()" 
                            name="pwConfirm" type="password" single-line style="width:200px"/>
                            <p class="error_next_box" id="pwMsg3" aria-live="assertive"></p>
                        </td>
                    </tr>
    
                    <tr>
                    <td><img src="@/assets/form/formName.png" width="100" style="margin-left:70px"> </td>
                        <td>
                        <v-text-field color="red darken-3" name="name" outlined  v-model="name" />
                        </td>
                    </tr>
                    <tr>
                        <td><img src="@/assets/form/formBirth.png" width="90" style="margin-left:70px"> </td>
                        <td>
                            <v-text-field color="red darken-3" outlined type="date"  single-line v-model="birth" />
                        </td>
                    </tr>
                    <tr>
                        <td><img src="@/assets/form/formIntro.png" width="86" style="margin-left:63px"> </td>
                        <td>
                            <v-textarea color="red darken-3" outlined cols="35" rows="5" placeholder="현재 등록된 자기소개가 없습니다." v-model="intro" >
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
         </v-row>
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
    data() {
        return {
            image:''
        }
    },
    methods: {
        handleFileUpload () {
            console.log('이미지 첨부')

            var image = this.$refs['files'].files[0]
            const url = URL.createObjectURL(image)
            this.image = url
            document.getElementById("imageBefore").style.display = 'none'

            this.files = this.$refs.files.files[0]
        },
        isCorrect () {
            var MemberInfo = document.MemberInfo
            var pw = MemberInfo.pw.value
            var pw2 =MemberInfo.pwConfirm.value

            var name = MemberInfo.name.value

            if (pw != pw2) {
                alert ("비밀번호가 일치하지 않습니다.")
                pw2.value=''
                pw2.focus()
            } else if (pw == null) {
                alert ("비밀번호를 확인해주세요.")
            }
            else if (name == null ) {
                alert ("이름을 입력해주세요.")

            }else { 
                const { pw, name, birth, intro} = this
                const file =  this.$refs.files.files[0]
                this.$emit('submit', { pw, name, birth, intro, file})

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

table {
    border-collapse : collapse;
    border-spacing: 0px;
    padding:0px;
}
img{
    display: block;
    margin:auto
}
td {
    border-collapse : collapse;
    border-spacing: 0px;
    padding:0px;
}
.v-text-field, input {
    font-family: 'Noto Sans KR', sans-serif;
}
.infoBtn {
    margin-left:40%;
}
#pwMsg2, #pwMsg3 {
    margin-left:12%;
}
.preview {
    position: relative;
    margin-left: auto;
    margin-right:auto;
    max-width: 220px;
    max-height: 600px;
}
.error_next_box {
    font-size: 10pt;
    font-family: 'Noto Sans KR', sans-serif;
}
@media (max-width:700px){
    table {
       zoom:90%;
    }
}
</style>