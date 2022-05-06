<template>
  <div style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white">
      <v-row justify="center">
        <v-col cols="auto">
          <v-card style="margin: 30px">
            <v-card-text>
              <validation-observer v-slot="{ invalid }">
                <form @submit.prevent="onSubmit" style="display: flex">
                  <div style="justify-content: center">
                    <table
                      style="
                        text-align: center;
                        margin-right: 50px;
                        margin-left: 50px;
                      "
                    >
                      <div class="text-h4 font-weight-black mb-10">
                        공지사항 등록
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
                                  v-model="title"
                                  label="제목"
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
                          <validation-provider
                            v-slot="{ errors }"
                            name="본문"
                            :rules="{ required: true }"
                          >
                            <v-textarea
                              style="width: 700px"
                              v-model="content"
                              label="본문"
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
                        등록
                      </v-btn>
                      <v-btn
                        to="noticeList"
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
  created() {
    if (this.$store.state.userInfo == null) {
      alert("로그인 후 이용해주세요.");
      this.$router.push("/login");
    }
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
</style>
