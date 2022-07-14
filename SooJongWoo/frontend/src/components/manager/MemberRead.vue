<template>
  <form>
    <div class="member-box">
      <v-col cols="12" md="12">
        <v-container>
          <v-text-field
            label="회원번호"
            required
            height="5vh"
            readonly
            :value="member.memberNo"
            type="memberNo"
          >
          </v-text-field>

          <v-text-field
            label="권한"
            required
            height="5vh"
            readonly
            :value="memberAuth.auth"
            type="auth"
          >
          </v-text-field>

          <v-text-field
            label="이름"
            required
            height="5vh"
            readonly
            :value="member.userName"
            type="userName"
          >
          </v-text-field>

          <v-text-field
            label="아이디"
            required
            height="5vh"
            readonly
            :value="member.userId"
            type="id"
          >
          </v-text-field>

          <v-text-field
            label="휴대전화"
            required
            height="5vh"
            readonly
            :value="member.userPhone"
            type="userPhone"
          >
          </v-text-field>
        </v-container>
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
    memberAuth: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>
.member-box {
  text-align: center;
  width: 80%;
  margin: 0 auto;
}
.register-box {
  border: 1px solid #cccccc;
  background-color: white;
  float: left;
  width: 500px;
  height: 500px;
}
.btn-size {
  margin: 0 auto;
  text-align: center;
  width: 50%;
  padding: 3% 0% 5% 0%;
}
h1 {
  font-family: "Gowun Dodum";
  font-size: 30px;
  margin-top: 5%;
  text-align: center;
}
</style>