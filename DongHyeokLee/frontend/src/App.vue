<template>

  <v-app>
   
   <top-nav-bar></top-nav-bar>
   <nav-bar></nav-bar>
    
    <v-main>
      <router-view/>
    </v-main>
  </v-app>

</template>

<script>

import NavBar from '@/views/bar/NavBar.vue'
import TopNavBar from '@/views/bar/TopNavBar.vue'

export default {
  name: 'App',
  components: {
    NavBar,
    TopNavBar
    
  },
  data () {
    return {
         
     
    }
  }
}
</script>
