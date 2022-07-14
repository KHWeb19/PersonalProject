<template>
  <div>
    <v-container class="slide">
      <swiper class="swiper" :options="swiperOption">
        <swiper-slide v-for="image in images" :key="image">
          <v-img :src="image" max-height="100%"></v-img>
        </swiper-slide>
        <div class="swiper-pagination" slot="pagination"></div>
        <div class="swiper-button-prev" slot="button-prev"></div>
        <div class="swiper-button-next" slot="button-next"></div>
      </swiper>
    </v-container>

    <v-container class="about-top">
      <h1>Special Service</h1>
      <p>#카페 #바베큐</p>
    </v-container>
    <v-divider></v-divider>

    <div class="intro-room01">
      <div class="container">
        <v-container class="room301-img-01">
          <h2>Special Service</h2>
          <v-img style="overflow: visible"> </v-img>
        </v-container>
      </div>

      <div class="container">
        <div class="overlay1">
          <h5 class="info-top-title">
            <b>Cafe <br />카페</b>
          </h5>
          <ul>
            <li>아메리카노</li>
            <li>카페라떼</li>
            <li>디저트</li>
          </ul>
        </div>
      </div>
      <div class="container">
        <div class="overlay2">
          <h5 class="info-top-title">
            <b>BBQ<br />바베큐</b>
          </h5>
          <ul>
            <li>그릴</li>
            <li>숯</li>
            <li>장작</li>
          </ul>
        </div>
      </div>

      <div class="container">
        <div class="overlay4">
          <p>가족 또는 연인과 함께 카페 및 바베큐 서비스를 이용해보세요</p>
          <h3>카페 이용시간 10:00 ~ 21:00</h3>
          <h3>바베큐 이용시간 16:00 ~ 21:00</h3>
        </div>
      </div>
    </div>

    <div>
      <v-btn x-large text class="reserve_btn" router :to="'/reservationPage'">
        <v-icon x-large>mdi-feather</v-icon>실시간 예약하기
      </v-btn>
    </div>
  </div>
</template>

<script>
import { Swiper, SwiperSlide } from "vue-awesome-swiper";
import "swiper/css/swiper.css";
export default {
  name: "ServicePage",
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      images: [
        "https://images.pexels.com/photos/1115600/pexels-photo-1115600.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/2159065/pexels-photo-2159065.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/4226806/pexels-photo-4226806.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/2921615/pexels-photo-2921615.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/8523167/pexels-photo-8523167.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/8523507/pexels-photo-8523507.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/2422968/pexels-photo-2422968.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
      ],
      swiperOption: {
        loopedSlides: 2,
        grabCursor: true,
        centeredSlides: true,
        slidesPerView: "auto",
        effect: "fade",
        pagination: {
          el: ".swiper-pagination",
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
        autoplay: {
          delay: 3000,
        },
      },
    };
  },
};
</script>

<style lang="scss" scoped>
/*위치*/
.container {
  position: relative;
}
.overlay1 {
  position: absolute;
  z-index: 9;
  margin-top: 2%;
  left: 75%;
}
.overlay2 {
  position: absolute;
  z-index: 9;
  margin-top: 0%;
  left: 90%;
}
.overlay4 {
  position: absolute;
  z-index: 9;
  margin-top: 15%;
  left: 38%;
  right: -30%;
}
.about-img-top {
  max-height: 70vh;
}
.room301-img-01 {
  position: relative;
  right: 35%;
  margin-top: 0%;
  left: -20%;
  position: absolute;
  z-index: 9;
}
.pay-box {
  position: relative;
  margin-top: 1%;
  margin-bottom: 5%;
  text-align: center;
  left: 20%;
  width: 60%;
}
.top-tr {
  background-color: #f6f7f7;
}
.about-bottom {
  margin-top: 60vh;
}
.section {
  background: #dcdfdc;
  height: 10vh;
  width: 100vw;
  position: relative;
  padding: 15px 0px 15px 0px;
}
.about-top {
  padding-top: 8vh;
}
/*폰트*/
.info-top-title {
  font-size: 20px;
  font-family: "Gowun Batang";
}
p {
  font-family: "Nanum Myeongjo";
  font-size: 18px;
  text-align: center;
  padding: 2vh 0vh 2vh 0vh;
  margin-bottom: 0px;
}
h1 {
  font-family: "Cinzel";
  font-size: 50px;
  text-align: center;
  margin-top: 10px;
}
h2 {
  font-family: "MonteCarlo";
  font-size: 100px;
  color: darkgrey;
}
h3 {
  font-family: "Gowun Batang";
  font-size: 22px;
  text-align: center;
  margin-top: 10px;
}
.btn-box {
  padding: 18px 10px 18px 10px;
  text-align: center;
}
.intro-room01 {
  background: #f6f7f7;
  height: 50vh;
}
.slide {
  padding-left: 0px;
  margin-left: 0px;
  padding-top: 0px;
}
.slide-3d {
  padding-top: 0px;
  padding-bottom: 0px;
}
.swiper {
  height: 94vh;
  width: 99.6vw;
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
.reserve_btn {
  border: 2px solid darkgrey;
  position: relative;
  left: 45%;
  margin: 3% 0% 3% 0%;
}
</style>