<template>
  <div style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1400px">
      <v-row>
        <v-col>
          <div
            style="
              font-size: 70px;
              text-align: center;
              font-weight: bold;
              margin-bottom: 10px;
            "
          >
            S E A R C H
          </div>
          <div
            style="
              font-size: 20px;
              text-align: center;
              font-weight: bold;
              color: grey;
            "
          >
            총 <b class="countFood">{{ searchResult.length }}</b> 개의 레시피가
            검색되었습니다.
          </div>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <div class="text_field">
            <v-text-field
              v-model="keyWord"
              type="text"
              label="검색창"
              placeholder="검색어를 입력해주세요."
              outlined
              color="orange"
            />
            <v-btn class="search_btn" text @click="search"
              ><v-icon>mdi-magnify</v-icon></v-btn
            >
          </div>
        </v-col>
      </v-row>
      <v-divider></v-divider>
      <v-row>
        <v-col> </v-col>
      </v-row>
      <v-row>
        <v-col
          class="search_input"
          v-if="
            !searchResult ||
            (Array.isArray(searchResult) && searchResult.length === 0)
          "
        >
          검색 결과가 없습니다.
        </v-col>
        <v-col
          v-else
          v-for="food in searchResult"
          :key="food.boardNo"
          lg="3"
          sm="6"
        >
          <v-card width="500" height="380" class="mx-auto">
            <router-link
              :to="{
                name: 'FoodDetailPage',
                params: { boardNo: food.boardNo },
              }"
            >
              <v-img
                :src="require(`@/assets/uploadImg/foodBoard/${food.filename}`)"
                height="200px"
              ></v-img>
            </router-link>

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
                {{ food.likeCount }}</v-card-text
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
import axios from "axios";

export default {
  name: "FoodSearchList",
  props: {
    searchResult: {
      type: Array,
    },
  },
  data() {
    return {
      keyWord: "",
    };
  },

  methods: {
    search() {
      if (this.keyWord != "") {
        const { keyWord } = this;
        axios
          .post("http://localhost:7777/foodBoard/search", { keyWord })
          .then((res) => {
            console.log(res.data);
            alert("검색 완료");
            this.$router
              .push({
                name: "FoodSearchPage",
                params: { searchResult: res.data, keyWord: this.keyWord },
              })
              .catch(() => {});
          })
          .catch(() => {
            alert("검색 실패");
          });
      } else {
        alert("검색어를 입력해주세요.");
      }
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
.text_field {
  width: 50%;
  margin: auto;
  display: flex;
}
.search_btn {
  width: 71px;
  height: 56px;
  background-color: orange;
}
.v-btn:not(.v-btn--round).v-size--default {
  height: 56px;
}
.search_input {
  text-align: center;
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
.countFood {
  font-size: 36px;
  color: orange;
}
.countFoodWrap {
  font-size: 16px;
  color: #333;
  padding: 5px 0 20px 8px;
}
</style>
