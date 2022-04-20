<template>
  <v-container>
    <form @submit.prevent="onSubmit">
      <h3>회원가입</h3>

      <table>
        <tr>
          <td>아이디</td>
          <td><input type="text" v-model="id"></td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" v-model="pw"></td>
        </tr>
        <tr>
          <td>비밀번호 확인</td>
          <td><input type="password"></td>
        </tr>
        <tr>
          <td>이메일 주소</td>
          <td><input type="text" v-model="email"></td>
        </tr>
      </table>

      <div>
        <button type="submit">가입하기</button>
        <router-link :to="{ name: 'LoginPage' }">
          취소
        </router-link>
      </div>
    </form>
  </v-container>
</template>

<script>

export default {
  name: "SignUpForm.vue",
  data () {
    return {
      id: '',
      pw: '',
      email: ''
    }
  },
  methods: {
    onSubmit () {
      const { id, pw, email } = this
      this.$emit('submit', { id, pw, email })
    }
  }
}

</script>

<style scoped src="../../assets/css/MainLoginStyle.css"></style>