<template>
  <div align="center" style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1200px">
      <v-row justify="center">
        <v-col>
          <v-card>
            <div class="wrap">
              <div style="display: flex">
                <v-text-field
                  flat
                  height="100px"
                  solo
                  readonly
                  :value="noticeBoard.title"
                  single-line
                  class="title_box"
                  style="height: 100px"
                />
              </div>
              <v-divider></v-divider>
              <div style="display: flex; height: 50px" class="mt-3 mb-3">
                <div>
                  <v-text-field
                    flat
                    solo
                    height="50px"
                    readonly
                    :value="noticeBoard.writer"
                    class="writer_box"
                  />
                </div>

                <div>
                  <v-text-field
                    flat
                    solo
                    readonly
                    :value="noticeBoard.regDate"
                    class="date_box"
                  />
                </div>
                <div class="mt-3">조회 수</div>
                <div>
                  <v-text-field
                    flat
                    solo
                    readonly
                    :value="noticeBoard.viewCount"
                  />
                </div>
                <div
                  class="mt-2"
                  v-if="
                    (noticeBoard.writer == this.nickName &&
                      this.$store.state.userInfo.auth == '관리자') ||
                    this.$store.state.userInfo.auth == '매니저'
                  "
                >
                  <v-btn
                    text
                    :to="{
                      name: 'NoticeModifyPage',
                      params: { boardNo: noticeBoard.boardNo.toString() },
                    }"
                    >수정</v-btn
                  >
                  <v-dialog v-model="dialogDelete" width="460">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        text
                        v-bind="attrs"
                        v-on="on"
                        @click="restCheckbox"
                        color="red"
                      >
                        삭제
                      </v-btn>
                    </template>

                    <v-card>
                      <v-card-title class="text-h5 orange lighten-3">
                        게시물 삭제
                      </v-card-title>
                      <v-card-text class="mt-5 pb-0">
                        게시물 삭제를 원하시면 <br />
                        버튼을 체크하시고 <br />
                        삭제 버튼을 클릭해주세요.
                      </v-card-text>
                      <v-container class="pt-0 pb-0" fluid>
                        <v-checkbox
                          color="orange"
                          v-model="checkbox"
                          label="삭제 동의 버튼."
                        ></v-checkbox>
                      </v-container>
                      <v-divider></v-divider>

                      <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn
                          color="orange lighten-3"
                          text
                          :disabled="!checkbox"
                          @click="onDelete"
                        >
                          삭제
                        </v-btn>
                        <v-btn
                          color="orange lighten-3"
                          text
                          @click="dialogDelete = false"
                        >
                          취소
                        </v-btn>
                      </v-card-actions>
                    </v-card>
                  </v-dialog>
                </div>
              </div>
              <v-divider></v-divider>
              <div style="display: flex">
                <v-textarea
                  flat
                  solo
                  readonly
                  auto-grow
                  rows="10"
                  :value="noticeBoard.content"
                  class="mt-10"
                  style="font-size: 20px"
                />
              </div>
              <v-btn
                class="mt-3 mb-3 orange lighten-1"
                style="float: right"
                @click="goList"
                >목록</v-btn
              >
            </div>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "NoticeReadForm",
  props: {
    noticeBoard: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      userInfo: "",
      nickName: "",
      dialogDelete: false,
      checkbox: false,
    };
  },
  created() {
    if (this.$store.state.userInfo != null) {
      this.userInfo = this.$store.state.userInfo;
      this.nickName = this.userInfo.nickName;
    } else {
      alert("로그인 후 이용해주세요.");
      this.$router.push("/login");
    }
  },
  methods: {
    goList() {
      this.$router.push("/noticeList");
    },
    onDelete() {
      const { boardNo } = this.noticeBoard;
      axios
        .delete(`http://localhost:7777/noticeBoard/${boardNo}`)
        .then(() => {
          alert("삭제 성공!");
          this.$router.push({ name: "NoticeListPage" });
        })
        .catch(() => {
          alert("삭제 실패");
        });
    },
    restCheckbox() {
      this.checkbox = false;
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");

.table {
  border: 1px solid black;
}
.title_box {
  font-size: 32px;
  zoom: 1.1;
}
.writer_box {
  font-size: 21px;
  zoom: 0.9;
}
.date_box {
  font-size: 18px;
  color: var(--skinText979797);
  zoom: 0.9;
  margin-top: 2px;
}
.wrap {
  margin: 30px;
}
.main_tit_box {
  text-align: center;
  font-size: 35px;
  font-weight: bold;
  color: #333;
  padding: 8px 0 8px 0;
  position: relative;
}
</style>
