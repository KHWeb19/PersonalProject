<template>
  <div>
    <b-navbar type="dark" variant="dark">
      <b-navbar-nav v-if="checkuserInfo == null">
        <b-nav-item href="/">Home</b-nav-item>

        <!-- Navbar dropdowns -->
        <b-nav-item href="/boardListPage">맛집 리뷰</b-nav-item>

        <b-nav-item href="/searchpage">맛집 검색</b-nav-item>

        <b-button
          squared
          variant="dark"
          style="position: fixed; right: 0px"
          href="/login"
          >Log in</b-button
        >
      </b-navbar-nav>
      <b-navbar-nav v-if="checkuserInfo != null">
        <b-nav-item href="/">Home</b-nav-item>

        <!-- Navbar dropdowns -->
        <b-nav-item href="/boardListPage">맛집 리뷰</b-nav-item>

        <b-nav-item href="/searchpage">맛집 검색</b-nav-item>

        <b-button
          squared
          variant="dark"
          style="position: fixed; right: 0px"
          @click="logout"
          type="submit"
          >Log Out</b-button
        >
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "navbar",
  component: {},
  data() {
    return {
      checkuserInfo: window.localStorage.getItem("token"),
    };
  },
  methods: {
    logout() {
      this.$cookies.remove("user");
      this.isLogin = false;
      this.$store.state.userInfo = null;
      window.localStorage.removeItem("token");
      alert("로그아웃 되었습니다!");
      this.$router.push({
        name: "LoginPage",
      });
    },
  },
};
</script>

<style></style>
