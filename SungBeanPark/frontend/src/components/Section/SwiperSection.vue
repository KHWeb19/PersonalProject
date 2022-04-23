<template>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-sm-4">
          <section class="product-section">
            <div class="product-container">
              <div class="product-swiper">
                <h3>Featured Shoes</h3>
              </div>
              <swiper
                class="swiper-container"
                ref="filterSwiper"
                :options="swiperOption"
                role="tablist"
              >
                <swiper-slide class="swiper" role="tab"
                  ><a href="">
                    <img
                      src="https://static-breeze.nike.co.kr/kr/ko_kr//cmsstatic/structured-content/65250/220223_hp_p8_bg1.jpg"
                      alt=""
                    />
                  </a>
                  <button><i class="ic-bookmark"></i></button>
                  <div>
                    <a href="">
                      <h4>나이키 에어맥스</h4>
                      <p>남성신발</p>
                      <p>199,000</p></a
                    >
                  </div>
                </swiper-slide>
                <swiper-slide class="swiper" role="tab"
                  ><a href="">
                    <img
                      src="https://static-breeze.nike.co.kr/kr/ko_kr//cmsstatic/structured-content/65250/220223_hp_p8_bg7.jpg"
                      alt=""
                    />
                  </a>
                  <button><i class="ic-bookmark"></i></button>
                  <div>
                    <a href="">
                      <h4>나이키 에어맥스</h4>
                      <p>남성신발</p>
                      <p>199,000</p></a
                    >
                  </div>
                </swiper-slide>
                <swiper-slide class="swiper" role="tab"
                  ><a href="">
                    <img
                      src="https://static-breeze.nike.co.kr/kr/ko_kr//cmsstatic/structured-content/65250/220223_hp_p8_bg8.jpg"
                      alt=""
                    />
                  </a>
                  <button><i class="ic-bookmark"></i></button>
                  <div>
                    <a href="">
                      <h4>나이키 에어맥스</h4>
                      <p>남성신발</p>
                      <p>199,000</p></a
                    >
                  </div>
                </swiper-slide>
                <swiper-slide class="swiper" role="tab"
                  ><a href="">
                    <img
                      src="https://static-breeze.nike.co.kr/kr/ko_kr//cmsstatic/structured-content/65250/220223_hp_p8_bg1.jpg"
                      alt=""
                    />
                  </a>
                  <button><i class="ic-bookmark"></i></button>
                  <div>
                    <a href="">
                      <h4>나이키 에어맥스</h4>
                      <p>남성신발</p>
                      <p>199,000</p></a
                    >
                  </div>
                </swiper-slide>
                <swiper-slide class="swiper" role="tab"
                  ><a href="">
                    <img
                      src="https://static-breeze.nike.co.kr/kr/ko_kr//cmsstatic/structured-content/65250/220223_hp_p8_bg9.jpg"
                      alt=""
                    />
                  </a>
                  <button><i class="ic-bookmark"></i></button>
                  <div>
                    <a href="">
                      <h4>나이키 에어맥스</h4>
                      <p>남성신발</p>
                      <p>199,000</p></a
                    >
                  </div>
                </swiper-slide>
                <swiper-slide class="swiper" role="tab"
                  ><a href="">
                    <img
                      src="https://static-breeze.nike.co.kr/kr/ko_kr//cmsstatic/structured-content/65250/220223_hp_p8_bg3.jpg"
                      alt=""
                    />
                  </a>
                  <button><i class="ic-bookmark"></i></button>
                  <div>
                    <a href="">
                      <h4>나이키 에어맥스</h4>
                      <p>남성신발</p>
                      <p>199,000</p></a
                    >
                  </div>
                </swiper-slide>
                <swiper-slide class="swiper" role="tab"
                  ><a href="">
                    <img
                      src="https://static-breeze.nike.co.kr/kr/ko_kr//cmsstatic/structured-content/65250/220223_hp_p8_bg2-1.jpg"
                      alt=""
                    />
                  </a>
                  <button><i class="ic-bookmark"></i></button>
                  <div>
                    <a href="">
                      <h4>나이키 에어맥스</h4>
                      <p>남성신발</p>
                      <p>199,000</p></a
                    >
                  </div>
                </swiper-slide>
                <swiper-slide class="swiper" role="tab"
                  ><a href="">
                    <img
                      src="https://static-breeze.nike.co.kr/kr/ko_kr//cmsstatic/structured-content/65250/220223_hp_p8_bg1.jpg"
                      alt=""
                    />
                  </a>
                  <button><i class="ic-bookmark"></i></button>
                  <div>
                    <a href="">
                      <h4>나이키 에어맥스</h4>
                      <p>남성신발</p>
                      <p>199,000</p></a
                    >
                  </div>
                </swiper-slide>
                <swiper-slide class="swiper" role="tab"
                  ><a href="">
                    <img
                      src="https://static-breeze.nike.co.kr/kr/ko_kr//cmsstatic/structured-content/65250/220223_hp_p8_bg1.jpg"
                      alt=""
                    />
                  </a>
                  <button><i class="ic-bookmark"></i></button>
                  <div>
                    <a href="">
                      <h4>나이키 에어맥스</h4>
                      <p>남성신발</p>
                      <p>199,000</p></a
                    >
                  </div>
                </swiper-slide>
              </swiper>
            </div>
          </section>
        </div>
      </div>
    </div>
  </body>
</template>
<script>
import { swiper, swiperSlide } from "vue-awesome-swiper"
import "swiper/dist/css/swiper.min.css"
export default {
  name: "SwiperSection",
  data() {
    return {
      swiperOption: {
        slidesPerView: "auto",
        spaceBetween: 8,
        slidesOffsetBefore: 0,
        slidesOffsetAfter: 0,
        freeMode: true,
        centerInsufficientSlides: true,
        loop: true,
        autoplay: {
          delay: 1000,
        },
      },
    }
  },
  components: {
    swiper,
    swiperSlide,
  },
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/components/swiper";
</style>
