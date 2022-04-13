<template>
  <div>
    <template>
      <v-toolbar color="orange lighten-1" dark>
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
        { text: "인기 순위", route: "/best" },
        { text: "레시피", route: "/recipe" },
      ],
    };
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
