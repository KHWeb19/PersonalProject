<template>
  <v-container>
    <v-row justify="end">
      <v-btn class="red white--text" style="margin-bottom: 35px; margin-right: 5px" @click="onModify" :disabled="isMember === false" >게시글 수정</v-btn>
      <v-btn class="red white--text" style="margin-bottom: 35px; margin-right: 5px" @click="onDelete" :disabled="isMember === false" >게시글 삭제</v-btn>
    </v-row>

    <v-card class="pa-10">
      <v-row>
        <v-col cols="3">제목</v-col>
        <v-col cols="9">{{boardRead.title}}</v-col>
      </v-row>

      <v-row>
        <v-col cols="3">장소</v-col>
        <v-col cols="9">{{boardRead.place}}</v-col>
      </v-row>

      <v-row>
        <v-col cols="3">작성자</v-col>
        <v-col cols="9">{{boardRead.writer}}</v-col>
      </v-row>

      <v-row>
        <v-col cols="3">내용</v-col>
        <v-col>{{boardRead.boardContent}}</v-col>
      </v-row>


      <v-row v-if="!boardReadImg">
        이미지는 없어요!
      </v-row>

      <v-row v-else>
        <swiper class="swiper" :options="swiperOption">
          <swiper-slide v-for="(boardImg,index) in boardReadImg" :key="index">
            <v-img :src="require(`@/assets/uploadImg/${boardImg.imgSrc}`)" id="img"></v-img>
          </swiper-slide>

          <div class="swiper-pagination" slot="pagination"></div>
          <div class="swiper-button-prev" slot="button-prev"></div>
          <div class="swiper-button-next" slot="button-next"></div>
        </swiper>
      </v-row>
    </v-card>

    <hr/>


  </v-container>
</template>

<script>
import 'swiper/css/swiper.css'
import {Swiper, SwiperSlide} from "vue-awesome-swiper";

export default {
  name: "BoardReadPage",
  components:{
    Swiper, SwiperSlide
  },
  props: {
    boardRead: {
      type: Object,
      required: true
    },
    boardReadImg: {
      type: Array
    },
    isMember: {
      type: Boolean
    }
  },
  methods:{
    onDelete(){
      this.$emit('onDelete')
    },
    onModify(){
      this.$emit('onModify')
    }
  },
  data () {
    return {
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
  }
}
</script>

<style lang="scss" scoped>
*{
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

#img {
  width: auto; height: auto;
  max-width: 1200px;
  max-height: 900px;
}

</style>