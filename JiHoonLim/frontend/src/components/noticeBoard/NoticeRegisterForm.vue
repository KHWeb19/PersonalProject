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
                    공지사항 등록
                  </div>
                  <div>
                    <div>
                      <tr>
                        <td>
                          <v-text-field
                            style="width: 500px"
                            v-model="title"
                            label="제목"
                            clearable
                            outlined
                            color="orange"
                          />
                        </td>
                      </tr>

                      <tr>
                        <td>
                          <v-text-field
                            style="width: 300px"
                            v-model="userInfo.nickName"
                            label="작성자"
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
                        v-model="content"
                        label="본문"
                        clearable
                        auto-grow
                        outlined
                        color="orange"
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
                    등록
                  </v-btn>
                  <v-btn to="foodList" large rounded color="orange lighten-1">
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
  name: "NoticeRegisterForm",
  data() {
    return {
      title: "",
      content: "",
      userInfo: JSON.parse(localStorage.getItem("userInfo")),
    };
  },
  methods: {
    onSubmit() {
      this.writer = this.userInfo.nickName;
      const { title, content, writer } = this;
      this.$emit("submit", { title, content, writer });
    },
  },
};
</script>
