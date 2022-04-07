<template>
  <div>
    <v-toolbar flat color="transparent">
      <v-app-bar-nav-icon
        @click="nav_drawer = !nav_drawer"
      ></v-app-bar-nav-icon>
      <v-btn text router :to="'/hotel'" class="home-btn" plain>
        <v-icon>mdi-home</v-icon>
      </v-btn>

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
          <v-list>
            <v-list-item router :to="{ name: 'UserList' }">
              <v-list-item-title>마이페이지</v-list-item-title>
            </v-list-item>
            <v-list-item @click="logout">
              <v-list-item-title>로그아웃</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-toolbar-items>
    </v-toolbar>

    <v-navigation-drawer app v-model="nav_drawer" temporary>
      <v-list nav dense class="MenuBar">
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
              <v-list-title>{{ link.text }}</v-list-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
  name: "MenuBar",
  computed: {
    ...mapState(["isLogin", "userInfo"]),
  },
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
    };
  },
  watch: {
    group() {
      this.nav_drawer = false;
    },
    methods: {
      ...mapActions(["logout"]),
    },
  },
};
</script>

<style lang="scss" scoped>
@import "@/assets/style/MenuBarStyle.scss";
</style>