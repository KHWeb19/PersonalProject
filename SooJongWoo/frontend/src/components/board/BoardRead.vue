<template>
  <form>
    <div class="board-box">
      <v-col cols="12" md="12">
        <v-text-field
          label="글번호"
          required
          height="5vh"
          style="margin-top: 10px"
          readonly
          filled
          :value="board.boardNo"
          type="boardNo"
        >
        </v-text-field>

        <v-text-field
          label="제목"
          required
          height="5vh"
          style="margin-top: 10px"
          readonly
          filled
          :value="board.title"
          type="title"
        >
        </v-text-field>

        <v-text-field
          label="작성자"
          required
          height="5vh"
          style="margin-top: 10px"
          readonly
          filled
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
          readonly
          filled
          :value="board.content"
          type="content"
        >
        </v-textarea>
      </v-col>
    </div>
  </form>
</template>

<script>
export default {
  name: "BoardRead",
  props: {
    board: {
      type: Object,
      required: true,
    },
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