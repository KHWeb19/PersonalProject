<template>
  <div>
    <template>
      <v-toolbar color="orange lighten-1" dark>
        <v-toolbar-title>
          <router-link to="/">
            <v-icon style="margin-right: 15px">mdi-chef-hat </v-icon>
            <span class="font-weight-light white--text">EasyCook</span>
          </router-link>
        </v-toolbar-title>
        <v-spacer></v-spacer>

        <v-toolbar-items style="margin: 15px">
          <v-btn text v-for="link in links" :key="link.icon" :to="link.route">
            {{ link.text }}
          </v-btn>
        </v-toolbar-items>

        <v-btn text class="orange lighten-2" style="margin-right: 15px">
          <router-link to="/login" class="font-weight-light white--text"
            >로그인</router-link
          >
        </v-btn>
        <v-btn text class="orange lighten-2">
          <router-link to="/signup" class="font-weight-light white--text"
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
</style>
