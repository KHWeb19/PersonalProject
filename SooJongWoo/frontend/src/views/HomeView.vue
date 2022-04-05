<template>
  <div class="HomeView">
    <div id="header">
      <main-page />
    </div>
  </div>
</template>

<script>
import MainPage from "@/views/main/MainPage.vue";

export default {
  components: { MainPage },
  name: "HomeView",
  data() {
    return {};
  },
};
</script>