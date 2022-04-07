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
              <v-form>
                <div class="text-h4 font-weight-black mb-10">회원가입</div>

                <v-text-field
                  v-model="id"
                  :value="userInfo.id"
                  clearable
                  prepend-icon="mdi-account-outline"
                  disabled
                />
                <!--
                <v-text-field
                  type="password"
                  v-model="pw"
                  label="비밀번호"
                  clearable
                  prepend-icon="mdi-lock-outline"
                />

                <v-text-field
                  type="password"
                  v-model="pwConfirm"
                  label="비밀번호 확인"
                  clearable
                  prepend-icon="mdi-lock-check-outline"
                />
                -->

                <v-text-field
                  v-model="name"
                  :value="userInfo.name"
                  clearable
                  prepend-icon="mdi-badge-account-horizontal-outline"
                  disabled
                />

                <v-text-field
                  v-model="nickName"
                  :value="userInfo.nickName"
                  clearable
                  prepend-icon="mdi-badge-account-outline"
                />

                <v-text-field
                  v-model="email"
                  :value="userInfo.email"
                  clearable
                  prepend-icon="mdi-email"
                />

                <v-btn
                  type="submit"
                  block
                  x-large
                  rounded
                  color="orange lighten-1"
                  class="mt-6"
                  :disabled="invalid"
                >
                  수정하기</v-btn
                >
              </v-form>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "MemberModifyForm",
  props: {
    userInfo: {
      type: Object,
      required: true,
    },
  },
  created() {
    this.id = this.userInfo.id;
    this.name = this.userInfo.name;
    this.nickName = this.userInfo.nickName;
    this.email = this.userInfo.email;
  },
};
</script>
