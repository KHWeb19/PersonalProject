<template>
  <v-container>
    <v-row class="ps-2">
      <v-col>
        <v-card class="pa-8" id="friend">

          <table width="100%">
            <tr>
              <td colspan="2">초대된 사람</td>
            </tr>

            <tr v-for="member in inviteMember" :key="member.memberId">
              <td>{{ member.memberName}}</td>
              <!-- <td>{{ member.memberColor}}</td> -->
            </tr>
          </table>

        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import {mapActions, mapState} from "vuex";
import EventBus from "@/eventBus";

export default {
  name: "FriendList",
  data() {
    return{
      planNumber: 0,
      member: null,
    }
  },
  props:{
    planNo: {
      type: Number,
    }
  },
  created() {
    this.planNumber = localStorage.getItem('planNo')
    alert(this.planNumber)
  },
  computed:{
    ...mapState(['inviteMember'])
  },
  mounted() {
    this.fetchInviteMember(this.planNumber)
  },
  methods: {
    ...mapActions(['fetchInviteMember']),
    clickEvent(){
      EventBus.$emit('event', '안녕');
      alert(this.inviteMember)
      alert(this.members)
    }
  }
}
</script>

<style scoped>

td{
  font-size: 30px;
  border-top: none;
  border-left: none;
  border-right: none;
  border-bottom: none;
  padding-left: 10px;
  text-align: center;
}
#friend {
  height: 260px;
}
</style>