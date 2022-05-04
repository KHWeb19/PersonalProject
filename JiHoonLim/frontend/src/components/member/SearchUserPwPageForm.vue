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
          <v-card width="460" v-if="!isPass">
            <v-card-text class="text-center px-12 py-16">
              <validation-observer ref="observer" v-slot="{ invalid }">
                <v-form>
                  <div class="text-h4 font-weight-black mb-10">PW 찾기</div>
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
                      :counter="12"
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
                    block
                    x-large
                    rounded
                    color="orange lighten-1"
                    class="mt-6"
                    @click="findUserId"
                    :disabled="invalid"
                  >
                    찾기</v-btn
                  >
                </v-form>
              </validation-observer>
            </v-card-text>
          </v-card>

          <v-card width="460" v-if="isPass">
            <v-card-text class="text-center px-12 py-16">
              <validation-observer v-slot="{ invalid }">
                <v-form>
                  <div class="text-h4 font-weight-black mb-10">
                    비밀번호 재설정
                  </div>

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

                  <v-btn
                    type="submit"
                    block
                    x-large
                    rounded
                    color="orange lighten-1"
                    class="mt-6"
                    @click="resetPw"
                    :disabled="invalid"
                  >
                    비밀번호 변경</v-btn
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
import axios from "axios";

export default {
  name: "SearchUserPwPageForm",
  data() {
    return {
      id: "",
      email: "",
      isPass: false,
      pw: "",
      pwConfirm: "",
    };
  },
  methods: {
    findUserId() {
      const { id, email } = this;
      axios
        .post("http://localhost:7777/member/idMatchEmail", { id, email })
        .then((res) => {
          if (res.data) {
            alert("인증이 완료되었습니다.");
            this.isPass = true;
          } else {
            alert("입력하신 정보로 가입된 정보가 없습니다.");
            this.isPass = false;
          }
        });
    },
    resetPw() {
      const { id, pw } = this;
      axios
        .post(`http://localhost:7777/member/resetNoLoginPw/${id}`, {
          pw,
        })
        .then(() => {
          alert("비밀번호가 변경되었습니다.");
        });
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
</style>
