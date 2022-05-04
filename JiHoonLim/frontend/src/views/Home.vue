<template>
  <div>
    <v-container class="white" style="width: 1840px">
      <v-row>
        <v-col class="col">
          <div class="grey lighten-3">
            <v-container class="slide">
              <swiper class="swiper" :options="swiperOption">
                <swiper-slide v-for="image in images" :key="image">
                  <v-img :src="image"></v-img>
                </swiper-slide>
                <div class="swiper-pagination" slot="pagination"></div>
                <div class="swiper-button-prev" slot="button-prev"></div>
                <div class="swiper-button-next" slot="button-next"></div>
              </swiper>
            </v-container>
            <v-container class="pt-0 pb-0">
              <v-row>
                <v-col>
                  <v-card>
                    <div class="bottom_box">
                      <v-img
                        class="responseive-img img_box"
                        src="@/assets/img/bjw.jpg"
                      ></v-img>
                      <v-img
                        class="responseive-img img_box"
                        src="https://img3.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202105/21/plock/20210521204241383xorq.png"
                      ></v-img>
                      <!--<div class="text_box grey lighten-5">
                        <h2>백종원</h2>
                        <h3>( 골목식당 -- 명언 -- )</h3>
                        <p>
                          " 이 사회는 자기가 좋아하는 <br />일을 해야 행복하다.
                          "
                        </p>
                        <p>" 자신이 좋아하는 일에 <br />도전하길 바란다. "</p>
                      </div>
                      -->
                      <v-img
                        class="responsive-img img_box"
                        src="@/assets/img/bjw.jpg"
                        style="transform: scaleX(-1)"
                      ></v-img>
                    </div>
                  </v-card>
                </v-col>
              </v-row>
            </v-container>
          </div>
        </v-col>
      </v-row>
    </v-container>
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
        "http://ottogi.okitchen.co.kr/pds/upfile/2020-08-25_427865954[13].jpg",
        "http://ottogi.okitchen.co.kr/pds/upfile/2020-08-23_214060951[9].jpg",
        "http://ottogi.okitchen.co.kr/pds/upfile/2020-08-24_427854552[1].jpg",
      ],
      swiperOption: {
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
  width: 33%;
}

.col {
  padding: 0;
}
.slide {
  padding: 0;
  height: 700px;
  margin: 0;
}

.swiper {
  height: 100%;
  width: 100%;

  .swiper-slide {
    display: flex;
    justify-content: center;
    width: 100%;
    height: 100%;
    text-align: center;
  }
}
</style>
