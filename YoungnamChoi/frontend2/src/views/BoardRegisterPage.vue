<template>
  <div align="center">
    <board-register @submit="onSubmit" />
  </div>
</template>

<script>
import axios from "axios";
import BoardRegister from "../components/board/BoardRegister.vue";

export default {
  name: "BoardRegisterPage",
  components: {
    BoardRegister,
  },
  methods: {
    onSubmit(payload) {
      const { title, content, regDate } = payload;
      axios.post("http://localhost:7777/board/register", {
        title,

        content,
        regDate,
      });
    },
  },
};
</script>
