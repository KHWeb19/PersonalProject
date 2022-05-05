<template>
  <v-container>
    <v-row justify="end" style="margin-bottom: 25px">
      <v-btn class="green white--text" @click="modifyDiary" style="width: 120px; height: 50px; margin-right: 20px">수정</v-btn>
      <v-btn class="green white--text" @click="deleteDiary" style="width: 120px; height: 50px">삭제</v-btn>
    </v-row>

    <v-row>
      <table border="1" width="100%">
        <tr>
          <td>제목</td>
          <td>{{diary.title}}</td>
        </tr>

        <tr>
          <td>여행 선택</td>
          <td>
            {{diary.planName}}
          </td>
        </tr>

        <tr>
          <td>내용</td>
          <td><textarea style="width: 100%; height: 620px" :value="diary.content" :disabled="true"></textarea></td>
        </tr>
      </table>
    </v-row>

    <v-row style="margin-top: 80px">
      <swiper class="swiper" :options="swiperOption">
        <swiper-slide v-for="(diary,index) in diaryImg" :key="index">
          <v-img :src="require(`@/assets/diary/${diary.diaryImgSrc}`)" id="img"></v-img>
        </swiper-slide>

        <div class="swiper-pagination" slot="pagination"></div>
        <div class="swiper-button-prev" slot="button-prev"></div>
        <div class="swiper-button-next" slot="button-next"></div>
      </swiper>
    </v-row>

  </v-container>
</template>

<script>
import 'swiper/css/swiper.css'
import {Swiper, SwiperSlide} from "vue-awesome-swiper";

export default {
  name: "DiaryRead",
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
  components:{
    Swiper, SwiperSlide
  },
  data(){
    return{
      title: '',
      content: '',
      user: localStorage.getItem("session"),
      swiperOption: {
        slidesPerView: 1,
        spaceBetween: 30,
        autoHeight: true,
        loop: false,
        pagination: {
          el: '.swiper-pagination',
          clickable: true
        },
        navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev'
        }
      }
    }
  },
  methods: {
    modifyDiary(){
      //alert(this.diaryNo)
      this.$router.push({name: 'MyPageDiaryModify', params: {diaryNo: this.diaryNo.toString()}})
    },
    deleteDiary(){
      this.$emit("onDelete")
    }
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