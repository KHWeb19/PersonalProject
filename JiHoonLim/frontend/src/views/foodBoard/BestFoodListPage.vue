<template>
  <div><best-food-list :bestFoodBoards="bestFoodBoards" /></div>
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
    ...mapState(["bestFoodBoards"]),
  },
  mounted() {
    this.fetchBestFoodList();
  },
  methods: {
    ...mapActions(["fetchBestFoodList"]),
  },
};
</script>
