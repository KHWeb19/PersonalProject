<template>
  <v-container style="height: 100%">
    <form @submit.prevent="onSubmit">
      <div>
        <v-card class="card-box">
          <h2>Create Account</h2>
          <p>Please enter your information</p>
          <div justify-center>
            <v-container style="width: 90%">
              <v-text-field
                solo
                flat
                v-model="userName"
                type="text"
                required
                height="3vh"
                dense
                label="Name"
                :rules="rules_name"
              ></v-text-field>
              <v-text-field
                solo
                flat
                v-model="userId"
                type="text"
                required
                height="3vh"
                dense
                label="ID (not Email Format)"
                :rules="rules_id"
              ></v-text-field>
              <v-text-field
                solo
                flat
                v-model="password"
                type="Password"
                required
                height="3vh"
                dense
                label="Password"
                :rules="rules_pw"
              ></v-text-field>
              <v-text-field
                solo
                flat
                v-model="passwordReInput"
                type="Password"
                required
                height="3vh"
                dense
                label="Repeat-Password"
                :rules="rules_pw2"
              ></v-text-field>
              <v-text-field
                solo
                flat
                v-model="userPhone"
                type="text"
                required
                height="3vh"
                dense
                label="Phone"
                :rules="rules_call"
              ></v-text-field>

              <div class="btn-size">
                <v-btn
                  width="300"
                  height="50"
                  type="submit"
                  color="blue"
                  style="float: left; margin-top: 6%"
                  class="white--text"
                  rounded
                >
                  SIGN UP
                </v-btn>
              </div>
            </v-container>
          </div>
        </v-card>
      </div>
    </form>
  </v-container>
</template>

<script>
export default {
  name: "MemberRegisterForm",
  data() {
    return {
      auth: "개인",
      userName: "",
      rules_name: [
        (v) => !!v || "이름을 입력해주세요.",
        (v) => !(v.length >= 5) || "이름은 5자 이상 입력할 수 없습니다.",
        (v) =>
          !/[~!@#$%^&*()_+|<>?:{}]/.test(v) || "특수문자를 사용할 수 없습니다.",
      ],
      rules_pw: [
        (v) => !!v || "비밀번호를 입력해주세요.",
        (v) => v.length >= 6 || "비밀번호를 6자 이상 입력해주세요",
      ],
      rules_pw2: [
        (v) => !!v || "비밀번호를 입력해주세요.",
        (v) => v === this.password || "비밀번호가 일치하지 않습니다.",
      ],
      rules_id: [
        (v) => !!v || "아이디를 입력해주세요.",
        (v) => v.length >= 5 || "아이디를 5자 이상 입력해주세요.",
      ],
      rules_call: [
        (v) => !!v || "전화번호를 입력해주세요.",
        (v) => v.length >= 11 || "전화번호를 입력해주세요.",
      ],

      userId: "",
      password: "",
      passwordReInput: "",
      userPhone: "",
    };
  },
  methods: {
    onSubmit() {
      const { userName, userId, password, passwordReInput, userPhone, auth } =
        this;
      this.$emit("submit", {
        userName,
        userId,
        password,
        passwordReInput,
        userPhone,
        auth,
      });
    },
  },
};
</script>