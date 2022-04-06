<template>
  <div class="grey lighten-3">
    <v-container class="white">
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

                  <div class="d-flex">
                    <validation-provider
                      v-slot="{ errors }"
                      name="아이디"
                      :rules="{
                        max: 12,
                        required: true,
                        alpha_num: true,
                      }"
                    >
                      <v-text-field
                        v-model="id"
                        label="아이디"
                        clearable
                        prepend-icon="mdi-account-outline"
                        :error-messages="errors"
                        :counter="12"
                        class="mr-5"
                      />
                    </validation-provider>
                    <v-btn
                      width="100px"
                      style="font-size: 13px"
                      class="mt-3 ml-5"
                      color="orange lighten-1"
                      @click="checkDuplicateId"
                      :disabled="id == ''"
                      >아이디 <br />중복 확인</v-btn
                    >
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
                  <validation-provider
                    v-slot="{ errors }"
                    name="이름"
                    :rules="{ required: true }"
                  >
                    <v-text-field
                      v-model="name"
                      label="이름"
                      clearable
                      prepend-icon="mdi-badge-account-horizontal-outline"
                      :error-messages="errors"
                    />
                  </validation-provider>
                  <div class="d-flex">
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
                        class="mr-5"
                      />
                    </validation-provider>
                    <v-btn
                      width="100px"
                      style="font-size: 13px"
                      class="mt-3 ml-5"
                      color="orange lighten-1"
                      @click="checkDuplicateNickName"
                      :disabled="nickName == ''"
                      >닉네임 <br />중복 확인</v-btn
                    >
                  </div>
                  <div class="d-flex">
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
                        class="mr-5"
                      />
                    </validation-provider>
                    <v-btn
                      width="100px"
                      style="font-size: 13px"
                      class="mt-3 ml-5"
                      color="orange lighten-1"
                      @click="checkDuplicateEmail"
                      :disabled="email == ''"
                      >이메일 <br />중복 확인</v-btn
                    >
                  </div>

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
import axios from "axios";

export default {
  name: "SignUpForm",
  data() {
    return {
      id: "",
      pw: "",
      pwConfirm: "",
      name: "",
      nickName: "",
      email: "",
      auth: "개인",
      IdPass: false,
      NickPass: false,
      EmailPass: false,
    };
  },
  methods: {
    onSubmit() {
      if (!this.IdPass) {
        alert("아이디 중복확인을 해주세요.");
      } else if (!this.NickPass) {
        alert("닉네임 중복확인을 해주세요.");
      } else if (!this.EmailPass) {
        alert("이메일 중복확인을 해주세요.");
      } else {
        const { id, pw, name, nickName, email, auth } = this;
        this.$emit("submit", { id, pw, name, nickName, email, auth });
      }
    },
    checkDuplicateId() {
      const { id } = this;
      axios.get(`http://localhost:7777/member/checkId/${id}`).then((res) => {
        this.temp = res.data;
        if (res.data) {
          alert("사용 가능한 아이디 입니다.");
          this.IdPass = true;
        } else {
          alert("중복된 아이디 입니다.");
          this.IdPass = false;
        }
      });
    },
    checkDuplicateNickName() {
      const { nickName } = this;
      axios
        .get(`http://localhost:7777/member/checkNickName/${nickName}`)
        .then((res) => {
          this.temp = res.data;
          if (res.data) {
            alert("사용 가능한 닉네임 입니다.");
            this.NickPass = true;
          } else {
            alert("중복된 닉네임 입니다.");
            this.NickPass = false;
          }
        });
    },
    checkDuplicateEmail() {
      const { email } = this;
      axios
        .get(`http://localhost:7777/member/checkEmail/${email}`)
        .then((res) => {
          this.temp = res.data;
          if (res.data) {
            alert("사용 가능한 이메일 입니다.");
            this.EmailPass = true;
          } else {
            alert("중복된 이메일 입니다.");
            this.EmailPass = false;
          }
        });
    },
  },
};
</script>
