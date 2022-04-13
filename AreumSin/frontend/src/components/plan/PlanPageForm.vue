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
          <tr v-for="(plans, index) in userPlans" :key="index">
            <table align="center" width="100%" border="1" @click="plansClick(index+1, plans)">
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

    }
  },
  methods: {
    plansClick(num, plan) {
      alert(num + "번 " + plan.planDate);
      alert(plan.planNo)

      let date = plan.planDate;

      let dateNum = date.split(/[-,~]/);

      console.log(dateNum);

      let year = dateNum[3] - dateNum[0];
      let month = dateNum[4] - dateNum[1];
      let day = dateNum[5] - dateNum[2] + 1;

      let lastDay = '';


      for (let i = 0; i < month; i++) {
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

      //alert(typeof dateNum)
      alert(day +"일 여행")

      this.$router.push({name: 'PlanView', params: { day: day.toString(), planNum: plan.planNo}})
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