<template>
  <v-container fluid>
    <main-category></main-category>
    <CalendarComponents/>
  </v-container>
</template>

<script>

  import MainCategory from "@/components/MainCategory";
  import CalendarComponents from "@/components/CalendarComponents";
  export default {
    name: 'HomeView',
    components: {
      CalendarComponents,
      MainCategory
    },
    methods: {

    }
  }
</script>

<style scoped>

</style>