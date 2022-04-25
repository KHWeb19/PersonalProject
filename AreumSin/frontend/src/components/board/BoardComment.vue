<template>
  <v-container>
    boardComment :) ....

    <v-card class="pa-10">
      <v-row>
        <v-col>
          <input type="text" value="여기에 댓글을 작성해주세요!" style="width: 80%; height: 40px" v-model="comment" v-on:keyup.enter="sendComment">
          <v-btn style="width: 20%; height: 40px" @click="sendComment">작성</v-btn>
        </v-col>
      </v-row>
      <hr style="margin-bottom: 50px">

      <v-row v-if="!boardListComment || (Array.isArray(boardListComment) && boardListComment.length === 0)">
        <v-col >
          댓글 없지요!
        </v-col>
      </v-row>

      <v-row v-else v-for="boardComment in boardListComment" :key="boardComment.boardCommentNo">
        <v-col cols="3" style="font-size: 25px;">
          {{boardComment.writer}}
        </v-col>
        <v-col cols="6" style="font-size: 30px;">
          {{boardComment.comment}}
        </v-col>

      </v-row>

    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "BoardComment",
  props: {
    boardListComment: {
      type: Array,
    }
  },
  data(){
    return{
      comment: '',
      replyCheck: false,
    }
  },
  methods: {
    sendComment(){
      const {comment} = this;
      this.$emit("sendComment", {comment});
    },

  }

}
</script>

<style scoped>
v-col{
  font-size: 50px;
}
</style>