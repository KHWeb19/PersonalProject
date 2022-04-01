

<template>
  <v-app id="inspire">
    <v-app-bar app clipped-right color="blue" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>
        <router-link style="text-decoration: none;"  :to="{ name: 'JpaBoardListPage' }">
     <h3>스마트 노트</h3>
    </router-link>
        
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <slot name="menubar"></slot>
    </v-app-bar>
    <v-navigation-drawer v-model="drawer" app>
      <v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
            <v-icon>
              mdi-exit-to-app
            </v-icon>
          </v-list-item-action>
          <v-list-item-action>
            <v-list-item-title @click="category">생활편의</v-list-item-title>
          </v-list-item-action>
        </v-list-item>
      </v-list>
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

