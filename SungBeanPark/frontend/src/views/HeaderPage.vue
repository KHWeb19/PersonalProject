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
                    <li class="gnb-nav-item"><a href="/">New Release</a></li>
                    <li class="gnb-nav-item"><a href="/">Men</a></li>
                    <li class="gnb-nav-item"><a href="/">Women</a></li>
                  </ul>
                </nav>

                <button
                  class="gnb-icon-button sm-only"
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
                    placeholder="스토어 검색"
                  />
                </div>

                <div class="button-group">
                  <button
                    class="gnb-search-button gnb-icon-button lg-hidden"
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

                  <nav class="sm-hidden">
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
  </body>
</template>
<script>
export default {}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/layout/header";
</style>
