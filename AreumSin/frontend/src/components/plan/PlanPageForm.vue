<template>
  <div>
    <v-container style="margin-top: 100px">
      <v-row id="wrapper">
        <v-col v-if="!userPlans || (Array.isArray(userPlans) && userPlans.length === 0)">
            등룍된 여행지가 없습니다!
        </v-col>

        <v-col cols="3" v-else v-for="(plans, index) in paginatedData" :key="index">
          <v-card style="width: 100%">
            <table align="center" @click="plansClick(plans)">
              <tr>
                <td colspan="2" align="center">
                  <img id="bgimg" class="pa-3" src="@/assets/281acb1b7f6147bfa55caa09410caa71.jpg" alt=""/>
                </td>
              </tr>
              <tr>
                <td>
                  {{plans.planName}}
                  </td>
                </tr>

              <tr>
                <td>
                  {{plans.planDate}}
                </td>
              </tr>

              <tr>
                <td id="lastTable">
                  <img src="../../assets/location.png" height="30">&nbsp;&nbsp; {{plans.placeName}}
                </td>
              </tr>
            </table>
          </v-card>
        </v-col>
      </v-row>

<!--      <v-row justify="center" id="wrapper">
        <table align="center" width="100%">
          &lt;!&ndash; <tr>
            <td>여행 이름</td>
            <td>여행 날짜</td>
            <td>여행지</td>
          </tr> &ndash;&gt;

          <tr v-if="!userPlans || (Array.isArray(userPlans) && userPlans.length === 0)">
            <td colspan="3">
              등룍된 여행지가 없습니다!
            </td>
          </tr>
          <tr v-for="(plans, index) in paginatedData" :key="index">
            <table align="center" width="100%" border="1" @click="plansClick(plans)">
              <tr>
                <td>
                  {{plans.planName}}
                </td>
              </tr>

              <tr>
                <td>
                  {{plans.planDate}}
                </td>
              </tr>

              <tr>
                <td id="lastTable">
                  <img src="../../assets/location.png" height="30">&nbsp;&nbsp; {{plans.placeName}}
                </td>
              </tr>
            </table>
          </tr>
        </table>
      </v-row>-->
    </v-container>

    <v-container>
      <v-row id="pageNum" justify="center">
        <v-btn :disabled="pageNum === 0" @click="prevPage">이전</v-btn>
        <span id="page">&nbsp;&nbsp;{{pageNum +1 }}  /  {{pageCount}}&nbsp;&nbsp;</span>
        <v-btn :disabled="pageNum >= pageCount -1" @click="nextPage">다음</v-btn>
      </v-row>
    </v-container>
  </div>
</template>

<script>

export default {
  name: "PlanPageForm",
  props: {
    userPlans: {
      type: Array
    }
  },
  data(){
    return{
      pageNum: 0,
      pageSize: 4
    }
  },
  methods: {
    plansClick(plan) {
      // alert(num + "번 " + plan.planDate);
      // alert(plan.planNo)

      let date = plan.planDate;

      let dateNum = date.split(/[-,~]/);

      console.log(dateNum);

      let year = dateNum[3] - dateNum[0]; // 0
      let month = dateNum[4] - dateNum[1]; // 5 - 3 = 2
      // let day = dateNum[5] - dateNum[2] + 1; //
      let day = dateNum[5] > dateNum[2] ? dateNum[5] - dateNum[2] +1 : dateNum[2] - dateNum[5] +1; // 14 - 6 +1 = 9

      let lastDay = '';

        switch (dateNum[1]) {
          case 1:
          case 3:
          case 5:
          case 7:
          case 8:
          case 10:
          case 12:
            lastDay = 31;
            break;

          case 2:
            lastDay = 28;
            break;

          default:
            lastDay = 30;
            break;

        }

      //alert(day + "일" + lastDay +"마지막 날" + year + "년" + month +"달")

      if(year !== 0){
        day += year * 365;
        console.log(day+"year")
      }
      if(month !== 0){
        day = lastDay - dateNum[2] + Number(dateNum[5]) +1;
        //console.log(day)
      }

      //alert(lastDay)
      //alert(day +"일 여행" + plan.planNo +"번호" + plan.placeName)
      let planNo = plan.planNo;
 /*     let monthDay = month
      let lastMonthDay = lastDay;
      let lastDay = dateNum[5];
      let startDay = dateNum[2];
*/
      //let makeTable = [Number(dateNum[1]), Number(dateNum[5]), Number(dateNum[2]), Number(lastDay), Number(month)];
      //alert(makeTable)
      localStorage.setItem('planNo', planNo);
      localStorage.setItem('placeName', plan.placeName);
      localStorage.setItem('startMonth', Number(dateNum[1]));
      localStorage.setItem('firstDay', Number(dateNum[2]));
      localStorage.setItem('lastDay', Number(dateNum[5]));
      localStorage.setItem('lastMonthDay', Number(lastDay));
      localStorage.setItem('monthDay', Number(month));
      // 구현 후 db에 저장해서 값 가져오도록하자.

      // localStorage.setItem('makeTable', makeTable)
      // localStorage.setItem('makeTables', Number(dateNum[1]), Number(dateNum[5]), Number(dateNum[2]), Number(lastDay), Number(month))

      // const payload = [Number(dateNum[1]), Number(dateNum[5]), Number(dateNum[2]), Number(lastDay), Number(month)]


      this.$router.push({name: 'PlanView', params: { day: day.toString(), planPlace: plan.placeName}})
    },
    nextPage () {
      this.pageNum += 1;
    },
    prevPage () {
      this.pageNum -= 1;
    }
  },
  computed: {
    pageCount() {
      let listLeng = this.userPlans.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);

      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData() {
      const start = this.pageNum * this.pageSize,
          end = start + this.pageSize;
      return this.userPlans.slice(start, end);
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
}
#lastTable{
  padding-bottom: 30px;
}
#wrapper{
  height: 650px;
  min-height: 100%;
  padding-bottom: 30px;
}
#pageNum{
  height: 30px;
  position : relative;
  transform : translateY(-100%);
}
#page{
  font-size: 20px;
}
#bgimg{
  width: 400px;
}
</style>