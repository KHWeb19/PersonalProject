<template>
  <div>
    <member-manage-form :registerMembers="registerMembers" />
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
    ...mapState(["registerMembers"]),
  },
  methods: {
    ...mapActions(["fetchRegisterMember"]),
  },
  mounted() {
    this.fetchRegisterMember();
  },
};
</script>
