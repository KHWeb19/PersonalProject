<template>
  <v-app>
    <div v-if="$route.name !=='EnterVellup' && $route.name !== 'JoinPage' && $route.name !== 'JoinPage2'">
        <v-container v-if="$store.state.token">
            <v-layout row>
                <div class="btnSet2">
                    <div class="float">
                        <router-link to="/myPage"><img src="@/assets/profile.png" width="30"/></router-link>
                    </div>
                    <div class="float">
                        <v-menu offset-y>
                                <template v-slot:activator="{ on}">
                                    <button depressed color="white" height="30" 
                                    v-on="on" class="myBtn" width="140">{{ user.message }} 님</button>
                                </template>
                            <v-list class="black">
                                <v-list-item
                                    dark
                                    v-for="(item,idx) in items"
                                    :key="idx"
                                    :to ="item.route"
                                    >
                                    {{ item.title }}
                                </v-list-item>
                            </v-list>
                            </v-menu>
                    </div>
                    <div  class="float">
                        <logout-button/>
                    </div>
                </div>
            </v-layout>
        </v-container>
        <v-container v-else>
            <v-row>
                <div class="btnSet"> 
                        <div class="float">
                            <login-button />
                        </div>
                        <div  class="float">
                            <join-button/>
                        </div>
                </div>
            </v-row>
        </v-container>

      <div class="header">
          <button><img src ="@/assets/main/banner.png" width="220" @click="goToMain"></button>
      </div>
      <div class="menuBar">  
          <main-toolbar/>
      </div>
    </div>

    <v-main>
      <v-container fluid justify-center class="py-0 px-0 mt-5 mb-10">
        <router-view></router-view>
      </v-container>
    </v-main>

    <div v-if="$route.name !=='EnterVellup' && $route.name !== 'JoinPage' && $route.name !== 'JoinPage2'">
        <v-footer dark padless style="width:76.5%; margin-left:auto; margin-right:auto">
        <v-card
        flat
        tile
        class="white--text text-center flex"
        >
        <v-card-text  class="white--text">
            <strong>Vellup!</strong>&nbsp; —  &nbsp; Level up Your Develop Skill
        </v-card-text>
        <v-card-text>
        <v-btn
            v-for="icon in icons"
            :key="icon"
            class="mx-4"
            dark
            small
            icon
            >
            <v-icon size="24px">
                {{ icon }}
            </v-icon>
            </v-btn>
        </v-card-text>

        <v-divider></v-divider>

        <v-card-text class="white--text" style="font-size:10pt">
            Copyright © {{ new Date().getFullYear() }}  Yoo A Rim All Right Reserved
        </v-card-text>
        </v-card>
    </v-footer>
    </div>
  </v-app>
</template>

<script>
import { mapState } from 'vuex';
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
         message: decodeURIComponent(this.$store.state.userInfo.id),
     },
     icons: [
        'mdi-facebook',
        'mdi-twitter',
        'mdi-linkedin',
        'mdi-instagram',
      ],
     items: [
         {title: 'My Page', route:'/myPage'},
         {title: 'My With', route:'/myWith'}
     ]
    }
  },
  computed: {
      ...mapState(['userInfo'])
  },
  methods : {
      goToMain () {
          this.$router.push("/main")
          history.go(0)
      }

  }
}
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');

.header {
    position: relative;
    left: 17%;
    padding-top: 5px;
    padding-bottom: 5px;
}
.btnSet{
  position: absolute;
  left: 75%;
  padding-top:1%;
}
.btnSet2{
  position: absolute;
  left: 71%;
  padding-top:1%;
}
.v-footer{
    font-family: 'Noto Sans KR', sans-serif;
}
.myBtn{
   font-family: 'Noto Sans KR', sans-serif;
    font-size: 16px;
    padding-top:2%;
}
.float {
  float: left;
  margin-right:7px;
}
</style>

<style>
a{
    text-decoration: none;
    color:white;
}
</style>
