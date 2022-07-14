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
      <h1>Sunflower Room</h1>
      <p>#옐로우톤 #화사함</p>
    </v-container>
    <v-divider></v-divider>

    <v-container>
      <v-container class="btn-box">
        <v-btn
          text
          v-for="room in rooms"
          :key="room.name"
          router
          :to="room.route"
        >
          {{ room.name }}
        </v-btn>
      </v-container>
    </v-container>
    <v-divider></v-divider>

    <div class="intro-room01">
      <div class="container">
        <v-container class="room301-img-01">
          <h2>Sunflower Room</h2>
          <v-img style="overflow: visible"> </v-img>
        </v-container>
      </div>

      <div class="container">
        <div class="overlay1">
          <h5 class="info-top-title">
            <b>Basic facilities <br />기본시설</b>
          </h5>
          <ul>
            <li>퀸 베드2</li>
            <li>거실</li>
            <li>화장실</li>
            <li>벽걸이TV</li>
            <li>에어컨</li>
            <li>소파</li>
            <li>테이블</li>
            <li>냉장고</li>
            <li>와이파이</li>
          </ul>
        </div>
      </div>
      <div class="container">
        <div class="overlay2">
          <h5 class="info-top-title">
            <b>Cooking<br />취사도구</b>
          </h5>
          <ul>
            <li>인덕션</li>
            <li>전자렌지</li>
            <li>전기포트</li>
          </ul>
        </div>
      </div>
      <div class="container">
        <div class="overlay3">
          <h5 class="info-top-title">
            <b>Bathroom ware<br />욕실용품</b>
          </h5>
          <ul>
            <li>수건</li>
            <li>핸드워시</li>
            <li>치약</li>
            <li>바디타올</li>
            <li>바디워시</li>
            <li>샴푸</li>
            <li>린스</li>
            <li>헤어드라이기</li>
          </ul>
        </div>
      </div>
      <div class="container">
        <div class="overlay4">
          <p>애완동물과 함께 입실하실 수 없습니다</p>
          <h3>CHECK-IN 15:00 | CHECK-OUT 11:00</h3>
        </div>
      </div>
    </div>

    <div>
      <v-btn x-large text class="reserve_btn" router :to="'/reservationPage'">
        <v-icon x-large>mdi-feather</v-icon>실시간 예약하기
      </v-btn>
    </div>

    <v-simple-table class="pay-box">
      <template v-slot:default>
        <thead>
          <tr class="top-tr">
            <th>객실명</th>
            <th>형태</th>
            <th>기준/최대</th>
            <th>가격</th>
          </tr>
          <tr>
            <th>SunflowerRoom</th>
            <th>패밀리형</th>
            <th>4명/4명</th>
            <th>250,000원</th>
          </tr>
        </thead>
      </template>
    </v-simple-table>
  </div>
</template>

<script>
import { Swiper, SwiperSlide } from "vue-awesome-swiper";
import "swiper/css/swiper.css";
export default {
  name: "SunflowerRoom",
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      images: [
        "https://images.pexels.com/photos/6585612/pexels-photo-6585612.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/6585608/pexels-photo-6585608.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/6585602/pexels-photo-6585602.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/6588569/pexels-photo-6588569.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/7031829/pexels-photo-7031829.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
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
      rooms: [
        { name: "# Rose Room", route: "/roseRoom" },
        { name: "# Sunflower Room", route: "/sunflowerRoom" },
        { name: "# Violet Room", route: "/violetRoom" },
        { name: "# Lily Room", route: "/lilyRoom" },
      ],
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
  margin-top: -0.8%;
  left: 65%;
}
.overlay2 {
  position: absolute;
  z-index: 9;
  margin-top: -3%;
  left: 93%;
}
.overlay3 {
  position: absolute;
  z-index: 9;
  margin-top: -5%;
  left: 79%;
}
.overlay4 {
  position: absolute;
  z-index: 9;
  margin-top: 20%;
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