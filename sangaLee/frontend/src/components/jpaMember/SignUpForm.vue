<template>
  <section>
      <div class="container">
        <div class="form">

          <form @submit.prevent="onSubmit">

            <h2>회원가입</h2>
            <!-- 아이디 입력 -->
            <div class="inputBox">
              <input type="text" v-model="id" placeholder="아이디를 입력해주세요.">
            </div>

            <!-- 비밀번호 입력 -->
            <div class="inputBox">
              <input type="pw" v-model="pw" placeholder="비밀번호를 입력해주세요.">
            </div>
            
            <!-- 비밀번호 확인 -->
            <div class="inputBox">
              <input type="pwcheck" placeholder="비밀번호를 한번 더 입력해주세요.">
            </div>

            <!-- 이메일 -->
            <div class="inputBox">
              <input type="email" v-model="email" placeholder="이메일 주소를 입력해주세요.">
            </div>

            <!-- 가입하기 버튼 -->
            <div class="inputBox">
            <input type="submit" value="가입하기">
            </div>

            <!--
            취소 버튼 : 로그인 페이지로 이동
            <div class="inputBox">
            <router-link :to="{ name: 'LoginPage' }">취소</router-link>
            </div>
            -->

          </form>

        </div>
      </div>
  </section>
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

<style scoped src="../../assets/css/SignupStyle.css"></style>