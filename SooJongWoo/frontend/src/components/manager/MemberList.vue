<template>
  <div align="center" class="member-box">
    <v-row align="center" class="table-row">
      <table class="table-b">
        <tr class="top-tr">
          <th>권한</th>
        </tr>

        <tr
          v-if="
            !memberAuths ||
            (Array.isArray(memberAuths) && memberAuths.length === 0)
          "
        >
          <td colspan="1">.</td>
        </tr>
        <tr v-else v-for="memberAuth in memberAuths" :key="memberAuth.memberNo">
          <td>
            <router-link
              :to="{
                name: 'MemberReadPage',
                params: { memberNo: memberAuth.memberNo.toString() },
              }"
            >
              {{ memberAuth.auth }}
            </router-link>
          </td>
        </tr>
      </table>

      <table class="table-a">
        <tr class="top-tr">
          <th width="100">회원번호</th>
          <th width="100">이름</th>
          <th width="100">아이디</th>
          <th width="200">가입일자</th>
        </tr>

        <tr v-if="!members || (Array.isArray(members) && members.length === 0)">
          <td colspan="4">등록된 회원이 존재하지 않습니다.</td>
        </tr>
        <tr v-else v-for="member in members" :key="member.memberNo">
          <td>{{ member.memberNo }}</td>
          <td>{{ member.userName }}</td>
          <td>{{ member.userId }}</td>
          <td>{{ member.regDate }}</td>
        </tr>
      </table>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "MemberList",
  props: {
    members: {
      type: Array,
    },
    memberAuths: {
      type: Array,
    },
  },
  data() {
    return {
      authSelect: false,
    };
  },
  methods: {
    cancle() {
      this.authSelect = false;
    },
  },
};
</script>

<style scoped>
.table-a {
  width: 70%;
  border: 0.5px solid #ebecec;
  float: left;
  margin-bottom: 5%;
}
.table-b {
  width: 15%;
  border: 0.5px solid #ebecec;
  float: left;
  margin-bottom: 5%;
  /* margin-left:50pt; */
}
.table-row {
  margin: 0 auto;
  position: relative;
  left: 18%;
}
.top-tr {
  background-color: #84c0cf33;
}
.member-box {
  margin-top: 2%;
  margin-bottom: 2%;
  width: 83%;
}
th,
td {
  text-align: center;
  height: 80px;
}
.exit {
  position: relative;
  left: 85%;
}
</style>