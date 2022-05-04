<template>
  <div>
    <template>
      <v-toolbar color="orange lighten-1" dark height="90px">
        <v-spacer></v-spacer>
        <v-toolbar-title>
          <router-link to="/">
            <v-img
              :src="require('@/assets/img/logo.png')"
              width="60"
              class="mr-5 mt-4"
              style="float: left"
            ></v-img>
            <div class="white--text mt-3" style="width: 500px; height: 85px">
              <b style="font-size: 50px; font-weight: bold">E</b>
              <b style="font-size: 25px; margin-right: 10px"> a s y </b>
              <b style="font-size: 35px"> C</b>
              <b style="font-size: 25px"> o o k</b>
            </div>
          </router-link>
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items style="margin: 15px">
          <v-btn
            text
            class="toolbar_items"
            v-for="link in links"
            :key="link.icon"
            :to="link.route"
            style="font-size: 25px; margin-right: 50px"
          >
            {{ link.text }}
          </v-btn>
        </v-toolbar-items>

        <div v-if="!this.$store.state.userInfo">
          <v-btn
            text
            class="orange lighten-5 mr-10"
            style="
              margin-right: 15px;
              font-size: 25px;
              width: 150px;
              height: 50px;
            "
          >
            <router-link to="/login" class="orange--text">Login</router-link>
          </v-btn>
          <v-btn
            text
            class="orange lighten-5"
            style="width: 150px; height: 50px"
          >
            <router-link
              to="/signup"
              class="orange--text"
              style="font-size: 25px"
              >Sign Up</router-link
            >
          </v-btn>
          <v-spacer></v-spacer>
        </div>

        <div v-if="this.$store.state.userInfo">
          <!--
          <v-btn
            text
            class="orange lighten-2"
            style="margin-right: 15px; font-family: fantasy; font-size: 20px"
          >
            <router-link to="/myPage" class="font-weight-light white--text"
              >마이페이지</router-link
            >
          </v-btn>
          -->
          <span
            class="text-center"
            v-if="this.$store.state.userInfo.auth != '관리자'"
          >
            <v-menu open-on-hover offset-y>
              <template v-slot:activator="{ on, attrs }">
                <v-btn
                  text
                  class="orange lighten-5 mr-10 orange--text"
                  dark
                  v-bind="attrs"
                  v-on="on"
                  style="
                    margin-right: 15px;
                    font-size: 25px;
                    width: 150px;
                    height: 50px;
                  "
                >
                  My Page
                </v-btn>
              </template>

              <v-list>
                <v-list-item
                  v-for="(item, index) in items"
                  :key="index"
                  :to="item.link"
                  link
                >
                  <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item>
              </v-list>
            </v-menu>
          </span>

          <span class="text-center" v-else>
            <v-menu open-on-hover offset-y>
              <template v-slot:activator="{ on, attrs }">
                <v-btn
                  text
                  class="orange lighten-5 mr-10"
                  dark
                  v-bind="attrs"
                  v-on="on"
                  style="
                    margin-right: 15px;
                    font-size: 25px;
                    width: 150px;
                    height: 50px;
                  "
                >
                  My Page
                </v-btn>
              </template>

              <v-list>
                <v-list-item
                  v-for="(item, index) in authItems"
                  :key="index"
                  :to="item.link"
                  link
                >
                  <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item>
              </v-list>
            </v-menu>
          </span>

          <v-btn
            text
            class="orange lighten-5"
            style="width: 150px; height: 50px"
          >
            <span class="orange--text" style="font-size: 25px" @click="logout"
              >Logout</span
            >
          </v-btn>
        </div>
        <v-spacer></v-spacer>
      </v-toolbar>
      <div class="orange lighten-5" style="height: 30px"></div>
    </template>
  </div>
</template>

<script>
export default {
  name: "Navigation",
  data() {
    return {
      userInfo: "",
      auth: "",
      authItems: [{ title: "회원 관리", link: "/memberManage" }],

      links: [
        { text: "CS CENTER", route: "/noticeList" },
        { text: "RANK", route: "/bestFoodList" },
        { text: "RECIPE", route: "/foodList" },
      ],
      items: [
        { title: "내 보관함", link: "/myCartFood" },
        { title: "회원 정보 수정", link: "/memberInfo" },
      ],
      isLogin: false,
    };
  },

  created() {
    this.$store.state.userInfo = this.$cookies.get("user");
    if (this.$store.state.userInfo != null) {
      this.isLogin = true;
      this.userInfo = this.$store.state.userInfo;
      this.auth = this.userInfo.auth;
    }
  },
  methods: {
    logout() {
      this.$cookies.remove("user");
      this.isLogin = false;
      this.$store.state.userInfo = null;
      localStorage.removeItem("userInfo");
      alert("로그아웃 성공");
      history.go(0);
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
a {
  text-decoration: none;
}
</style>
