<template>
  <div>
    <member-manage-modify-form
      v-if="registerMember && registerMemberAuth"
      :registerMember="registerMember"
      :registerMemberAuth="registerMemberAuth"
      @submit="onSubmit"
    />
  </div>
</template>

<script>
import MemberManageModifyForm from "@/components/adminPage/MemberManageModifyForm.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "MemberManageModifyPage",
  props: {
    memberNo: {
      type: String,
      required: true,
    },
  },
  components: {
    MemberManageModifyForm,
  },
  computed: {
    ...mapState(["registerMember", "registerMemberAuth"]),
  },
  methods: {
    ...mapActions(["fetchRegisterMember", "fetchRegisterMemberAuth"]),
    onSubmit() {},
  },
  created() {
    this.fetchRegisterMember(this.memberNo).catch(() => {
      alert("조회 실패");
      this.$router.back();
    });

    this.fetchRegisterMemberAuth(this.memberNo).catch(() => {
      alert("조회 실패");
      this.$router.back();
    });
  },
};
</script>
