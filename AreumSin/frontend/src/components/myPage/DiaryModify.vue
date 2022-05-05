<template>
  <v-container>
    <v-row justify="end" style="margin-bottom: 25px">
      <v-btn class="green white--text" @click="returnDiary" style="width: 120px; height: 50px; margin-right: 15px">돌아가기</v-btn>
      <v-btn class="red white--text" @click="modifyDiary" style="width: 120px; height: 50px; margin-right: 20px">수정 완료</v-btn>
    </v-row>

    <v-row>
      <table border="1" width="100%">
        <tr>
          <td>제목</td>
          <td><input type="text" v-model="title"></td>
        </tr>

        <tr>
          <td>여행 선택</td>
          <td>
            {{diary.planName}}
          </td>
        </tr>

        <tr>
          <td>내용</td>
          <td><textarea style="width: 100%; height: 620px" v-model="content"></textarea></td>
        </tr>
      </table>
    </v-row>

    <v-row v-for="(img,index) in diaryImg" :key="index">
      <v-col>
        <input type="checkbox" v-model="checkbox" :value="index">
        <v-img :src="require(`@/assets/diary/${img.diaryImgSrc}`)" id="img"></v-img>
      </v-col>
    </v-row>

  </v-container>
</template>

<script>

export default {
  name: "DiaryModify",
  props: {
    diary: {
      type: Object
    },
    diaryImg: {
      type: Array
    },
    diaryNo: {
      type: String
    }
  },
  data(){
    return{
      title: '',
      content: '',
      user: localStorage.getItem("session"),
      checkbox: [],
    }
  },
  methods: {
    returnDiary(){
      this.$router.push({name: 'MyPageDiaryRead', params: {diaryNo: this.diaryNo.toString()}})
    },
    modifyDiary(){
      let diaryImg = [];

      for(let i = 0;  i < this.checkbox.length; i++){
        diaryImg.push(this.diaryImg[this.checkbox[i]].diaryImgNo);
      }

      const {title, planName, content} = this;

      //alert(title + ", " + planName + ", " + content + ", " + diaryImg )

      this.$emit("onModify", {title, planName, content, diaryImg})
    }
  },
  created() {
    this.title = this.diary.title;
    this.planName = this.diary.palnName;
    this.content = this.diary.content;
  }
}
</script>

<style lang="scss" scoped>
table{
  border-collapse : collapse;
}
td{
  font-size: 30px;
}
.swiper {
  height: 900px;
  width: 100%;

  .swiper-slide {
    display: flex;
    justify-content: center;
    align-items: center;
  }
}
</style>