<template>
  <div id="app">
  <v-app>
        <top-nav-bar></top-nav-bar>
    <v-main>
      <router-view/>
         <footer-bar></footer-bar> 
    </v-main>
  </v-app>
  </div>
</template>

<script>


import TopNavBar from '@/views/bar/TopNavBar.vue'
import FooterBar from './views/bar/FooterBar.vue'


export default {
  name: 'App',
  components: {
   TopNavBar,
    FooterBar
    
  },
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap');


  
</style>