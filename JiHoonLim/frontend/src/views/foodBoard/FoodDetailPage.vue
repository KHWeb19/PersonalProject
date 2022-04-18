<template>
  <div>
    <food-detail-form v-if="foodBoard" :foodBoard="foodBoard" />
    <food-board-comment
      @submit="onSubmit"
      :foodBoardComments="foodBoardComments"
    />
  </div>
</template>

<script>
import FoodDetailForm from "@/components/foodBoard/FoodDetailForm.vue";
import FoodBoardComment from "@/components/foodBoard/FoodBoardComment.vue";
import { mapActions, mapState } from "vuex";
import axios from "axios";

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
    FoodBoardComment,
  },
  computed: {
    ...mapState(["foodBoard", "foodBoardComments"]),
  },
  mounted() {
    this.fetchFoodBoardCommentList(this.boardNo).catch(() => {
      alert("댓글 요청 실패");
    });
  },
  created() {
    this.fetchFoodBoard(this.boardNo).catch(() => {
      alert("게시물 요청 실패");
    });
  },
  methods: {
    ...mapActions(["fetchFoodBoard", "fetchFoodBoardCommentList"]),
    onSubmit(payload) {
      const { comment, commentWriter } = payload;
      axios
        .post(
          `http://localhost:7777/foodBoard/comment/register/${this.boardNo}`,
          { comment, commentWriter }
        )
        .then(() => {
          alert("댓글 등록 성공");
        })
        .catch(() => {
          alert("댓글 등록 실패");
        });
    },
  },
};
</script>
