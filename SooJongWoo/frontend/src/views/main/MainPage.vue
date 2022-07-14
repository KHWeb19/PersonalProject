<template>
  <div>
    <div class="hero">
      <v-app-bar-nav-icon
        @click="nav_drawer = !nav_drawer"
        class="main-bar"
        color="white"
      ></v-app-bar-nav-icon>
      <v-toolbar-items class="login-locate">
        <v-btn
          plain
          text
          v-if="this.cookie === false"
          router
          :to="'/login'"
          color="white"
        >
          <v-icon>mdi-export</v-icon>
        </v-btn>

        <v-menu
          offset-y
          v-if="this.cookie === true && this.individual == '개인'"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn text v-bind="attrs" v-on="on">
              <v-icon color="white">mdi-account-circle</v-icon>
            </v-btn>
          </template>
          <v-list>
            <v-list-item router :to="{ name: 'UserList' }">
              <v-list-item-title>마이페이지</v-list-item-title>
            </v-list-item>
            <v-list-item @click="logout">
              <v-list-item-title>로그아웃</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>

        <v-menu
          offset-y
          v-if="this.cookie === true && this.individual != '개인'"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn text v-bind="attrs" v-on="on">
              <v-icon color="white">mdi-account-circle</v-icon>
            </v-btn>
          </template>
          <v-list>
            <v-list-item router :to="{ name: 'MemberListPage' }">
              <v-list-item-title>관리자페이지</v-list-item-title>
            </v-list-item>
            <v-list-item @click="logout">
              <v-list-item-title>로그아웃</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-toolbar-items>

      <v-navigation-drawer app v-model="nav_drawer" temporary>
        <v-list nav dense class="menubar">
          <v-list-item-group
            v-model="group"
            active-class="deep-blue--text text--accent-4"
          >
            <v-list-item
              v-for="link in links"
              :key="link.name"
              router
              :to="link.route"
            >
              <v-list-item-content>
                <v-list-item-title>{{ link.text }}</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-navigation-drawer>

      <div class="content">
        <h1>WELCOME</h1>
        <h2>HAWUL</h2>
        <h2>HAWUL</h2>
      </div>
    </div>

    <div id="content" class="content">
      <div>
        <h3 style="font-size: 15px; margin-bottom: 2%">숙소 소개글</h3>
        <p>바다의 아름다움을 느낄 수 있는 바다전망 숙소</p>
        <p>편안하고 시원한 분위기에서 휴식을 즐길 수 있는 공간</p>
        <p style="margin: 0% 0% 5% 0%">가족과 함께 자연을 느낄 수 있는 공간</p>
      </div>

      <v-divider></v-divider>

      <div>
        <swiper class="swiper" :options="swiperOption">
          <swiper-slide v-for="image in images" :key="image">
            <v-img :src="image" max-height="100%"></v-img>
          </swiper-slide>
          <div class="swiper-pagination" slot="pagination"></div>
          <div class="swiper-button-prev" slot="button-prev"></div>
          <div class="swiper-button-next" slot="button-next"></div>
        </swiper>
      </div>

      <v-divider></v-divider>

      <div>
        <p>지금 바로 여행을 떠나봐요</p>
        <p style="margin-top: 0%; font-size: 14px"></p>
      </div>

      <div class="button">
        <v-row align="center" class="justify-center">
          <v-btn
            outlined
            x-large
            class="btn2"
            route
            :to="{ name: 'ReservationPage' }"
          >
            <v-icon>mdi-feather</v-icon>실시간 예약</v-btn
          >
        </v-row>
      </div>
    </div>
  </div>
</template>


<script>
import { mapActions } from "vuex";
import { Swiper, SwiperSlide } from "vue-awesome-swiper";
import "swiper/css/swiper.css";
export default {
  name: "MainPage",
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
      nav_drawer: false,
      group: false,
      cookie: this.$cookies.isKey("user"),
      individual: this.$cookies.get("auth"),
      userId: this.$cookies.get("user"),
      links: [
        {
          text: "Home",
          name: "Hawul",
          route: "/hawul",
        },
        {
          text: "객실 안내",
          name: "ROOMS",
          route: "/rooms",
        },
        {
          text: "예약 안내",
          name: "ReservationPage",
          route: "/reservationPage",
        },
        {
          text: "부대 시설",
          name: "Service",
          route: "/service",
        },
        {
          text: "공지사항",
          name: "BOARD",
          route: "/board",
        },
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
  watch: {
    group() {
      this.nav_drawer = false;
    },
  },
  methods: {
    ...mapActions(["logout"]),
  },
};
</script>

<style lang="scss" scoped>
// 메인상단 이미지 스타일
.hero {
  position: relative;
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: left;
  color: white;
  padding-left: 5%;
  background: {
    image: linear-gradient(
        to bottom,
        rgba(172, 172, 172, 0.014) 0%,
        rgba(0, 0, 0, 0.75) 100%
      ),
      url("@/assets/image/mainimage.jpeg");
    size: cover;
  }
  .content {
    color: #fff;
    font-size: 4em;
  }
  .content h2:nth-child(1) {
    color: #fff;
    -webkit-text-stroke: 2px white;
  }

  .content h2:nth-child(2) {
    color: #03a9f4;
    animation: animate 4s infinite;
    position: absolute;
  }
}
.main-bar {
  position: absolute;
  top: 2%;
  left: 1%;
}
.login-locate {
  padding: 10px 0px 10px 0px;
  position: absolute;
  right: 0.5%;
  top: 1.5%;
}
.menubar {
  padding-top: 100px;
  padding-left: 40px;
}
.account {
  padding-left: 40vw;
}
.container {
  width: 100%;
  position: absolute;
  bottom: 20%;
}

// 실시간 예약 버튼
.btn2 {
  margin: 5%;
}
.btn2:hover {
  opacity: 1;
  background-color: white;
}

// 설명글 스타일
h3 {
  text-align: center;
  margin: 5% 0% 5% 0%;
}

p {
  font-size: 18px;
  text-align: center;
  padding: 5px 0px 5px 0px;
  margin: 5px 10px;
}
h2 {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}

body {
  display: flex;
  background: #000;
  min-height: 100vh;
  align-items: center;
  justify-content: center;
}

@keyframes animate {
  0%,
  100% {
    clip-path: polygon(
      0% 45%,
      16% 44%,
      33% 50%,
      54% 60%,
      70% 61%,
      84% 59%,
      100% 52%,
      100% 100%,
      0% 100%
    );
  }

  50% {
    clip-path: polygon(
      0% 60%,
      15% 65%,
      34% 66%,
      51% 62%,
      67% 50%,
      84% 45%,
      100% 46%,
      100% 100%,
      0% 100%
    );
  }
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
    flex-grow: 1;
    background-position: center;
    background-size: center;
  }
}

.btn2 {
  margin: 5%;
}
.btn2:hover {
  color: #ffffff;
}
.btn2:hover::before {
  opacity: 1;
  background-color: #6098ff;
}

*,
*::before,
*::after {
  box-sizing: border-box;
}
</style>
