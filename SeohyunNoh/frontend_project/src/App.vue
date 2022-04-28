<template>
  <v-app>
    <Header :cartCount="cartCount" @resetCartCount="resetCartCount"/>

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

  <Footer/>
  </v-app> 
</template>

<script>

import Header from './components/layout/Header.vue'
import axios from 'axios'
import Footer from './components/layout/Footer.vue'

export default {
  name: 'App',
  components: {
    Header,
    Footer,

  },
  data() {
    return {
      products: null,
      categories: null,
      cartCount: 0,
      id: ''
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

      if(this.$store.state.isLogin === true) {
        axios.get(`http://localhost:7777/cart/list/${this.id}`)
        .then ((res) => {
          const result = res.data
          this.cartCount = result.cartItems.length
        })
        .catch((err) => {
          console.log('cart err' + err)
        })
      }
    },
    resetCartCount() {
      this.cartCount = 0;
    }
  },
  mounted() {
    this.id = this.$store.state.userInfo.id
    this.fetchData()
  }
}
</script>

