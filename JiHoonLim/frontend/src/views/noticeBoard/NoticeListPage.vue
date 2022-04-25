<template>
  <div>
    <notice-board-list :noticeBoards="noticeBoards" />
  </div>
</template>

<script>
import NoticeBoardList from "@/components/noticeBoard/NoticeBoardList.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "NoticeListPage",
  components: {
    NoticeBoardList,
  },
  computed: {
    ...mapState(["noticeBoards"]),
  },
  mounted() {
    this.fetchNoticeBoardList();
  },
  methods: {
    ...mapActions(["fetchNoticeBoardList"]),
  },
};
</script>
