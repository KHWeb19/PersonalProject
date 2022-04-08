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
              <div class="radio-group">
                <input
                  v-model="radioGroup"
                  type="radio"
                  :label="`${kindsOfMember[0]}`"
                  :value="`${kindsOfMember[0]}`"
                />
                <input
                  v-model="radioGroup"
                  type="radio"
                  :label="`${kindsOfMember[1]}`"
                  :value="`${kindsOfMember[1]}`"
                />
              </div>
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
                          :rules="rules_id"
                          required
                        />
                      </div>
                      <div class="sign-member-password">
                        <input
                          class="sign-input"
                          type="password"
                          name="pw"
                          placeholder="비밀번호"
                          :rules="rules_pw"
                          required
                        />
                      </div>
                      <div class="sign-member-password-confirm">
                        <input
                          class="sign-input"
                          type="password"
                          name="pwCheck"
                          placeholder="비밀번호 확인"
                          :rules="rules_pw1"
                          required
                        />
                      </div>
                      <div class="sign-member-name">
                        <input
                          class="sign-input"
                          type="text"
                          name="name"
                          placeholder="이름(2~30자)"
                          :rules="rules_name"
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
      kindsOfMember: ["회원", "관리자"],
      id: "",
      pw: "",
      name: "",
      pw1: "",
      rules_id: [(v) => !!v || "아이디를 입력해주세요"],
      rules_pw: [
        (v) => !!v || "비밀번호를 입력해주세요",
        (v) => v.length >= 6 || "비밀번호를 6자리 이상 입력해주세요",
      ],
      rules_pw1: [
        (v) => !!v || "비밀번호를 입력해주세요",
        (v) => v === this.pw || "비밀번호가 일치하지 않습니다",
      ],
      rules_name: [(v) => !!v || "이름을 입력해주세요"],
    }
  },
  /* eslint-disable */
  methods: {
    onSubmit() {
      const { id, pw, name } = this
      const auth = this.radioGroup == "사용자" ? "사용자" : "관리자"
      this.$emit("submit", { id, pw, name, auth })
    },
    checkValid() {
      const { id } = this
      axios
        .get(`http://localhost:8888/Member/check/${id}`)
        .then((res) => {
          this.temp = res.data
          if (res.data == true) {
            alert("사용 가능한 아이디 입니다!")
            this.valid = res.data
          } else {
            alert("중복된 아이디 입니다!")
            this.valid = false
          }
        })
        .catch(() => {
          alert("아이디를 입력해주세요!")
        })
    },
  },
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/pages/sign";
</style>
