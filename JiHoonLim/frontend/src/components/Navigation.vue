<template>
  <div>
    <template>
      <v-toolbar color="orange lighten-1" dark height="90px">
        <v-spacer></v-spacer>
        <v-toolbar-title>
          <router-link to="/">
            <v-img
              :src="require('@/assets/img/logo.png')"
              width="50"
              class="mx-auto mr-3"
              style="float: left"
            ></v-img>
            <div
              id="logo_text"
              class="font-weight-light white--text mt-3"
              style="width: 200px"
            >
              EasyCook
            </div>
          </router-link>
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items style="margin: 15px">
          <v-btn
            text
            v-for="link in links"
            :key="link.icon"
            :to="link.route"
            style="font-family: fantasy; font-size: 20px"
            class="font-weight-bold"
          >
            {{ link.text }}
          </v-btn>
        </v-toolbar-items>

        <div v-if="!this.$store.state.userInfo">
          <v-btn
            text
            class="orange lighten-2"
            style="margin-right: 15px; font-family: fantasy; font-size: 20px"
          >
            <router-link to="/login" class="font-weight-light white--text"
              >로그인</router-link
            >
          </v-btn>
          <v-btn text class="orange lighten-2">
            <router-link
              to="/signup"
              class="font-weight-light white--text"
              style="font-family: fantasy; font-size: 20px"
              >회원가입</router-link
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
          <span class="text-center">
            <v-menu open-on-hover offset-y>
              <template v-slot:activator="{ on, attrs }">
                <v-btn
                  text
                  class="orange lighten-2"
                  dark
                  v-bind="attrs"
                  v-on="on"
                  style="
                    margin-right: 15px;
                    font-family: fantasy;
                    font-size: 20px;
                  "
                >
                  마이페이지
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

          <v-btn text class="orange lighten-2">
            <span
              class="font-weight-light white--text"
              style="font-family: fantasy; font-size: 20px"
              @click="logout"
              >로그아웃</span
            >
          </v-btn>
        </div>
        <v-spacer></v-spacer>
      </v-toolbar>
    </template>
  </div>
</template>

<script>
export default {
  name: "Navigation",
  data() {
    return {
      links: [
        { text: "공지사항", route: "/announcement" },
        { text: "인기 순위", route: "/bestFoodList" },
        { text: "레시피", route: "/foodList" },
      ],
      items: [
        { title: "내 보관함", link: "/" },
        { title: "회원 정보 수정", link: "/memberInfo" },
      ],
      isLogin: false,
    };
  },
  mounted() {
    this.$store.state.userInfo = this.$cookies.get("user");
    if (this.$store.state.userInfo != null) {
      this.isLogin = true;
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
a {
  text-decoration: none;
}
#logo_text {
  height: 50px;

  font-size: 25px;
  font-family: fantasy;
}
</style>
