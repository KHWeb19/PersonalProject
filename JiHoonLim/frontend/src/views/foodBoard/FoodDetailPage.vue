<template>
  <div>
    <food-detail-form v-if="foodBoard" :foodBoard="foodBoard" />
  </div>
</template>

<script>
import FoodDetailForm from "@/components/foodBoard/FoodDetailForm.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "FoodDetailPage",
  props: {
    boardNo: {
      type: String,
      required: true,
    },
  },
  components: {
    FoodDetailForm,
  },
  computed: {
    ...mapState(["foodBoard"]),
  },
  created() {
    this.fetchFoodBoard(this.boardNo).catch(() => {
      alert("요청 실패");
    });
  },
  methods: {
    ...mapActions(["fetchFoodBoard"]),
  },
};
</script>
