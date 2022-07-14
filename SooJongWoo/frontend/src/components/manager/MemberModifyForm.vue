<template>
  <form @submit.prevent="onSubmit">
    <div class="member-box">
      <v-col cols="12" md="12">
        <v-container>
          <v-text-field
            label="회원번호"
            required
            height="5vh"
            disabled
            :value="member.memberNo"
            type="memberNo"
          >
          </v-text-field>

          <v-radio-group v-model="radioGroup" row>
            <v-radio
              v-for="kinds in kindsOfMember"
              :key="kinds"
              :label="`${kinds}`"
            >
            </v-radio>
          </v-radio-group>

          <v-text-field
            label="이름"
            required
            height="5vh"
            disabled
            :value="member.userName"
            type="userName"
          >
          </v-text-field>

          <v-text-field
            label="아이디"
            required
            height="5vh"
            disabled
            :value="member.userId"
            type="id"
          >
          </v-text-field>

          <v-text-field
            label="휴대전화"
            required
            height="5vh"
            disabled
            :value="member.userPhone"
            type="userPhone"
          >
          </v-text-field>
        </v-container>
      </v-col>
    </div>

    <v-container class="justify center" style="padding: 0%">
      <v-col cols="12" md="12">
        <v-btn type="submit" color="blue" class="ma-2 white--text">
          수정등록
        </v-btn>
        <v-btn
          color="blue darken-4"
          outlined
          class="ma-2 white--text"
          route
          :to="{
            name: 'MemberReadPage',
            params: { memberNo: member.memberNo.toString() },
          }"
        >
          취소
        </v-btn>
      </v-col>
    </v-container>
  </form>
</template>

<script>
export default {
  name: "MemberModifyForm",
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
  data() {
    return {
      radioGroup: 1,
      kindsOfMember: ["개인", "관리자"],
    };
  },
  methods: {
    onSubmit() {
      const { radioGroup } = this;
      const auth = radioGroup == 0 ? "개인" : "관리자";
      this.$emit("submit", { auth });
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
}
h1 {
  font-family: "Gowun Dodum";
  font-size: 30px;
  margin-top: 5%;
  text-align: center;
}
</style>