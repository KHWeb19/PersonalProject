<template>
  <div>
    <!-- <v-simple-table style="padding:50px 100px 100px 100px">
            <template v-slot:default>
                <thead>
                    <tr>
                    <th class="text-left">
                        번호
                    </th>
                    <th class="text-left">
                        제목
                    </th>
                    <th class="text-left">
                        작성자
                    </th>
                    <th class="text-left">
                        등록일자
                    </th>
                    </tr>
                </thead>

                <tbody>
                    <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                            <td colspan="4">
                                현재 등록된 게시물이 없습니다!
                            </td>
                        </tr>

                    <tr v-else
                    v-for="board in boards"
                    :key="board.boardNo"
                    >
                    <td>{{ board.boardNo }}</td>
                    <td align="left">
                                <router-link :to="{ name: 'BoardReadPage',
                                                params: { boardNo: board.boardNo.toString() } }"
                                                style="text-decoration: none;
                                                color:black">
                                    {{ board.title }}
                                </router-link>
                            </td>
                    <td>{{ board.writer }}</td>
                    <td>{{ board.regDate }}</td>
                    </tr>
                </tbody> -->

    <!-- <v-container>
                    <v-data-table :headers="headerTitle"
                            :items="boards"
                            :items-per-page="5"
                            class="elevation-1" @click:row="handleClick">
                    </v-data-table>
                </v-container> -->

    <div>
      <v-simple-table style="padding:20px 100px 100px 100px">
        <v-data-table
          :headers="headerTitle"
          :items="boards"
          :page.sync="page"
          :items-per-page="10"
          hide-default-footer
          class="elevation-1"
          @click:row="handleClick"
          @page-count="pageCount = $event"
        ></v-data-table>
      </v-simple-table>

      <div class="text-center pt-2">
        <v-pagination v-model="page" :length="pageCount" dark></v-pagination>
      </div>
    </div>
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
  data() {
    return {
      page: 1,
      pageCount: 0,
      itemsPerPage: 10,
      headerTitle: [
        { text: "번호", value: "boardNo", width: "70px" },
        { text: "제목", value: "title", width: "200px" },

        { text: "등록일자", value: "regDate", width: "60px" },
      ],
    };
  },
  function: {},
  methods: {
    handleClick(event, idx) {
      this.$router.push({
        name: "BoardReadPage",
        params: { boardNo: String(idx.item.boardNo) },
      });
    },
  },
  mounted() {
    console.log(this.boards.regDate);
    console.log(this.boards.boardNo);
  },
};
</script>

<style scoped></style>
