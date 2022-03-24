<template>
  <v-row align="center">
    <v-col cols="3"  sm="3" md="3" lg="3">
      <v-btn style="margin-left: 20px" fab> 사용자 </v-btn>
    </v-col>
    <v-col style="margin-left: 30px">
      <v-btn class="ca red lighten-2" outlined> PLAN </v-btn>
    </v-col>
    <v-col>
      <v-btn class="ca blue lighten-2" outlined> SEARCH </v-btn>
    </v-col>
    <v-col>
      <v-btn class="ca green lighten-2" outlined> BOARD </v-btn>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: "MainCategory"
}
</script>

<style scoped>
.ca{
  width: 150px;
}
</style>