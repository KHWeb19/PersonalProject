<template>
  <div>
    <member-manage-form
      :registerMembers="registerMembers"
      :registerMemberAuths="registerMemberAuths"
    />
  </div>
</template>

<script>
import MemberManageForm from "@/components/adminPage/MemberManageForm.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "MemberManagePage",
  components: {
    MemberManageForm,
  },
  computed: {
    ...mapState(["registerMembers", "registerMemberAuths"]),
  },
  methods: {
    ...mapActions(["fetchRegisterMembers", "fetchRegisterMemberAuths"]),
  },
  mounted() {
    this.fetchRegisterMembers();
    this.fetchRegisterMemberAuths();
  },
};
</script>
