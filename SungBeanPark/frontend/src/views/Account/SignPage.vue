<template>
  <sign-page-form @submit="onSubmit" :members="members" />
</template>
<script>
import SignPageForm from "@/components/Account/SignPageForm"
import { mapActions, mapState } from "vuex"
import axios from "axios"
export default {
  name: "SignPage",
  components: {
    SignPageForm,
  },
  methods: {
    onSubmit(payload) {
      const { id, pw, userName, auth } = payload
      axios
        .post("http://localhost:8888/Member/register", {
          id,
          pw,
          userName,
          auth,
        })
        .then((res) => {
          if (res.data) {
            alert("가입완료")
            this.$router.push({
              name: "LoginPage",
            })
          } else {
            alert("이미 존재하는 아이디입니다.")
          }
        })
        .catch((res) => {
          alert(res.response.data.message)
        })
    },
    ...mapActions(["fetchMemberList"]),
  },
  computed: {
    ...mapState(["members"]),
  },
  mounted() {
    this.fetchMemberList()
  },
}
</script>
<style></style>
