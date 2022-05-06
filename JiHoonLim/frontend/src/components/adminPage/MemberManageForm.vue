<template>
  <div style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1300px">
      <v-row justify="center">
        <v-col>
          <div class="mb-10">
            <div
              style="
                font-size: 70px;
                text-align: center;
                font-weight: bold;
                margin-bottom: 10px;
              "
            >
              C S &nbsp; M A N A G E
            </div>
            <div
              style="
                font-size: 20px;
                text-align: center;
                font-weight: bold;
                color: grey;
              "
            >
              관리자님, 환영합니다.
            </div>
          </div>
          <v-divider></v-divider>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <v-card flat>
            <div style="countWrap" class="mt-5 mb-5">
              총
              <b class="count">{{ registerMembers.length }}</b
              >명의 회원이 있습니다.
            </div>
            <div class="tableWrap">
              <table class="authTable">
                <tr style="height: 50px">
                  <th class="orange lighten-5" width="100">권한</th>
                </tr>
                <tr
                  v-if="
                    !registerMemberAuths ||
                    (Array.isArray(registerMemberAuths) &&
                      registerMemberAuths.length == 0)
                  "
                ></tr>
                <tr
                  v-else
                  v-for="memberAuth in registerMemberAuths"
                  :key="memberAuth.memberNo"
                >
                  <td>{{ memberAuth.auth }}</td>
                </tr>
              </table>

              <table class="memberTable">
                <tr style="height: 50px">
                  <th class="orange lighten-5" width="80">회원 번호</th>
                  <th class="orange lighten-5" width="150">아이디</th>
                  <th class="orange lighten-5" width="150">닉네임</th>
                  <th class="orange lighten-5" width="200">가입일자</th>
                  <th class="orange lighten-5" width="80">수정</th>
                </tr>

                <tr
                  v-if="
                    !registerMembers ||
                    (Array.isArray(registerMembers) &&
                      registerMembers.length == 0)
                  "
                ></tr>
                <tr
                  v-else
                  v-for="member in registerMembers"
                  :key="member.memberNo"
                >
                  <td>{{ member.memberNo }}</td>
                  <td>{{ member.id }}</td>
                  <td>{{ member.nickName }}</td>
                  <td>{{ member.regDate }}</td>
                  <td>
                    <v-btn
                      text
                      style="font-size: 20px"
                      :to="{
                        name: 'MemberManageModifyPage',
                        params: { memberNo: member.memberNo.toString() },
                      }"
                      >수정</v-btn
                    >
                  </td>
                </tr>
              </table>
            </div>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "MemberManagerForm",
  props: {
    registerMembers: {
      type: Array,
    },
    registerMemberAuths: {
      type: Array,
    },
  },
  created() {
    if (this.$store.state.userInfo.auth != "관리자") {
      alert("관리자 권한 페이지입니다.");
      this.$router.push("/");
    }
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
.main_tit_box {
  text-align: center;
  font-size: 35px;
  font-weight: bold;
  color: #333;
  padding: 8px 0 8px 0;
  position: relative;
  margin-bottom: 10px;
}
.count {
  font-size: 36px;
  color: orange;
}
.countWrap {
  font-size: 16px;
  color: #333;
  padding: 5px 0 20px 8px;
}
.tableWrap {
  display: flex;
  justify-content: center;
  margin-bottom: 50px;
}
.authTable {
  font-size: 18px;
  width: 20%;
  text-align: center;
  border-collapse: collapse;
  border: 1px solid lightgrey;
  border-top: 3px solid orange;
  border-right: none;
  border-left: none;
}
.memberTable {
  font-size: 18px;
  width: 80%;
  text-align: center;
  border-collapse: collapse;
  border: 1px solid lightgrey;
  border-left: none;
  border-right: none;
  border-top: 3px solid orange;
}
.borderBot {
  border-bottom: 1px solid lightgrey;
}
th {
  border-bottom: 1px solid lightgrey;
  border-top: 1px solid lightgrey;
  height: 70px;
  font-size: 22px;
}

td {
  border-bottom: 1px solid lightgrey;
  border-top: 1px solid lightgrey;
  height: 70px;
}
</style>
