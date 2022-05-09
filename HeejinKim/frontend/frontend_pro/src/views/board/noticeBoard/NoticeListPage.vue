<template>
  <v-container>
        <v-btn  v-if="loginAuth == 'Manager'" class="writeBtn" @click="writeBoard" >
          <v-icon color="black"> mdi-pencil-remove-outline </v-icon></v-btn>
        <v-row justify="center">
            <notice-board-list :noticeBoards="noticeBoards" />
        </v-row>
    </v-container>
</template>

<script>
import NoticeBoardList from "@/components/board/noticeBoard/NoticeBoardList.vue";
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
  created() {
   if (this.$store.state.session != null) {
      this.loginAuth = this.$store.state.auth.auth
      this.userId =  this.$store.state.session.userId;
    }
  },
  methods: {
    ...mapActions(["fetchNoticeBoardList"]),
    writeBoard(){
      this.$router.push('/noticeRegister')
    }
  },
}
</script>
<style scoped>
.writeBtn{
  margin-top:40px;
  left:90%;
  height:40px;
  width:40px;    
}
</style>