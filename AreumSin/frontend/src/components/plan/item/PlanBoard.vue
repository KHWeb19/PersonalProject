<template>
  <v-container>
    <v-card class="pa-5" @click="showDialog">
      <v-row justify="center">
        PlanBoard
        <img src="../../../../public/undraw_Traveling_re_weve.png" height="300px">
      </v-row>
    </v-card>

    <v-dialog max-width="800" v-model="planBoardDialog">
      <v-card class="pa-10">
        <v-row justify="start">
          <v-btn @click="closeDialog()"> x </v-btn>
        </v-row>

        <v-row justify="center">
          <v-card-title>
            <span style="font-size: 40px; color: darkolivegreen"><br/>투표 내용이 들어가 있음! </span>
          </v-card-title>
        </v-row>
        <v-card-actions>
          <v-spacer></v-spacer>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
export default {
  name: "PlanBoard",
  data(){
    return{
      planBoardDialog: false,
    }
  },
  methods: {
    showDialog(){
      this.planBoardDialog = true;
    },
    closeDialog(){
      this.planBoardDialog = false;
    }
  }
}
</script>

<style scoped>
p{
  font-size: 30px;
}
</style>