<template>
    <v-app-bar
      color="white"
    >
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
          <v-icon color="black">
            mdi-circle-outline
          </v-icon>
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

Vue.use(cookies)

  export default {
    props: {
      member: {
          type: Object,
          require: true
      }
    },
    data: () => ({
      isLogin: true,
      loginInfo: JSON.parse(localStorage.getItem('loginInfo'))
    }),
    methods: {
      logout() {
        localStorage.removeItem("loginInfo")
        this.$cookies.remove("user")
        this.$router.push({name: 'LoginPage'})
      }
    }
  }
</script>
