<template>
  <v-container>
    <MainCategory></MainCategory>
    <p></p>
    <p style="font-size: 35px;">{{day}} 일</p>

    <div id='wrapper'>
      <div>
        content
      </div>
    </div>

    <v-row style="margin-bottom: 30px">
      <v-col cols="8">
        <ContentList v-bind:dayContent="dayContent" @clickLike="clickLike" @clickHate="clickHate" @clickRemove="clickRemove"></ContentList>
      </v-col>

      <v-col cols="4">
        <v-card class="pa-3">
          <v-row justify="center">
            <v-card-title style="font-size: 30px">
              {{day}}날 가야하는 곳
            </v-card-title>
          </v-row>

          <v-row>
            <v-card-text style="margin-left: 15px; font-size: 20px; margin-bottom: 10px;">
              <v-row v-for="(rs, index) in placeList" :key="index">
                {{index+1}}: {{rs.title}}
              </v-row>
            </v-card-text>
          </v-row>
        </v-card>
      </v-col>
    </v-row>

    <hr/>
    <p></p>

    <WriteContent :day="day"></WriteContent>
<!--    <WriteContent @onSubmit="sendContent"></WriteContent>-->
  </v-container>
</template>

<script>
import MainCategory from "@/components/MainCategory";
import WriteContent from "@/components/plan/day/WriteContent";
import axios from "axios";
import {mapState} from "vuex";
import ContentList from "@/components/plan/day/ContentList";
import {FETCH_DAY_CONTENT, FETCH_PLACE_LIST} from "@/store/mutation-types";

export default {
  name: "PlanDayView",
  components: {ContentList, WriteContent, MainCategory},
  props:{
    day: {
      type: String,
      default: ''
    }
  },
  data(){
    return{
      date: Number(this.day),
      planNo: localStorage.getItem('planNo'),
      id: localStorage.getItem('session')
    }
  },
  methods:{
    clickLike(payload){
      const {planDayNo} = payload;
      let id = this.id
      console.log(planDayNo, id);
      axios.post('http://localhost:7777/planDay/like', {planDayNo, id})
      .then(() => {
        //alert('성공' + res.data.likeCount);
      })
    },
    clickHate(payload){
      const {planDayNo} = payload;
      let id = this.id
      console.log(planDayNo, id);
      axios.post('http://localhost:7777/planDay/hate', {planDayNo, id})
          .then(() => {
            //alert('성공' + res);
          })
    },
    clickRemove(payload){
      const {planDayNo} = payload;
      let id = this.id
      console.log(planDayNo, id);
      axios.post('http://localhost:7777/planDay/remove/',{planDayNo, id})
          .then((res) => {
            if(!res.data){
              //alert('지울 수 없습니다. ')
            }
          })
    }
  },
  computed: {
    ...mapState(['dayContent','placeList'])
  },
  mounted() {
    let planNo = this.planNo;
    let day = this.day;
    axios.post('http://localhost:7777/planDay/list', {planNo, day})
      .then((res) => {
        console.log(res + "성공");
        this.$store.commit(FETCH_DAY_CONTENT, res.data);
      })
    axios.post('http://localhost:7777/planDay/mapPlaceListDay', {planNo, day})
          .then((res) => {
            //alert('성공')
            this.$store.commit(FETCH_PLACE_LIST, res.data)
          })
  }
}
</script>

<style scoped>
#wrapper{
  height: auto;
  min-height: 100%;
  padding-bottom: 100px;
}
WriteContent{
  height: 100px;
  position: relative;
  transform: translateY(-100%);
}
</style>