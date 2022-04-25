<template>
  <div
    class="grey lighten-3"
    align="center"
    style="font-family: 'Noto Sans KR', sans-serif"
  >
    <v-container class="white" style="width: 1700px">
      <v-row justify="center">
        <v-col>
          <v-card width="1475px">
            <div class="foodRec-wrap">
              <div class="foodRec-up">
                <v-img
                  max-height="700px"
                  width="100%"
                  contain
                  content-class=""
                  :src="
                    require(`../../assets/uploadImg/foodBoard/${foodBoard.filename}`)
                  "
                />
              </div>
              <v-divider></v-divider>
              <div class="foodRec-cont">
                <div class="foodRec-left">
                  <div class="foodRec-tit">
                    <div style="display: flex; justify-content: space-between">
                      <h2>
                        {{ foodBoard.name }}
                      </h2>

                      <div style="display: flex">
                        <v-text-field
                          :value="foodBoard.writer"
                          readonly
                          solo
                          flat
                          style="width: 100px; margin-top: 2px"
                        />
                        <v-text-field
                          :value="foodBoard.regDate"
                          readonly
                          solo
                          flat
                          style="width: 200px; margin-top: 2px"
                        />
                        <div v-if="checkWriteUser">
                          <v-btn
                            text
                            :to="{
                              name: 'FoodModifyPage',
                              params: { boardNo: foodBoard.boardNo.toString() },
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
                    </div>
                    <div style="display: flex; justify-content: space-between">
                      <div class="foodRec-cat">
                        <v-chip class="tag" large outlined>
                          # {{ foodBoard.mat }}
                        </v-chip>
                        <v-chip class="tag" large outlined>
                          # {{ foodBoard.kind }}
                        </v-chip>
                        <v-chip class="tag" large outlined>
                          # {{ foodBoard.way }}
                        </v-chip>
                      </div>
                      <div>
                        <div style="display: flex">
                          <div style="display: flex">
                            <v-icon
                              color="orange"
                              class="pr-1"
                              style="height: 45px; padding-top: 6px"
                            >
                              mdi-eye</v-icon
                            >
                            <v-text-field
                              flat
                              solo
                              readonly
                              style="width: 50px"
                              :value="foodBoard.viewCount"
                            />
                          </div>
                          <div style="display: flex">
                            <v-btn text class="mt-2" @click="clickLike">
                              <v-icon color="orange"> mdi-thumb-up</v-icon>
                            </v-btn>
                            <v-text-field
                              flat
                              solo
                              readonly
                              style="width: 50px"
                              :value="foodBoard.likeCnt"
                            />
                          </div>

                          <div>
                            <v-btn text @click="myCart">
                              <v-icon color="orange" class="pr-1">
                                mdi-cart</v-icon
                              ><span style="font-weight: bold"
                                >내 보관함에 추가</span
                              >
                            </v-btn>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <v-textarea
                    type="text"
                    readonly
                    :value="foodBoard.des"
                    rows="5"
                    flat
                    solo
                    auto-grow
                    class="textAreaLeft"
                  />
                  <v-divider></v-divider>
                  <div class="main_title">
                    <b>조리순서</b>
                    <span style="">Steps</span>
                  </div>
                  <v-textarea
                    type="text"
                    :value="foodBoard.content"
                    auto-grow
                    readonly
                    solo
                    flat
                    rows="10"
                    class="textAreaLeft"
                  />
                </div>

                <div class="foodRec-right">
                  <div class="main_title">
                    <b>재료</b>
                    <span>Ingredients</span>
                  </div>
                  <v-textarea
                    :value="foodBoard.material"
                    rows="10"
                    auto-grow
                    solo
                    flat
                    readonly
                    class="textAreaRight"
                  />
                  <div>
                    <v-divider></v-divider>
                    <div class="main_title">
                      <b>주의사항</b>
                      <span style="">Tip</span>
                    </div>

                    <v-textarea
                      :value="foodBoard.tip"
                      rows="5"
                      auto-grow
                      solo
                      flat
                      readonly
                      style="width: 800px"
                      class="textAreaRight"
                    />
                  </div>
                </div>
              </div>
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
  name: "FoodDetailForm",
  props: {
    foodBoard: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      checkWriteUser: false,
      dialogDelete: false,
      checkbox: false,
      img: this.foodBoard.filename,
      nickName: "",
      comment: "",
      userInfo: this.$store.state.userInfo,
      userId: "",
      boardNo: this.foodBoard.boardNo,

      name: this.foodBoard.name,
      des: this.foodBoard.des,
      material: this.foodBoard.material,
      content: this.foodBoard.content,
      writer: this.foodBoard.writer,
      tip: this.foodBoard.tip,
      chooseKind: this.foodBoard.chooseKind,
      chooseMat: this.foodBoard.chooseMat,
      chooseWay: this.foodBoard.chooseWay,
      filename: this.foodBoard.filename,
    };
  },

  created() {
    if (this.userInfo != null) {
      this.nickName = this.userInfo.nickName;
      this.userId = this.userInfo.id;
    }
    if (this.nickName == this.foodBoard.writer) {
      this.checkWriteUser = true;
    } else {
      this.checkWriteUser = false;
    }
  },
  methods: {
    onDelete() {
      const { boardNo, filename } = this.foodBoard;
      axios
        .delete(`http://localhost:7777/foodBoard/${boardNo}`, {
          filename,
        })
        .then(() => {
          alert("삭제 성공!");
          this.$router.push({ name: "FoodListPage" });
        })
        .catch(() => {
          alert("삭제 실패");
        });
    },
    restCheckbox() {
      this.checkbox = false;
    },
    clickLike() {
      if (this.userInfo != null) {
        const { boardNo, userId } = this;

        axios
          .post(`http://localhost:7777/foodBoard/like/${boardNo}`, {
            userId,
          })
          .then((res) => {
            if (res.data) {
              alert("좋아요 성공");
              this.$router.go();
            } else {
              alert("이미 좋아요를 누르셨습니다.");
            }
          })
          .catch(() => {
            alert("오류 발생");
          });
      } else {
        alert("로그인 후 이용해주세요.");
      }
    },
    myCart() {
      if (this.userInfo != null) {
        const { foodBoard } = this;
        axios
          .post(
            `http://localhost:7777/member/myCart/register/${this.userInfo.memberNo}`,
            foodBoard
          )
          .then((res) => {
            if (res.data) {
              alert("보관함 등록 성공");
              this.$router.go();
            } else {
              alert("이미 등록하셨습니다.");
            }
          })
          .catch(() => {
            alert("등록 실패");
          });
      } else {
        alert("로그인 후 이용해주세요.");
      }
    },
  },
};
</script>

