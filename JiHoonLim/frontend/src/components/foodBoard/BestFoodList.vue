<template>
  <div class="grey lighten-3">
    <v-container class="white" style="width: 1240px">
      <v-row>
        <v-col> 인기 순위 </v-col>
      </v-row>
      <v-row>
        <v-col v-for="food in bestFoodBoards" :key="food.boardNo" lg="3" sm="6">
          <v-card width="500" height="400" class="mx-auto">
            <div style="position: relative">
              <div class="rankNum">rank</div>
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
              ><v-chip class="ma-2" small>
                {{ food.mat }}
              </v-chip>
              <v-chip class="ma-2" small> {{ food.kind }} </v-chip>
              <v-chip class="ma-2" small> {{ food.way }} </v-chip>
            </v-card-subtitle>

            <v-card-title class="pt-0 pb-0"> {{ food.name }} </v-card-title>

            <v-card-actions>
              <v-card-text class="pb-0 pt-0">{{ food.writer }}</v-card-text>
            </v-card-actions>
            <v-card-actions>
              <v-card-text class="food_sub_icon"
                ><v-icon color="orange"> mdi-thumb-up</v-icon>
                추천수</v-card-text
              >
              <v-card-text class="food_sub_icon"
                ><v-icon color="orange">mdi-eye</v-icon
                >{{ food.viewCount }}</v-card-text
              >
              <v-card-text class="food_sub_icon"
                ><v-icon color="orange">mdi-comment</v-icon
                >{{ food.commentCnt }}</v-card-text
              >
            </v-card-actions>
            <v-card-actions>
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
  top: -11%;
  left: -3%;
}
</style>
