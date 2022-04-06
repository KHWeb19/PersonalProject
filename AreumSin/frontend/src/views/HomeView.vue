<template>
  <v-container fluid>
    <main-category></main-category>
    <CalendarComponents/>
    <BeforePencilIcon/>
  </v-container>
</template>

<script>

  import MainCategory from "@/components/MainCategory";
  import CalendarComponents from "@/components/CalendarComponents";
  import BeforePencilIcon from "@/components/Item/BeforePencilIcon";
  export default {
    name: 'HomeView',
    components: {
      BeforePencilIcon,
      CalendarComponents,
      MainCategory

    },
  }
</script>

<style scoped>

</style>