<template>
  <v-container>
    <form>
      <table style="width: 100%" >
        <tr v-if="!dayContent || (Array.isArray(dayContent) && dayContent.length === 0)">
          <td colspan="3">
            등록된 내용이 없어요!
          </td>
        </tr>
        <tr v-for="(day, index) in dayContent" :key="index">
          <table align="center" style="width: 100%" >
            <tr>
<!--              <td>
                {{day.planDayNo}}
              </td>-->
              <td style="font-size: 20px">
                {{day.id}}
              </td>
            </tr>
            <tr>
              <td colspan="3">
                {{day.content}}
              </td>
            </tr>

            <tr>
              <td colspan="3" align="center" v-if="day.imgSrc">
                <div id="image">
                  <v-img :src="require(`@/assets/content/${day.imgSrc}`)" id="contain"></v-img>
                </div>
              </td>
<!--              <td colspan="2" align="center">
                <v-img :src="require(`@/assets/content/${day.imgSrc}`)" id="img"></v-img>
              </td>-->

            </tr>


            <tr>
              <v-row justify="end" style="margin-bottom: 15px; margin-right: 3px">
              <td>
                <v-btn icon @click="like(day)"><v-icon>mdi-thumb-up-outline</v-icon>{{day.likeCount}}</v-btn>
                &nbsp;
                <v-btn icon @click="hate(day.planDayNo)"><v-icon>mdi-thumb-down-outline</v-icon>{{day.hateCount}}</v-btn>
                &nbsp;
                <v-btn icon @click="remove(day.planDayNo)"><v-icon>mdi-delete</v-icon></v-btn>
              </td>
              </v-row>
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
    },
    dayContentImg: {
      type: Array,
    }
  },
  data() {
    return {
      id: localStorage.getItem("session")
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
#contain {
  object-fit: contain;
  width: 850px;
  height: 600px;
}
#image {
  background-color: rgba(0, 0, 0, 0.56);
}
</style>