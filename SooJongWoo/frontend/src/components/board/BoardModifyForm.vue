<template>
  <form @submit.prevent="onSubmit">
    <div class="board-box">
      <v-col cols="12" md="12">
        <v-text-field
          label="글번호"
          required
          height="5vh"
          style="margin-top: 10px"
          disabled
          :value="board.boardNo"
          type="boardNo"
        >
        </v-text-field>

        <v-text-field
          label="제목"
          required
          height="5vh"
          style="margin-top: 10px"
          v-model="title"
          type="title"
        >
        </v-text-field>

        <v-text-field
          label="작성자"
          required
          height="5vh"
          style="margin-top: 10px"
          disabled
          :value="board.writer"
          type="writer"
        >
        </v-text-field>

        <v-textarea
          label="본문"
          auto-grow
          style="margin-top: 10px"
          counter
          maxlength="500"
          full-width
          single-line
          outlined
          v-model="content"
          type="content"
        >
        </v-textarea>
      </v-col>
    </div>

    <div class="btn-size">
      <v-col cols="12" md="12">
        <v-btn type="submit" color="blue" class="ma-2 white--text">
          수정등록
        </v-btn>
        <v-btn
          color="blue darken-4"
          outlined
          class="ma-2 white--text"
          route
          :to="{
            name: 'BoardReadPage',
            params: { boardNo: board.boardNo.toString() },
          }"
        >
          취소
        </v-btn>
      </v-col>
    </div>
  </form>
</template>

<script>
export default {
  name: "BoardModifyForm",
  props: {
    board: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      title: "",
      content: "",
    };
  },
  methods: {
    onSubmit() {
      const { title, content } = this;
      this.$emit("submit", { title, content });
    },
  },
  created() {
    this.title = this.board.title;
    this.content = this.board.content;
  },
};
</script>


<style scoped>
.board-box {
  text-align: center;
  width: 50%;
  padding-top: 5%;
  margin: 0 auto;
}
.register-box {
  border: 1px solid #cccccc;
  background-color: white;
  float: left;
  width: 500px;
  height: 500px;
}
.btn-size {
  margin: 0 auto;
  text-align: center;
  width: 50%;
  padding: 3% 0% 5% 0%;
}
h1 {
  font-family: "Gowun Dodum";
  font-size: 30px;
  margin-top: 5%;
  text-align: center;
}
</style>
