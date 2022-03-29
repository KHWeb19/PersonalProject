<template>
  <body>
    <div class="password">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <header class="visually-hidden">
              <h1>E-commerce</h1>
            </header>

            <div class="password-header">
              <h2>비밀번호 찾기</h2>
            </div>

            <div class="password-line"></div>

            <section class="password-section">
              <div class="password-member">
                <form class="password-form" action="/" method="POST">
                  <div class="password-input">
                    <label for="/">가입한 아이디를 입력해주세요</label>
                    <input type="text" placeholder="아이디" />
                  </div>

                  <button class="btn-black btn-46">다음</button>
                </form>
              </div>
            </section>
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
@import "~@/assets/scss/pages/password";
</style>
