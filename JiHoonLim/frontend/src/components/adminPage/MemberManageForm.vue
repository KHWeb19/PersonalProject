<template>
  <div class="grey lighten-3" style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1240px">
      <v-row class="orange lighten-5">
        <v-col>
          <div class="main_tit_box">회원 관리</div>
        </v-col>
      </v-row>
      <v-row justify="center">
        <v-col>
          <div style="countWrap">
            총
            <b class="count">{{ registerMembers.length }}</b
            >명의 회원이 있습니다.
          </div>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <div class="tableWrap">
            <table class="authTable">
              <tr style="height: 50px">
                <th class="orange lighten-3" width="100">권한</th>
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
                <th class="orange lighten-3" width="80">회원 번호</th>
                <th class="orange lighten-3" width="150">아이디</th>
                <th class="orange lighten-3" width="150">닉네임</th>
                <th class="orange lighten-3" width="200">가입일자</th>
                <th class="orange lighten-3" width="80">수정</th>
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
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
.main_tit_box {
  text-align: left;
  font-size: 35px;
  color: #333;
  padding: 8px 0 8px 0;
  font-style: italic;
  position: relative;
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
}
.authTable {
  font-size: 25px;
  width: 15%;
  text-align: center;
  border-collapse: collapse;
  border: 1px solid grey;
  border-right: none;
}
.memberTable {
  font-size: 25px;
  width: 75%;
  text-align: center;
  border-collapse: collapse;
  border: 1px solid grey;
  border-left: none;
}
.borderBot {
  border-bottom: 1px solid grey;
}
th,
td {
  border-bottom: 1px solid grey;
  height: 50px;
}
</style>
