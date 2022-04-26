<template>
  <v-container>
    <v-row align="center">
      <v-col cols="3"  sm="3" md="3" lg="3">
        <v-btn style="margin-left: 20px" fab @click="checkLogin" x-large> 사용자 </v-btn>
      </v-col>
      <v-spacer></v-spacer>
      <v-col>
        <v-btn class="ca red lighten-2" style="font-size: 30px" @click="planLink" x-large outlined> PLAN </v-btn>
      </v-col>
      <v-col>
        <v-btn class="ca blue lighten-2" style="font-size: 30px" @click="searchLink" x-large outlined> SEARCH </v-btn>
      </v-col>
      <v-col>
        <v-btn class="ca green lighten-2" style="font-size: 30px" @click="boardLink" x-large outlined> BOARD </v-btn>
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
      if(localStorage.getItem("session") === null) {
        this.$router.push({name: 'HomeView'})
      }else {
        this.$router.push({name: 'PlanListView'})
      }
    },
    searchLink() {
      this.$router.push({name: 'SearchView'})
    },
    boardLink(){
      this.$router.push({name: 'BoardView'})
    },
    checkLogin(){
      if(localStorage.getItem("session") === null){
        this.$router.push({name: 'LoginPage'})
      }else{
        this.$router.push({name: 'MyPage'})
      }

    }
  }
}
</script>

<style scoped>
.ca{
  width: 230px;
}
</style>