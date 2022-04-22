<template>
  <div>
    <food-list :foodBoards="foodBoards" :list-array="pageArray" />
  </div>
</template>

<script>
import FoodList from "@/components/foodBoard/FoodList.vue";
import { mapActions, mapState } from "vuex";
import axios from "axios";

export default {
  name: "FoodListPage",
  components: {
    FoodList,
  },

  computed: {
    ...mapState(["foodBoards"]),
  },
  mounted() {
    this.fetchFoodBoardList();
  },
  methods: {
    ...mapActions(["fetchFoodBoardList"]),
  },

  data() {
    return {
      pageArray: [],
    };
  },
  created() {
    axios
      .get("http://localhost:7777/foodBoard/getFoodList")
      .then((res) => {
        this.pageArray = res.data;
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>
