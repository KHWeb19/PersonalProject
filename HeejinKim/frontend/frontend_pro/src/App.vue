<template>
  <v-app>
    <main-bar></main-bar>
    <main-page></main-page>
    <v-main>
      <router-view/>
    </v-main>
 
  </v-app>
</template>

<script>

import MainBar from "@/views/main/MainBar.vue";
import MainPage from "@/views/main/MainPage.vue";


export default {
  name: 'App',

  components: { 
    MainBar,
    MainPage
    
  },

  data: () => ({
    //
  }),
  mounted() {
   
    
  },
  methods:{
   
  }
};
</script>
