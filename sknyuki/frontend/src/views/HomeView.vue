
<template>
  <v-sheet class="main">
    <v-row>
      <v-col cols="12" md="7">
        <header-view></header-view>
        <v-row>
          <v-col>
            <record-preview></record-preview>
          </v-col>
          <v-col>
            <map-preview></map-preview>
          </v-col>
        </v-row>
      </v-col>
      <v-col cols="12" md="5">
        <challenge-preview></challenge-preview>
        <recommend-preview></recommend-preview>
        <together-preview></together-preview>
      </v-col>
    </v-row>
  </v-sheet>
</template>

<script>
import HeaderView from '../components/home/headerView.vue'
  

  export default {
    name: 'HomeView',

    components: {
        HeaderView,
    },
  }
</script>
