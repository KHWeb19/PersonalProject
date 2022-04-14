<template>
  <div class="grey lighten-3" align="center">
    <v-container class="white" style="width: 1800px">
      <v-row justify="center">
        <v-col>
          <v-card width="1600px">
            <div class="foodRec-wrap">
              <div class="foodRec-up">
                <v-img
                  max-width="1600px"
                  max-height="700px"
                  contain
                  content-class=""
                  :src="
                    require(`@/assets/uploadImg/foodBoard/${foodBoard.filename}`)
                  "
                ></v-img>
              </div>
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
export default {
  name: "FoodDetailForm",
  props: {
    foodBoard: {
      type: Object,
      required: true,
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
.v-textarea {
  display: block;
  font-size: 20px;
  color: #666;
  font-weight: lighter;
  line-height: 1.5;
}
</style>
