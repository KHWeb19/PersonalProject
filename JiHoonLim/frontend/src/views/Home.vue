<template>
  <div>
    <v-container class="slide">
      <swiper class="swiper" :options="swiperOption">
        <swiper-slide v-for="image in images" :key="image">
          <v-img :src="image" max-width="100%"></v-img>
        </swiper-slide>
        <div class="swiper-pagination" slot="pagination"></div>
        <div class="swiper-button-prev" slot="button-prev"></div>
        <div class="swiper-button-next" slot="button-next"></div>
      </swiper>
    </v-container>

    <div class="bottom_box">
      <span class="img_box">
        <v-img class="responseive-img" src="@/assets/img/bjw.jpg"></v-img>
      </span>
      <span class="text_box grey lighten-5">
        <h2>백종원</h2>
        <h3>( 골목식당 -- 명언 -- )</h3>
        <p>" 이 사회는 자기가 좋아하는 <br />일을 해야 행복하다. "</p>
        <p>" 자신이 좋아하는 일에 <br />도전하길 바란다. "</p>
      </span>
      <span class="img_box">
        <v-img
          class="responsive-img"
          src="@/assets/img/bjw.jpg"
          style="transform: scaleX(-1)"
        ></v-img>
      </span>
    </div>
  </div>
</template>

<script>
import { swiper, swiperSlide } from "vue-awesome-swiper";
import "swiper/dist/css/swiper.css";

export default {
  name: "Home",
  components: {
    swiper,
    swiperSlide,
  },
  data() {
    return {
      images: [
        "https://img.hani.co.kr/imgdb/resize/2019/0531/00502615_20190531.JPG",
        "https://static.hubzum.zumst.com/hubzum/2018/02/14/09/21aeae60c28f46268e6be882ff4a46a7.jpg",
        "https://t1.daumcdn.net/cfile/tistory/995BAE345C17421B11",
      ],
      swiperOption: {
        loopedSlides: 2,
        grabCursor: true,
        centeredSlides: true,
        slidesPerView: "auto",
        effect: "fade",
        pagination: { el: ".swiper-pagination", clickable: true },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
        autoplay: {
          delay: 3000,
          disableOnInteraction: false,
        },
      },
    };
  },
};
</script>

<style lang="scss" scoped>
.bottom_box {
  display: flex;
  justify-content: center;
}

.img_box {
  width: 38%;
}
.text_box {
  display: flex;
  flex-direction: column;
  width: 30%;
  text-align: center;

  background-size: cover;
}
.text_box h2 {
  font-family: fantasy;
  font-size: 45px;
  margin-top: 100px;
  margin-bottom: 10px;
}
.text_box h3 {
  font-family: fantasy;
  font-size: 20px;
  margin-bottom: 90px;
}
.text_box p {
  font-family: fantasy;
  font-size: 22.5px;
  font-weight: bold;
}

.slide {
  padding: 0;
  height: 700px;
  margin-left: 0;
}

.swiper {
  height: 100%;
  width: 99.8vw;

  .swiper-slide {
    display: flex;
    justify-content: center;
    width: 100%;
    height: 100%;
    text-align: center;
    font-weight: bold;
    font-size: 3rem;
    background-position: center;
    background-size: center;
  }
}
</style>
