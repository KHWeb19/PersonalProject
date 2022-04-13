<template>
  <div class="grey lighten-3" align="center">
    <v-container class="white" style="width: 1240px">
      <v-row justify="center">
        <v-col>
          <v-card width="1000">
            <div align="center">
              <v-img
                max-width="512px"
                contain
                content-class=""
                :src="
                  require(`@/assets/uploadImg/foodBoard/${foodBoard.filename}`)
                "
              ></v-img>
            </div>
            <table>
              <tr>
                <td>
                  <v-text-field
                    type="text"
                    style="font-size: 45px"
                    :value="foodBoard.name"
                    readonly
                    solo
                  />
                  <div class="text-center">
                    <v-chip class="ma-2" large>
                      {{ foodBoard.mat }}
                    </v-chip>
                    <v-chip class="ma-2" large> {{ foodBoard.kind }} </v-chip>
                    <v-chip class="ma-2" large> {{ foodBoard.way }} </v-chip>
                  </div>
                  <v-textarea
                    type="text"
                    style="
                      padding: 2px 10px 10px 10px;
                      color: #aaa;
                      font-size: 16px;
                    "
                    solo
                    :value="foodBoard.des"
                    readonly
                    auto-grow
                  />
                </td>
              </tr>
            </table>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
    <div class="grey lighten-3" style="height: 5px"></div>
    <v-container class="white" style="width: 1240px">
      <v-row justify="center">
        <v-col>
          <v-card width="1000">
            <table>
              <tr>
                <td>
                  <div class="main_title">
                    <b>재료</b>
                    <span>Ingredients</span>
                  </div>
                </td>
              </tr>
              <tr>
                <td>
                  <v-textarea
                    :value="foodBoard.material"
                    auto-grow
                    solo
                    readonly
                    style="width: 800px"
                    class="mx-auto"
                  />
                </td>
              </tr>
            </table>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
    <div class="grey lighten-3" style="height: 5px"></div>
    <v-container class="white" style="width: 1240px">
      <v-row justify="center">
        <v-col>
          <v-card width="1000">
            <table>
              <tr>
                <td>
                  <div class="main_title">
                    <b>조리순서</b>
                    <span style="">Steps</span>
                  </div>
                </td>
              </tr>
              <tr>
                <td>
                  <v-textarea
                    :value="foodBoard.content"
                    auto-grow
                    solo
                    readonly
                    style="width: 800px"
                    class="mx-auto"
                  />
                </td>
              </tr>
              <tr>
                <td>
                  <div class="main_title">
                    <b>주의사항</b>
                    <span style="">Tip</span>
                  </div>
                </td>
              </tr>
              <tr>
                <td>
                  <v-textarea
                    :value="foodBoard.tip"
                    auto-grow
                    solo
                    readonly
                    style="width: 800px"
                    class="mx-auto"
                  />
                </td>
              </tr>
            </table>
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

<style scoped>
.main_title {
  width: 1000px;
  font-size: 20px;
  color: #000;
  padding: 30px 35px 30px 35px;
}
.main_title span {
  color: #ccc;
  font-size: 14px;
  font-style: italic;
  padding-left: 4px;
}
.main_title b {
  font-weight: 500;
}
</style>
