<template>
  <div>
    <header-layout />
    <member-read v-if="member" :member="member"></member-read>
    <p v-else>로딩중 ......</p>

    <router-link :to="{ name: 'MemberModifyPage', params: { memberNo } }"
      >게시물수정</router-link
    >
    <button @click="onDelete">삭제</button>

    <router-link :to="{ name: 'MemberListPage' }">보기</router-link>
    <footer-layout />
  </div>
</template>
<script>
import MemberRead from "@/components/Manager/MemberRead.vue"
import HeaderLayout from "@/components/Header/HeaderLayout.vue"
import FooterLayout from "@/components/Footer/FooterLayout.vue"
import { mapState, mapActions } from "vuex"
import axios from "axios"
export default {
  name: "MemberReadPage",
  components: { MemberRead, HeaderLayout, FooterLayout },
  props: {
    memberNo: {
      type: String,
      required: true,
    },
  },

  computed: {
    ...mapState(["member"]),
  },
  created() {
    this.fetchMember(this.memberNo).catch(() => {
      alert("요청실패!")
      this.$router.push()
    })
  },
  methods: {
    ...mapActions(["fetchMember"]),
    onDelete() {
      const { memberNo } = this.member
      axios
        .delete(`http://localhost:8888/Member/${memberNo}`)
        .then(() => {
          alert("삭제 성공!")
          this.$router.push({ name: "MemberListPage" })
        })
        .catch(() => {
          alert("삭제 실패! 문제 발생!")
        })
    },
  },
}
</script>
<style lang=""></style>
