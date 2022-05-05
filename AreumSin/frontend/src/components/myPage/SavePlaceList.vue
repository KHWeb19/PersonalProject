<template>
  <v-container>
    <v-row id="wrapper">
      <v-col>
        <table border="1" width="100%">
          <tr>
            <td>번호</td>
            <td>장소 이름</td>
            <td>일정 이름</td>
            <td>지역</td>
          </tr>

          <tr v-if="!savePlace">
            내용이 없음!
          </tr>
          <tr v-else v-for="(place, index) in paginatedData" :key="index">
            <td>{{index+1}}</td>
            <td>{{ place.placeName }}</td>
            <td>{{ place.planName }}</td>
            <td>{{ place.place }}</td>
<!--              <td align="center">
                <v-icon color="red">
                  mdi-cards-heart
                </v-icon>
              </td>-->
          </tr>
        </table>
      </v-col>
    </v-row>

    <v-row id="pageNum" justify="center">
      <v-btn :disabled="pageNum === 0" @click="prevPage" icon><v-icon>mdi-chevron-left</v-icon></v-btn>
      <span id="page">&nbsp;&nbsp;{{pageNum +1 }}  /  {{pageCount}}&nbsp;&nbsp;</span>
      <v-btn :disabled="pageNum >= pageCount -1" @click="nextPage" icon><v-icon>mdi-chevron-right</v-icon></v-btn>
    </v-row>

  </v-container>
</template>

<script>
export default {
  name: "SavePlaceList",
  props: {
    savePlace: {
      type: Array
    }
  },
  data(){
    return {
      pageNum: 0,
      pageSize: 8
    }
  },
  methods: {
    nextPage () {
      this.pageNum += 1;
    },
    prevPage () {
      this.pageNum -= 1;
    }
  },
  computed: {
    pageCount() {
      let listLeng = this.savePlace.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);

      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData() {
      const start = this.pageNum * this.pageSize,
          end = start + this.pageSize;
      return this.savePlace.slice(start, end);
    },
  }
}
</script>

<style scoped>
table{
  border-collapse : collapse;
}
td {
  font-size: 30px;
}
#wrapper{
  height: 810px;
  min-height: 100%;
  padding-bottom: 30px;
}
#pageNum{
  height: 20px;
  position : relative;
  transform : translateY(-100%);
}
</style>