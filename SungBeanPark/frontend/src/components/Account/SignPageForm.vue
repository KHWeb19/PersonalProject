<template>
  <body>
    <div class="sign">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <header class="visually-hidden">
              <h1>E-commerce</h1>
            </header>

            <div class="sign-form">
              <div class="sign-header">
                <h2>회원가입</h2>
              </div>

              <div class="sign-line-top"></div>

              <section class="sign-section">
                <div class="sign-member">
                  <form
                    class="sign-form"
                    @submit.prevent="onSubmit"
                    method="POST"
                  >
                    <div class="sign-member-form">
                      <div class="sign-member-id">
                        <input
                          class="sign-input"
                          type="text"
                          name="id"
                          placeholder="아이디"
                          v-model="id"
                          required
                        />
                      </div>
                      <div class="sign-member-password">
                        <input
                          class="sign-input"
                          type="password"
                          name="pw"
                          placeholder="비밀번호"
                          v-model="pw"
                          required
                        />
                      </div>
                      <div class="sign-member-password-confirm">
                        <input
                          class="sign-input"
                          type="password"
                          name="pwCheck"
                          placeholder="비밀번호 확인"
                          v-model="pwCheck"
                          required
                        />
                      </div>
                      <div class="sign-member-name">
                        <input
                          class="sign-input"
                          type="text"
                          name="name"
                          placeholder="이름(2~30자)"
                          v-model="name"
                          required
                          minlength="2"
                          maxlength="30"
                        />
                      </div>
                    </div>

                    <div class="sign-line-bottom"></div>

                    <button class="btn-black btn-46" type="submit">
                      가입하기
                    </button>
                  </form>
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
  name: "SignPageForm",

  data() {
    return {
      id: "",
      pw: "",
      pwCheck: "",
      name: "",
    }
  },

  methods: {
    onSubmit() {
      const { id, pw, pwCheck, name } = this
      this.$emit("submit", { id, pw, pwCheck, name })
    },
  },
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/pages/sign";
</style>
