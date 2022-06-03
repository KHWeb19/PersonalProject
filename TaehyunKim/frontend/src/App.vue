<template>
  <v-app>
    <v-container class="main">
      <the-header class="header"/>

      <router-view :key="$route.path"/>

      <the-footer/>
    </v-container>
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