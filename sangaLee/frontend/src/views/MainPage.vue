<template>
<div class="background">

    <!-- 프로젝트명, 프로젝트 개요 -->
    <h1>개인, 그룹 스터디 관리 도구 사이트</h1>
    <br>
    <p class="text">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
         Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
         Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
         Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
    <br>

    <div class="btnAB">
    <!-- 로그인 페이지 이동 버튼 -->
    <div class="buttonA">
    <router-link :to="{name: 'LoginPage'}">
        <button><div class="fontA">로그인</div></button>
    </router-link>
    </div>
    
    <!-- 회원가입 페이지 이동 버튼 -->
    <div class="buttonB">
    <router-link :to="{name: 'SignUpPage'}">
        <button><div class="fontB">회원가입</div></button>
    </router-link>
    </div>
    </div>

    <!-- 배경 -->
    <div class="marni">
    <v-img src="@/assets/img/Marni4.png"></v-img>
    </div>
    <div class="Other14">
    <v-img src="@/assets/img/Other14.png"></v-img>
    </div>
    <div class="Other6">
    <v-img src="@/assets/img/Other06.png"></v-img>
    </div>

</div>
</template>

<script>
export default {
    name: 'MainPage'
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');
.background {
 background-color: #EBECF0;
 height: 100vh;
 padding: 280px;
 width: auto;
 margin: 0 auto;
 position: relative;
}
.text {
    color: #6768ab;
    width: 600px;
}
h1 {
    color: #6768ab;
}
.fontA, .fontB {
color: #6768ab;
}
.buttonA, .buttonB {
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
margin: 0 3em;
margin-left: 0;
padding: 0 3.5em;
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
.marni {
    width: 650px;
    margin-top: -430px;
    margin-left: 580px;
    position: absolute;
}
.Other14{
    width: 200px;
    margin-top: -490px;
    margin-left: 1000px;
    position: absolute;
    animation: animate 10s linear infinite;
    animation-delay: calc(1s * var(--i));
}
@keyframes animate {
    0%, 50%
    {
       transform: translateY(-10px); 
    }
    50%, 0%
    {
        transform: translateY(10px);
    }
}
.Other6 {    
    width: 200px;
    margin-top: -70px;
    margin-left: 630px;
    position: absolute;
}
</style>