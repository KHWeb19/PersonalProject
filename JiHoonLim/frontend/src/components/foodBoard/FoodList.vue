<template>
  <div style="font-family: 'Noto Sans KR', sans-serif" id="app">
    <v-container class="white" style="width: 1400px">
      <v-row>
        <v-col>
          <div class="mb-10">
            <div
              style="
                font-size: 70px;
                text-align: center;
                font-weight: bold;
                margin-bottom: 10px;
              "
            >
              R E C I P E
            </div>
            <div
              style="
                font-size: 20px;
                text-align: center;
                font-weight: bold;
                color: grey;
              "
            >
              Easy Cook 유저들이 제공하는 레시피로 최고의 순간을 만들어 보세요.
            </div>
          </div>
          <v-divider></v-divider>
        </v-col>
      </v-row>
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
                  @click="clickMat(catMat.value)"
                >
                  {{ catMat.value }}
                </v-chip>
              </v-chip-group>
            </div>
            <v-divider></v-divider>
            <div class="cate_subBox">
              <div class="cate_main">종류별</div>
              <v-chip-group mandatory active-class="orange--text cate_sub">
                <v-chip
                  v-for="(catKind, idx) in catKinds"
                  :key="idx"
                  @click="clickKind(catKind.value)"
                >
                  {{ catKind.value }}
                </v-chip>
              </v-chip-group>
            </div>
            <v-divider></v-divider>
            <div class="cate_subBox">
              <div class="cate_main">방법별</div>
              <v-chip-group mandatory active-class="orange--text cate_sub">
                <v-chip
                  v-for="(catWay, idx) in catWays"
                  :key="idx"
                  @click="clickWay(catWay.value)"
                >
                  {{ catWay.value }}
                </v-chip>
              </v-chip-group>
            </div>
          </div>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <div style="display: flex; justify-content: space-between">
            <div class="countFoodWrap">
              총
              <b class="countFood">{{ paginatedData.length }}</b> 개의 레시피가
              있습니다.
            </div>
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
            color="orange lighten-1"
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
    /*foodBoards: {
      type: Array,
    },*/
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

      chooseMat: "전체",
      chooseKind: "전체",
      chooseWay: "전체",

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

      copyData: [...this.listArray],
      //filteringData: [],
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

    selectCate(mat, kind, way) {
      this.chooseMat = mat;
      this.chooseKind = kind;
      this.chooseWay = way;

      this.copyData = [];
      let i;

      if (
        // 카테고리 3항목이 전체인 경우
        this.chooseMat == "전체" &&
        this.chooseKind == "전체" &&
        this.chooseWay == "전체"
      ) {
        this.copyData = [...this.listArray];
        return;
      } else if (
        // 재료만  선택
        this.chooseMat != "전체" &&
        this.chooseKind == "전체" &&
        this.chooseWay == "전체"
      ) {
        for (i = 0; i < this.listArray.length; i++) {
          if (this.listArray[i].mat == this.chooseMat) {
            this.copyData.push(this.listArray[i]);
          }
        }
        return;
      } else if (
        //종류만 선택
        this.chooseMat == "전체" &&
        this.chooseKind != "전체" &&
        this.chooseWay == "전체"
      ) {
        for (i = 0; i < this.listArray.length; i++) {
          if (this.listArray[i].kind == this.chooseKind) {
            this.copyData.push(this.listArray[i]);
          }
        }
        return;
      } else if (
        //방법만 선택
        this.chooseMat == "전체" &&
        this.chooseKind == "전체" &&
        this.chooseWay != "전체"
      ) {
        for (i = 0; i < this.listArray.length; i++) {
          if (this.listArray[i].way == this.chooseWay) {
            this.copyData.push(this.listArray[i]);
          }
        }
        return;
      } else if (
        //재료와 종류만 선택
        this.chooseMat != "전체" &&
        this.chooseKind != "전체" &&
        this.chooseWay == "전체"
      ) {
        for (i = 0; i < this.listArray.length; i++) {
          if (
            this.listArray[i].mat == this.chooseMat &&
            this.listArray[i].kind == this.chooseKind
          ) {
            this.copyData.push(this.listArray[i]);
          }
        }

        return;
      } else if (
        //종류와 방법만 선택
        this.chooseMat == "전체" &&
        this.chooseKind != "전체" &&
        this.chooseWay != "전체"
      ) {
        for (i = 0; i < this.listArray.length; i++) {
          if (
            this.listArray[i].kind == this.chooseKind &&
            this.listArray[i].way == this.chooseWay
          ) {
            this.copyData.push(this.listArray[i]);
          }
        }

        return;
      } else if (
        //재료와 방법만 선택
        this.chooseMat != "전체" &&
        this.chooseKind == "전체" &&
        this.chooseWay != "전체"
      ) {
        for (i = 0; i < this.listArray.length; i++) {
          if (
            this.listArray[i].mat == this.chooseMat &&
            this.listArray[i].way == this.chooseWay
          ) {
            this.copyData.push(this.listArray[i]);
          }
        }
        return;
      } else if (
        // 재료 종류 방법 모두 선택
        this.chooseMat != "전체" &&
        this.chooseKind != "전체" &&
        this.chooseWay != "전체"
      ) {
        for (i = 0; i < this.listArray.length; i++) {
          if (
            this.listArray[i].mat == this.chooseMat &&
            this.listArray[i].kind == this.chooseKind &&
            this.listArray[i].way == this.chooseWay
          ) {
            this.copyData.push(this.listArray[i]);
          }
        }
        return;
      }
    },

    clickMat(value) {
      this.chooseMat = value;
      console.log(this.chooseMat, this.chooseKind, this.chooseWay);
      this.selectCate(this.chooseMat, this.chooseKind, this.chooseWay);
    },
    clickKind(kind) {
      this.chooseKind = kind;
      console.log(this.chooseMat, this.chooseKind, this.chooseWay);
      this.selectCate(this.chooseMat, this.chooseKind, this.chooseWay);
    },
    clickWay(way) {
      this.chooseWay = way;
    },

    /* 재료 설정 백업
    selectMat(value) {
      this.chooseMat = value;
      console.log("사용자가 선택한 카테고리" + this.chooseMat);

      this.copyData = [];

      if (this.chooseMat == "전체") {
        this.copyData = [...this.listArray];
        return;
      }

      let i;
      for (i = 0; i < this.listArray.length; i++) {
        console.log("반복문 재료 " + this.listArray[i].mat);

        if (this.listArray[i].mat == this.chooseMat) {
          console.log("카테고리 일치 확인");
          this.copyData.push(this.listArray[i]);
        } else {
          console.log("카테고리 해당 없는 사항 ");
        }
      }
    },*/
  },

  computed: {
    pageCount() {
      this.selectCate(this.chooseMat, this.chooseKind, this.chooseWay);

      let listLeng = this.copyData.length,
        listSize = this.pageSize,
        page = Math.floor(listLeng / listSize);

      if (listLeng % listSize > 0) page += 1;
      return page;
    },
    paginatedData() {
      const start = this.pageNum * this.pageSize,
        end = start + this.pageSize;
      return this.copyData.slice(start, end);
    },

    /*
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
    },*/
  },

  /*beforeUpdate() {
    console.log("beforeUpdate");
    if (this.chooseMat == "전체") {
      this.listArray = this.copyData;
      return;
    }
    let i;
    for (i = 0; i < this.listArray.length; i++) {
      if (this.listArray[i].mat == this.chooseMat) {
        console.log("일치");
      } else {
        this.listArray.splice(i, 1);
      }
    }
  },*/
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
