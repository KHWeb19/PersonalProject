<template>
  <v-container>
    <v-card class="pa-8">
      <v-row class="ps-2">
        <v-col cols="6">
          <p>
            <img src="../../../assets/location.png"> {{planPlace}}
          </p>
        </v-col>
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "PlanPlace",
  data(){
    return{
      planPlace: localStorage.getItem('placeName')
    }
  }
}
</script>

<style scoped>
img{
  height: 80px;
  margin-right: 10px;
}
p{
  padding-top: 30px;
  padding-left: 50px;
  font-size: 50px;
}
</style>