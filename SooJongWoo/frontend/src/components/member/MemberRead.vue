<template>
  <form>
    <div class="member-box">
      <v-col cols="12" md="12">
        <v-text-field
          label="회원번호"
          dense
          required
          height="5vh"
          style="margin-top: 10px"
          outlined
          readonly
          :value="member.memberNo"
          type="memberNo"
        >
        </v-text-field>

        <v-text-field
          label="이름"
          dense
          required
          height="5vh"
          style="margin-top: 10px"
          outlined
          readonly
          :value="member.userName"
          type="userName"
        >
        </v-text-field>

        <v-text-field
          label="아이디"
          dense
          required
          height="5vh"
          style="margin-top: 10px"
          outlined
          readonly
          :value="member.userId"
          type="userId"
        >
        </v-text-field>

        <v-textarea
          label="휴대전화"
          auto-grow
          style="margin-top: 10px"
          counter
          maxlength="500"
          full-width
          single-line
          outlined
          readonly
          :value="member.userPhone"
          type="userPhone"
        >
        </v-textarea>
      </v-col>
    </div>
  </form>
</template>

<script>
export default {
  name: "MemberRead",
  props: {
    member: {
      type: Object,
      required: true,
    },
  },
};
</script>