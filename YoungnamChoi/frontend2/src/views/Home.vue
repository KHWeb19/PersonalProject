<template>
  <div class="slide-3d">
    <v-app id="inspire">
      <v-container>
        <swiper class="swiper" :options="swiperOption">
          <swiper-slide class="s1"></swiper-slide>
          <swiper-slide class="s2"></swiper-slide>
          <swiper-slide class="s3"></swiper-slide>
          <swiper-slide class="s4"></swiper-slide>
          <swiper-slide class="s5"></swiper-slide>
          <swiper-slide class="s6"></swiper-slide>
          <swiper-slide class="s7"></swiper-slide>
          <swiper-slide class="s8"></swiper-slide>

          <div class="swiper-pagination" slot="pagination"></div>
        </swiper>
        <home-page></home-page>
      </v-container>
    </v-app>
  </div>
</template>

<script>
import { Swiper, SwiperSlide } from "vue-awesome-swiper";
import "swiper/css/swiper.css";
import HomePage from "../components/main/HomePage.vue";

export default {
  name: "Home",
  components: {
    Swiper,
    SwiperSlide,
    HomePage,
  },
  data() {
    return {
      swiperOption: {
        loop: true,
        effect: "coverflow",
        grabCursor: true,
        centeredSlides: true,
        slidesPerView: "auto",
        coverflowEffect: {
          rotation: 50,
          stretch: 0,
          depth: 100,
          // 회전을 많이 먹이고 싶은 경우 높이도록 한다.
          modifier: 1,
          slideShadows: true,
        },
        pagination: {
          el: ".swiper-pagination",
          dynamicBullets: true,
        },
        autoplay: {
          delay: 1000,
        },
      },
    };
  },
};
</script>

<style lang="scss" scoped>
.slide-3d {
  width: 100%;
  height: 400px;
  padding-top: 50px;
  padding-bottom: 50px;
}

.swiper {
  height: 100%;
  width: 100%;

  .swiper-slide {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 300px;
    height: 300px;
    text-align: center;
    font-weight: bold;
    font-size: 1.7rem;
    background-position: center;
    background-size: cover;

    &.s1 {
      background-image: url("../assets/imgs/s2.jpg");
    }
    &.s2 {
      background-image: url("../assets/imgs/s6.jpg");
    }
    &.s3 {
      background-image: url("../assets/imgs/s1.jpg");
    }
    &.s4 {
      background-image: url("../assets/imgs/s3.jpg");
    }
    &.s5 {
      background-image: url("../assets/imgs/s2.jpg");
    }
    &.s6 {
      background-image: url("../assets/imgs/s4.jpg");
    }
    &.s7 {
      background-image: url("../assets/imgs/s8.jpg");
    }
    &.s8 {
      background-image: url("../assets/imgs/s7.jpg");
    }
  }
}
</style>
