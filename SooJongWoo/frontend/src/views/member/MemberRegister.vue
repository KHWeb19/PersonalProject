<template>
  <div class="img">
    <div class="content">
      <member-register-form @submit="onSubmit" class="comp-login" />
    </div>
    <div class="img-cover"></div>
  </div>
</template>

<script>
import MemberRegisterForm from "@/components/member/MemberRegisterForm.vue";
import axios from "axios";
export default {
  name: "MemberRegister",
  components: {
    MemberRegisterForm,
  },
  methods: {
    onSubmit(payload) {
      const { userName, userId, password, passwordReInput, userPhone, auth } =
        payload;
      if (password == passwordReInput) {
        axios
          .post("http://localhost:7777/jpaMember/register", {
            userName,
            userId,
            password,
            passwordReInput,
            userPhone,
            auth,
          })
          .then((res) => {
            if (res.data != "") {
              alert("회원가입이 완료됐습니다." + res);
              this.$router.push({
                name: "MemberLogin",
              });
            } else {
              alert("중복된 아이디입니다.");
            }
          })
          .catch((res) => {
            alert(res.response.data.message);
          });
      } else {
        alert("비밀번호가 일치하지 않습니다.");
        return false;
      }
    },
  },
};
</script>