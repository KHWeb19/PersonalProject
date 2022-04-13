<template>
  <v-app-bar flat color="white">
    <v-spacer></v-spacer>
    <v-spacer></v-spacer>
    
    <v-app-bar-title>
      <router-link style="text-decoration: none;" :to="{name: 'HomeView'}">
        <v-img
          src="@/assets/vuelogo.png"
          width="100"
          min-width="100"
        />
      </router-link>
    </v-app-bar-title>

    <v-spacer></v-spacer>
    <input style="background-color: #efefef; 
                              margin: 3px;
                              border-radius: 8px; 
                              width: 244px; 
                              height: 36px;
                              padding-left: 10px;" 
                          type="text" placeholder="검색" />
    <v-spacer></v-spacer>
    
    <v-btn icon>
      <router-link style="text-decoration: none;" :to="{name: 'HomeView'}">
        <v-icon color="black">
          mdi-home
        </v-icon>
      </router-link>
    </v-btn>

    <v-btn icon>
      <router-link style="text-decoration: none;" :to="{name: 'BoardRegisterPage'}">
        <v-icon color="black">
          mdi-plus-box-outline
        </v-icon>
      </router-link>
    </v-btn>
    <v-menu offset-y min-width="230px">
      <template v-slot:activator="{ on }">
        <v-btn icon v-on="on">
                <v-img v-if="imageChange" max-width="24" height="24" :src="require(`@/assets/mImage/${imageChange}`)"/>
                <v-img v-else-if="loginInfo.imageName" max-width="24" height="24" :src="require(`@/assets/mImage/${loginInfo.imageName}`)"/>
                <v-img v-else max-width="24" height="24"  src="@/assets/logo.png"/>
        </v-btn> 
      </template>
      <v-list>
          <v-list-item-title> 
            <router-link style="text-decoration: none;" :to="{
              name: 'MyProfilePage',
              params: {memberNo: loginInfo.memberNo.toString()}}">
              <v-btn>프로필</v-btn>
            </router-link>
          </v-list-item-title>
          <v-list-item-title> 
            <router-link style="text-decoration: none;" :to="{
              name: 'AccountsEditPage',
              params: {memberNo: loginInfo.memberNo.toString()}}">
              <v-btn>설정</v-btn>
            </router-link>
          </v-list-item-title>
            <v-list-item-title>        
              <v-btn @click="logout">
                로그아웃
              </v-btn>
          </v-list-item-title>
        </v-list>
      </v-menu>
    <v-spacer></v-spacer>
    <v-spacer></v-spacer>
  </v-app-bar>
  
</template>

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'
import { mapActions, mapState } from 'vuex'

Vue.use(cookies)

  export default {
    name: 'MenuBar',
    // props: {
    //   member: {
    //       type: Object,
    //       require: true
    //   }
    // },
    data: () => ({
      loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
      imageChange: JSON.parse(localStorage.getItem('imageChange'))
    }),
      computed: {
    ...mapState(['member']),
  },
    methods: {
    ...mapActions(['fetchMember']),
      logout() {
        localStorage.removeItem("loginInfo")
        localStorage.removeItem("imageChange")
        this.$cookies.remove("user")
        this.$router.push({name: 'LoginPage'})
      }
    }
  }
</script>
