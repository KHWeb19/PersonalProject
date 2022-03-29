<template>
  <v-app>
    <div v-if="$route.name !=='EnterVellup' && $route.name !== 'JoinPage' && $route.name !== 'JoinPage2'">
      <v-container>
        <v-layout row wrap class="btnSet">
          <div id="m">
            <login-button/>
          </div>
          <div>
            <join-button/>
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
import MainToolbar from './components/MainToolbar.vue';

export default {
  components: { MainToolbar, LoginButton, JoinButton },
  name: 'App',

  data: () => ({
    //
  }),
};
</script>

<style scoped>
.header {
    position: relative;
    left: 20%;
    padding-top: 10px;
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
a:visited{
    color: black;
}
a:link{
    color: black;
}

</style>

<style>
a {
    text-decoration: none;
}
</style>
