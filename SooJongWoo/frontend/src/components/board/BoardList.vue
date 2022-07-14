<template>
  <div align="center" class="board-box">
    <table>
      <tr class="top-tr">
        <th align="center" width="150">번호</th>
        <th align="center" width="200">제목</th>
        <th align="center" width="100">작성자</th>
        <th align="center" width="100">등록일자</th>
      </tr>
      <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
        <td colspan="4">현재 등록된 게시물이 없습니다!</td>
      </tr>
      <tr v-else v-for="board in boards" :key="board.boardNo">
        <td align="center">{{ board.boardNo }}</td>

        <td align="center">
          <router-link
            :to="{
              name: 'BoardReadPage',
              params: { boardNo: board.boardNo.toString() },
            }"
          >
            {{ board.title }}
          </router-link>
        </td>

        <td align="center">{{ board.writer }}</td>
        <td align="center">{{ board.regDate }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "BoardList",
  props: {
    boards: {
      type: Array,
    },
  },
};
</script>

<style scoped>
table {
  width: 55%;
  border: 1px solid #ebecec;
}
.top-tr {
  background-color: #f6f7f7;
}
.board-box {
  margin-top: 5%;
}
h4 {
  margin-top: 0px;
  font-family: "Nanum Myeongjo";
  font-size: 18px;
  margin-left: 40%;
}
.member-box {
  margin-top: 2%;
}
</style>