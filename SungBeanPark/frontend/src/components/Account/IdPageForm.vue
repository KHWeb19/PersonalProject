<template>
  <body>
    <div class="id">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <header>
              <h1 class="visually-hidden">Nike</h1>
            </header>

            <div class="id-container">
              <div class="id-header">
                <h2>아이디 찾기</h2>
              </div>
              <section class="id-section">
                <div class="id-member">
                  <form class="id-form">
                    <div class="id-input-label">
                      <label for="">가입시 입력하신 휴대폰 번호</label>
                    </div>
                    <div class="id-input">
                      <input
                        class="id-input-input"
                        type="text"
                        placeholder="휴대전화(-없이)"
                      />
                      <button
                        @click="test"
                        class="id-input-button"
                        type="button"
                      >
                        인증 요청
                      </button>
                    </div>
                  </form>
                </div>
                <div class="id-button">
                  <button class="btn-black btn-46" type="button">다음</button>
                  <span :class="{ active: isActive }">ssss</span>
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
export default {
  name: "IdPageForm",
  data() {
    return {
      isActive: false,
    }
  },
  methods: {
    test() {
      this.isActive = !this.isActive
    },
  },
}
</script>
<style lang="scss" scoped>
.active {
  color: red;
}
@import "~@/assets/scss/pages/id";
</style>
