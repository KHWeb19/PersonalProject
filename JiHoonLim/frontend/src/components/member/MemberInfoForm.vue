<template>
  <div class="grey lighten-3" style="font-family: 'Noto Sans KR', sans-serif">
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
              <validation-observer ref="observer">
                <v-form>
                  <div class="text-h4 font-weight-black mb-10">
                    회원 정보 수정
                  </div>

                  <v-text-field
                    :value="userInfo.id"
                    label="아이디"
                    clearable
                    prepend-icon="mdi-account-outline"
                    disabled
                  />

                  <v-text-field
                    :value="userInfo.name"
                    label="이름"
                    clearable
                    prepend-icon="mdi-badge-account-horizontal-outline"
                    disabled
                  />
                  <div class="d-flex">
                    <v-text-field
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

                  <template>
                    <validation-observer v-slot="{ invalid }">
                      <div class="text-center">
                        <v-dialog v-model="dialogPw" width="460">
                          <template v-slot:activator="{ on, attrs }">
                            <v-btn
                              rounded
                              x-large
                              style="font-size: 13px"
                              class="mt-3"
                              color="orange lighten-1"
                              v-bind="attrs"
                              v-on="on"
                            >
                              비밀번호 변경
                            </v-btn>
                          </template>

                          <v-card>
                            <v-card-title class="text-h5 orange lighten-3">
                              비밀번호 변경
                            </v-card-title>
                            <v-card-text>
                              <validation-provider
                                v-slot="{ errors }"
                                name="비밀번호"
                                :rules="{ max: 15, required: true }"
                              >
                                <v-text-field
                                  type="password"
                                  v-model="pw"
                                  label="변경하실 비밀번호"
                                  clearable
                                  prepend-icon="mdi-lock-outline"
                                  :error-messages="errors"
                                  :counter="15"
                                />
                              </validation-provider>
                              <validation-provider
                                v-slot="{ errors }"
                                name="비밀번호 확인"
                                :rules="{
                                  max: 15,
                                  confirmed: '비밀번호',
                                  required: true,
                                }"
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
                            </v-card-text>

                            <v-divider></v-divider>

                            <v-card-actions>
                              <v-spacer></v-spacer>
                              <v-btn
                                color="orange lighten-3"
                                text
                                :disabled="invalid"
                                @click="memberPwModify"
                              >
                                수정
                              </v-btn>
                              <v-btn
                                color="orange lighten-3"
                                text
                                @click="dialogPw = false"
                              >
                                취소
                              </v-btn>
                            </v-card-actions>
                          </v-card>
                        </v-dialog>
                      </div>
                    </validation-observer>
                  </template>

                  <template>
                    <div class="text-center">
                      <v-dialog v-model="dialogDeleteMember" width="460">
                        <template v-slot:activator="{ on, attrs }">
                          <v-btn
                            width="100px"
                            rounded
                            style="font-size: 13px"
                            class="mt-5"
                            color="orange lighten-5 red--text"
                            v-bind="attrs"
                            v-on="on"
                            @click="resetCheckbox"
                          >
                            회원 탈퇴
                          </v-btn>
                        </template>

                        <v-card>
                          <v-card-title class="text-h5 orange lighten-3">
                            회원 탈퇴
                          </v-card-title>
                          <v-card-text class="mt-5 pb-0">
                            정말로 회원을 탈퇴하시겠습니까? <br />
                            탈퇴를 원하시면 동의버튼을 체크하시고 <br />
                            탈퇴버튼을 클릭해주세요.
                          </v-card-text>
                          <v-container class="pt-0 pb-0" fluid>
                            <v-checkbox
                              v-model="checkbox"
                              label="동의합니다."
                            ></v-checkbox>
                          </v-container>
                          <v-divider></v-divider>

                          <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn
                              color="orange lighten-3"
                              text
                              :disabled="!checkbox"
                              @click="deleteLoginUser"
                            >
                              탈퇴
                            </v-btn>
                            <v-btn
                              color="orange lighten-3"
                              text
                              @click="dialogDeleteMember = false"
                            >
                              취소
                            </v-btn>
                          </v-card-actions>
                        </v-card>
                      </v-dialog>
                    </div>
                  </template>
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
      dialogPw: false,
      dialogDeleteMember: false,
      NickPass: false,
      EmailPass: false,
      nickName: "",
      email: "",
      pw: "",
      pwConfirm: "",
      checkbox: false,
    };
  },
  props: {
    userInfo: {
      type: Object,
      required: true,
    },
  },
  created() {
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
          .then((res) => {
            alert("닉네임이 변경되었습니다.");
            localStorage.setItem("userInfo", JSON.stringify(res.data));

            this.dialogNick = false;
            this.$router.go();
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
          .then((res) => {
            alert("이메일이 변경되었습니다. ");
            localStorage.setItem("userInfo", JSON.stringify(res.data));

            this.dialogEmail = false;
            this.$router.go();
          });
      }
    },
    memberPwModify() {
      const { pw } = this;
      axios
        .post(`http://localhost:7777/member/resetLoginPw/${this.memberNo}`, {
          pw,
        })
        .then(() => {
          alert("비밀번호가 변경되었습니다.");
          this.dialogPw = false;
        });
    },
    deleteLoginUser() {
      const { memberNo } = this.userInfo;
      axios
        .delete(`http://localhost:7777/member/deleteMember/${memberNo}`)
        .then(() => {
          alert("회원탈퇴가 완료되었습니다.");
          this.$cookies.remove("user");
          this.isLogin = false;
          this.$store.state.userInfo = null;
          localStorage.removeItem("userInfo");
          this.$router.push("/");
        });
    },
    resetCheckbox() {
      this.checkbox = false;
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
</style>
