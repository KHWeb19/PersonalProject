<template>
  <div class="grey lighten-3">
    <v-container class="white" style="width: 1240px">
      <v-row>
        <v-col> 인기 순위 </v-col>
      </v-row>
      <v-row>
        <v-col
          v-if="
            !bestFoodBoards ||
            (Array.isArray(bestFoodBoards) && bestFoodBoards.length === 0)
          "
        >
          게시물 없음</v-col
        >
        <v-col v-else v-for="food in bestFoodBoards" :key="food.boardNo">
          <v-card width="305" height="370" class="mx-auto">
            <router-link
              :to="{
                name: 'FoodDetailPage',
                params: { boardNo: food.boardNo },
              }"
            >
              <v-img
                :src="require(`@/assets/uploadImg/foodBoard/${food.filename}`)"
                height="215px"
              ></v-img>
            </router-link>

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
              <v-card-text class="pt-0">추천 수</v-card-text>
              <v-card-text class="pt-0">{{ food.viewCount }}</v-card-text>
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
