<style scope>
 .wrapperl { 
  background-color: #FFF;
  border-radius: 2px;
  box-sizing: border-box;
  height: 200px;
  left: 50%;
  margin: -150px 0 0 -150px;
  position: absolute;
  top: 35%;
  width: 250px;
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
  width: 190px;
}
#wrapper{
  text-align: center;
  font-size: 120%;
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
    <form @submit.prevent="onSubmit">
     <div class="wrapperl" align="center">
       <table> 
         <br>
          <h3 align = "center">로그인</h3> 
          <br>
            <hr>   
        <tr>
          <td><v-icon color="black" right>mdi-card-account-details</v-icon><a href="#"><input class="input" type="text" v-model="id" placeholder="아이디"></a></td>
        </tr> 
        <tr>
          <td><v-icon color="black" right>mdi-lock</v-icon><a href="#"><input class="input" type="password" v-model="pw" placeholder="비밀번호"></a></td>
        </tr>    
        <hr>    
        <div id="wrapper">
        <button type="submit" style="width:115px; border: 0; background-color: #3c3d3e" :style="{fontSize:'x-large'}"> 
        <v-icon color="white" left>mdi-login</v-icon>로그인</button>
        <button type="button" style="width:115px; border: 0; background-color: #808080" onclick="location.href='http://localhost:8080/stock/'" :style="{fontSize:'x-large'}">
        <v-icon color="white" left>mdi-close-circle-outline</v-icon>취소</button>
        </div>                                                                      
      </table>     
      </div>
    </form>
  </v-container>
</div>
</template>

<script>

export default {
  name: "LoginForm.vue",
  data () {
    return {
      id: '',
      pw: '',
    }
  },
  methods: {
    onSubmit () {
      const { id, pw } = this
      this.$emit('submit', { id, pw })
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