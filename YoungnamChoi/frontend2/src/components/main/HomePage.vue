<template>
  <v-container>
    <category-card></category-card>
  </v-container>
</template>

<script>
import CategoryCard from "./CategoryCard.vue";

import "swiper/css/swiper.css";
export default {
  components: { CategoryCard },
  name: "HomePage",
};
</script>
