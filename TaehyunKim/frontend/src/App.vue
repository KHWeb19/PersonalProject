<template>
  <v-app>
    
    <the-header/>
    
    <router-view/>

    <the-footer/>

  </v-app>
</template>

<script>
import TheHeader from './components/TheHeader.vue'
import TheFooter from './components/TheFooter.vue'

export default {
  name: 'App',

  components:{
    TheHeader,
    TheFooter
  },

  data: () => ({
    //
  }),
};
</script>

<style src="./assets/css/style.css">

</style>