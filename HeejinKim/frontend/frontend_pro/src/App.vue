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



export default {
  name: 'App',

  components: { 
    MainBar,
   
    
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
