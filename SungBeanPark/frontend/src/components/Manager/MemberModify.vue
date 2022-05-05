<template>
  <div>
    <form @submit.prevent="onSubmit">
      <tr>
        <td>
          <input type="text" :value="member.memberNo" disabled />
        </td>
      </tr>
      <tr>
        <td>아이디</td>
        <td><input type="text" :value="member.userId" /></td>
      </tr>
      <tr>
        <td>이름</td>
        <td><input type="text" :value="member.userName" readonly /></td>
      </tr>
      <button type="sumbit">수정</button>
      <router-link
        :to="{
          name: 'MemberReadPage',
          params: { memberNo: member.memberNo.toString() },
        }"
      >
        취소
      </router-link>
    </form>
  </div>
</template>
<script>
export default {
  name: "MemberModify",
  props: {
    member: {
      type: Object,
      require: true,
    },
  },
  methods: {
    onSubmit() {
      const { userId, userName } = this
      this.$emit("submit", { userId, userName })
    },
  },
}
</script>
<style></style>
