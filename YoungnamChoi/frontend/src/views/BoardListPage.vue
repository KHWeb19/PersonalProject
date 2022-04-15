<template>
  <div id="board">
    <board-list :Boards="Boards" />
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import BoardList from "../components/board/BoardList.vue";

export default {
  name: "BoardListPage",
  components: {
    BoardList,
  },
  computed: {
    ...mapState(["Boards"]),
  },
  mounted() {
    this.fetchJpaBoardList();
  },
  methods: {
    ...mapActions(["fetchBoardList"]),
  },
};
</script>
