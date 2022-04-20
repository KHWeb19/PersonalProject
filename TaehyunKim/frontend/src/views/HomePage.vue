<template>
  <v-container>
    <v-main>
      <the-carousel/>
      <the-gallery/>
      <the-cards/>
    </v-main>
  </v-container>
</template>

<script>
import TheCarousel from '../components/TheCarousel.vue'
import TheGallery from '../components/TheGallery.vue'
import TheCards from "../components/TheCards.vue"

  export default {

    components:{
      TheCarousel,
      TheGallery,
      TheCards
    },
    data(){
      return {

      }
    }
  }
</script>
