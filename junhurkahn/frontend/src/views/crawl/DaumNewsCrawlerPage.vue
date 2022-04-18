<template>
  <v-app id="inspire">
    <v-app-bar app clipped-right color="blue" dark>
     
      <v-toolbar-title>
        <router-link style="text-decoration: none;"  :to="{ name: 'JpaBoardListPage' }">
     <h3>스마트 노트</h3>
    </router-link>
        
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <slot name="menubar"></slot>
    </v-app-bar>
    <v-navigation-drawer v-model="drawer" app>
     
        
       
     
    </v-navigation-drawer>
    <v-container>
      <v-content id="content">
        <slot name="content" class="font">
        </slot>
      </v-content>
    </v-container>
    <v-footer app color="blue" class="white--text">
      <v-spacer></v-spacer>
      <span>&copy; EDDI</span>
    </v-footer>
  </v-app>
</template>

<script>
import router from '@/router'
export default {
  name: "Layout.vue",
  data () {
    return {
      drawer: false,
      left: false
    }
  },
  methods: {
    home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    },
    category () {
      (window.location.pathname !== '/daumNewsCrawler') ? router.push('/') : router.go(0)
    }
  }
}
</script>

<style scoped>
h3{color: white;}
</style>

