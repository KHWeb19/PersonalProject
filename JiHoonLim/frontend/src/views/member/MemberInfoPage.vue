<template>
  <div>
    <member-info-form :userInfo="userInfo" />
  </div>
</template>

<script>
import MemberInfoForm from "@/components/member/MemberInfoForm.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "MemberInfoPage",
  components: {
    MemberInfoForm,
  },

  computed: {
    ...mapState(["userInfo"]),
  },
  created() {
    this.fetchMember(this.$store.state.userInfo.memberNo).catch(() => {
      alert("요청 실패");
      this.$router.push();
    });
  },
  methods: {
    ...mapActions(["fetchMember"]),
  },
};
</script>
