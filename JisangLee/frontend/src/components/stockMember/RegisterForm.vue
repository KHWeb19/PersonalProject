<style scope>
 .wrapperj { 
  background-color: #FFF;
  border-radius: 2px;
  box-sizing: border-box;
  height: 430px;
  left: 50%;
  margin: -150px 0 0 -150px;
  position: absolute;
  top: 25%;
  width: 270px;
}
.input {
  background-color: transparent;
  border: 0;
  outline: 0;
  border-bottom: 1px solid #CCC;
  color: black;
  box-sizing: border-box;
  font-family: 'Arvo';
  font-size: 18px;
  height: 50px;
  left: 45%;
  margin: -120px 0 0 -100px;
  padding: 10px 0px;
  position: relative;
  top: 50%;
  width: 220px;
}
.button{
  background: #808080;
  font-size: 12px;
}
#decide{
  font-size: 12px;
}
#wrapper{
  font-family:  'Cute Font', cursive;
  text-align: center;
  margin:auto;
  color:white;
}
input[class=input]::placeholder {
  color: gray;
  font-size: 0.7em;
}
</style>
<style scoped>
img { background:#ffe993; display: block;  margin: 0 auto;}
</style>
<template>
<div>
     <div id=vb>
     <v-container v-if="this.$store.state.userInfo == null">
                <v-btn tile color="grey darken-3 white--text" onclick="location.href='http://localhost:8080/stock/register'" width="125" :style="{fontSize:'x-large'}">
                    <v-icon left>mdi-account-plus-outline</v-icon>
                    회원 가입 
                </v-btn> 
                <v-btn tile color="grey darken-2 white--text" onclick="location.href='http://localhost:8080/stock/login'" width="100" :style="{fontSize:'x-large'}"> 
                    <v-icon left>mdi-login</v-icon>
                    로그인 
                </v-btn>
    </v-container>
    </div>
  <v-container aline>
    <form action="insert.no" method="post" @submit.prevent="onSubmit"> 
     <div class="wrapperj" align="center">
       <table> 
         <br>
          <h3 align = "center">회원 가입</h3> 
          <br>
            <hr>   
        <tr>
          <td><v-icon color="black" right>mdi-card-account-details</v-icon><a href="#"><input class="input" type="text" v-model="id" placeholder="아이디" onclick="swal({text: '4 ~ 15자로 입력해주세요',icon:'info'}); this.onclick=null;"  required></a></td>
        </tr>
         <p><span id="decide" style='color:#373a3c;' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;아이디 중복 여부를 확인해주세요.</span>
         <button class="button" type="button" name="submit" style="border: solid 1px gray; color:white;" v-on:click="idCheck" >중복검사</button>
        <tr>
          <td><v-icon color="black" right>mdi-lock</v-icon><a href="#"><input class="input" type="password" v-model="pw" placeholder="비밀번호" onclick="swal({text: '대/소문자, 특수문자, 숫자 포함 8자 이상으로 입력해주세요',icon:'info'}); this.onclick=null;" required></a></td>
        </tr>    
        <tr>
          <td><v-icon color="black" right>mdi-lock-alert</v-icon><input class="input" type="password" v-model="pwc" placeholder="비밀번호 확인" required></td>
        </tr>   
        <tr>
          <td><v-icon color="black" right>mdi-rename-box</v-icon><input class="input" type="text" v-model="nickname" placeholder="닉네임" v-on:click="pwCheck()" required></td>
        </tr>  
         <p><span id="decide" style='color:#373a3c;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;닉네임 중복 여부를 확인해주세요.</span>
        <button class="button" type="button" name="submit" style="border: solid 1px gray; color:white;" v-on:click="nicknameCheck()">중복검사</button>
        <tr>
          <td><v-icon color="black" right>mdi-email</v-icon><input class="input" type="text" v-model="email" placeholder="이메일" required></td>
        </tr> 
        <tr>
          <td><v-icon color="black" right>mdi-cellphone</v-icon><input class="input" type="text" v-model="phonenumber" placeholder="휴대폰번호" onclick="swal({text: '\'-\'을 빼고 입력해주세요',icon:'info'}); this.onclick=null;" required></td>
        </tr> 
        <hr>
        <div id="wrapper">
        <button type="submit" style="width:230px; border: 0; background-color: #3c3d3e;" :style="{fontSize:'x-large'}">
        <v-icon color="white" left >mdi-account-plus-outline</v-icon>가입하기</button>
        </div>                                                                       
      </table>
    </div>
    </form>
  </v-container>
  </div>
</template>

<script>
import swal from 'sweetalert';
import axios from 'axios'
export default {
    name: "RegisterForm.vue",
    data() {
      return {
        id: "",
        pw: "",
        pwc:"",
        nickname:"",
        email: "",
        phonenumber:"",
      }
    },
    methods: {
      idCheck() {
         const { id } =this
                axios.get(`http://localhost:7777/vueJpaMember/check/${id}`)
                    .then(res => {
                        this.temp = res.data;
                        if(res.data == true){
                            swal({
                              text: "사용 가능한 아이디입니다!",
                              icon: "info"
                              }) 
                            this.valid = res.data;
                        }else {
                            swal({
                              text: "중복된 아이디입니다!",
                              icon: "error"
                              })                
                            this.valid = false;
                        }
                    })
      },
      nicknameCheck(){
         const { nickname } = this
                axios.get(`http://localhost:7777/vueJpaMember/checkto/${nickname}`)
                    .then(res => {
                        this.temp = res.data;
                        if(res.data == true){
                            swal({
                              text: "사용 가능한 닉네임입니다!",
                              icon: "info"
                              }) 
                            this.valid = res.data;
                        }else {
                            swal({
                              text: "중복된 닉네임입니다!",
                              icon: "error"
                              })     
                            this.valid = false;
                        }
                    })
      },
      pwCheck(){
        if(this.pw!=this.pwc){
        swal({
          text: "입력한 2개의 비밀번호가 일치하지 않습니다.",
          icon: "error"          
          })
      }else {
        swal({
          text: "입력한 2개의 비밀번호가 일치합니다.",
          icon: "success"
          })  
          this.pwCheck = null;     
      }
      },  
      onSubmit() {
        const { id, pw, nickname, email, phonenumber, auth } = this
        this.$emit('submit', { id, pw, nickname, email, phonenumber, auth })
        if (!/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]{4,15}$/.test(this.id)) {
          alert("아이디는 4 ~ 15자로 입력해주세요.")
        }    
        if ( !/^(?=.*[A-Z])(?=.*[a-z])(?=.*[.!#$%&'*+/=?^_`{|}~-])(?=.*[0-9]).{8,}$/.test(this.pw)) {
          alert("비밀번호는 대/소문자, 특수문자, 숫자 포함 8자 이상으로 입력해주세요.")
        }
        if (!/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(this.email)) {
          alert("이메일 주소를 입력해 주세요.")
        }   
        if (!/^[0-9]{11}$/.test(this.phonenumber)) {
          alert("휴대폰 번호를 입력해 주세요.")
        }              
        return false
      }
    }    
}
</script>

<style scoped>
.Main{
  height: 100vh;
  overflow: hidden;
  margin:0;
  background-color: #ffe993;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;  
}
</style>
