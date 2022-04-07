<template>
  <div>
    <member-modify-form :userInfo="userInfo" />
  </div>
</template>

<script>
import MemberModifyForm from "@/components/member/MemberModifyForm.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "MemberModifyPage",
  components: {
    MemberModifyForm,
  },

  computed: {
    ...mapState(["userInfo"]),
  },
  created() {
    this.fetchMember(this.$store.state.userInfo.memberNo)
      .then(() => {
        alert("요청 성공");
      })
      .catch(() => {
        alert("요청 실패");
        this.$router.push();
      });
  },
  methods: {
    ...mapActions(["fetchMember"]),
  },
};
</script>
