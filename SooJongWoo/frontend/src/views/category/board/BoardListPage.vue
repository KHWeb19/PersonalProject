<template>
  <div id="board" class="list">
    <v-container class="about-top">
      <h1>NOTICE BOARD</h1>
      <p>| 공지사항 |</p>
    </v-container>
    <v-divider></v-divider>

    <board-list :boards="boards" />

    <v-btn
      color="blue"
      outlined
      class="btn-locate"
      v-if="this.auth == '관리자'"
      route
      :to="'/board/create'"
      >글쓰기</v-btn
    >
  </div>
</template>

<script>
import BoardList from "@/components/board/BoardList.vue";
import { mapActions, mapState } from "vuex";
export default {
  name: "BoardListPage",
  components: {
    BoardList,
  },
  data() {
    return {
      title: "",
      auth: this.$cookies.get("auth"),
    };
  },
  computed: {
    ...mapState(["boards"]),
  },
  mounted() {
    this.fetchBoardList();
  },
  methods: {
    ...mapActions(["fetchBoardList"]),
  },
};
</script>

<style scoped>
.list {
  margin-bottom: 5%;
}
.pagination li a {
  padding: 0 15px;
}
.page-num {
  background-color: white;
  box-shadow: 0 0px 0px 0 rgb(0 0 0 / 0%), 0 0px 0px -0px rgb(0 0 0 / 0%),
    0 0px 0px 0 rgb(0 0 0 / 0%);
  width: 16%;
}
.search-box {
  margin: 0;
  margin-top: -10%;
  position: relative;
  left: 35%;
  width: 80%;
}
.btn-locate {
  position: relative;
  left: 72%;
  margin-bottom: 5%;
}
.board-box {
  padding-bottom: 5%;
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
  padding-top: 7vh;
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