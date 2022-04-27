<template>
<div class="background">
  <div class="sidebar">

    <!-- 로고 -->
    <div class="title">
      <div class="logoimg"><img src="@/assets/img/naevis.jpg"></div>
    </div>

    <!-- 대시보드 -->
    <div class="buttonA">
    <router-link :to="{name: 'DashBoardPage'}">
        <button><div class="fontA"><i class="fas fa-home"></i>　Home</div></button>
    </router-link>
    </div>

    <!-- 프로필 -->
    <div class="buttonB">
    <router-link :to="{name: ''}">
        <button><div class="fontA"><i class="fa-regular fa-user"></i>　Profile</div></button>
    </router-link>
    </div>

    <!-- 캘린더 -->
    <div class="buttonC">
    <router-link :to="{name: ''}">
        <button><div class="fontA"><i class="fa-regular fa-calendar"></i>　Calendar</div></button>
    </router-link>
    </div>

    <!-- 질문 게시판 -->
    <div class="buttonD">
    <router-link :to="{name: 'QuestionBoardListPage'}">
        <button><div class="fontA"><i class="fa-solid fa-comments"></i>　QnA</div></button>
    </router-link>
    </div>

    <!-- 자료게시판 -->
    <div class="buttonE">
    <router-link :to="{name: 'DataBoardListPage'}">
        <button><div class="fontA"><i class="fa-solid fa-download"></i>　Data</div></button>
    </router-link>
    </div>

    <!-- 로그아웃 -->
    <div class="buttonF">
    <router-link :to="{name: 'MainPage'}">
        <button v-on:click="logout"><div class="fontA"><i class="fa-solid fa-arrow-right-from-bracket"></i>　Logout</div></button>
    </router-link>
    </div>

    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)
export default {
  name : 'SideBar',
  components : {

  },
  data () {
    return {
      isLogin: false
    }
  },
  methods: {
    logout () {
      this.$cookies.remove("user")
      this.isLogin = false
      this.$store.state.userInfo = null
      alert('로그아웃 성공!')
    }
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');
.background {
  background-color: #EBECF0;
  position: relative;
  width: 300px;
  padding: 30px;
  height: 100vh;
}
.title {
  transition: box-shadow 0.3s ease, color 0.3s ease;
  color: #6768ab;
  margin-top: 30px;
  margin-bottom: 10px;
  padding: 0 25px;
}
img {
  max-width: 200px;
  border-radius: 50%;
  box-shadow: -4px -4px 6px rgba(255, 255, 255, 0.7), 4px 4px 6px #c0c0de, inset -4px -4px 12px rgba(255, 255, 255, 0.1), inset 4px 4px 12px #e8e8f3;
}
.fontA {
  margin-left: 10px;
  color: #6768ab;
}
.buttonA, .buttonB, .buttonC, .buttonD, .buttonE, .buttonF {
transition: box-shadow 0.3s ease, color 0.3s ease;
display: inline-block;
width: 200px;
height: 48px;
border-radius: 50em;
line-height: 48px;
color: #6768ab;
letter-spacing: 0.1em;
font-weight: bold;
cursor: pointer;
text-transform: uppercase;
text-shadow: 1px 1px rgba(255, 255, 255, 0.6);
margin: 0 3em;
margin-left: 20px;
padding: 0 3em;
box-shadow: -4px -4px 6px rgba(255, 255, 255, 0.7), 4px 4px 6px #c0c0de, inset -4px -4px 12px rgba(255, 255, 255, 0.1), inset 4px 4px 12px #e8e8f3;
}
[class*=button]:hover {
color: #6768ab;
}
.buttonA:hover {
box-shadow: -4px -4px 10px rgba(255, 255, 255, 0.2), 4px 4px 6px #e8e8f3, inset -4px -4px 12px rgba(255, 255, 255, 0.6), inset -2px -2px 2px rgba(255, 255, 255, 0.2), inset 4px 4px 6px #c6c6e2;
}
.buttonB:hover {
box-shadow: -4px -4px 10px rgba(255, 255, 255, 0.2), 4px 4px 6px #e8e8f3, inset -4px -4px 12px rgba(255, 255, 255, 0.6), inset -2px -2px 2px rgba(255, 255, 255, 0.2), inset 4px 4px 6px #c6c6e2;
}
.buttonC:hover {
box-shadow: -4px -4px 10px rgba(255, 255, 255, 0.2), 4px 4px 6px #e8e8f3, inset -4px -4px 12px rgba(255, 255, 255, 0.6), inset -2px -2px 2px rgba(255, 255, 255, 0.2), inset 4px 4px 6px #c6c6e2;
}
.buttonD:hover {
box-shadow: -4px -4px 10px rgba(255, 255, 255, 0.2), 4px 4px 6px #e8e8f3, inset -4px -4px 12px rgba(255, 255, 255, 0.6), inset -2px -2px 2px rgba(255, 255, 255, 0.2), inset 4px 4px 6px #c6c6e2;
}
.buttonE:hover {
box-shadow: -4px -4px 10px rgba(255, 255, 255, 0.2), 4px 4px 6px #e8e8f3, inset -4px -4px 12px rgba(255, 255, 255, 0.6), inset -2px -2px 2px rgba(255, 255, 255, 0.2), inset 4px 4px 6px #c6c6e2;
}
.buttonF:hover {
box-shadow: -4px -4px 10px rgba(255, 255, 255, 0.2), 4px 4px 6px #e8e8f3, inset -4px -4px 12px rgba(255, 255, 255, 0.6), inset -2px -2px 2px rgba(255, 255, 255, 0.2), inset 4px 4px 6px #c6c6e2;
}
.buttonA, .buttonB, .buttonC, .buttonD, .buttonE, .buttonF {
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>