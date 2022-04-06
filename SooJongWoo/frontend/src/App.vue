<template>
  <v-app>
    <v-main>
      <router-view />
    </v-main>
    <footer-view />
  </v-app>
</template>

<script>
import FooterView from "@/views/FooterView.vue";

export default {
  name: "App",
  components: {
    FooterView,
  },
};
</script>