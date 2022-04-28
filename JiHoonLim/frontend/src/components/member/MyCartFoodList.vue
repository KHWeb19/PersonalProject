<template>
  <div class="grey lighten-3" style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1240px">
      <v-row class="orange lighten-5">
        <v-col>
          <div class="main_tit_box">내 보관함</div>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <div style="countFoodWrap">
            총
            <b class="countFood">{{ myCartFoods.length }}</b
            >개의 레시피가 보관되어 있습니다.
          </div>
        </v-col>
      </v-row>
      <v-row class="mt-5 mb-5s">
        <v-col v-for="food in paginatedData" :key="food.boardNo" lg="3" sm="6">
          <v-card width="500" height="320" class="mx-auto">
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

            <v-card-actions class="pt-0 pb-0">
              <v-card-text class="pb-0 pt-0">{{ food.writer }}</v-card-text>
              <v-card-text class="pb-0 pt-0"
                ><v-btn
                  icon
                  text
                  class="deleteBtn"
                  color="red"
                  @click="deleteFood(food.cartNo)"
                >
                  삭제
                </v-btn></v-card-text
              >
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>

      <v-row>
        <v-col>
          <div class="btn-cover">
            <v-btn :disabled="pageNum === 0" @click="prevPage" class="page-btn">
              이전
            </v-btn>
            <span class="page-count"
              >{{ pageNum + 1 }} / {{ pageCount }} 페이지</span
            >
            <v-btn
              :disabled="pageNum >= pageCount - 1"
              @click="nextPage"
              class="page-btn"
            >
              다음
            </v-btn>
          </div>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "MyCartFoodList",
  props: {
    myCartFoods: {
      type: Array,
    },
    listArray: {
      type: Array,
      required: true,
    },
    pageSize: {
      type: Number,
      required: false,
      default: 10,
    },
  },
  data() {
    return {
      pageNum: 0,
    };
  },
  methods: {
    nextPage() {
      this.pageNum += 1;
    },
    prevPage() {
      this.pageNum -= 1;
    },
    deleteFood(cartNo) {
      axios
        .delete(`http://localhost:7777/myCart/delete/${cartNo}`)
        .then(() => {
          alert("삭제되었습니다.");
          this.$router.go();
        })
        .catch(() => {
          alert("삭제요청실패");
        });
    },
  },
  computed: {
    pageCount() {
      let listLeng = this.listArray.length,
        listSize = this.pageSize,
        page = Math.floor(listLeng / listSize);

      if (listLeng % listSize > 0) page += 1;
      return page;
    },
    paginatedData() {
      const start = this.pageNum * this.pageSize,
        end = start + this.pageSize;
      return this.listArray.slice(start, end);
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
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

.v-chip-group .v-chip {
  margin: 4px 15px 4px 5px;
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
.main_tit_box {
  text-align: left;
  font-size: 35px;
  color: #333;
  padding: 8px 0 8px 0;
  font-style: italic;
  position: relative;
}
.deleteBtn {
  padding: 0;
  float: right;
}
</style>
