<template>
  <div id="board" align="center">
    <h3 style="padding:30px 0px 20px 0px; font-weight:bold">리뷰 게시판</h3>
    <router-link
      :to="{ name: 'BoardRegisterPage' }"
      style="text-decoration: none;"
    >
      <v-btn
        text
        color="black"
        rounded
        x-large
        style="padding: 10px; width: 90px;"
      >
        리뷰 쓰기
      </v-btn>
    </router-link>

    <div class="게시물목록">
      <board-list :boards="boards" />
    </div>
  </div>
</template>

<script>
import BoardList from "@/components/board/BoardList.vue";
import { mapState, mapActions } from "vuex";
export default {
  name: "BoardListPage",
  components: {
    BoardList,
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
.게시물목록 {
  padding: 0px 50px 100px 50px;
}
</style>
