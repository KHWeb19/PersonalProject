<template>
  <v-card class="spacing-playground pa-16">
    <v-row justify="center">
      <v-card-title style="font-size: 30px; margin-bottom: 15px">로그인<br/></v-card-title>
    </v-row>
    <v-row justify="center">
      <form @submit.prevent="onSubmit">
        <table>
          <tr>
            <td style="font-size: 20px">&nbsp;ID &nbsp;</td>
            <td><input type="text" style="border: 1px solid black;" v-model="id"></td>
            <td rowspan="2"><v-btn height="60px" type="submit">로그인</v-btn></td>
          </tr>
          <tr>
            <td style="font-size: 20px">PW &nbsp;</td>
            <td><input type="password" style="border: 1px solid black;" v-model="pw"></td>
          </tr>

          <tr align="center">
            <td colspan="3">
              <br/>
              <router-link :to="{name: 'RegisterPage'}">회원가입 </router-link>
              &nbsp;
              <router-link :to="{name: 'IdPwSearchPage'}">아이디/비밀번호 찾기</router-link>
            </td>
          </tr>
        </table>
      </form>
    </v-row>
  </v-card>
</template>

<script>
export default {
  name: "LoginPageForm",
  data() {
    return{
      id: '',
      pw: '',
    }
  },
  methods: {
    onSubmit() {
      const {id, pw} = this;
      this.$emit('submit', {id, pw});
    }
  }
}
</script>

<style scoped>

</style>