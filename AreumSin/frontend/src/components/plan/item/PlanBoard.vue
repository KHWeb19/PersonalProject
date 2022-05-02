<template>
  <v-container>
    <v-card class="pa-5">
      <v-row id="wrapper">
        <table width="100%">

          <tr v-if="!voteContents || (Array.isArray(voteContents) && voteContents.length === 0)">
            투표한 내용이 없습니다!
          </tr>

          <tr v-for="vote in paginatedData" :key="vote.voteNo">
<!--            <td style="font-size: 25px">{{vote.voteNo}}</td>-->
            <td style="font-size: 25px">{{vote.voteContent}}</td>
            <td><v-btn @click="voteGood(vote.voteNo)" icon><v-icon>mdi-thumb-up-outline</v-icon></v-btn>{{vote.agreement}}</td>
            <td><v-btn @click="voteBad(vote.voteNo)" icon><v-icon>mdi-thumb-down-outline</v-icon></v-btn>{{vote.opposition}}</td>
          </tr>
        </table>
      </v-row>

      <v-row id="pageNum" justify="center">
        <v-btn :disabled="pageNum === 0" @click="prevPage" icon><v-icon>mdi-chevron-left</v-icon></v-btn>
        <span id="page">&nbsp;&nbsp;{{pageNum +1 }}  /  {{pageCount}}&nbsp;&nbsp;</span>
        <v-btn :disabled="pageNum >= pageCount -1" @click="nextPage" icon><v-icon>mdi-chevron-right</v-icon></v-btn>
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
      pageNum: 0,
      pageSize: 4
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
    },
    nextPage () {
      this.pageNum += 1;
    },
    prevPage () {
      this.pageNum -= 1;
    }
  },
  computed:{
    ...mapState(['voteContents']),
    pageCount() {
      let listLeng = this.voteContents.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);

      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData() {
      const start = this.pageNum * this.pageSize,
          end = start + this.pageSize;
      return this.voteContents.slice(start, end);
    },
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
#wrapper{
  height: 225px;
  min-height: 100%;
  padding-bottom: 30px;
}
#pageNum{
  height: 20px;
  position : relative;
  transform : translateY(-100%);
}
</style>