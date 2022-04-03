<template>
  <v-app>
    <div v-if="$route.name !=='EnterVellup' && $route.name !== 'JoinPage' && $route.name !== 'JoinPage2'">
        <v-container>
            <v-layout row wrap>
                <div v-if="$store.state.token">
                    <div>
                    <logout-button class="logOutButton"/>
                    </div>
                    <div class="userMessage">
                     {{ user.message }} 님
                    </div>
                </div>
                <div v-else class="btnSet"> 
                    <div class="float">
                        <login-button />
                    </div>
                    <div  class="float">
                        <join-button/>
                    </div>
                </div>
            </v-layout>
        </v-container>
      <div class="header">
          <router-link to="main"><img src ="@/assets/main/banner.png" width="250"></router-link>
      </div>
      <div class="menuBar">  
          <main-toolbar/>
      </div>
    </div>

    <v-main>
      <v-container fluid justify-center class="py-0 px-0">
        <router-view></router-view>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import JoinButton from './components/button/JoinButton.vue';
import LoginButton from './components/button/LoginButton.vue';
import LogoutButton from './components/button/LogoutButton.vue';
import MainToolbar from './components/MainToolbar.vue';

export default {
  components: { MainToolbar, LoginButton, JoinButton, LogoutButton },
  name: 'App',

  data () {
    return {
     user: {
         message: decodeURIComponent(this.$store.state.userInfo.id)
     },
     login : true,
     notlogin: true
    }
  },
   computed: {
   },
   
  methods : {

  }
}
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@800&display=swap');

.header {
    position: relative;
    left: 20%;
    padding-top: 5px;
    padding-bottom: 5px;
}
.btnSet{
  position: absolute;
  left: 75%;
  padding-top:1%;
}
.logOutButton{
  position: absolute;
  left: 80%;
  padding-top:1%;
}
.float {
  float: left;
  margin-right:5px;
}
.userMessage {
  position: absolute;
  left: 73%;
  padding-top:1.1%;
}
.profileImg{
    position: absolute;
    width:2%;
    left:72%;
    float: left;
    margin-right:10px;
}
</style>

<style>
a {
    text-decoration: none;
}
a:linked{
  color:white;
}
</style>
