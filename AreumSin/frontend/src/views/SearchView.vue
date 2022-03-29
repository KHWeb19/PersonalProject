<template>
  <v-container fluid>
    <MainCategory/>
    <v-row>
      <v-spacer></v-spacer>
      <v-col>
        <v-text-field dense outlined label="장소 검색"
                      full-width :style="{marginTop:'10px', align: 'center'}"/>
      </v-col>
      <v-col>
        <v-btn :style="{marginTop:'10px'}"><v-icon>mdi-magnify</v-icon></v-btn>
      </v-col>
    </v-row>
    <v-row>
      <v-card height="500" width="800" outlined> 캘린더 </v-card>
    </v-row>
  </v-container>
</template>

<script>
import MainCategory from "@/components/MainCategory";
export default {
  name: "SearchView",
  components: {MainCategory}
}
</script>

<style scoped>

</style>