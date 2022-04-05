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
              <validation-observer ref="observer" v-slot="{ invalid }">
                <v-form @submit.prevent="LogIn">
                  <div class="text-h4 font-weight-black mb-10">로그인</div>
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
                    />
                  </validation-provider>
                  <validation-provider
                    v-slot="{ errors }"
                    name="비밀번호"
                    :rules="{ max: 15, required: true }"
                  >
                    <v-text-field
                      v-model="pw"
                      label="비밀번호"
                      clearable
                      prepend-icon="mdi-lock-outline"
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
                    로그인</v-btn
                  >
                  <div class="mt-5">
                    <router-link
                      class="text-decoration-none orange--text"
                      to="/signup"
                    >
                      회원가입
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
      id: null,
      pw: null,
    };
  },
  methods: {
    async LogIn() {
      const res = await this.$refs.observer.validate();
      if (res) {
        alert("로그인 프로세스");
      }
    },
  },
};
</script>
