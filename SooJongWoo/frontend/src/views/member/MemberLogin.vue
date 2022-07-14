<template>
  <div class="img">
    <div class="content">
      <v-container fill-height style="max-width: 700px">
        <v-card class="login-box">
          <v-flex xs12>
            <h1 style="color: black">Login</h1>
            <p>Please enter your account.</p>
            <div>
              <v-container style="width: 80%; margin-top: 10%">
                <v-text-field
                  solo
                  flat
                  v-model="userId"
                  type="text"
                  required
                  height="5vh"
                  dense
                  label="아이디"
                  :rules="[(v) => !!v || '필수정보입니다.']"
                ></v-text-field>

                <v-text-field
                  solo
                  flat
                  v-model="password"
                  type="password"
                  required
                  height="5vh"
                  dense
                  label="비밀번호"
                  :rules="[(v) => !!v || '필수정보입니다.']"
                ></v-text-field>
              </v-container>

              <div class="btn-size">
                <v-btn
                  width="300"
                  height="50"
                  @click="login({ userId, password })"
                  rounded
                  color="blue"
                  style="float: left; margin-top: 3%"
                  class="white--text"
                >
                  LOGIN
                </v-btn>
                <v-btn
                  width="300"
                  height="50"
                  color="blue darken-4"
                  style="float: left; margin-top: 3%"
                  class="white--text"
                  route
                  :to="'/memberRegister'"
                  text
                  plain
                >
                  Is this your first time?
                </v-btn>
              </div>
            </div>
          </v-flex>
        </v-card>
      </v-container>
    </div>
    <div class="img-cover"></div>
  </div>
</template>

<script>
import { LOGIN_SUCCESS } from "@/store/mutation-types";
export default {
  name: "MemberLogin",
  data() {
    return {
      userId: "",
      password: "",
    };
  },
  mounted() {
    this.$store.state.session = this.$cookies.get("user");
    if (this.$store.state.session != null) {
      LOGIN_SUCCESS;
    }
  },
  methods: {
    login(payload) {
      if (this.$store.state.session == null) {
        const { userId, password } = payload;
        this.$store.dispatch("login", { userId, password });
      } else {
        alert("이미 로그인 되어 있습니다.");
      }
    },
  },
};
</script>