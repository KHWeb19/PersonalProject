<template>
  <div><best-food-list :foodBoards="foodBoards" /></div>
</template>

<script>
import BestFoodList from "@/components/foodBoard/BestFoodList.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "BestFoodListPage",
  components: {
    BestFoodList,
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
};
</script>
