<template>
  <div>
    <header-layout />
    <member-modify
      v-if="member"
      :member="member"
      @submit="onSubmit"
    ></member-modify>
    <p v-else>로딩중 .......</p>
    <footer-layout />
  </div>
</template>
<script>
import MemberModify from "@/components/Manager/MemberModify.vue"
import HeaderLayout from "@/components/Header/HeaderLayout.vue"
import FooterLayout from "@/components/Footer/FooterLayout.vue"
import { mapActions, mapState } from "vuex"
import axios from "axios"

export default {
  name: "MemberModifyPage",
  components: { MemberModify, HeaderLayout, FooterLayout },

  props: {
    memberNo: {
      type: String,
      required: true,
    },
  },
  computed: {
    ...mapState(["member"]),
  },
  methods: {
    ...mapActions(["fetchMember"]),
    onSubmit(payload) {
      const { userId, userName } = payload
      axios
        .put(`http://localhost:8888/Member/modify/${this.memberNo}`, {
          userId,
          userName,
        })
        .then((res) => {
          alert("게시물 수정 성공!")
          this.$router.push({
            name: "MemberReadPage",
            params: { memberNo: res.data.memberNo.toString() },
          })
        })
        .catch(() => {
          alert("게시물 수정 실패!")
        })
    },
  },
  created() {
    this.fetchMember(this.memberNo).catch(() => {
      alert("게시물 DB 조회 실패!")
      this.$router.back()
    })
  },
}
</script>
<style lang=""></style>
