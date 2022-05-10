<template>
<div class="background">
  <div class="sidebar">

    <!-- 로고 -->
    <div class="title">
      <div class="logoimg"><img src="@/assets/img/logo.png"></div>
    </div>

    <!-- 대시보드 -->
    <div class="buttonA">
    <router-link :to="{name: 'DashBoardPage'}">
        <button><i class="fas fa-home"></i></button>
    </router-link>
    </div>

    <!-- 프로필 -->
    <div class="buttonB">
    <router-link :to="{name: 'ProFilePage'}">
        <button><i class="fa-regular fa-user"></i></button>
    </router-link>
    </div>

    <!-- 캘린더 
    <div class="buttonC">
    <router-link :to="{name: ''}">
        <button><i class="fa-regular fa-calendar"></i></button>
    </router-link>
    </div>-->

    <!-- 질문 게시판 -->
    <div class="buttonD">
    <router-link :to="{name: 'QBoardListPage'}">
        <button><i class="fas fa-question"></i></button>
    </router-link>
    </div>

    <!-- 자료게시판 -->
    <div class="buttonE">
    <router-link :to="{name: 'DataBoardListPage'}">
        <button><i class="fa-solid fa-download"></i></button>
    </router-link>
    </div>

    <!-- 로그아웃 -->
    <div class="buttonF">
    <router-link :to="{name: 'MainPage'}">
        <button v-on:click="logout"><i class="fa-solid fa-arrow-right-from-bracket"></i></button>
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
.background {
  position: relative;
  width: 150px;
  height: 100vh;
}
img {
  width: 100px;
  margin-left: 27px;
  margin-top: 40px;
}
.buttonA, .buttonB, .buttonC, .buttonD, .buttonE, .buttonF {
transition: box-shadow 0.3s ease, color 0.3s ease;
display: inline-block;
width: 5px;
border-radius: 50em;
line-height: 48px;
cursor: pointer;
margin: 0 3em;
padding: 0 1.75em;
}
i {
font-size: 20px;
margin: -10px;
color: #6768ab;
}
.buttonA, .buttonB, .buttonC, .buttonD, .buttonE {
  margin-top: 60px;
}
.buttonF {
  margin-top: 250px;
}
</style>