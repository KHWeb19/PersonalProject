<template>
  <body>
    <header-layout />
    <member-list :members="members" :list-array="pageArray"></member-list>
    <footer-layout />
  </body>
</template>
<script>
import HeaderLayout from "@/components/Header/HeaderLayout.vue"
import FooterLayout from "@/components/Footer/FooterLayout.vue"
import MemberList from "@/components/Manager/MemberList.vue"
import { mapActions, mapState } from "vuex"
import axios from "axios"
export default {
  name: "MemberListPage",
  components: {
    MemberList,
    HeaderLayout,
    FooterLayout,
  },

  computed: {
    ...mapState(["members"]),
  },
  methods: {
    ...mapActions(["fetchMemberList"]),
  },
  mounted() {
    this.fetchMemberList()
  },

  data() {
    return {
      pageArray: [],
    }
  },
  created() {
    axios
      .get("http://localhost:8888/Member/list")
      .then((res) => {
        this.pageArray = res.data
      })
      .catch((err) => {
        console.log(err)
      })
  },
}
</script>
<style></style>
