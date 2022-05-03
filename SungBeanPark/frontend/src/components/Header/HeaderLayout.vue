<template>
  <header class="global-header">
    <div class="gnb">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <div class="gnb-wrapper">
              <div class="gnb-left">
                <h1 class="logo">
                  <router-link :to="{ name: 'MainPage' }">
                    <img src="@/assets/image/Logo.svg" alt="나이키" />
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
                  <input class="form-input" type="text" placeholder="Search" />
                </div>

                <div class="button-group">
                  <button
                    class="gnb-icon-button is-search lg-hidden"
                    type="button"
                    aria-label="검색창 열기 버튼"
                  >
                    <i class="ic-search"></i>
                  </button>

                  <router-link
                    class="gnb-icon-button"
                    :to="{ name: 'CartPage' }"
                    aria-label="장바구니 페이지로 이동"
                  >
                    <i class="ic-cart"></i>
                    <strong class="badge">{{ cartList.length }}</strong>
                  </router-link>

                  <nav class="gnb-text sm-hidden">
                    <!-- 로그인을 하지 않은 경우 -->
                    <router-link
                      :to="{ name: 'LoginPage' }"
                      v-if="checkUser == null"
                      >Login</router-link
                    >
                    <!-- 로그인을 한 경우 -->
                    <button
                      v-if="checkUser != null"
                      @click="mymenumodal"
                      aria-label="마이메뉴 열기 버튼"
                    >
                      MyPage
                    </button>
                    <a href="">Support</a>
                  </nav>
                  <div class="my-menu sm-hidden" :class="{ active: isActive }">
                    <div class="my-menu-content is-active">
                      <ul class="my-menu-list">
                        <li class="my-menu-item">
                          <router-link :to="{ name: 'MyPage' }"
                            >마이페이지</router-link
                          >
                        </li>

                        <li
                          class="my-menu-item"
                          v-if="
                            this.cookie === true && this.individual != '사용자'
                          "
                        >
                          <router-link :to="{ name: 'MemberListPage' }"
                            >회원관리</router-link
                          >
                        </li>
                        <li
                          class="my-menu-item"
                          v-if="
                            this.cookie === true && this.individual != '사용자'
                          "
                        >
                          <router-link :to="{ name: 'ProductRegisterPage' }"
                            >상품관리</router-link
                          >
                        </li>
                        <li class="my-menu-item">
                          <button
                            @click="logout"
                            type="submit"
                            aria-label="로그아웃 버튼"
                          >
                            로그아웃
                          </button>
                        </li>
                      </ul>
                    </div>
                  </div>
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
          <img src="@/assets/image/Logo.svg" alt="나이키" />
        </h1>

        <nav class="sidebar-nav">
          <h2 class="visually-hidden">메뉴</h2>
          <div class="sidebar-user-menu">
            <ul class="user-menu-list">
              <li class="user-menu-item"><a href="/">Best</a></li>
              <li class="user-menu-item"><a href="/">New Release</a></li>
              <li class="user-menu-item"><a href="/">Men</a></li>
              <li class="user-menu-item"><a href="/">Women</a></li>
              <!-- 로그인을 하지 않은 경우 -->
              <li class="user-menu-item" v-if="checkUser == null">
                <router-link :to="{ name: 'LoginPage' }">Login</router-link>
              </li>
              <!-- 로그인을 한 경우 -->
              <li v-if="checkUser != null"><a href="">MyPage</a></li>
              <li class="user-menu-item">
                <router-link :to="{ name: 'CartPage' }">Cart</router-link>
              </li>
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
    ></div>
  </header>
</template>
<script>
import { mapState } from "vuex"

export default {
  name: "Header-Layout",
  data() {
    return {
      isActive: false,
      cookie: this.$cookies.isKey("user"),
      individual: this.$cookies.get("auth"),
      checkUser: window.localStorage.getItem("token"),
    }
  },
  methods: {
    test() {
      this.isActive = !this.isActive
    },
    test2() {
      this.isActive = !this.isActive
    },
    mymenumodal() {
      this.isActive = !this.isActive
    },
    logout() {
      this.$cookies.remove("user")
      this.isLogin = false
      this.$store.state.userInfo = null
      window.localStorage.removeItem("token")
      window.localStorage.removeItem("userInfo")
      history.go(0)
    },
  },

  computed: {
    ...mapState(["cartList"]),
  },
}
</script>

<style lang="scss" scoped>
@import "~@/assets/scss/layout/header";
@import "~@/assets/scss/layout/global-header";
@import "~@/assets/scss/layout/sidebar";
@import "~@/assets/scss/layout/overlay";
@import "~@/assets/scss/components/my-menu";
</style>
