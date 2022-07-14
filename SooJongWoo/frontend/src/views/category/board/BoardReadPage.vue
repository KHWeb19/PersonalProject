<template>
  <div id="board">
    <v-container class="about-top">
      <h1>NOTICE BOARD</h1>
      <p>| 공지사항 |</p>
    </v-container>
    <v-divider></v-divider>

    <board-read v-if="board" :board="board" />

    <p v-else>로딩중 ......</p>

    <div class="btn-size">
      <v-col cols="12" md="12">
        <v-btn
          color="blue"
          class="ma-2 white--text"
          route
          :to="{ name: 'BoardListPage' }"
        >
          목록보기
        </v-btn>
        <v-btn
          type="submit"
          color="blue darken-2"
          v-if="this.auth == '관리자'"
          class="ma-2 white--text"
          route
          :to="{ name: 'BoardModifyPage', params: { boardNo } }"
        >
          게시글 수정
        </v-btn>
        <v-btn
          color="blue darken-2"
          outlined
          v-if="this.auth == '관리자'"
          class="ma-2 white--text"
          @click="onDelete"
        >
          게시글 삭제
        </v-btn>
      </v-col>
    </div>
  </div>
</template>

<script>
import BoardRead from "@/components/board/BoardRead.vue";
import { mapState, mapActions } from "vuex";
import axios from "axios";
export default {
  name: "BoardReadPage",
  props: {
    boardNo: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      auth: this.$cookies.get("auth"),
    };
  },
  components: {
    BoardRead,
  },
  computed: {
    ...mapState(["board"]),
  },
  created() {
    this.fetchBoard(this.boardNo).catch((err) => {
      alert(err.response.data.message);
      this.$router.push();
    });
  },
  methods: {
    ...mapActions(["fetchBoard"]),
    onDelete() {
      const { boardNo } = this.board;
      axios
        .delete(`http://localhost:7777/board/${boardNo}`)
        .then(() => {
          alert("게시글을 삭제했습니다.");
          this.$router.push({ name: "BoardListPage" });
        })
        .catch((res) => {
          alert(res.response.data.message);
        });
    },
  },
};
</script>

<style scoped>
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
.board-box {
  padding-bottom: 15%;
}
.container {
  position: relative;
}
.overlay {
  position: absolute;
  z-index: 9;
  margin-top: 9%;
  left: -8%;
}
.overlay2 {
  position: absolute;
  z-index: 9;
  margin-top: 1%;
  left: 70%;
}
.overlay3 {
  position: absolute;
  z-index: 9;
  margin-top: 43%;
  left: 7%;
}
.test3 {
  margin-left: 50vw;
  position: relative;
  bottom: 25vh;
}
.intro-top {
  text-align: left;
}
.about-img-top {
  max-height: 70vh;
}
.about-img-01 {
  position: relative;
  left: 20vw;
  height: 60vh;
}
.about-img-02 {
  position: relative;
  right: 20vw;
  height: 50vh;
  margin-top: -5vh;
}
.about-img-03 {
  position: relative;
  left: 20vw;
  height: 60vh;
  margin-top: 5vh;
}
.section {
  background: #dcdfdc;
  height: 10vh;
}
p {
  font-family: "Nanum Myeongjo";
  font-size: 18px;
  text-align: center;
  padding: 18px 0px 18px 0px;
}
.about-top {
  padding-top: 10vh;
}
h1 {
  font-size: 40px;
  text-align: center;
  margin-top: 10px;
}
h2 {
  font-family: "MonteCarlo";
  font-size: 150px;
  color: darkgrey;
}
h3 {
  font-size: 80px;
  margin-top: 10px;
  color: darkgrey;
}
h4 {
  margin-top: 0px;
  font-family: "Nanum Myeongjo";
  font-size: 35px;
}
</style>