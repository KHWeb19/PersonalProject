<style>
.Main{     
  height: 20vh;
  overflow: hidden;
  margin:0;
  background-color: #D3D3D3;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  width: 100vw; 
}
.background{
    height: 120vh;
    overflow: hidden;
    margin:0;
    background-image: url("../src/assets/img/main.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center;
}
.navbar { 
    width: 100vw; 
    position: fixed; 
    transform: translate3d(0, 0, 0); 
    transition: 0.1s all ease-out; 
    } 
.navbar.navbar--hidden { 
    box-shadow: none; 
    transform: translate3d(0, -100%, 0);
} 
#contact{
    width: 100%; 
    height: 80px;
    background-color:rgb(40, 44, 53) ;
    position: relative;
}
#icon{
    text-align: center;
    position: relative;
}
</style>
<template>
  <v-app>
    <div class="Main" align="center">
       <header>
            <div class="navbar" 
                 :class="{ 'navbar--hidden': !showNavbar }" >
                </div> 
                <br>
            <a href="http://localhost:8080/stock/"><img src='../src/assets/img/newlogo.png'></a>
            <br>
        </header>     
    </div>
    <div id= article v-on:click="checkLogin">
        <v-btn v-bind:disabled="this.$store.state.userInfo == null" class="grey darken-1 white--text" width="325px" onclick="location.href='http://localhost:8080/stock/LocalList'" :style="{fontSize:'x-large'}">국내 주식 분석</v-btn>
        <v-btn v-bind:disabled="this.$store.state.userInfo == null" class="grey darken-2 white--text" width="325px" onclick="location.href='http://localhost:8080/stock/ForeignList'" :style="{fontSize:'x-large'}">해외 주식 분석</v-btn>
        <v-btn v-bind:disabled="this.$store.state.userInfo == null" class="grey darken-3 white--text" width="325px" onclick="location.href='http://localhost:8080/stock/QuestionList'" :style="{fontSize:'x-large'}">질문</v-btn>
        <v-btn v-bind:disabled="this.$store.state.userInfo == null" class="grey darken-4 white--text" width="325px" onclick="location.href='http://localhost:8080/stock/ComplaintList'" :style="{fontSize:'x-large'}">하소연</v-btn> 
    </div>       

    <v-main class="background" id="vm" align="center">
      <router-view/>
    </v-main>
    <footer id=contact>             
            <div id=icon>
                <v-icon color="white">mdi-twitter</v-icon>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
                <v-icon color="white">mdi-facebook</v-icon>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
                <v-icon color="white">mdi-whatsapp</v-icon>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
                <v-icon color="white">mdi-wechat</v-icon>
            </div>   
            <p align="center" style="font-size:16px; color:white;">JulinCommu | 대표자 : 이지상 | 주소 : 서울특별시 영등포구 영등포로 3길 23 <br> 
                                                                   Copyright©2022 CommunityForJulin. All rights reserved.</p>              
    </footer>
  </v-app>
</template>

<script>
import swal from 'sweetalert';
export default {
name: 'App',
 data: () => ({
    //
  }),
 created () {
  //         sessionStorage
  if (sessionStorage.getItem('store')) {
   this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(sessionStorage.getItem('store'))))
  }
  //        store   sessionStorage 
  window.addEventListener('beforeunload', () => {
   sessionStorage.setItem('store', JSON.stringify(this.$store.state))
  })
 },
 methods:{
 checkLogin(){
        if(this.$store.state.userInfo == null){
             swal({
                text: "로그인을 먼저 해주세요.",
                icon:"warning"
                })
        }
    },
    onScroll () { 
          const currentScrollPosition = window.pageYOffset || document.documentElement.scrollTop 
          if (currentScrollPosition < 0) { return } // Stop executing this function if the difference between // current scroll position and last scroll position is less than some offset 
          if (Math.abs(currentScrollPosition - this.lastScrollPosition) < 20) {return } 
          this.showNavbar = currentScrollPosition < this.lastScrollPosition 
          this.lastScrollPosition = currentScrollPosition 
        },
 }
}
</script>


