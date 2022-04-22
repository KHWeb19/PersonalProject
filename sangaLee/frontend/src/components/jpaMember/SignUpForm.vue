<template>
      <div class="background">

          <form @submit.prevent="onSubmit">

            <h1>(σ≥∀⊙)σ♡</h1>
            <br>
            <!-- 아이디 입력 -->
            <div class="inputBox">
              <input type="text" v-model="id" placeholder="아이디">
            </div>
            <br>
            <!-- 비밀번호 입력 -->
            <div class="inputBox">
              <input type="password" v-model="pw" placeholder="비밀번호">
            </div>
            <br>
            <!-- 비밀번호 확인 -->
            <div class="inputBox">
              <input type="pwcheck" placeholder="비밀번호 확인">
            </div>
            <br>
            <!-- 이메일 -->
            <div class="inputBox">
              <input type="email" v-model="email" placeholder="이메일">
            </div>

            <!-- 가입하기 버튼 -->
            <div class="buttonA">
            <button type="submit" value="가입하기">가입하기</button>
            </div>


            <!-- 뒤로가기 버튼 -->
            <router-link :to="{name: 'MainPage'}">
              <button class="backbtn"><i class="fas fa-arrow-left"></i></button>
            </router-link>

          </form>
      </div>
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

<style scoped>
.background {
  background-color: #EBECF0;
  height: 100vh;
  text-align: center;
  position: relative;
  padding: 200px;
}
h1 {
  color: #6768ab;
}
form {
  width: 100%;
  justify-content: center;
}
input {
  box-shadow: 0px -4px 10px rgba(255, 255, 255, 0.2), 0px 4px 6px #e8e8f3, inset 0px -4px 12px rgba(255, 255, 255, 0.6), inset 0px -2px 2px rgba(255, 255, 255, 0.2), inset 0px 4px 6px #c6c6e2;
  border: none;
  padding: 1em 2.7em;
  border-radius: 50em;
  background: transparent;
  color: #6768ab;
  text-shadow: 1px 1px rgba(255, 255, 255, 0.6);
}
input::placeholder {
  color: #b6b6d9;
  text-shadow: 1px 1px rgba(255, 255, 255, 0.6);
}
input:focus {
  outline: none;
  color: #a5a5d0;
}
.buttonA {
transition: box-shadow 0.3s ease, color 0.3s ease;
display: inline-block;
height: 48px;
border-radius: 50em;
line-height: 48px;
color: #6768ab;
letter-spacing: 0.1em;
font-weight: bold;
cursor: pointer;
text-transform: uppercase;
text-shadow: 1px 1px rgba(255, 255, 255, 0.6);
margin: 0 2.7em;
margin-top: 25px;
margin-left: 30px;
padding: 0 3.5em;
box-shadow: -4px -4px 6px rgba(255, 255, 255, 0.7), 4px 4px 6px #c0c0de, inset -4px -4px 12px rgba(255, 255, 255, 0.1), inset 4px 4px 12px #e8e8f3;
}
.backbtn {
transition: box-shadow 0.3s ease, color 0.3s ease;
display: inline-block;
height: 48px;
border-radius: 50em;
text-align: center;
line-height: 48px;
color: #6768ab;
letter-spacing: 0.1em;
font-weight: bold;
cursor: pointer;
text-transform: uppercase;
text-shadow: 1px 1px rgba(255, 255, 255, 0.6);
margin: 0 2em;
margin-left: -10px;
padding: 0 1.5em;
box-shadow: -4px -4px 6px rgba(255, 255, 255, 0.7), 4px 4px 6px #c0c0de, inset -4px -4px 12px rgba(255, 255, 255, 0.1), inset 4px 4px 12px #e8e8f3;
}
[class*=button]:hover {
color: #6768ab;
}
.buttonA:hover {
box-shadow: -4px -4px 10px rgba(255, 255, 255, 0.2), 4px 4px 6px #e8e8f3, inset -4px -4px 12px rgba(255, 255, 255, 0.6), inset -2px -2px 2px rgba(255, 255, 255, 0.2), inset 4px 4px 6px #c6c6e2;
}
.backbtn:hover {
box-shadow: -4px -4px 10px rgba(255, 255, 255, 0.2), 4px 4px 6px #e8e8f3, inset -4px -4px 12px rgba(255, 255, 255, 0.6), inset -2px -2px 2px rgba(255, 255, 255, 0.2), inset 4px 4px 6px #c6c6e2;
}
</style>