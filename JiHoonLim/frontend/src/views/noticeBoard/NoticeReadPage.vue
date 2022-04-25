<template>
  <div>
    <notice-read-form :noticeBoard="noticeBoard" />
  </div>
</template>

<script>
import NoticeReadForm from "@/components/noticeBoard/NoticeReadForm.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "NoticeReadPage",
  components: {
    NoticeReadForm,
  },
  props: {
    boardNo: {
      type: String,
      required: true,
    },
  },
  computed: {
    ...mapState(["noticeBoard"]),
  },
  created() {
    this.fetchNoticeBoard(this.boardNo).catch(() => {
      alert("게시물 요청 실패");
      this.$router.push();
    });
  },
  methods: {
    ...mapActions(["fetchNoticeBoard"]),
  },
};
</script>
