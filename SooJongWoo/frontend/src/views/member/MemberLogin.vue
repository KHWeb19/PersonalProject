<template>
  <div class="img">
    <div class="content">
      <v-container fill-height style="width: 500px; height: 500px">
        <v-card class="login-box">
          <v-flex xs12>
            <h1 style="color: black">Login</h1>
            <p>Please enter your account.</p>
            <div>
              <v-container style="width: 90%; margin-top: 10%">
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
                  width="350"
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
                  width="350"
                  height="50"
                  color="blue darken-4"
                  style="float: left; margin-top: 3%"
                  class="white--text"
                  route
                  :to="'/memberRegister'"
                  text
                  plain
                  type="button"
                >
                  저희 숙소를 처음 이용하시는 건가요?
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
    this.$store.state.userInfo = this.$cookies.get("user");

    if (this.$store.state.userInfo != null) {
      LOGIN_SUCCESS;
    }
  },
  methods: {
    login(payload) {
      if (this.$store.state.session == null) {
        const { userId, password } = payload;
        this.$store.dispatch("login", { userId, password });
      } else {
        alert("이미 로그인 되어있습니다.");
      }
    },
  },
};
</script>

<style scoped>
.login-box {
  padding: 10% 0% 10% 0%;
}

.btn-size {
  position: relative;
  left: 13%;
}
.mail-icon {
  float: left;
  padding: 10px 20px 10px 20px;
}
h1 {
  font-size: 80px;
  margin: 0;
}
h2 {
  font-weight: bold;
  font-size: 40px;
  margin: -3%;
}
p {
  font-size: 14px;
  margin: 2% 0% 2% 0%;
}
.comp-login {
  width: 500px;
  height: 500px;
}
.img {
  position: relative;
  background-image: url("https://images.pexels.com/photos/533923/pexels-photo-533923.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
  height: 100vh;
  background-size: cover;
}
.img-cover {
  position: absolute;
  height: 100%;
  width: 100%;
  background-color: rgba(0, 0, 0, 0.6);
  z-index: 1;
}
.img .content {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 5rem;
  color: white;
  z-index: 2;
  text-align: center;
}
</style>