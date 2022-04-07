<template>
  <div>
    <div class="AllIn">
      <v-app-bar-nav-icon
        @click="nav_drawer = !nav_drawer"
        class="main-bar"
      ></v-app-bar-nav-icon>
      <v-toolbar-items class="login-locate">
        <v-btn plain text router :to="'/login'">
          <v-icon>mdi-export</v-icon>
        </v-btn>
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

      <section>
        <div class="content">
          <h2>WELCOME</h2>
          <h2>WELCOME</h2>
        </div>
      </section>
    </div>

    <div id="content" class="content">
      <div>
        <h3 style="font-size: 15px; margin-bottom: 2%">숙소 소개글</h3>
        <p>숙소의 이것저것 소개</p>
        <p style="margin: 0% 0% 5% 0%">여행의 휴식처</p>
      </div>

      <v-divider></v-divider>

      <div class="main-colorbox">
        <v-row>
          <v-flex xs3 sm12 lg12>
            <div class="img-s">
              <v-img
                style="overflow: visible"
                contain
                width="900px"
                height="600px"
              >
              </v-img>
            </div>
          </v-flex>
        </v-row>
      </div>

      <div>
        <p>지금 바로 여행을 떠냐봐요</p>
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
            >실시간 예약<v-icon>mdi-check</v-icon></v-btn
          >
        </v-row>
      </div>
    </div>

    <div id="icon">
      <vs-button icon relief danger animation-type="rotate">
        <template #animate>
          <i class="bx bxs-like"></i>
        </template>
      </vs-button>
    </div>
  </div>
</template>

<script>
import "swiper/css/swiper.css";
import { mapActions } from "vuex";

export default {
  name: "MainPage",
  data() {
    return {
      nav_drawer: false,
      group: false,
      links: [
        { text: "Home", name: "home", route: "/" },
        { text: "객실안내", name: "room", route: "/" },
        { text: "예약안내", name: "reservation", route: "/" },
        { text: "부대시설", name: "service", route: "/" },
        { text: "공지사항", name: "notice", route: "/" },
      ],
      watch: {
        group() {
          this.nav_drawer = false;
        },
      },
      methods: {
        ...mapActions(["logout"]),
      },
    };
  },
};
</script>


<style lang= "scss" scoped>
@import "@/assets/style/MainPageStyle.scss";
</style>
