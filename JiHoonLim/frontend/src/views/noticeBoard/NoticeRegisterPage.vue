<template>
  <div><notice-register-form @submit="onSubmit" /></div>
</template>

<script>
import NoticeRegisterForm from "@/components/noticeBoard/NoticeRegisterForm.vue";
import axios from "axios";

export default {
  name: "NoticeRegisterPage",
  components: {
    NoticeRegisterForm,
  },

  methods: {
    onSubmit(payload) {
      const { title, content, writer } = payload;
      axios
        .post("http://localhost:7777/noticeBoard/register", {
          title,
          content,
          writer,
        })
        .then(() => {
          alert("게시물 등록 성공");
          this.$router.push({
            name: "NoticeListPage",
          });
        })
        .catch(() => {
          alert("오류 발생");
        });
    },
  },
};
</script>
