<template>
  <div>
    <v-container>
      <table align="center">
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
        <tr v-for="plans in userPlans" :key="plans.planNo">
          <table align="center">
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

            <tr id="lastTable">
              <td>
                <img src="../../assets/location.png" height="30">&nbsp;&nbsp; {{plans.placeName}}
              </td>
            </tr>

            <tr v-for="index in 20" :key="index">
              <td></td>
            </tr>
          </table>
        </tr>
      </table>
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
  }
}
</script>

<style scoped>
td{
  font-size: 30px;

}
</style>