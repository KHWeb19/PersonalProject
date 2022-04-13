<template>
  <div>
    <div class="AllIn">
      <v-app-bar-nav-icon
        @click="nav_drawer = !nav_drawer"
        class="main-bar"
      ></v-app-bar-nav-icon>
      <v-toolbar-items class="login-locate">
        <v-btn plain text v-if="this.cookie === false" router :to="'/login'">
          <v-icon>mdi-export</v-icon>
        </v-btn>

        <v-menu
          offset-y
          v-if="this.cookie === true && this.individual == '개인'"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn text v-bind="attrs" v-on="on">
              <v-icon>mdi-account-circle</v-icon>
            </v-btn>
          </template>
        </v-menu>

        <v-menu
          offset-y
          v-if="this.cookie === true && this.individual != '개인'"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn text v-bind="attrs" v-on="on">
              <v-icon>account_circle</v-icon>
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
          <swiper-slide></swiper-slide>
          <swiper-slide>Slide 2</swiper-slide>
          <swiper-slide>Slide 3</swiper-slide>
          <swiper-slide>Slide 4</swiper-slide>
          <swiper-slide>Slide 5</swiper-slide>
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
            :to="{ name: 'Reservation' }"
            >RESERVATION<v-icon>mdi-next</v-icon></v-btn
          >
        </v-row>
      </div>
    </div>
  </div>
</template>

<script>
import { Swiper, SwiperSlide } from "vue-awesome-swiper";
import "swiper/css/swiper.css";
import { mapActions } from "vuex";

export default {
  name: "MainPage",
  components: {
    Swiper,
    SwiperSlide,
  },
  computed: {
    ...mapActions(["isLogin", "userInfo"]),
  },
  data() {
    return {
      nav_drawer: false,
      group: false,
      cookie: this.$cookies.isKey("user"),
      individual: this.$cookies.get("auth"),
      userId: this.$cookies.get("user"),
      links: [
        { text: "Home", name: "home", route: "/hawul" },
        { text: "객실안내", name: "room", route: "/rooms" },
        { text: "예약안내", name: "reservation", route: "/reservation" },
        { text: "부대시설", name: "service", route: "/service" },
        { text: "공지사항", name: "notice", route: "/notice" },
      ],
      watch: {
        group() {
          this.nav_drawer = false;
        },
      },
      methods: {
        ...mapActions(["logout"]),
      },
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


<style lang= "scss" scoped>
@import "@/assets/style/MainPageStyle.scss";
</style>
