<template>
  <div>
    <food-register-form @submit="onSubmit" />
  </div>
</template>

<script>
import FoodRegisterForm from "@/components/foodBoard/FoodRegisterForm.vue";
import axios from "axios";
import { mapActions, mapState } from "vuex";

export default {
  name: "FoodRegisterPage",
  components: {
    FoodRegisterForm,
  },
  data() {
    return {
      userInfo: JSON.parse(localStorage.getItem("userInfo")),
    };
  },

  computed: {
    ...mapState(["member"]),
  },

  methods: {
    ...mapActions(["fetchMember"]),

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

      axios
        .post("http://localhost:7777/foodBoard/register", formData, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then(() => {
          alert("게시물 등록 성공");
          setTimeout(() => {
            this.$router.push({
              name: "FoodListPage",
            });
          }, 300);
        })
        .catch(() => {
          alert("문제 발생");
        });
    },
  },
};
</script>
