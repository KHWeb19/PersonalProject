<template>
  <div class="grey lighten-3" style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1240px">
      <v-row justify="center">
        <v-col class="pb-0">
          <div class="text_field mt-3">
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

      <v-row>
        <v-col>
          <div class="cate_box">
            <div class="cate_subBox">
              <div class="cate_main">재료별</div>

              <v-chip-group mandatory active-class="orange--text cate_sub">
                <v-chip
                  v-for="(catMat, idx) in catMats"
                  :key="idx"
                  @click="selectMat(catMat.value)"
                >
                  {{ catMat.value }}
                </v-chip>
              </v-chip-group>
            </div>
            <v-divider></v-divider>
            <div class="cate_subBox">
              <div class="cate_main">종류별</div>
              <v-chip-group mandatory active-class="orange--text cate_sub">
                <v-chip v-for="(catKind, idx) in catKinds" :key="idx">
                  {{ catKind.value }}
                </v-chip>
              </v-chip-group>
            </div>
            <v-divider></v-divider>
            <div class="cate_subBox">
              <div class="cate_main">방법별</div>
              <v-chip-group mandatory active-class="orange--text cate_sub">
                <v-chip v-for="(catWay, idx) in catWays" :key="idx">
                  {{ catWay.value }}
                </v-chip>
              </v-chip-group>
            </div>
          </div>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <div class="countFoodWrap">
            총
            <b class="countFood">{{ foodBoards.length }}</b
            >개의 레시피가 있습니다.
          </div>
        </v-col>
      </v-row>

      <v-row class="mt-5 mb-5s">
        <v-col v-for="food in paginatedData" :key="food.boardNo" lg="3" sm="6">
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
          <v-btn
            x-large
            rounded
            color="orange lighten-3"
            class="mx-auto"
            style="float: right"
            @click="write"
          >
            레시피 작성</v-btn
          >
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "FoodList",
  props: {
    foodBoards: {
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
      sortReset: true,
      keyWord: "",

      chooseMat: "",

      catKinds: [
        { value: "전체" },
        { value: "밥" },
        { value: "반찬" },
        { value: "국물" },
        { value: "면" },
        { value: "디저트" },
        { value: "분식" },
        { value: "샐러드" },
        { value: "음료" },
        { value: "기타" },
      ],
      catMats: [
        { value: "전체" },
        { value: "소고기" },
        { value: "돼지고기" },
        { value: "닭고기" },
        { value: "채소" },
        { value: "해물" },
        { value: "계란" },
        { value: "유제품" },
        { value: "기타" },
      ],
      catWays: [
        { value: "전체" },
        { value: "구이" },
        { value: "찜" },
        { value: "국탕찌개" },
        { value: "볶음" },
        { value: "조림" },
        { value: "튀김" },
        { value: "무침 / 비빔" },
        { value: "기타" },
      ],
      selectCate: false,
    };
  },

  methods: {
    write() {
      if (this.$store.state.userInfo == null) {
        alert("로그인 후 이용해주세요.");
        this.$router.push("/login");
      } else {
        this.$router.push("/foodRegister");
      }
    },

    nextPage() {
      this.pageNum += 1;
    },
    prevPage() {
      this.pageNum -= 1;
    },
    search() {
      if (this.keyWord != "") {
        const { keyWord } = this;
        axios
          .post("http://localhost:7777/foodBoard/search", { keyWord })
          .then((res) => {
            console.log(res.data);
            alert("검색 완료");
            this.$router.push({
              name: "FoodSearchPage",
              params: { searchResult: res.data, keyWord: this.keyWord },
            });
          })
          .catch(() => {
            alert("검색 실패");
          });
      } else {
        alert("검색어를 입력해주세요.");
      }
    },
    selectMat(value) {
      console.log(value);
      this.chooseMat = value;
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
.cate_box {
  border: 1px solid lightgrey;
}
.cate_subBox {
  display: flex;
}
.cate_main {
  border-right: 1px solid lightgrey;
  color: orange;
  font-weight: 500;
  margin: 0 5px 0 0;
  text-align: center;
  padding-top: 6px;
  font-size: 15px;
  width: 20%;
  padding-top: 12px;
  font-weight: bold;
  background: #f9f9f9;
}
.cate_sub {
  font-size: 15px;
  line-height: 1;
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
</style>
