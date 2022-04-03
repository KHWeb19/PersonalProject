<template>
  <body>
    <div class="id">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <header class="visually-hidden">
              <h1>E-commerce</h1>
            </header>

            <div class="id-header">아이디 찾기</div>

            <section>
              <form action="/" method="POST">
                <div>
                  <div class="id-radio">
                    <input type="radio" />
                    <label class="id-radio-label" for="">휴대전화</label>
                  </div>
                  <div class="id-input">
                    <div class="id-input-wrap">
                      <input
                        class="id-input-input"
                        type="text"
                        placeholder="이름"
                      />
                      <button class="id-input-button" type="button"></button>
                    </div>
                  </div>
                  <div class="id-input">
                    <div class="id-input-wrap">
                      <input
                        class="id-input-input"
                        type="tel"
                        placeholder="휴대전화(-없이)"
                        maxlength="11"
                      />
                      <button class="id-input-button" type="button">
                        인증 요청
                      </button>
                    </div>
                  </div>
                  <div class="id-radio">
                    <input type="radio" />
                    <label class="id-radion-label" for="">이메일</label>
                  </div>
                  <div class="id-input">
                    <div class="id-input-wrap">
                      <input
                        class="id-input-input"
                        type="email"
                        placeholder="이메일"
                        maxlength="11"
                      />
                      <button class="id-input-button" type="button">
                        인증 요청
                      </button>
                    </div>
                  </div>
                </div>
              </form>
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
@import "~@/assets/scss/pages/id";
</style>
