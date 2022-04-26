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
              <v-form>
                <div class="text-h4 font-weight-black mb-10">
                  회원 정보 수정
                </div>

                <v-text-field
                  :value="registerMember.memberNo"
                  label="회원번호"
                  clearable
                  prepend-icon="mdi-counter"
                  disabled
                />
                <v-text-field
                  :value="registerMember.id"
                  label="아이디"
                  clearable
                  prepend-icon="mdi-account-outline"
                  disabled
                />

                <v-text-field
                  :value="registerMember.name"
                  label="이름"
                  clearable
                  prepend-icon="mdi-badge-account-horizontal-outline"
                  disabled
                />

                <v-text-field
                  label="닉네임"
                  clearable
                  :value="registerMember.nickName"
                  prepend-icon="mdi-badge-account-outline"
                  disabled
                />

                <v-text-field
                  label="이메일"
                  :value="registerMember.email"
                  clearable
                  prepend-icon="mdi-email"
                  disabled
                />
                <v-text-field
                  label="가입일자"
                  :value="registerMember.regDate"
                  clearable
                  prepend-icon="mdi-calendar-range"
                  disabled
                />

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
                            @click="deleteMember"
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
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
//import axios from "axios";

export default {
  name: "MemberManageModifyForm",
  props: {
    registerMember: {
      type: Object,
      required: true,
    },
    registerMemberAuth: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      dialogDeleteMember: false,
      checkbox: false,
    };
  },
  methods: {
    deleteMember() {},
    resetCheckbox() {
      this.checkbox = false;
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
</style>
