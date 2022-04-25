<template>
  <div>
    <notice-modify-form :noticeBoard="noticeBoard" />
  </div>
</template>

<script>
import NoticeModifyForm from "@/components/noticeBoard/NoticeModifyForm.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "NoticeModifyPage",
  components: {
    NoticeModifyForm,
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
  methods: {
    ...mapActions(["fetchNoticeBoard"]),
  },
  created() {
    this.fetchNoticeBoard(this.boardNo).catch(() => {
      alert("게시물 요청 실패");
      this.$router.back(0);
    });
  },
};
</script>
