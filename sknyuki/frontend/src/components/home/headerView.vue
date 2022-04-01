<template>

<v-container>
    <div>
        <router-link style="text-decoration: none;" :to="{ name: 'homeView' }">
        &nbsp;회원가입/
    </router-link>
    <router-link style="text-decoration: none;" :to="{ name: 'homeView' }">
        로그인
    </router-link>
    

    </div>
    <v-row align="center" justify="center">
  <router-link :to="{name:'homeView'}"><v-img
  class="log"
    src="@/assets/mainlog/LnT log.png"
    max-height="120"
    max-width="120"
    ></v-img></router-link></v-row>
    
 

   <v-card-title>
        <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="Search"
          single-line
          hide-details
           class="shrink"
        ></v-text-field>
      </v-card-title>
    

 <v-tabs v-model="tab" background-color="transparent" color="secondary" show-arrows grow>
      <v-tab v-for="tab of tabs" :key="tab.name" :to="tab.route" class="font-weight-bold">
        {{ tab.name }}
      </v-tab>
    </v-tabs>

 
   </v-container>
</template>


<script>
//import axios from 'axios'
export default {
     name: 'HeaderView',
  data () {
    return {
      tab: null,
      tabs: [ 
          { name: "Home", route: `/` }, 
          { name: "명품 판별", route: `/awesomeSwiperTest` }, 
          { name: "질문 게시판", route: `/` }, 
          { name: "판매 중", route: `/` }, 
          { name: "판매 완료", route: `/` }, 
          { name: "시장 가격", route: `/` }, 
          { name: "마이 페이지", route: `/` }, 
        ]
      }
  }
}

</script>
<style>

</style>