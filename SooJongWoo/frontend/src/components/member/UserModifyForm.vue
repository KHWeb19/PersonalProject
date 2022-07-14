<template>
  <div>
    <form @submit.prevent="onSubmit">
      <v-container class="member-box">
        <v-container>
          <div style="margin-bottom: 3%">
            <v-text-field
              label="회원번호"
              :value="user.memberNo"
              disabled
              type="member"
            ></v-text-field>
            <v-text-field
              label="가입날짜"
              :value="user.regDate"
              disabled
              type="dates"
            ></v-text-field>
            <v-text-field
              label="회원명"
              :value="user.userName"
              disabled
              type="userName"
            ></v-text-field>
            <v-text-field
              label="회원 아이디"
              :value="user.userId"
              disabled
              type="userId"
            ></v-text-field>

            <div>
              <v-text-field
                label="전화번호"
                v-model="userPhone"
                type="phone"
                class="field-edit"
              ></v-text-field>
              <v-btn outlined class="ma-2 edit2" type="submit">수정완료</v-btn>
            </div>
          </div>

          <v-container class="before">
            <v-row class="justify-center">
              <v-btn
                color="blue"
                outlined
                class="ma-2 white--text"
                route
                :to="{ name: 'UserReadPage' }"
              >
                이전으로</v-btn
              >
            </v-row>
          </v-container>
        </v-container>
      </v-container>
    </form>
  </div>
</template>

<script>
export default {
  name: "UserModifyForm",
  props: {
    user: {
      authList: Array,
      password: String,
      userId: String,
      userName: String,
      userPhone: String,
      memberNo: Number,
    },
  },
  data() {
    return {
      userPhone: "",
    };
  },
  methods: {
    onSubmit() {
      const { userPhone } = this;
      this.$emit("submit", { userPhone });
    },
  },
  created() {
    this.userPhone = this.user.userPhone;
  },
};
</script>

<style scoped>
h4 {
  margin-top: 0px;
  font-family: "Nanum Myeongjo";
  font-size: 18px;
  margin-left: 40%;
}
.member-box {
  /* margin-top: 2%; */
  width: 80%;
  padding: 0%;
  margin: 0 auto;
}
.field-edit {
  float: left;
  width: 85%;
}
.edit2 {
  float: left;
  position: absolute;
  width: 10px;
  font-size: 6px;
  color: rgb(102, 101, 101);
}
.before {
  margin-top: 15%;
}
</style>