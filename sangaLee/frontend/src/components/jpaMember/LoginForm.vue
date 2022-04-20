<template>
  <section>
    <div class="color"></div>
    <div class="color"></div>
    <div class="color"></div>
    <div class="box">
    <div class="square" style="--i:0;"></div>
    <div class="square" style="--i:1;"></div>
    <div class="square" style="--i:2;"></div>
    <div class="square" style="--i:3;"></div>
    <div class="square" style="--i:4;"></div>
      <div class="container">
        <div class="form">
          
          <form @submit.prevent="onSubmit">

            <!-- 아이디 입력 -->
            <div class="inputBox">
              <input type="text" placeholder="ID">
            </div>

            <!-- 비밀번호 입력 -->
            <div class="inputBox">
              <input type="password" placeholder="Password">
            </div>

            <!-- 로그인 버튼 -->
            <div class="inputBox">
              <input type="submit" value="Login">
            </div>

            <!-- 회원가입, 비밀번호 찾기 -->
            <div class="loginfunction">
            <p class="signup"><router-link :to="{ name: 'SignUpPage' }">회원가입</router-link></p>
            <p class="forget"><router-link :to="{ name:'/forget' }">비밀번호 찾기</router-link></p>
            </div>

          </form>

        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "LoginForm.vue",
  data () {
    return {
      id: '',
      pw: ''
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

<style scoped src="../../assets/css/MainLoginStyle.css"></style>