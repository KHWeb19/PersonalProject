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

    <ContentList v-bind:dayContent="dayContent" @clickLike="clickLike" @clickHate="clickHate" @clickRemove="clickRemove"></ContentList>

    <hr/>
    <p></p>

    <WriteContent @onSubmit="sendContent"></WriteContent>
  </v-container>
</template>

<script>
import MainCategory from "@/components/MainCategory";
import WriteContent from "@/components/plan/day/WriteContent";
import axios from "axios";
import {mapActions, mapState} from "vuex";
import ContentList from "@/components/plan/day/ContentList";
import {FETCH_DAY_CONTENT} from "@/store/mutation-types";

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
    ...mapActions(['fetchDayContent']),
    sendContent(payload){
      const {id, planNo, content} = payload
      let day = this.date;

      console.log(id + ", " + content + ", " + planNo + ", " + day)
      axios.post('http://localhost:7777/planDay/day', {id, planNo, day, content})
      .then((res) => {
        alert('성공' + res)
      })
    },
    clickLike(payload){
      const {planDayNo} = payload;
      let id = this.id
      console.log(planDayNo, id);
      axios.post('http://localhost:7777/planDay/like', {planDayNo, id})
      .then((res) => {
        alert('성공' + res.data.likeCount);
      })
    },
    clickHate(payload){
      const {planDayNo} = payload;
      let id = this.id
      console.log(planDayNo, id);
      axios.post('http://localhost:7777/planDay/hate', {planDayNo, id})
          .then((res) => {
            alert('성공' + res);
          })
    },
    clickRemove(payload){
      const {planDayNo} = payload;
      let id = this.id
      console.log(planDayNo, id);
      axios.post('http://localhost:7777/planDay/remove/',{planDayNo, id})
          .then((res) => {
            if(!res.data){
              alert('지울 수 없습니다. ')
            }
          })
    }
  },
  computed: {
    ...mapState(['dayContent'])
  },
  mounted() {
    let planNo = this.planNo;
    let day = this.day;
    axios.post('http://localhost:7777/planDay/list', {planNo, day})
      .then((res) => {
        console.log(res + "성공");
        this.$store.commit(FETCH_DAY_CONTENT, res.data);
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