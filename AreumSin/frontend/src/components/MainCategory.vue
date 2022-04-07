<template>
  <v-container>
    <v-row align="center">
      <v-col cols="3"  sm="3" md="3" lg="3">
        <v-btn style="margin-left: 20px" fab @click="myPage"> 사용자 </v-btn>
      </v-col>
      <v-spacer></v-spacer>
      <v-col>
        <v-btn class="ca red lighten-2" @click="planLink" outlined> PLAN </v-btn>
      </v-col>
      <v-col>
        <v-btn class="ca blue lighten-2" @click="searchLink" outlined> SEARCH </v-btn>
      </v-col>
      <v-col>
        <v-btn class="ca green lighten-2" @click="boardLink" outlined> BOARD </v-btn>
      </v-col>
    </v-row>
    <hr size="20px" style="margin-top: 10px;">

  </v-container>
</template>

<script>
export default {
  name: "MainCategory",
  methods: {
    planLink(){
      this.$router.push({name: 'HomeView'})
    },
    searchLink() {
      this.$router.push({name: 'SearchView'})
    },
    boardLink(){
      this.$router.push({name: 'BoardView'})
    },
    myPage(){
      this.$router.push({name: 'LoginPage'})
    }
  }
}
</script>

<style scoped>
.ca{
  width: 190px;
}
</style>