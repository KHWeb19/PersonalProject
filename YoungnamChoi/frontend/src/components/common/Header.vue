<template>
  <div>
    <b-navbar type="dark" variant="dark">
      <b-navbar-nav>
        <b-nav-item href="/">Home</b-nav-item>

        <!-- Navbar dropdowns -->
        <b-nav-item href="/about">맛집 리뷰</b-nav-item>

        <b-nav-item href="#">맛집 검색</b-nav-item>

        <b-nav-item href="#">위시 리시트</b-nav-item>

        <b-button
          squared
          variant="dark"
          style="position: fixed; right: 0px"
          href="/login"
          >Log in</b-button
        >
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "header",
};
</script>

<style></style>
