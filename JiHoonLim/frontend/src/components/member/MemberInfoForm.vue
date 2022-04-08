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
              <validation-observer ref="observer">
                <v-form>
                  <div class="text-h4 font-weight-black mb-10">
                    회원 정보 수정
                  </div>

                  <v-text-field
                    v-model="userInfoId"
                    :value="userInfo.id"
                    label="아이디"
                    clearable
                    prepend-icon="mdi-account-outline"
                    disabled
                  />

                  <v-text-field
                    v-model="userInfoName"
                    :value="userInfo.name"
                    label="이름"
                    clearable
                    prepend-icon="mdi-badge-account-horizontal-outline"
                    disabled
                  />
                  <div class="d-flex">
                    <v-text-field
                      v-model="userInfoNickName"
                      label="닉네임"
                      clearable
                      :value="userInfo.nickName"
                      prepend-icon="mdi-badge-account-outline"
                      disabled
                    />

                    <template>
                      <div class="text-center">
                        <v-dialog v-model="dialogNick" width="460">
                          <template v-slot:activator="{ on, attrs }">
                            <v-btn
                              width="100px"
                              style="font-size: 13px"
                              class="mt-3 ml-5"
                              color="orange lighten-1"
                              v-bind="attrs"
                              v-on="on"
                            >
                              닉네임 변경
                            </v-btn>
                          </template>

                          <v-card>
                            <v-card-title class="text-h5 orange lighten-3">
                              닉네임 변경
                            </v-card-title>
                            <v-card-text>
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
                                  class="mt-3 ml-8"
                                  color="orange lighten-1"
                                  @click="checkDuplicateNickName"
                                  :disabled="nickName == ''"
                                  >닉네임 <br />중복 확인</v-btn
                                >
                              </div>
                            </v-card-text>

                            <v-divider></v-divider>

                            <v-card-actions>
                              <v-spacer></v-spacer>
                              <v-btn
                                color="orange lighten-3"
                                text
                                :disabled="nickName == ''"
                                @click="memberNickModify"
                              >
                                수정
                              </v-btn>
                              <v-btn
                                color="orange lighten-3"
                                text
                                @click="dialogNick = false"
                              >
                                취소
                              </v-btn>
                            </v-card-actions>
                          </v-card>
                        </v-dialog>
                      </div>
                    </template>
                  </div>
                  <div class="d-flex">
                    <v-text-field
                      v-model="userInfoEmail"
                      label="이메일"
                      :value="userInfo.email"
                      clearable
                      prepend-icon="mdi-email"
                      disabled
                    />
                    <template>
                      <div class="text-center">
                        <v-dialog v-model="dialogEmail" width="460">
                          <template v-slot:activator="{ on, attrs }">
                            <v-btn
                              width="100px"
                              style="font-size: 13px"
                              class="mt-3 ml-5"
                              color="orange lighten-1"
                              v-bind="attrs"
                              v-on="on"
                            >
                              이메일 변경
                            </v-btn>
                          </template>

                          <v-card>
                            <v-card-title class="text-h5 orange lighten-3">
                              이메일 변경
                            </v-card-title>
                            <v-card-text>
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
                                  class="mt-3 ml-8"
                                  color="orange lighten-1"
                                  @click="checkDuplicateEmail"
                                  :disabled="email == ''"
                                  >이메일 <br />중복 확인</v-btn
                                >
                              </div>
                            </v-card-text>

                            <v-divider></v-divider>

                            <v-card-actions>
                              <v-spacer></v-spacer>
                              <v-btn
                                color="orange lighten-3"
                                text
                                :disabled="email == ''"
                                @click="memberEmailModify"
                              >
                                수정
                              </v-btn>
                              <v-btn
                                color="orange lighten-3"
                                text
                                @click="dialogEmail = false"
                              >
                                취소
                              </v-btn>
                            </v-card-actions>
                          </v-card>
                        </v-dialog>
                      </div>
                    </template>
                  </div>

                  <v-btn
                    type="submit"
                    width="100px"
                    rounded
                    color="orange lighten-1"
                    class="mt-6 mr-5"
                  >
                    비밀번호 변경</v-btn
                  >
                  <v-btn
                    type="submit"
                    width="100px"
                    rounded
                    color="orange lighten-1"
                    class="mt-6 ml-5"
                  >
                    탈퇴하기</v-btn
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
  name: "MemberInfoForm",
  data() {
    return {
      dialogNick: false,
      dialogEmail: false,
      NickPass: false,
      EmailPass: false,
      nickName: "",
      email: "",
    };
  },
  props: {
    userInfo: {
      type: Object,
      required: true,
    },
  },
  created() {
    this.userInfoId = this.userInfo.id;
    this.userInfoName = this.userInfo.name;
    this.userInfoNickName = this.userInfo.nickName;
    this.userInfoEmail = this.userInfo.email;
    this.memberNo = this.userInfo.memberNo;
  },
  methods: {
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
    memberNickModify() {
      if (!this.NickPass) {
        alert("닉네임 중복확인을 해주세요.");
      } else {
        const { nickName } = this;
        axios
          .post(`http://localhost:7777/member/modifyNick/${this.memberNo}`, {
            nickName,
          })
          .then(() => {
            alert("닉네임이 변경되었습니다.");
            this.dialogNick = false;
          });
      }
    },
    memberEmailModify() {
      if (!this.EmailPass) {
        alert("이메일 중복확인을 해주세요.");
      } else {
        const { email } = this;
        axios
          .post(`http://localhost:7777/member/modifyEmail/${this.memberNo}`, {
            email,
          })
          .then(() => {
            alert("이메일이 변경되었습니다.");
            this.dialogEmail = false;
          });
      }
    },
  },
};
</script>
