<template>
  <div class="grey lighten-3" style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1240px">
      <v-row class="orange lighten-5">
        <v-col>
          <div class="main_tit_box">
            <div style="display: block">
              <v-img
                width="150px"
                height="100%"
                src="@/assets/img/bestLeft.png"
                class="bestImg1"
              />
              <v-img
                width="150px"
                height="100%"
                src="@/assets/img/bestCenter.png"
                class="bestImg2"
              />

              <b class="main_tit">EASY COOK</b>
              인기메뉴
              <b class="main_tit">TOP 10</b>
              <v-img
                width="150px"
                height="100%"
                src="@/assets/img/bestCenter.png"
                class="bestImg3"
              />
              <v-img
                width="150px"
                height="100%"
                src="@/assets/img/bestLeft.png"
                class="bestImg4"
              />
            </div>
          </div>
        </v-col>
      </v-row>

      <v-row class="mt-10 ml-5 mr-5 mb-10">
        <v-col
          v-for="(food, index) in bestFoodBoards"
          :key="food.boardNo"
          lg="3"
          sm="6"
        >
          <v-card width="500" height="380" class="mx-auto">
            <div v-if="index == 0" style="position: relative">
              <div class="rankNum">
                <v-img
                  width="80px"
                  height="100px"
                  src="@/assets/img/gold.png"
                  class="gold"
                />
              </div>
              <router-link
                :to="{
                  name: 'FoodDetailPage',
                  params: { boardNo: food.boardNo },
                }"
              >
                <v-img
                  :src="
                    require(`@/assets/uploadImg/foodBoard/${food.filename}`)
                  "
                  height="200px"
                ></v-img>
              </router-link>
            </div>
            <div v-else-if="index == 1" style="position: relative">
              <div class="rankNum">
                <v-img
                  width="150px"
                  height="100%"
                  src="@/assets/img/silver.png"
                  class="silver"
                />
              </div>
              <router-link
                :to="{
                  name: 'FoodDetailPage',
                  params: { boardNo: food.boardNo },
                }"
              >
                <v-img
                  :src="
                    require(`@/assets/uploadImg/foodBoard/${food.filename}`)
                  "
                  height="200px"
                ></v-img>
              </router-link>
            </div>
            <div v-else-if="index == 2" style="position: relative">
              <div class="rankNum">
                <v-img
                  width="135px"
                  height="100%"
                  src="@/assets/img/bronze.png"
                  class="bronze"
                />
              </div>
              <router-link
                :to="{
                  name: 'FoodDetailPage',
                  params: { boardNo: food.boardNo },
                }"
              >
                <v-img
                  :src="
                    require(`@/assets/uploadImg/foodBoard/${food.filename}`)
                  "
                  height="200px"
                ></v-img>
              </router-link>
            </div>
            <div v-else style="position: relative">
              <router-link
                :to="{
                  name: 'FoodDetailPage',
                  params: { boardNo: food.boardNo },
                }"
              >
                <v-img
                  :src="
                    require(`@/assets/uploadImg/foodBoard/${food.filename}`)
                  "
                  height="200px"
                ></v-img>
              </router-link>
            </div>
            <v-card-subtitle class="pt-3 pb-0"
              ><v-chip class="ma-1" small>
                {{ food.mat }}
              </v-chip>
              <v-chip class="ma-1" small> {{ food.kind }} </v-chip>
              <v-chip class="ma-1" small> {{ food.way }} </v-chip>
            </v-card-subtitle>

            <v-card-title class="pt-0 pb-0"> {{ food.name }} </v-card-title>

            <v-card-actions>
              <v-card-text class="pb-0 pt-0">{{ food.writer }}</v-card-text>
            </v-card-actions>
            <v-card-actions>
              <v-card-text class="food_sub_icon"
                ><v-icon color="orange" class="pr-1"> mdi-thumb-up</v-icon>
                추천수</v-card-text
              >
              <v-card-text class="food_sub_icon"
                ><v-icon color="orange" class="pr-1">mdi-eye</v-icon
                >{{ food.viewCount }}</v-card-text
              >
              <v-card-text class="food_sub_icon"
                ><v-icon color="orange" class="pr-1">mdi-comment</v-icon
                >{{ food.commentCnt }}</v-card-text
              >
            </v-card-actions>
            <v-card-actions class="pl-0 pb-0 pt-0">
              <v-card-text class="food_date">{{ food.regDate }}</v-card-text>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "BestFoodList",
  props: {
    bestFoodBoards: {
      type: Array,
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
.btn-cover .page-count {
  padding: 0 1rem;
}
.food_sub_icon {
  padding: 0;
  text-align: center;
}
.food_date {
  padding: 0;
  text-align: right;
  color: grey;
}
.rankNum {
  position: absolute;
  top: -9%;
  left: -9%;
  z-index: 100;
}
.main_tit {
  font-size: 36px;
  color: orange;
  font-style: italic;
}
.main_tit_box {
  text-align: center;
  font-size: 30px;
  color: #333;
  padding: 8px 0 8px 0;
  font-style: italic;
  position: relative;
}
.bestImg1 {
  position: absolute;
  left: 20px;
  top: 10px;
}
.bestImg2 {
  position: absolute;
  top: -11px;
  left: 191px;
}
.bestImg3 {
  position: absolute;
  right: 191px;
  top: -11px;
  transform: scaleX(-1);
}
.bestImg4 {
  position: absolute;
  right: 20px;
  top: 10px;
  transform: scaleX(-1);
}
.gold {
  right: 18px;
  top: -12px;
}
.silver {
  right: 45px;
  top: -30px;
}
.bronze {
  right: 40px;
  top: -20px;
}
</style>
