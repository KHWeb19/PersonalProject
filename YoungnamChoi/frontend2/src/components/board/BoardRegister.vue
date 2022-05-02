<template>
  <form @submit.prevent="onSubmit">
    <div class="글작성">
      <h3 style="padding:30px 0px 30px 0px; font-weight:bold" align="left">
        나의 생각
      </h3>

      <h6 align="left">제목 :</h6>
      <b-form-input type="text" placeholder="" v-model="title"> </b-form-input>

      <br />

      <br />

      <h6 align="left">내용 :</h6>
      <b-form-textarea
        id="textarea-rows"
        placeholder=""
        rows="8"
        v-model="content"
      >
      </b-form-textarea>

      <div class="버튼" style="padding:20px;">
        <v-btn
          text
          color="black"
          rounded
          x-large
          style="padding: 10px; width: 90px;"
          type="submit"
          >등록하기
        </v-btn>

        <br />

        <router-link
          style="text-decoration: none; color:black"
          :to="{ name: 'BoardListPage' }"
        >
          <v-btn
            text
            color="black"
            rounded
            x-large
            style="padding: 10px; width: 90px;"
            type="submit"
            >목록으로
          </v-btn>
        </router-link>
      </div>
    </div>
  </form>
</template>

<script>
export default {
  name: "BoardRegister",
  data() {
    return {
      title: "",

      content: "",
    };
  },
  methods: {
    onSubmit() {
      var result = confirm("등록 하시겠습니까?");
      if (result) {
        const { title, content } = this;
        this.$emit("submit", { title, content });
        this.$router.push({
          name: "BoardListPage",
          // params: { boardNo: res.data.boardNo.toString() }
        });
      }
    },
  },
};
</script>

<style scoped>
.글작성 {
  padding: 0px 200px 100px 200px;
}
</style>
