<template>
  <div>
    <food-modify-form
      v-if="foodBoard"
      :foodBoard="foodBoard"
      @submit="onSubmit"
    />
  </div>
</template>

<script>
import FoodModifyForm from "@/components/foodBoard/FoodModifyForm.vue";
import { mapActions, mapState } from "vuex";
import axios from "axios";

export default {
  name: "FoodModifyPage",
  components: {
    FoodModifyForm,
  },
  props: {
    boardNo: {
      type: String,
      required: true,
    },
  },
  computed: {
    ...mapState(["foodBoard"]),
  },
  created() {
    this.fetchFoodBoard(this.boardNo).catch(() => {
      alert("조회 실패");
      this.$router.back();
    });
  },
  methods: {
    ...mapActions(["fetchFoodBoard"]),
    onSubmit(payload) {
      const {
        name,
        des,
        material,
        content,
        writer,
        tip,
        chooseKind,
        chooseMat,
        chooseWay,
        file,
        filename,
      } = payload;

      let formData = new FormData();

      if (file != null) {
        formData.append("file", file);
      }
      formData.append("name", name);
      formData.append("des", des);
      formData.append("material", material);
      formData.append("content", content);
      formData.append("tip", tip);
      formData.append("kind", chooseKind);
      formData.append("way", chooseWay);
      formData.append("mat", chooseMat);
      formData.append("writer", writer);
      formData.append("filename", filename);

      axios
        .put(`http://localhost:7777/foodBoard/${this.boardNo}`, formData, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then((res) => {
          alert("게시물 수정 성공");

          this.$router.push({
            name: "FoodDetailPage",
            params: { boardNo: res.data.boardNo.toString() },
          });
        })
        .catch(() => {
          alert("게시물 수정 실패");
        });
    },
  },
};
</script>
