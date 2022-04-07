<template>
  <body>
    <header class="global-header">
      <div class="gnb">
        <div class="container">
          <div class="row">
            <div class="col-sm-4">
              <div class="gnb-wrapper">
                <div class="gnb-left">
                  <h1 class="logo">
                    <router-link :to="{ name: 'MainPage' }">
                      <img src="@/assets/images/Logo.svg" alt="나이키" />
                    </router-link>
                  </h1>

                  <nav class="sm-hidden">
                    <h2 class="visually-hidden">메뉴</h2>
                    <ul class="gnb-nav-list">
                      <li class="gnb-nav-item"><a href="/">Best</a></li>
                      <li class="gnb-nav-item is-active">
                        <a href="/">New Release</a>
                      </li>
                      <li class="gnb-nav-item"><a href="/">Men</a></li>
                      <li class="gnb-nav-item"><a href="/">Women</a></li>
                    </ul>
                  </nav>
                  <button
                    @click="test"
                    class="gnb-icon-button is-menu sm-only"
                    type="button"
                    aria-label="메뉴 열기 버튼"
                  >
                    <i class="ic-menu"></i>
                  </button>
                </div>

                <div class="gnb-right">
                  <div class="input-group lg-only">
                    <i class="ic-search" aria-hidden></i>
                    <input
                      class="form-input"
                      type="text"
                      placeholder="Search"
                    />
                  </div>

                  <div class="button-group">
                    <button
                      class="gnb-icon-button is-search lg-hidden"
                      type="button"
                      aria-label="검색창 열기 버튼"
                    >
                      <i class="ic-search"></i>
                    </button>

                    <a
                      class="gnb-icon-button"
                      href="/"
                      aria-label="장바구니 페이지로 이동"
                    >
                      <i class="ic-cart"></i>
                    </a>

                    <nav class="gnb-text sm-hidden">
                      <router-link :to="{ name: 'LoginPage' }"
                        >Login</router-link
                      >
                      <a href="">Support</a>
                    </nav>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <aside class="sidebar sm-only" :class="{ active: isActive }">
        <header class="sidebar-header">
          <h1 class="logo">
            <img src="@/assets/images/Logo.svg" alt="나이키" />
          </h1>

          <nav class="sidebar-nav">
            <h2 class="visually-hidden">메뉴</h2>
            <div class="sidebar-user-menu">
              <ul class="user-menu-list">
                <li class="user-menu-item"><a href="/">Best</a></li>
                <li class="user-menu-item"><a href="/">New Release</a></li>
                <li class="user-menu-item"><a href="/">Men</a></li>
                <li class="user-menu-item"><a href="/">Women</a></li>
                <li class="user-menu-item">
                  <router-link :to="{ name: 'LoginPage' }">Login</router-link>
                </li>
                <li class="user-menu-item"><a href="/">Cart</a></li>
                <li class="user-menu-item"><a href="/">Support</a></li>
              </ul>
            </div>
          </nav>
        </header>
      </aside>
      <div
        class="overlay sm-only"
        aria-hidden
        :class="{ active: isActive }"
        @click="test2"
      >
        {{}}
      </div>
    </header>
  </body>
</template>
<script>
export default {
  name: "Header-Layout",
  data() {
    return {
      isActive: false,
    }
  },
  methods: {
    test() {
      this.isActive = !this.isActive
    },
    test2() {
      this.isActive = !this.isActive
    },
  },
}
</script>

<style lang="scss" scoped>
@import "~@/assets/scss/layout/header";
@import "~@/assets/scss/layout/global-header";
@import "~@/assets/scss/layout/sidebar";
@import "~@/assets/scss/layout/overlay";
</style>
