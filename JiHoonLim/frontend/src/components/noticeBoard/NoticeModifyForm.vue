<template>
  <div style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white">
      <v-row justify="center">
        <v-col cols="auto">
          <v-card style="margin: 30px">
            <v-card-text>
              <validation-observer v-slot="{ invalid }">
                <form @submit.prevent="onSubmit">
                  <div style="justify-content: center">
                    <table
                      style="
                        text-align: center;
                        margin-right: 50px;
                        margin-left: 50px;
                      "
                    >
                      <div class="text-h4 font-weight-black mb-10">
                        공지사항 수정
                      </div>
                      <div>
                        <div>
                          <tr>
                            <td>
                              <validation-provider
                                v-slot="{ errors }"
                                name="제목"
                                :rules="{ required: true }"
                              >
                                <v-text-field
                                  style="width: 700px"
                                  :value="noticeBoard.title"
                                  v-model="title"
                                  clearable
                                  outlined
                                  color="orange"
                                  :error-messages="errors"
                                />
                              </validation-provider>
                            </td>
                          </tr>

                          <tr>
                            <td>
                              <v-text-field
                                style="width: 700px"
                                :value="noticeBoard.writer"
                                clearable
                                disabled
                                outlined
                                color="orange"
                              />
                            </td>
                          </tr>
                        </div>
                      </div>

                      <tr>
                        <td>
                          <validation-provider
                            v-slot="{ errors }"
                            name="본문"
                            :rules="{ required: true }"
                          >
                            <v-textarea
                              style="width: 700px"
                              :value="noticeBoard.content"
                              v-model="content"
                              clearable
                              auto-grow
                              outlined
                              color="orange"
                              rows="10"
                              :error-messages="errors"
                            />
                          </validation-provider>
                        </td>
                      </tr>
                    </table>

                    <div class="d-flex" style="justify-content: center">
                      <v-btn
                        type="submit"
                        class="mr-5"
                        large
                        rounded
                        color="orange lighten-1"
                        :disabled="invalid"
                      >
                        수정
                      </v-btn>
                      <v-btn
                        :to="{
                          name: 'NoticeReadPage',
                          params: { boardNo: noticeBoard.boardNo.toString() },
                        }"
                        large
                        rounded
                        color="orange lighten-1"
                      >
                        취소
                      </v-btn>
                    </div>
                  </div>
                </form>
              </validation-observer>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "NoticeModifyForm",
  props: {
    noticeBoard: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      title: "",
      content: "",
      userInfo: "",
      userNick: "",
      userAuth: "",
    };
  },
  methods: {
    onSubmit() {
      const { title, content } = this;
      this.$emit("submit", { title, content });
    },
  },
  created() {
    this.title = this.noticeBoard.title;
    this.content = this.noticeBoard.content;
    if (this.$store.state.userInfo != null) {
      this.userInfo = this.$store.state.userInfo;
      this.userNick = this.userInfo.nickName;
      this.userAuth = this.userInfo.auth;
    }
    if (this.userAuth != "관리자" && this.userAuth != "매니저") {
      alert("권한이 없습니다.");
      this.$router.push("/noticeList");
    }
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
</style>
