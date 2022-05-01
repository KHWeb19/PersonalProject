<template>
  <v-app-bar flat color="white">
    <v-spacer></v-spacer>
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
    <v-spacer></v-spacer>
    <input style="background-color: #efefef; 
                              margin: 3px;
                              border-radius: 8px; 
                              width: 244px; 
                              height: 36px;
                              padding-left: 10px;" 
                          type="text" placeholder="검색" v-model="keyWord" />
    <v-btn icon @click="onSearch"><v-icon>mdi-arrow-right</v-icon></v-btn>
    <v-spacer></v-spacer>
    <v-btn icon large>
      <router-link style="text-decoration: none;" :to="{name: 'HomeView'}">
        <v-icon color="black">
          mdi-home
        </v-icon>
      </router-link>
    </v-btn>
    <v-btn icon large>
      <router-link style="text-decoration: none;" :to="{name: 'BoardRegisterPage'}">
        <v-icon color="black">
          mdi-plus-box-outline
        </v-icon>
      </router-link>
    </v-btn>
    <v-btn icon large>
      <router-link style="text-decoration: none;" :to="{name: 'MyLikesList',
              params: {memberNo: loginInfo.memberNo.toString()}}">
        <v-icon color="black">
          mdi-cards-heart-outline
        </v-icon>
      </router-link>
    </v-btn>
    <v-menu offset-y min-width="130px">
      <template v-slot:activator="{ on }">
        <v-btn icon v-on="on">
          <div style="border-radius: 70%; overflow: hidden;">
            <v-img v-if="imageChange" max-width="26" height="26" :src="require(`@/assets/mImage/${imageChange}`)"/>
            <v-img v-else-if="loginInfo.imageName" max-width="26" height="26" :src="require(`@/assets/mImage/${loginInfo.imageName}`)"/>
            <v-img v-else max-width="26" height="26"  src="@/assets/profile.jpg"/>
          </div>
        </v-btn> 
      </template>
      <v-list>
          <v-list-item-title> 
            <router-link style="text-decoration: none;" :to="{
              name: 'MyProfilePage',
              params: {memberNo: loginInfo.memberNo.toString()}}">
              <v-btn text block>프로필</v-btn>
            </router-link>
          </v-list-item-title>
          <v-list-item-title> 
            <router-link style="text-decoration: none;" :to="{
              name: 'AccountsEditPage',
              params: {memberNo: loginInfo.memberNo.toString()}}">
              <v-btn text block>설정</v-btn>
            </router-link>
          </v-list-item-title>
          <v-list-item-title>        
              <v-btn text block @click="logout">
                로그아웃
              </v-btn>
          </v-list-item-title>
        </v-list>
      </v-menu>
    <v-spacer></v-spacer>
    <v-spacer></v-spacer>
    <v-spacer></v-spacer>
  </v-app-bar>
  
</template>

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'
import { mapActions, mapState } from 'vuex'
import axios from 'axios';

Vue.use(cookies)

  export default {
    name: 'MenuBar',
    data: () => ({
      loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
      imageChange: JSON.parse(localStorage.getItem('imageChange')),
      searchMembers: [],
      keyWord: ''
    }),
      computed: {
    ...mapState(['member']),
  },
    methods: {
    ...mapActions(['fetchMember']),
    onSearch() {
            const keyWord = this.keyWord
            axios.post('http://localhost:7777/member/search',  { keyWord })
              .then((res) => {
                  this.$router.push({name: 'MemberList',
                  params: { keyWord:keyWord, searchMembers: res.data} })
              })
        },
      logout() {
        localStorage.removeItem("loginInfo")
        localStorage.removeItem("imageChange")
        this.$cookies.remove("user")
        this.$router.push({name: 'LoginPage'})
        history.go(0);
      }
    }
  }
</script>
