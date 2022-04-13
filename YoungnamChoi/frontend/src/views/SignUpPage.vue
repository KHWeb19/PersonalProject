<template>
  <div>
    <div class="회원가입상단" align="center">
      <h1 style="padding: 50px; font-weight: bold">Sign Up</h1>
    </div>
    <sign-up-form @submit="onSubmit" />
  </div>
</template>

<script>
import axios from "axios";
import SignUpForm from "@/components/user/SignUpForm.vue";

export default {
  name: "SignUpPage.vue",
  components: {
    SignUpForm,
  },
  methods: {
    onSubmit(payload) {
      const { id, pw } = payload;
      axios
        .post("http://localhost:7777/user/register", { id, pw })
        .then(() => {
          alert("회원가입이 완료되었습니다.!");

          this.$router.push({
            name: "LoginPage",
          });
        })
        .catch((res) => {
          alert(res.response.data.message);
        });
    },
  },
};
</script>
<style scoped></style>
