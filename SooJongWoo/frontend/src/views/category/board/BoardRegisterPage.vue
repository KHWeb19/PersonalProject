<template>
  <div id="board">
    <v-container class="about-top">
      <h1>NOTICE BOARD</h1>
      <p>| 공지사항 |</p>
    </v-container>
    <v-divider></v-divider>

    <board-register-form @submit="onSubmit" />
  </div>
</template>

<script>
import BoardRegisterForm from "@/components/board/BoardRegisterForm.vue";
import axios from "axios";
export default {
  name: "BoardRegisterPage",
  components: {
    BoardRegisterForm,
  },
  methods: {
    onSubmit(payload) {
      const { title, writer, content } = payload;
      axios
        .post("http://localhost:7777/board/register", {
          title,
          writer,
          content,
        })
        .then((res) => {
          alert("등록이 완료되었습니다." + res);
          this.$router.push({
            name: "BoardListPage",
          });
        })
        .catch((res) => {
          alert(res.response.data.message);
        });
    },
  },
};
</script>


<style scoped>
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