<template>

<v-container>
    <div>
   <login-page v-if="!isLogin"></login-page>
   <login-info v-else></login-info>
    

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

import LoginInfo from '@/components/member/LoginInfo'
import LoginPage from '@/views/member/LoginPage.vue'

import { mapState } from 'vuex'


export default {
     name: 'HeaderView',
     components:{
       LoginPage,
       LoginInfo,
          
     },
  data () {
    return {
      search: '',
      tab: null,
      tabs: [ 
          { name: "Home", route: `/` }, 
          { name: "명품 판별", route: `/K1CheckBrandView` }, 
          { name: "질문 게시판", route: `/K1QuestionView` }, 
          { name: "판매 중", route: `/K2ProductView` }, 
          { name: "판매 완료", route: `/K2ProductView` }, 
          { name: "마이 페이지", route: `/MyPage` }, 

        ]
      }
  },
  computed: {
      ...mapState([ 'isLogin' ])
    }
}
</script>
<style>
</style>