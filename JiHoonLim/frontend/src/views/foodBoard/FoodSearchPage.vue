<template>
  <div>
    <food-search-list :searchResult="searchResult" />
  </div>
</template>

<script>
import FoodSearchList from "@/components/foodBoard/FoodSearchList.vue";

export default {
  name: "FoodSearchPage",
  components: {
    FoodSearchList,
  },
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
};
</script>
