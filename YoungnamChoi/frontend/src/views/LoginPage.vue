<template>
  <div>
    <div class="로그인상단" align="center">
      <h1 style="padding: 50px; font-weight: bold">LOGIN</h1>
    </div>
    <login-form @submit="onSubmit" />
  </div>
</template>

<script>
import LoginForm from "@/components/user/LoginForm.vue";
import { mapState, mapActions } from "vuex";
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
    this.$store.state.session = this.$cookies.get("user");
    if (this.$store.state.session != null) {
      this.isLogin = true;
    }
  },
  computed: {
    ...mapState(["session"]),
  },
  methods: {
    ...mapActions(["fetchSession"]),
    onSubmit(payload) {
      if (this.$store.state.session == null) {
        const { email, password } = payload;
        axios
          .post("http://localhost:7777/jpasession/sign-in", { email, password })
          .then((res) => {
            if (res.data.hashcode != null) {
              alert("로그인 되었습니다.");
              this.isLogin = true;
              this.$store.state.session = res.data;
              this.$cookies.set("user", res.data, "1h");
              this.$router.push({
                name: "Home2",
              });
            } else {
              alert("아이디와 비밀번호를 확인해주세요.");
              this.isLogin = false;
            }
          })
          .catch((res) => {
            alert(res.response.data.message);
          });
      } else {
        alert(
          "이미 로그인 되어 있습니다. - 계정: " +
            this.$store.state.session.email
        );
      }
    },
    showSession() {
      if (this.isLogin == true) {
        axios
          .post("http://localhost:7777/jpamember/needSession")
          .then((res) => {
            if (res.data == true) {
              alert("세션 정보 유지! - " + res.data);
            } else {
              alert("세션 정보 유지 안되는 중! - " + res.data);
            }
            /*
                            this.$router.push({
                                name: 'Page'
                            })
                            */
          })
          .catch((res) => {
            alert(res.response.data.message);
          });
      } else {
        alert("로그인 하세요.");
      }
    },
    removeSession() {
      axios
        .post("http://localhost:7777/jpamember/removeSession")
        .then((res) => {
          this.isLogin = res.data;
        });
    },
    logout() {
      this.$cookies.remove("user");
      this.isLogin = false;
      this.$store.state.session = null;
    },
    account() {
      this.$router.push({
        name: "MyPage",
      });
    },
  },
};
</script>
