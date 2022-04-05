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
                <v-form @submit.prevent="onSubmit">
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
    };
  },
  methods: {
    findUserId() {
      const { id, email } = this;
      axios
        .post("http://localhost:7777/member/idMatchEmail", { id, email })
        .then((res) => {
          if (res.data) {
            alert("인증이 완료되었습니다. 비밀번호 변경 페이지로 이동합니다.");
            this.$router.push("/pwReset");
          } else {
            alert("입력하신 정보로 가입된 정보가 없습니다.");
          }
        });
    },
  },
};
</script>
