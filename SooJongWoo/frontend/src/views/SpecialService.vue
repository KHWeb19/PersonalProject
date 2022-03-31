<template>
  <div>
    <v-toolbar dense dark>
      <v-toolbar-items>
        <v-btn text v-for="link in links" :key="link.icon" :to="link.route">
          {{ link.text }}
        </v-btn>
      </v-toolbar-items>
    </v-toolbar>
    <v-navigation-drawer app v-model="nav_drawer" temporary>
      <v-list nav dense>
        <v-list-item
          v-for="link in links"
          :key="link.name"
          router
          :to="link.route"
        >
          <v-list-item-action>
            <v-icon left>
              {{ link.icon }}
            </v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              {{ link.text }}
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <coverflow :coverList="coverList" :coverWiddth="260" :index="2" />
  </div>
</template>

<script>
import coverflow from "vue-coverflow";

export default {
  data() {
    return {
      nav_drawer: false,
      service: {},
      links: [
        { icon: "mdi-home", text: "홈로고", name: "home", route: "/" },
        { icon: "mdi-door", text: "객실안내", name: "room", route: "/" },
        { icon: "mdi-check", text: "예약안내", name: "check", route: "/" },
        { icon: "mdi-coffee", text: "부대시설", name: "coffee", route: "/" },
        { icon: "mdi-notice", text: "공지사항", name: "notice", route: "/" },
      ],
      coverList: [
        {
          cover: require("@/assets/logo.png"),
          title: "001",
        },
        {
          cover: require("@/assets/logo.png"),
          title: "002",
        },
        {
          cover: require("@/assets/logo.png"),
          title: "003",
        },
        {
          cover: require("@/assets/logo.png"),
          title: "004",
        },
      ],
    };
  },
  methods: {},
  components: {
    coverflow,
  },
};
</script>
