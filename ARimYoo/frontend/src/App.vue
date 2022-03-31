<template>
  <v-app>
    <div v-if="$route.name !=='EnterVellup' && $route.name !== 'JoinPage' && $route.name !== 'JoinPage2'">
      <v-container>
        <v-layout row wrap class="btnSet" >
          <div id="m">
            <div class="button" v-if="isCookie">
            <logout-button/>
            </div>
            <div class="button" v-else>
            <login-button />
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
      //isCookie: this.$cookies.get('user')  == 'true'
    }
  },
  computed: {
    isCookie () {
     return  this.$store.state.userInfo 
    }
  }
};
</script>

<style scoped>
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
#m {
  margin-right:5px;
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
