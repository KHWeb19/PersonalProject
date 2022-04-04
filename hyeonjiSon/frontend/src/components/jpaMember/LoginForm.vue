<template>
<div align="center">
  <v-container>
    <form @submit.prevent="onSubmit">
      
      <br>
      <p> 프로젝트 이름에 오신 것을 환영합니다. <br> 회원 정보를 입력해주세요. </p>

      <br>

      <table>
        <tr>
          <td>아이디</td>
          <td><input id="loginInput" type="text" v-model="id" placeholder="*ID를 입력해주세요."></td>          
        </tr>
      </table>

      <table>
        <tr>
          <td>비밀번호</td>
          <td><input id="loginInput" type="password" v-model="pw" placeholder="*비밀번호를 입력하세요"></td>
        </tr>
      </table>

      <br>
      
      <div>
        <button id="login" type="submit">로그인</button>
      </div>

      <find-pw-pop-up/>

    </form>
  </v-container>
</div>
</template>

<script>
import FindPwPopUp from '@/components/jpaMember/FindPwPopUp.vue'

export default {
  components: {
    FindPwPopUp
  },
  name: "VuetifyMemberRegisterForm.vue",
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
    table {
        width: 350px;
        margin: 6px;
        border-collapse: collapse;
        border-bottom: 2px solid;
    }
    #loginInput {
      margin: 15px;
      outline: none;

      font-size: 100%;
    }
    #login {
      margin: 15px;
      height: 50px;
      width: 350px;
      background-color: lightblue;

      font-size: 120%;
      color: white;
    }
    a {
      -webkit-text-stroke: 1px;
      text-decoration: none;
      } 
</style>