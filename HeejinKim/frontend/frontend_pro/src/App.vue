<template>
  <v-app>
    <main-bar></main-bar>
  
    <v-main>
      <router-view/>
    </v-main>
 
  </v-app>
</template>

<script>

import MainBar from "@/views/main/MainBar.vue";
import {mapActions} from "vuex";

export default {
  name: 'App',

  components: { 
    MainBar
    
  },

  data: () => ({
    //
  }),
  mounted() {
    this.setIsLogin()
    this.cookieSession()
    this.setAuth()
    
  },
  methods:{
    ...mapActions(['cookieSession', 'setIsLogin',"setAuth",])
  }
};
</script>
