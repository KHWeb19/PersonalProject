<template>
  <aside class="sidebar" v-show="show">
    <header class="sidebar-header">
      <h1 class="logo">
        <a href="/">
          <img src="@/assets/images/Logo.svg" alt="나이키" />
        </a>
      </h1>

      <nav class="sidebar-nav">
        <h2 class="visually-hidden">메뉴</h2>
        <div class="sidebar-user-menu">
          <ul class="user-menu-list">
            <li class="user-menu-item"><a href="/">Best</a></li>
            <li class="user-menu-item"><a href="/">New Release</a></li>
            <li class="user-menu-item"><a href="/">Men</a></li>
            <li class="user-menu-item"><a href="/">Women</a></li>
            <li class="user-menu-item"><a href="/">Login</a></li>
            <li class="user-menu-item"><a href="/">Cart</a></li>
            <li class="user-menu-item"><a href="/">Support</a></li>
          </ul>
        </div>
      </nav>
    </header>
  </aside>
</template>
<script>
/* eslint-disable */
export default {
  name: "SidebarLayout",
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/layout/sidebar";
@import "~@/assets/scss/components/overlay";
</style>
