<template>
  <div class="grey lighten-3">
    <v-container class="white" style="width: 1240px">
      <v-row>
        <v-col> 카테고리 박스 </v-col>
      </v-row>
      <v-row>
        <v-col v-for="food in paginatedData" :key="food.boardNo" lg="3" sm="6">
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
              <v-card-text class="pt-0">조회 수</v-card-text>
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
</style>
