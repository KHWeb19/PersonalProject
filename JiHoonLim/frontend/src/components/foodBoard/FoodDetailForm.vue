<template>
  <div class="grey lighten-3" align="center">
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
                    <h2>
                      {{ foodBoard.name }}
                    </h2>
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

                    <v-textarea
                      type="text"
                      readonly
                      :value="foodBoard.des"
                      flat
                      solo
                      auto-grow
                      class="textArea"
                    />
                  </div>
                  <div class="main_title">
                    <b>조리순서</b>
                    <span style="">Steps</span>
                  </div>
                  <v-textarea
                    type="text"
                    :value="foodBoard.content"
                    auto-grow
                    readonly
                    flat
                    solo
                    style
                  />
                </div>

                <div class="foodRec-right">
                  <div class="main_title">
                    <b>재료</b>
                    <span>Ingredients</span>
                  </div>
                  <v-textarea
                    :value="foodBoard.material"
                    auto-grow
                    solo
                    flat
                    readonly
                    style="width: 800px"
                  />
                  <div>
                    <v-divider></v-divider>
                    <div class="main_title">
                      <b>주의사항</b>
                      <span style="">Tip</span>
                    </div>

                    <v-textarea
                      :value="foodBoard.tip"
                      auto-grow
                      solo
                      flat
                      readonly
                      style="width: 800px"
                    />
                  </div>
                  <div>
                    <v-text-field :value="foodBoard.viewCount"></v-text-field>
                  </div>
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
    };
  },
  created() {
    if (this.$store.state.userInfo != null) {
      this.nickName = this.$store.state.userInfo.nickName;
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
  },
};
</script>

<style lang="scss" scoped>
.main_title {
  float: left;
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
  border-bottom: 1px solid #dbdbdb;
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
  border-left: 1px solid #dbdbdb;
  border-right: 1px solid #dbdbdb;
}

.foodRec-right {
  padding: 15px;
  width: 30%;
  border-right: 1px solid #dbdbdb;
}

.v-textarea {
  display: block;
  font-size: 20px;
  color: #666;
  font-weight: lighter;
  line-height: 2;
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
</style>
