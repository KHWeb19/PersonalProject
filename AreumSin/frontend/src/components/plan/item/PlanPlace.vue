<template>
  <v-container>
    <v-card class="pa-8" @click="showMapList">
      <v-row class="ps-2">
        <v-col cols="6">
          <p>
            <img src="../../../assets/location.png"> {{planPlace}}
          </p>
        </v-col>
      </v-row>
    </v-card>

<!--    <v-dialog v-model="showPlace">
      <v-card>
        <v-row justify="center">
          <v-card-title>
            <span style="font-size: 40px; color: darkolivegreen"><br/>어디 여행지에 저장을 할까요?</span>
          </v-card-title>
        </v-row>

        <div class="kmap" ref="map">a</div>

      <v-row>
        <v-spacer></v-spacer>
        <v-btn color="green darken-1" text @click="showPlace = false">Close</v-btn>
        <v-btn color="green darken-1">Save</v-btn>
      </v-row>
      </v-card>
    </v-dialog>-->

  </v-container>
</template>

<script>
export default {
  name: "PlanPlace",
  data(){
    return{
      planPlace: localStorage.getItem('placeName'),
      showPlace: false,
    }
  },
  props:{
    planNo: {
      type: String,
    },
    dates: {
      type: Array,
    }
  },
  methods: {
    showMapList() {
      this.$router.push({name: 'PlanMapListView', params: {planNo: this.planNo, dates: this.dates}})
    }
  },
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
.kmap {
  width: 100%;
  height: 600px;
}
</style>