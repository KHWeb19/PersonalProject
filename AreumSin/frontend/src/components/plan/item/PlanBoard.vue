<template>
  <v-container>
    <v-card class="pa-5">
      <v-row>
        <table width="100%" border="1">

          <tr v-if="!voteContents || (Array.isArray(voteContents) && voteContents.length === 0)">
            투표한 내용이 없습니다!
          </tr>

          <tr v-for="vote in voteContents" :key="vote.voteNo">
            <td>{{vote.voteNo}}</td>
            <td>{{vote.voteContent}}</td>
            <td><v-btn @click="voteGood(vote.voteNo)"><v-icon>mdi-thumb-up-outline</v-icon></v-btn>{{vote.agreement}}</td>
            <td><v-btn @click="voteBad(vote.voteNo)"><v-icon>mdi-thumb-down-outline</v-icon></v-btn>{{vote.opposition}}</td>
          </tr>
        </table>
      </v-row>
    </v-card>

  </v-container>
</template>

<script>
import {mapActions, mapState} from "vuex";

export default {
  name: "PlanBoard",
  data(){
    return{

    }
  },
  created() {
    this.planNo = localStorage.getItem('planNo')
    alert(this.planNo)
  },
  methods: {
    ...mapActions(['fetchVoteContent']),
    voteGood(voteNo){
      console.log(voteNo);
      this.$emit('voteGood', {voteNo});
    },
    voteBad(voteNo){
      console.log(voteNo);
      this.$emit('voteBad', {voteNo});
    }
  },
  computed:{
    ...mapState(['voteContents'])
  },
  mounted() {
    this.fetchVoteContent(this.planNo)
  },
}
</script>

<style scoped>
p{
  font-size: 30px;
}
</style>