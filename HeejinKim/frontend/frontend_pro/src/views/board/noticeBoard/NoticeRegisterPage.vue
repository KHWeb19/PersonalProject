<template>
 <v-container class="writeForm">
        <v-row>
            <notice-register-form @submit="onSubmit" />
        </v-row>
    </v-container>

</template>

<script>
import NoticeRegisterForm from "@/components/board/noticeBoard/NoticeRegisterForm.vue"
import axios from "axios"
export default {
  name: "NoticeRegisterPage",
  components: {
    NoticeRegisterForm,
  },
  methods: {
    onSubmit(payload) {
      const { title, content, writer } = payload
      axios
        .post("http://localhost:7777/noticeBoard/register", {
          title,
          content,
          writer,
        })
        .then(() => {
          alert("Successfully submitted")
          this.$router.push({
            name: "NoticeListPage",
          })
        })
        .catch(() => {
          alert("오류 발생")
        })
    },
  },
}
</script>


<style scoped>
.writeForm{
    margin-top:2.5%;
    margin-bottom: 5%;
}
</style>