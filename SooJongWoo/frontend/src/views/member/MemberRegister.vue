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
              this.$$router.push({
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

<style scoped>
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
  color: white;
  z-index: 2;
  text-align: center;
}
</style>