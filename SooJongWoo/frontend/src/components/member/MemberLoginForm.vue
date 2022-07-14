<template>
  <form @submit.prevent="onSubmit">
    <v-flex xs12>
      <v-alert class="mb-3" :value="isLoginError" type="error">
        아이디와 비밀번호를 확인해주세요.
      </v-alert>
      <v-alert class="mb-3" :value="isLogin" type="success">
        로그인이 완료되었습니다.
      </v-alert>
      <h1>Welcome</h1>
      <h2>to</h2>
      <h1>Cinzel</h1>

      <div>
        <v-icon class="mail-icon" color="white">email</v-icon>
        <v-text-field
          label="아이디"
          dense
          required
          height="5vh"
          v-model="userId"
          :rules="[(v) => !!v || '필수정보입니다.']"
          type="id"
        >
        </v-text-field>

        <v-icon class="mail-icon" color="white">lock</v-icon>
        <v-text-field
          label="비밀번호"
          dense
          required
          height="5vh"
          v-model="password"
          :rules="[(v) => !!v || '필수정보입니다.']"
          type="password"
        >
        </v-text-field>

        <div class="btn-size">
          <v-btn
            width="410"
            height="50"
            type="submit"
            color="blue"
            style="float: left; margin-top: 3%"
            class="white--text"
          >
            로그인
          </v-btn>
          <v-btn
            width="410"
            height="50"
            color="blue darken-4"
            style="float: left; margin-top: 3%"
            class="white--text"
            route
            :to="'/memberRegister'"
          >
            회원가입
          </v-btn>
        </div>
      </div>
    </v-flex>
  </form>
</template>

<script>
export default {
  name: "MemberLoginForm",
  data() {
    return {
      userId: "",
      password: "",
    };
  },
  methods: {
    onSubmit() {
      const { userId, password } = this;
      this.$emit("submit", { userId, password });
    },
  },
};
</script>