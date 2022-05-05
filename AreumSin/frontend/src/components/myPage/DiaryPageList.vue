<template>
  <v-container>
    <v-row justify="end">
      <v-btn class="red white--text" @click="writeDiary">일기 작성</v-btn>
    </v-row>
    <v-row justify="center" id="wrapper">
        <v-col v-if="!diaryList || (Array.isArray(diaryList) && diaryList.length === 0)">
          내용이 없습니다!!!
        </v-col>

        <v-col cols="5" v-else v-for="diary in paginatedData" :key="diary.diaryNo">
          <v-card style="height: 320px; width: 800px" @click="showDetail(diary)">
            <table style="width: 100%">
              <tr>
                <td colspan="2" align="center">
                  <v-img :src="require(`@/assets/diary/${diary.diarySrc}`)" id="img"></v-img>
                </td>
              </tr>
              <tr>
                <td style="width: 25%; height: 75%">&nbsp;&nbsp;&nbsp;제목</td>
                <td>&nbsp;&nbsp;&nbsp;{{ diary.title }}</td>
              </tr>

              <tr>
                <td style="width: 35%; height: 75%;">&nbsp;&nbsp;&nbsp;일정 이름 </td>
                <td>&nbsp;&nbsp;&nbsp;{{ diary.planName }}</td>
              </tr>

            </table>
          </v-card>
        </v-col>
    </v-row>

    <v-row id="pageNum" justify="center">
      <v-btn :disabled="pageNum === 0" @click="prevPage">이전</v-btn>
      <span id="page">&nbsp;&nbsp;{{pageNum +1 }}  /  {{pageCount}}&nbsp;&nbsp;</span>
      <v-btn :disabled="pageNum >= pageCount -1" @click="nextPage">다음</v-btn>
    </v-row>

  </v-container>
</template>

<script>
export default {
  name: "DiaryPageList",
  props:{
    diaryList: {
      type: Array,
    }
  },
  data(){
    return{
      pageNum: 0,
      pageSize: 4,
    }
  },
  methods: {
    writeDiary(){
      this.$router.push({name: 'MyPageKeepADiary'})
    },
    nextPage () {
      this.pageNum += 1;
    },
    prevPage () {
      this.pageNum -= 1;
    },
    showDetail(diary){
      //alert(diary.diaryNo);
      this.$router.push({name: 'MyPageDiaryRead', params: {diaryNo: diary.diaryNo.toString()}})
    }
  },
  computed: {
    pageCount(){
      let listLeng = this.diaryList.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);

      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize,
          end = start + this.pageSize;
      return this.diaryList.slice(start, end);
    }
  }
}
</script>

<style scoped>
#img{
  width: 340px;
  height: 220px;
  display: block;
  margin-bottom: 15px;
}
td {
  font-size: 25px;
}
#wrapper{
  height: 770px;
  min-height: 100%;
  padding-bottom: 30px;
  padding-top: 20px;
}
#pageNum{
  height: 30px;
  position : relative;
  transform : translateY(-100%);
}
</style>