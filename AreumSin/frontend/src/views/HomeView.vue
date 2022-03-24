<template>
  <v-container fluid>
    <main-category></main-category>
    <v-row>
      <v-col>
        <v-card height="600" outlined> 캘린더 </v-card>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <v-btn class="float-right">
          mdi-pencil
        </v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>

  import MainCategory from "@/components/MainCategory";
  export default {
    name: 'HomeView',

    components: {
      MainCategory

    },
  }
</script>

<style scoped>

</style>