<template>
  <v-container>
    <MainCategory></MainCategory>
    <v-row>
      <v-col align="end" style="padding-right: 30px">
        <v-btn class="red lighten-1 white--text">cancel</v-btn>
      </v-col>
    </v-row>
    <PlanPage :days="days"></PlanPage>

    <v-row>
      <v-col cols="3">
        <FriendList :planNo="planNum"></FriendList>
      </v-col>

      <v-col cols="3">
        <PlanBoard></PlanBoard>
      </v-col>

      <v-col>
        <v-row>
          <v-col>
            <table>
              <tr>&nbsp;</tr>
            </table>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <PlanPlace/>
          </v-col>
        </v-row>

      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <table border="1">
          <tr><v-btn>클릭</v-btn></tr>
        </table>
      </v-col>
    </v-row>

    <InPlanPencilIcon @submit="onSubmit" :findId="findId" :findName="findName" @addSubmit="addFriend" ></InPlanPencilIcon>

  </v-container>
</template>

<script>
import MainCategory from "@/components/MainCategory";
import PlanPage from "@/components/plan/PlanPage";
import InPlanPencilIcon from "@/components/Item/InPlanPencilIcon";
import FriendList from "@/components/plan/item/FriendList";
import axios from "axios";
import PlanBoard from "@/components/plan/item/PlanBoard";
import PlanPlace from "@/components/plan/item/PlanPlace";
export default {
  name: "PlanView",
  components: {PlanPlace, PlanBoard, InPlanPencilIcon, PlanPage, MainCategory, FriendList},
  data(){
    return {
      days: Number(this.day),
      findMember: null,
      findId: null,
      findName: null,
      data: '',
      planNo: localStorage.getItem('planNo')
    }
  },
  props: {
    day: {
      type: String,
      required: true
    },
    planNum: {
      type: Number,
      default: 0
    },
    planPlace: {
      type: String,
      default: ''
    },
  },
  methods: {
    onSubmit(payload){
      const {friendId} = payload;
      console.log({friendId});

      axios.post('http://localhost:7777/plan/search', {friendId})
          .then((res) => {
            console.log(res + "성공!")
            //this.$store.commit('fetchFindMember', res.data)
            console.log(res.data)
            this.findId = res.data.memberId;
            this.findName = res.data.memberName;
          })
    },
    addFriend(payload){
      const{friendId} = payload;
      let planNo = this.planNo;

      alert(friendId + "얍!" + this.planNo)

      axios.post('http://localhost:7777/plan/addFriend', {friendId, planNo})
      .then((res) => {
        console.log(res.data + "성공!")
      })
    },
  },
  created() {

  },
  computed: {
  }
}
</script>

<style scoped>

</style>