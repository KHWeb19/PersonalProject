<template>
  <v-app>
    <Header/>

    <!--
    <v-app-bar
      app
      color="primary"
      dark
    >
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />

        <v-img
          alt="Vuetify Name"
          class="shrink mt-1 hidden-sm-and-down"
          contain
          min-width="100"
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-name-dark.png"
          width="100"
        />
      </div>

      <v-spacer></v-spacer>

      <v-btn
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
        text
      >
        <span class="mr-2">Latest Release</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar> -->

    <v-main>
      <router-view v-if="categories && products" :categories="categories" :products="products" @fetchData="fetchData"/>
    </v-main> 

  </v-app> 
</template>

<script>

import Header from './components/layout/Header.vue'
import axios from 'axios'

export default {
  name: 'App',
  components: {
    Header,

  },
  data() {
    return {
      products: null,
      categories: null
    }
  },
  methods: {
    async fetchData() {
      await axios.get('http://localhost:7777/category/list')
      .then((res) => {
        this.categories = res.data
      })
      .catch((err) => {
        console.log('err: ' + err)
      })

       await axios.get('http://localhost:7777/product/list')
      .then((res) => {
        this.products = res.data
        console.log(this.products)
      })
      .catch((err) => {
        console.log('err: ' + err)
      })
    }
  },
  mounted() {
    this.fetchData()
  }
}
</script>

