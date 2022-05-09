<template>

  <v-container>
    <v-row>
      <notice-modify-form v-if="noticeBoard" :noticeBoard="noticeBoard" @submit="onSubmit"/>
    </v-row>
  </v-container>

</template>

<script>
import NoticeModifyForm from "@/components/board/noticeBoard/NoticeModifyForm.vue"
import { mapActions, mapState } from "vuex"
import axios from "axios"
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
    onSubmit(payload) {
      const { title, content } = payload;
      axios
        .put(`http://localhost:7777/noticeBoard/${this.boardNo}`, {
          title,
          writer: this.noticeBoard.writer,
          content,
          regDate: this.noticeBoard.regDate,
        })
        .then(res => {
          alert('Successfully submitted')
          this.$router.push({
            name: "NoticeReadPage",
            params: { boardNo: res.data.boardNo.toString() },
          })
        })
        .catch(() => {
          alert("수정 실패")
        })
    },
  },
  created() {
    this.fetchNoticeBoard(this.boardNo).catch(() => {
      alert("게시물 요청 실패")
      this.$router.back(0)
    })
  },
}
</script>