<template>
  <v-app>
    <main-bar></main-bar>
    
    <v-main>
      <router-view/>
    </v-main>
    <footer-form></footer-form>
  </v-app>
</template>

<script>

import MainBar from "@/views/main/MainBar.vue";
import FooterForm from "@/components/main/FooterForm.vue";



export default {
  name: 'App',
  

  components: { 
    MainBar,
    FooterForm,
    
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
