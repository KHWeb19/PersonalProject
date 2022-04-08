<template>
  <sign-page-form @submit="onSubmit" />
</template>
<script>
import SignPageForm from "@/components/Account/SignPageForm"
import axios from "axios"
export default {
  name: "SignPage",
  components: {
    SignPageForm,
  },
  methods: {
    onSubmit(payload) {
      const { id, pw, name, auth } = payload
      axios
        .post("http://localhost:8888/Member/register", { id, pw, name, auth })
        .then(() => {
          alert("등록 성공!")

          this.$router.push({
            name: "LoginPage",
          })
        })
        .catch(() => {
          alert("다시 확인해주세요.")
        })
    },
  },
}
</script>
<style></style>
