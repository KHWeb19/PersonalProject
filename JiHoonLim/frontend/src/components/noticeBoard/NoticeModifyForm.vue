<template>
  <div class="grey lighten-3" style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1240px">
      <v-row justify="center">
        <v-col cols="auto" style="padding-bottom: 90px">
          <v-card width="1000">
            <v-card-text>
              <form @submit.prevent="onSubmit">
                <table>
                  <div class="text-h4 font-weight-black mb-10">
                    공지사항 수정
                  </div>
                  <div>
                    <div>
                      <tr>
                        <td>
                          <v-text-field
                            style="width: 700px"
                            :value="noticeBoard.title"
                            v-model="title"
                            clearable
                            outlined
                            color="orange"
                          />
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
                      <v-textarea
                        style="width: 700px"
                        :value="noticeBoard.content"
                        v-model="content"
                        clearable
                        auto-grow
                        outlined
                        color="orange"
                        rows="10"
                      />
                    </td>
                  </tr>
                </table>

                <div class="d-flex" style="justify-content: flex-end">
                  <v-btn
                    type="submit"
                    class="mr-5"
                    large
                    rounded
                    color="orange lighten-1"
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
              </form>
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
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
</style>
