<template>
<div align="center">
  <v-container>
    <form @submit.prevent="onSubmit">
      
      <br>
      <p>나눔 받는 페이지에 게시글을 작성하고 싶으신가요?</p>

      <br>

      <table>
        <tr>
          <td>아이디</td>
          <td><input type="text" v-model="id" placeholder="*ID를 입력해주세요." :rules="idRule"></td>          
        </tr>
      </table>

      <table>
        <tr>
          <td>상호명</td>
          <td><input type="text" v-model="sn" placeholder="*ID를 입력해주세요."></td>          
        </tr>
      </table>

      <table>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" v-model="pw" placeholder="*8~14자리로 작성하세요."></td>
        </tr>
      </table>

      <table>
        <tr>
          <td>비밀번호 질문</td>
          <td><input type="text" v-model="pwConfirm" placeholder="*가장 좋아하는 과일은?"></td>
        </tr>
      </table>

      <br>
      
      <div>
        <button type="submit">가입하기</button>
      </div>

      <div>
        <p>이미 계정이 있습니까? &nbsp;
            <router-link :to="{ name: 'memberLoginPage' }">
              로그인 하기
            </router-link>
        </p>

      </div>

    </form>
  </v-container>
</div>
</template>

<script>

export default {
  name: "VuetifyMemberRegisterForm.vue",
  data () {
    return {
      id: '',
      sn: '',
      pw: '',
      pwConfirm: ''
    }
  },
  methods: {
    onSubmit () {
      const { id, sn, pw, pwConfirm } = this
      this.$emit('submit', { id, sn, pw, pwConfirm })
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
    input {
      margin: 15px;
      outline: none;

      font-size: 100%;
    }
    button {
      margin: 15px;
      height: 50px;
      width: 350px;
      background-color: lightblue;

      font-size: 120%;
      color: white;
    }
    a {
      -webkit-text-stroke: 1px;
      text-decoration: none; } 
</style>