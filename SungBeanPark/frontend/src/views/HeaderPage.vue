<template>
  <body>
    <header class="gnb">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <div class="gnb-wrapper">
              <div class="gnb-left">
                <h1 class="logo">
                  <a href="">
                    <img src="@/assets/images/Logo.svg" alt="나이키" />
                  </a>
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

                  <a
                    class="gnb-icon-button"
                    href="/"
                    aria-label="장바구니 페이지로 이동"
                  >
                    <i class="ic-cart"></i>
                  </a>

                  <nav class="gnb-text sm-hidden">
                    <a href="">Login</a>
                    <a href="">Support</a>
                  </nav>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- <aside class="sidebar">
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
    </aside> -->
    <section class="home-section sm-only">
      <div class="home-section-content">
        <p class="home-section-text">
          <a href="/">회원 가입</a>하고 10% 할인 쿠폰, 무료 배송 등의 혜택을
          받으세요.
        </p>
      </div>
    </section>

    <div class="swiper">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <figure class="swiper-figure">
              <div class="swiper-container">
                <div class="swiper-wrapper">
                  <a href="/">
                    <img src="@/assets/images/nike.jpg" alt="" />
                  </a>
                </div>
              </div>
            </figure>
          </div>
        </div>
      </div>
    </div>
  </body>
</template>
<script>
export default {}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/layout/header";
@import "~@/assets/scss/components/gnb-nav";
@import "~@/assets/scss/components/gnb-icon-buttons";
@import "~@/assets/scss/layout/sidebar";
@import "~@/assets/scss/components/home-section";
@import "~@/assets/scss/components/swiper";
@import "~@/assets/scss/layout/sidebar";
</style>
