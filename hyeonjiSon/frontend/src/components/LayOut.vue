<template>
  <v-app id="inspire">
    <v-app-bar app clipped-right color="blue" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
        <nav-header/>
      <v-spacer></v-spacer>
      <slot name="menubar"></slot>
    </v-app-bar>

    <v-navigation-drawer v-model="drawer" app>
      <v-list dense>

        <v-list-item @click.stop="left = !left">
          <nav-drawer/>
        </v-list-item>

      </v-list>
    </v-navigation-drawer>

    <v-container>
      <v-content id="content">
        <slot name="content" class="font">
        </slot>
      </v-content>
    </v-container>

  </v-app>
</template>

<script>
import router from '@/router'
import NavDrawer from './layout/NavDrawer.vue'
import NavHeader from './layout/NavHeader.vue'

export default {
  components: {
    NavDrawer,
    NavHeader
   },
  name: "LayOut",
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
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    }
  }
}
</script>

<style scoped>
</style>