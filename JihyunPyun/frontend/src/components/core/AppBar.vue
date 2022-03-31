<template>
  <v-app-bar 
    color="white"
    app
  >
  <v-container class="mx-auto py-0">
    <v-row align="center">
        <v-img
          :src="require('@/assets/logo.png')"
          contain
          max-width="45"
          @click="$vuetify.goTo(0)"
        />

        <v-spacer/>

        <search />
        
   <!-- 로그인 안했을때 등장 -->
        <v-btn outlined height="38" text>
             로그인
        </v-btn>
        <sign-up />
      
   <!-- 로그인 했을때 등장 -->
     <v-btn outlined height="38" color="deep-orange">
       <v-icon left>
        mdi-pencil
      </v-icon>
         판매하기
      </v-btn>
    <dots-menu />
    </v-row>
  </v-container>
    
    <template v-slot:extension>
      <tap-menu />
    </template>
  </v-app-bar>
</template>

<script>
import SignUp from '../authentication/SignUp.vue'
import DotsMenu from './DotsMenu.vue'
import Search from './Search.vue'
import TapMenu from './TapMenu.vue'
  export default {
  components: {SignUp, Search, DotsMenu, TapMenu},
    name: 'CoreAppBar'
  }
</script>

<style scoped>
.v-btn {
    margin-left: 10px;
    margin-right: 5px;
}
</style>
