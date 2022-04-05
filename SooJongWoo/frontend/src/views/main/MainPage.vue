<template>
  <div>
    <v-toolbar dense dark>
      <v-toolbar-items>
        <v-btn text v-for="link in links" :key="link.icon" :to="link.route">
          {{ link.text }}
        </v-btn>
      </v-toolbar-items>
    </v-toolbar>

    <div class="slide-3d">
      <v-app id="inspire">
        <v-container>
          <swiper class="swiper" :options="swiperOption">
            <swiper-slide>Slide 1</swiper-slide>
            <swiper-slide>Slide 2</swiper-slide>
            <swiper-slide>Slide 3</swiper-slide>
            <swiper-slide>Slide 4</swiper-slide>
            <div class="swiper-pagination" slot="pagination"></div>
            <div class="swiper-button-prev" slot="button-prev"></div>
            <div class="swiper-button-next" slot="button-next"></div>
          </swiper>
        </v-container>
      </v-app>
    </div>
  </div>
</template>

<script>
import "swiper/css/swiper.css";
import { Swiper, SwiperSlide } from "vue-awesome-swiper";

export default {
  name: "MainPage",
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      links: [
        { icon: "mdi-home", text: "Home", name: "home", route: "/" },
        { icon: "mdi-room", text: "객실안내", name: "room", route: "/" },
        {
          icon: "mdi-check",
          text: "예약안내",
          name: "reservation",
          route: "/",
        },
        { icon: "mdi-coffee", text: "부대시설", name: "service", route: "/" },
        { icon: "mdi-notice", text: "공지사항", name: "notice", route: "/" },
      ],
      swiperOption: {
        loop: true,
        centeredSlides: true,
        slidesPerview: "auto",
        effect: "fade",
        fadeEffect: {
          crossFade: true,
          speed: 5000,
          slidesPerview: 1,
        },
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
        navigation: {
          prevEl: ".swiper-button-prev",
          nextEl: ".swiper-button-next",
        },
        autoplay: {
          delay: 5000,
        },
      },
    };
  },
};
</script>

<style lang="scss" scoped>
@import "@/assets/style/SwiperStyle.scss";
</style>
