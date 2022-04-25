<template>
  <div
    class="grey lighten-3"
    align="center"
    style="font-family: 'Noto Sans KR', sans-serif"
  >
    <v-container class="white" style="width: 1700px">
      <v-row justify="center">
        <v-col>
          <v-card width="1200px">
            <form @submit.prevent="onSubmit">
              <v-divider></v-divider>
              <div class="comment_title">
                <b>댓글</b>
                <span
                  class="ml-5"
                  style="color: orange"
                  v-if="foodBoardComments"
                  >{{ foodBoardComments.length }}</span
                >
                <v-divider></v-divider>
              </div>

              <v-row>
                <v-col
                  v-for="commentList in foodBoardComments"
                  :key="commentList.id"
                  cols="12"
                  class="pt-0 pb-0"
                >
                  <div class="comment_wrap">
                    <div style="display: flex">
                      <h3 class="ml-7 pb-2 pr-5 pt-2" style="color: orange">
                        {{ commentList.commentWriter }}
                      </h3>
                      <v-spacer></v-spacer>
                      <h3 class="pb-2 pr-5 pt-2">{{ commentList.regDate }}</h3>
                      <v-btn
                        class="ml-5 mr-5"
                        text
                        v-if="commentList.commentWriter == nickName"
                        @click="onDelete(commentList.commentNo)"
                        color="red"
                        >삭제</v-btn
                      >
                    </div>
                    <div style="display: flex">
                      <v-text-field
                        class="ml-5 mr-5"
                        readonly
                        :value="commentList.comment"
                        solo
                        auto-grow
                        filled
                      />
                    </div>
                    <v-divider></v-divider>
                  </div>
                </v-col>
              </v-row>
              <div>
                <div style="display: flex">
                  <v-textarea
                    v-model="comment"
                    label="댓글"
                    placeholder="댓글을 입력해주세요."
                    clearable
                    auto-grow
                    outlined
                    color="orange"
                    class="ml-5 mt-5"
                  />
                  <v-btn
                    color="orange lighten-3"
                    style="width: 128px; height: 128px"
                    class="mr-5 mt-5"
                    type="submit"
                    >등록</v-btn
                  >
                </div>
              </div>
            </form>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "FoodBoardComment",
  props: {
    foodBoardComments: {
      type: Array,
    },
  },
  data() {
    return {
      comment: "",
      commentWriter: "",
      userInfo: this.$store.state.userInfo,
      nickName: "",
    };
  },

  created() {
    if (this.$store.state.userInfo != null) {
      this.nickName = this.$store.state.userInfo.nickName;
    }
  },
  methods: {
    onSubmit() {
      if (this.$store.state.userInfo != null) {
        this.commentWriter = this.userInfo.nickName;
        const { comment, commentWriter } = this;
        this.$emit("submit", { comment, commentWriter });
      } else {
        alert("로그인 해주세요.");
      }
    },
    onDelete(commentNo) {
      axios
        .delete(
          `http://localhost:7777/foodBoard/comment/${commentNo}`,
          commentNo
        )
        .then(() => {
          alert("삭제 성공!");
          history.go(0);
        })
        .catch(() => {
          alert("삭제 실패");
        });
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
.comment_title {
  font-size: 24px;
  display: block;
  color: #000;
  padding: 30px 35px 30px 12px;
  text-align: left;
}
.comment_title b {
  font-weight: bold;
}
</style>
