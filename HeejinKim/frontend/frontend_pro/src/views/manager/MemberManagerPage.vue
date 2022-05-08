<template>
  <div>
    <member-manager-form
      :registerMembers="registerMembers"
      :registerMemberAuths="registerMemberAuths"
      @submit="onSubmit"
    />
  </div>
</template>

<script>
import MemberManagerForm from "@/components/manager/MemberManagerForm.vue"
import { mapActions, mapState } from "vuex"
import axios from "axios"
export default {
  name: "MemberManagerPage",
  components: {
    MemberManagerForm,
  },
  computed: {
    ...mapState(["registerMembers", "registerMemberAuths"]),
  },
  methods: {
    ...mapActions(["fetchRegisterMembers", "fetchRegisterMemberAuths"]),
    onSubmit(payload) {
      const { auth } = payload
      axios
        .put(`http://localhost:7777/memberManage/${this.memberNo}`, {
          memberAuthNo: this.registerMemberAuth.memberAuthNo,
          memberNo: this.registerMemberAuth.memberNo,
          auth,
          regDate: this.registerMemberAuth.regDate,
        })
        .then(() => {
          alert("수정 성공")
          this.$router.push("/memberManage")
        })
        .catch(() => {
          alert("수정 실패")
        });
    },
  },
  mounted() {
    this.fetchRegisterMembers()
    this.fetchRegisterMemberAuths()
  
  },
}
</script>