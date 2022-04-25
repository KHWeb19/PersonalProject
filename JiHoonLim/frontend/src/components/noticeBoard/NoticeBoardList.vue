<template>
  <div class="grey lighten-3" style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1240px">
      <v-row class="orange lighten-5">
        <v-col>
          <div class="main_tit_box">공지사항</div>
        </v-col>
      </v-row>
      <v-row justify="center">
        <v-col>
          <div style="countWrap">
            총
            <b class="count">{{ noticeBoards.length }}</b
            >개의 공지사항이 있습니다.
          </div>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <v-data-table
            :headers="headers"
            :items="noticeBoards"
            :items-per-page="10"
            :key="noticeBoards.boardNo"
            class="elevation-5"
          >
            <template v-slot:[`item.title`]="{ item }">
              <router-link
                style="color: black; text-decoration: none"
                :to="{
                  name: 'NoticeReadPage',
                  params: { boardNo: item.boardNo.toString() },
                }"
                >{{ item.title }}</router-link
              >
            </template>
          </v-data-table>
        </v-col>
      </v-row>

      <v-row>
        <v-col>
          <v-btn
            v-if="loginAuth == '관리자'"
            x-large
            rounded
            color="orange lighten-1"
            class="mx-auto"
            style="float: right"
            @click="register"
          >
            공지사항 작성</v-btn
          >
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "NoticeBoardList",
  props: {
    noticeBoards: {
      type: Array,
    },
  },
  data() {
    return {
      userInfo: "",
      loginAuth: "",
      headers: [
        { text: "글번호", value: "boardNo", width: "100px", align: "center" },
        { text: "제목", value: "title", width: "500px", align: "left" },
        { text: "작성자", value: "writer", width: "150px", align: "center" },
        { text: "조회수", value: "viewCount", width: "100px", align: "center" },
        { text: "작성일자", value: "regDate", width: "300px", align: "center" },
      ],
    };
  },
  methods: {
    register() {
      this.$router.push("/noticeRegister");
    },
  },
  created() {
    if (this.$store.state.userInfo != null) {
      this.userInfo = this.$store.state.userInfo;
      this.loginAuth = this.userInfo.auth;
    } else {
      alert("로그인 후 이용해주세요.");
      this.$router.push("/login");
    }
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
</style>

<style lang="scss" scoped>
.v-data-table::v-deep th {
  font-size: 18px !important;
}
.v-data-table::v-deep td {
  font-size: 16px !important;
}
</style>
