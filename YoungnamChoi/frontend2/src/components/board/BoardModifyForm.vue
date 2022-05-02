<template>
  <div class="글작성">
    <h3 style="padding: 30px 0px 30px 0px; font-weight: bold" align="left">
      나의 생각
    </h3>
    <form @submit.prevent="onSubmit">
      <h6 align="left">등록일자 :</h6>
      <b-form-input type="text" :value="board.regDate" disabled> </b-form-input>

      <br />

      <h6 align="left">제목 :</h6>
      <b-form-input type="text" v-model="title"> </b-form-input>

      <br />

      <h6 align="left">내용 :</h6>
      <b-form-textarea
        id="textarea-rows"
        placeholder=""
        rows="8"
        v-model="content"
      >
      </b-form-textarea>
      <div>
        <div class="버튼" style="padding: 20px">
          <v-btn
            text
            color="black"
            rounded
            x-large
            style="padding: 10px; width: 90px"
            type="submit"
            >수정완료
          </v-btn>

          <br />

          <router-link
            style="text-decoration: none; color: black"
            :to="{
              name: 'BoardReadPage',
              params: { boardNo: board.boardNo.toString() },
            }"
          >
            <v-btn
              text
              color="black"
              rounded
              x-large
              style="padding: 10px; width: 90px"
            >
              취소
            </v-btn>
          </router-link>
        </div>
      </div>
    </form>
  </div>
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
      var result = confirm("수정 하시겠습니까?");
      if (result) {
        const { title, content } = this;
        this.$emit("submit", { title, content });
      }
    },
  },
  created() {
    this.title = this.board.title;
    this.content = this.board.content;
  },
};
</script>

<style scoped>
.글작성 {
  padding: 0px 200px 100px 200px;
}
</style>
