<style>
table {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width : 270px;
  height: 200px;
  background-color: whitesmoke;
  border: 1px solid #CCC;
}
 .wrapper { 
  background-color: #FFF;
  border-radius: 2px;
  box-sizing: border-box;
  height: 300px;
  left: 50%;
  margin: -150px 0 0 -150px;
  position: absolute;
  top: 50%;
  width: 300px;
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
  left: 40%;
  margin: -120px 0 0 -120px;
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
  text-align: center;
  margin:auto;
  color:white;
}
input[class=input]::placeholder {
  color: gray;
  font-size: 0.7em;
}
</style>
<template>
  <v-container aline>
    <form @submit.prevent="onSubmit">
    <!-- <form @submit="formSubmit" method="post">   -->
     <div class="wrapper" align="center">
       <table> 
         <br>
          <h3 align = "center">회원 가입</h3> 
          <br>
            <hr>   
        <tr>
          <td><v-icon color="black" right>mdi-card-account-details</v-icon><a href="#"><input class="input" type="text" v-model="id" placeholder="아이디" onclick="alert('4 ~ 15자로 입력해주세요')" ></a></td>
        </tr>
         <p><span id="decide" style='color:#373a3c;' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;아이디 중복 여부를 확인해주세요.</span>
         <button class="button" type="button" name="submit" style="border: solid 1px gray; color:white;" v-on:click="idCheck" >중복검사</button>
        <tr>
          <td><v-icon color="black" right>mdi-lock</v-icon><a href="#"><input class="input" type="password" v-model="pw" placeholder="비밀번호" onclick="alert('대/소문자, 특수문자, 숫자 포함 8자 이상으로 입력해주세요')"></a></td>
        </tr>    
        <tr>
          <td><v-icon color="black" right>mdi-lock-alert</v-icon><input class="input" type="password" v-model="pwc" placeholder="비밀번호 확인" v-on:click="pwCheck" ></td>
        </tr>   
        <tr>
          <td><v-icon color="black" right>mdi-rename-box</v-icon><input class="input" type="text" v-model="nickname" placeholder="닉네임"></td>
        </tr>  
         <p><span id="decide" style='color:#373a3c;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;닉네임 중복 여부를 확인해주세요.</span>
        <button class="button" type="button" name="submit" style="border: solid 1px gray; color:white;" v-on:click="nicknameCheck()">중복검사</button>
        <tr>
          <td><v-icon color="black" right>mdi-email</v-icon><input class="input" type="text" v-model="email" placeholder="이메일"></td>
        </tr> 
        <tr>
          <td><v-icon color="black" right>mdi-cellphone</v-icon><input class="input" type="text" v-model="phonenumber" placeholder="휴대폰번호" onclick="alert('\'-\'을 빼고 입력해주세요')"></td>
        </tr> 
        <hr>
        <br>
        <div id="wrapper">
        <button type="submit" style="width:230px; border: 0; background-color: #3c3d3e">
        <v-icon color="white" left>mdi-account-plus-outline</v-icon>가입하기</button>
        </div> 
        <br>                                                                      
      </table>

      </div>
    </form>
  </v-container>
</template>

<script>
export default {
    name: "RegisterForm.vue",
    data() {
      return {
        id: "",
        pw: "",
        pwc:"",
        nickname:"",
        email: "",
        phonenumber:""
      }
    },
    methods: {
      idCheck() {
        if(!/userId/.test(this.id))
        alert("사용 가능한 아이디입니다.")
        else
        alert("해당 아이디는 사용하실 수 없습니다.")
      },
      nicknameCheck(){
        if(!/userNickname/.test(this.nickname))
        alert("사용 가능한 닉네임입니다.")
        else
        alert("해당 닉네임은 사용하실 수 없습니다.")
      },
      pwCheck(){
        if(!/pw/.test(this.pwc))
        alert("입력한 2개의 비밀번호가 일치하지 않습니다.")
      },

      onSubmit() {
        const { id, pw, nickname, email, phonenumber } = this
        this.$emit('submit', { id, pw, nickname, email, phonenumber })
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
        return true
      }
    }    
}
</script>

<style scoped>

</style>
