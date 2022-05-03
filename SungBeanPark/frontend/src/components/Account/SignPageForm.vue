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
                    @submit.prevent="submit"
                    method="POST"
                  >
                    <ValidationObserver
                      class="sign-member-form"
                      ref="validator"
                    >
                      <ValidationProvider
                        tag="div"
                        class="sign-member-id"
                        v-slot="{ errors }"
                        :rules="{ required }"
                      >
                        <input
                          class="sign-input"
                          type="text"
                          placeholder="아이디"
                          maxlength="20"
                          required
                          v-model="id"
                        />

                        <div class="errmsg">
                          {{ errors[0] }}
                        </div>
                      </ValidationProvider>

                      <ValidationProvider
                        class="sign-member-password"
                        tag="div"
                        name="password"
                        type="password"
                        v-slot="{ errors }"
                        :rules="{ checkPw }"
                      >
                        <div class="field">
                          <input
                            class="sign-input"
                            type="password"
                            name="password"
                            placeholder="비밀번호"
                            v-model="pw"
                            required
                          />
                        </div>
                        <div class="errmsg" aria-live="polite">
                          {{ errors[0] }}
                        </div>
                      </ValidationProvider>

                      <ValidationProvider
                        class="sign-member-password-confirm"
                        tag="div"
                        v-slot="{ errors }"
                        name="checkPassword"
                        :rules="{ confirmed: 'password' } || { required }"
                      >
                        <input
                          class="sign-input"
                          type="password"
                          placeholder="비밀번호 확인"
                          v-model="checkPassword"
                          required
                        />
                        <div class="errmsg" aria-live="polite">
                          {{ errors[0] }}
                        </div>
                      </ValidationProvider>

                      <ValidationProvider
                        class="sign-member-name"
                        tag="div"
                        name="name"
                        v-slot="{ errors }"
                        :rules="{ min: 2, max: 30 } || { required }"
                      >
                        <input
                          class="sign-input"
                          type="text"
                          placeholder="이름(2~30자)"
                          v-model="userName"
                          required
                        />
                        <div class="errmsg" aria-live="polite">
                          {{ errors[0] }}
                        </div>
                      </ValidationProvider>
                    </ValidationObserver>

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
import { ValidationObserver, ValidationProvider, extend } from "vee-validate"

export default {
  name: "SignPageForm",
  props: {
    members: {
      type: Array,
    },
  },
  data() {
    return {
      radioGroup: 1,
      kindsOfMember: ["사용자", "관리자"],
      id: "",
      pw: "",
      checkPassword: "",
      userName: "",
      required: "",
      checkPw: "",
    }
  },
  component: {
    ValidationObserver,
    ValidationProvider,
    extend,
  },
  methods: {
    submit() {
      const { id, pw, userName } = this
      const auth = this.radioGroup == "사용자" ? "사용자" : "관리자"
      this.$emit("submit", { id, pw, userName, auth })
    },
  },
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/pages/sign";
</style>
