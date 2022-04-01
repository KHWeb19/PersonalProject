<template>
  <div>
    <v-container>
      <v-row justify="center">
        <v-col cols="auto" style="padding-bottom: 90px">
          <router-link to="/">
            <v-img
              :src="require('@/assets/img/logo.png')"
              width="120"
              class="mx-auto mb-6"
            ></v-img>
          </router-link>
          <v-card width="460">
            <v-card-text class="text-center px-12 py-16">
              <validation-observer v-slot="{ invalid }">
                <v-form @submit.prevent="onSubmit">
                  <div class="text-h4 font-weight-black mb-10">회원가입</div>
                  <validation-provider
                    v-slot="{ errors }"
                    name="아이디"
                    :rules="{ max: 12, required: true }"
                  >
                    <v-text-field
                      v-model="id"
                      label="아이디"
                      clearable
                      prepend-icon="mdi-account-outline"
                      :error-messages="errors"
                      :counter="12"
                    />
                  </validation-provider>
                  <validation-provider
                    v-slot="{ errors }"
                    name="비밀번호"
                    :rules="{ max: 15, required: true }"
                  >
                    <v-text-field
                      type="password"
                      v-model="pw"
                      label="비밀번호"
                      clearable
                      prepend-icon="mdi-lock-outline"
                      :error-messages="errors"
                      :counter="15"
                    />
                  </validation-provider>
                  <validation-provider
                    v-slot="{ errors }"
                    name="비밀번호 확인"
                    :rules="{ max: 15, confirmed: '비밀번호', required: true }"
                  >
                    <v-text-field
                      type="password"
                      v-model="pwConfirm"
                      label="비밀번호 확인"
                      clearable
                      prepend-icon="mdi-lock-check-outline"
                      :error-messages="errors"
                      :counter="15"
                    />
                  </validation-provider>
                  <validation-provider
                    v-slot="{ errors }"
                    name="닉네임"
                    :rules="{ max: 10, required: true }"
                  >
                    <v-text-field
                      v-model="nickName"
                      label="닉네임"
                      clearable
                      prepend-icon="mdi-badge-account-outline"
                      :error-messages="errors"
                      :counter="10"
                    />
                  </validation-provider>
                  <validation-provider
                    v-slot="{ errors }"
                    name="이메일"
                    :rules="{ email: true, required: true }"
                  >
                    <v-text-field
                      v-model="email"
                      label="이메일"
                      clearable
                      prepend-icon="mdi-email"
                      :error-messages="errors"
                    />
                  </validation-provider>
                  <v-btn
                    type="submit"
                    block
                    x-large
                    rounded
                    color="orange lighten-1"
                    class="mt-6"
                    :disabled="invalid"
                  >
                    가입하기</v-btn
                  >
                </v-form>
              </validation-observer>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "SignUpForm",
  data() {
    return {
      id: "",
      pw: "",
      pwConfirm: "",
      nickName: "",
      email: "",
      auth: "개인",
    };
  },
  methods: {
    onSubmit() {
      const { id, pw, nickName, email, auth } = this;
      this.$emit("submit", { id, pw, nickName, email, auth });
    },
  },
};
</script>
