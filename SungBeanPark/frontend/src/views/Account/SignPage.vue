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
      const { id, pw } = payload
      axios
        .post("http://localhost:8888/member/register", { id, pw })
        .then((res) => {
          alert("등록 성공!" + res)
        })
        .catch((res) => {
          alert(res.response.data.message)
        })
    },
  },
}
</script>
<style></style>
