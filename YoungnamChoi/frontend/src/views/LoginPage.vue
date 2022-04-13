<template>
  <div>
    <div class="login" align="center">
      <h1 style="padding: 50px; font-weight: bold">LOGIN</h1>
    </div>
    <login-form @submit="onSubmit" />
  </div>
</template>

<script>
import LoginForm from "@/components/user/LoginForm.vue";
import Vue from "vue";
import cookies from "vue-cookies";
import axios from "axios";
Vue.use(cookies);
export default {
  name: "LoginPage",
  components: {
    LoginForm,
  },
  data() {
    return {
      isLogin: false,
    };
  },
  mounted() {
    // this.fetchSession()
    this.$store.state.userInfo = this.$cookies.get("user");
    if (this.$store.state.userInfo != null) {
      this.isLogin = true;
    } else {
      this.isLogin = false;
    }
  },

  methods: {
    onSubmit(payload) {
      if (!this.isLogin) {
        const { id, pw } = payload;
        axios
          .post("http://localhost:7777/user/login", { id, pw })
          .then((res) => {
            if (res.data) {
              alert("로그인 되었습니다.");
              window.localStorage.setItem("userInfo", JSON.stringify(res.data));
              window.localStorage.setItem("token", res.data.token);
              localStorage.setItem("id", res.data.id);
              this.isLogin = true;
              this.$router.push({ name: "MainHomepage" });
              console.log(window.localStorage.getItem("userInfo"));
              console.log(window.localStorage.getItem("id"));
              this.$router.push({
                name: "Home",
              });
            } else {
              alert("아이디와 비밀번호를 확인해주세요.");
            }
          })
          .catch((res) => {
            alert(res.response.data.message);
          });
      } else {
        alert("이미 로그인 되어 있습니다. - 계정: ");
      }
    },
  },
};
</script>
