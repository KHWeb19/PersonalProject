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
import axios from "axios";

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
    onSubmit(payload) {
      const { auth } = payload;

      axios
        .put(`http://localhost:7777/memberManage/${this.memberNo}`, {
          memberAuthNo: this.registerMemberAuth.memberAuthNo,
          memberNo: this.registerMemberAuth.memberNo,
          auth,
          regDate: this.registerMemberAuth.regDate,
        })
        .then(() => {
          alert("수정 성공");
          this.$router.push("/memberManage");
        })
        .catch(() => {
          alert("수정 실패");
        });
    },
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
