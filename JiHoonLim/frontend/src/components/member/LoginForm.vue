<template>
  <div class="grey lighten-5" style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1240px">
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
              <validation-observer ref="observer" v-slot="{ invalid }">
                <v-form @submit.prevent="onSubmit">
                  <div class="text-h4 font-weight-black mb-10">로그인</div>
                  <validation-provider
                    v-slot="{ errors }"
                    name="아이디"
                    :rules="{ max: 12, required: true, alpha_num: true }"
                  >
                    <v-text-field
                      v-model="id"
                      label="아이디"
                      clearable
                      prepend-icon="mdi-account-outline"
                      :error-messages="errors"
                      color="orange"
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
                      color="orange"
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
                    로그인</v-btn
                  >
                  <div class="mt-5">
                    <router-link
                      class="text-decoration-none orange--text mr-5"
                      to="/signup"
                    >
                      회원가입
                    </router-link>
                    |
                    <router-link
                      class="text-decoration-none orange--text ml-5 mr-5"
                      to="/searchUserId"
                    >
                      ID 찾기
                    </router-link>
                    |
                    <router-link
                      class="text-decoration-none orange--text ml-5 mr-5"
                      to="/searchUserPw"
                    >
                      PW 찾기
                    </router-link>
                  </div>
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
  name: "LoginForm",
  data() {
    return {
      id: "",
      pw: "",
    };
  },
  methods: {
    onSubmit() {
      const { id, pw } = this;
      this.$emit("submit", { id, pw });
    },
  },
};
</script>
<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
</style>
