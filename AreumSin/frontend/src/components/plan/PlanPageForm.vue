<template>
  <div>
    <v-container>
      <v-row justify="center">
        <table align="center" border="1" width="100%">
          <!-- <tr>
            <td>여행 이름</td>
            <td>여행 날짜</td>
            <td>여행지</td>
          </tr> -->

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
      </v-row>
    </v-container>

    <v-container>
      <v-row justify="center">
        <div class="btn-cover">
          <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
            <v-icon>mdi-chevron-left</v-icon>
          </button>
          <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
          <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
            <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
              <v-icon>mdi-chevron-right</v-icon>
            </button>
          </button>
        </div>
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
      pageSize: 5
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
      let listLeng = this.userPlans.length, listSize = this.pageSize, page = Math.floor(listLeng / listSize);

      if (listLeng % listSize > 0) page += 1;

      /*
      아니면 page = Math.floor((listLeng - 1) / listSize) + 1;
      이런식으로 if 문 없이 고칠 수도 있다!
      */
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
</style>