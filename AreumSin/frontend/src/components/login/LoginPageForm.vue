<template>
  <v-card class="spacing-playground pa-16">
    <v-row justify="center">
      <v-card-title style="font-size: 40px; margin-bottom: 15px">로그인<br/></v-card-title>
    </v-row>
    <v-row justify="center">
      <form @submit.prevent="onSubmit">
        <table>
          <tr>
            <td style="font-size: 30px">&nbsp;ID &nbsp;</td>
            <td><input type="text" style="border: 1px solid black;" v-model="id"></td>
            <td rowspan="2">&nbsp;<v-btn height="76px" width="80px" style="font-size: 25px" type="submit">로그인</v-btn></td>
          </tr>
          <tr>
            <td style="font-size: 30px">PW &nbsp;</td>
            <td><input type="password" style="border: 1px solid black;" v-model="pw"></td>
          </tr>

          <tr align="center">
            <td colspan="3">
              <br/>
              <router-link :to="{name: 'RegisterPage'}" style="font-size: 20px">회원가입 </router-link>
              &nbsp;
              <router-link :to="{name: 'IdPwSearchPage'}" style="font-size: 20px">아이디/비밀번호 찾기</router-link>
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