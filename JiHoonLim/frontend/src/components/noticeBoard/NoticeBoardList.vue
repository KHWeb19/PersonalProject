<template>
  <div style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1400px">
      <v-row>
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
              N O T I C E
            </div>
            <div
              style="
                font-size: 20px;
                text-align: center;
                font-weight: bold;
                color: grey;
              "
            >
              Easy Cook 의 공지사항을 알려드립니다.
            </div>
          </div>
          <v-divider></v-divider>
        </v-col>
      </v-row>

      <v-row>
        <v-col
          ><v-card flat>
            <v-card-title class="mb-3">
              <div style="countWrap">
                총
                <b class="count">{{ noticeBoards.length }}</b
                >개의 공지사항이 있습니다.
              </div>
              <v-spacer></v-spacer>
              <v-spacer></v-spacer>
              <v-spacer></v-spacer>
              <v-text-field
                v-model="search"
                append-icon="mdi-magnify"
                placeholder="검색어를 입력해주세요."
                single-line
                hide-details
                color="orange"
                style="width: 10px"
                outlined
                rounded
              />
            </v-card-title>
            <div>
              <v-data-table
                :headers="headers"
                :items="noticeBoards"
                :items-per-page="itemsPerPage"
                :key="noticeBoards.boardNo"
                :search="search"
                :page.sync="page"
                hide-default-footer
                @page-count="pageCount = $event"
                class="vTable"
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
              <div class="text-center pt-10">
                <v-pagination
                  v-model="page"
                  :length="pageCount"
                  color="orange"
                ></v-pagination>
              </div>
            </div>
          </v-card>
        </v-col>
      </v-row>

      <v-row>
        <v-col>
          <v-btn
            v-if="loginAuth == '관리자' || loginAuth == '매니저'"
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
        {
          text: "No",
          value: "boardNo",
          width: "100px",
          align: "center",
          class: "orange lighten-5",
        },
        {
          text: "제목",
          value: "title",
          width: "500px",
          align: "left",
          class: "orange lighten-5",
        },
        {
          text: "작성자",
          value: "writer",
          width: "150px",
          align: "center",
          class: "orange lighten-5",
        },
        {
          text: "조회수",
          value: "viewCount",
          width: "100px",
          align: "center",
          class: "orange lighten-5",
        },
        {
          text: "작성일자",
          value: "regDate",
          width: "300px",
          align: "center",
          class: "orange lighten-5",
        },
      ],

      search: "",
      page: 1,
      pageCount: 0,
      itemsPerPage: 10,
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
  font-weight: bold;
}
.vTable {
  line-height: 85px;
  border-top: 3px solid orange;
  color: black;
}
</style>

<style lang="scss" scoped>
.v-data-table::v-deep th {
  font-size: 18px !important;
  border-bottom: 1px solid grey;
}
.v-data-table::v-deep td {
  font-size: 18px !important;
  border-bottom: 1px solid lightgrey;
  border-top: 1px solid lightgrey;
}
</style>
