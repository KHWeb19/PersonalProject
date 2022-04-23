<template>
  <body>
    <div class="password">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <header>
              <h1 class="visually-hidden">Nike</h1>
            </header>

            <div class="password-container">
              <div class="password-header">
                <h2>비밀번호 찾기</h2>
              </div>
              <section class="password-section">
                <div class="password-member">
                  <form class="password-form">
                    <div class="password-input-label">
                      <label for="">비밀번호를 찾으려는 아이디</label>
                    </div>
                    <div class="password-input">
                      <input
                        class="password-input-input"
                        type="text"
                        placeholder="아이디 입력"
                      />
                    </div>
                    <div class="password-input-label">
                      <label for="">가입시 입력하신 휴대폰 번호</label>
                    </div>
                    <div class="password-input">
                      <input
                        class="password-input-input"
                        type="text"
                        placeholder="휴대전화(-없이)"
                      />
                      <button class="password-input-button" type="button">
                        인증 요청
                      </button>
                    </div>
                  </form>
                </div>
                <div class="password-button">
                  <button class="btn-black btn-46" type="button">다음</button>
                </div>
              </section>
            </div>
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