<style lang="scss" scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
.main_title {
  font-size: 24px;

  color: #000;
  padding: 30px 35px 30px 12px;
}
.main_title span {
  color: orange;
  font-size: 18px;
  font-style: italic;
  padding-left: 4px;
}
.main_title b {
  font-weight: bold;
}

.foodRec-tit {
  padding: 15px;
  font-size: 30px;
  font-weight: bold;
}
.foodRec-cat {
  margin-top: 30px;
  margin-bottom: 30px;
}
.foodRec-cont {
  display: flex;
}

.foodRec-left {
  text-align: left;
  padding: 15px;
  width: 70%;
  height: 100%;
  border-left: 1px solid #dbdbdb;
  border-right: 1px solid #dbdbdb;
}

.foodRec-right {
  text-align: left;
  padding: 15px;
  width: 30%;
  height: 100%;
  border-right: 1px solid #dbdbdb;
}

h2 {
  font-size: 45px;
  color: #333;
}

.tag {
  font-size: 20px;
  color: #777777;
  padding: 5px 20px 5px;
  border: 1px solid #c1c1c1;
  background: #fff;
  border-radius: 50px;
  margin-right: 10px;
}
.textAreaLeft {
  font-size: 22px;
  color: #666;
}
.textAreaRight {
  font-size: 17px;
  color: #666;
}
</style>
