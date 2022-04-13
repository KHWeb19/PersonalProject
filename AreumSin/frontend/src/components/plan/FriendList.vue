<template>
  <v-container>
    <v-card>
      <table>
        <tr>
          <td>초대된 사람</td>
        </tr>

        <tr v-for="member in inviteMember" :key="member.memberId">
          <td>{{ member.memberId }}</td>
          <td>{{ member.memberName}}</td>
          <td>{{ member.memberColor}}</td>

        </tr>
      </table>
      <v-btn @click="clickEvent">클릭</v-btn>
    </v-card>
  </v-container>
</template>

<script>
import {mapActions, mapState} from "vuex";

export default {
  name: "FriendList",
  data() {
    return{
    }
  },
  props:{
    planNo: {
      type: Number,
    }
  },
  computed:{
    ...mapState(['inviteMember'])
  },
  mounted() {
    this.fetchInviteMember(this.planNo)
  },
  methods: {
    ...mapActions(['fetchInviteMember']),
    clickEvent(){
      alert(this.inviteMember)
      alert(this.members)
    }
  }
}
</script>

<style scoped>

</style>