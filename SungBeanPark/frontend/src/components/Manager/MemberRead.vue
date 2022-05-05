<template>
  <div class="member">
    <div class="container">
      <div class="row">
        <div class="col-sm-4">
          <header class="member-header">
            <h2>{{ member.userId }}님의 정보</h2>
          </header>
          <div class="member-card">
            <div class="member-card-content">
              <ul>
                <li>No: {{ member.memberNo }}</li>
                <li>ID: {{ member.userId }}</li>
                <li>닉네임: {{ member.userName }}</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "MemberRead",
  props: {
    member: {
      type: Object,
      require: true,
    },
  },

  methods: {},
}
</script>
<style lang="scss">
@import "~@/assets/scss/components/member-card";
</style>
