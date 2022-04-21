<template>
  <v-container>
    <form>
      <table>
        <tr v-if="!dayContent || (Array.isArray(dayContent) && dayContent.length === 0)">
          <td colspan="3">
            등록된 내용이 없어요!
          </td>
        </tr>
        <tr v-for="(day, index) in dayContent" :key="index">
          <table align="center" width="100%" border="1">
            <tr>
              <td>
                {{day.planDayNo}}
              </td>
              <td>
                {{day.id}}
              </td>
            </tr>
            <tr>
              <td colspan="3">
                {{day.content}}
              </td>
            </tr>

            <tr>
              <td>
                <v-btn @click="like(day)"><v-icon>mdi-thumb-up-outline</v-icon>{{day.likeCount}}</v-btn>
              </td>
              <td>
                <v-btn @click="hate(day.planDayNo)"><v-icon>mdi-thumb-down-outline</v-icon>{{day.hateCount}}</v-btn>
              </td>
              <td>
                <v-btn @click="remove(day.planDayNo)"><v-icon>mdi-delete</v-icon></v-btn>
              </td>
            </tr>
          </table>
        </tr>
      </table>
    </form>
  </v-container>
</template>

<script>
export default {
  name: "ContentList",
  props: {
    dayContent: {
      type: Array,
    }
  },
  data() {
    return {

    }
  },
  methods: {
    like(day) {
      let planDayNo = day.planDayNo;
      console.log(planDayNo)
      this.$emit('clickLike', {planDayNo})
    },
    hate(planDayNo) {
      console.log(planDayNo)
      this.$emit('clickHate', {planDayNo})
    },
    remove(planDayNo) {
      console.log(planDayNo)
      this.$emit('clickRemove', {planDayNo})
    }
  }
}
</script>

<style scoped>
td{
  font-size: 35px;
}
</style>