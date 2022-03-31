<template>
  <v-app>
    <v-main>
      <Navigation />
      <v-main>
        <router-view />
      </v-main>
      <Footer />
    </v-main>
  </v-app>
</template>

<script>
import Navigation from "@/components/Navigation.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: "App",

  components: {
    Navigation,
    Footer,
  },
  data: () => ({}),
};
</script>
