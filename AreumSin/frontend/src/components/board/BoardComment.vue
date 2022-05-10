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

      <table width="100%">
        <tr v-if="!boardListComment || (Array.isArray(boardListComment) && boardListComment.length === 0)">
          <td>
            댓글 없지요!
          </td>
        </tr>


        <tr v-else v-for="boardComment in boardListComment" :key="boardComment.boardCommentNo" style="height: 60px">
          <v-col v-if="boardComment.deep !== 0 " style=" width: 150px">
            <td v-for="index in boardComment.deep" :key="index" style="width: 30px;">
               &nbsp;
            </td>
            <td><v-icon>mdi-arrow-right-bottom-bold</v-icon></td>
          </v-col>
          <td style="font-size: 25px; width: 240px">
            {{boardComment.writer}}
          </td>
          <td style="font-size: 25px;">
            {{boardComment.comment}}
  <!--          {{boardComment}}-->
            <v-btn @click="writeReply(boardComment)" icon><v-icon>mdi-message</v-icon></v-btn>
          </td>


        </tr>
      </table>
      <v-row>
        <v-col v-if="replyCheck">
          <input type="text" value="여기에 대댓글!" style="width: 80%; height: 40px; border: black 1px solid" v-model="reply" v-on:keyup.enter="sendReply">
          <v-btn style="width: 20%; height: 40px" @click="sendReply">작성</v-btn>
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
      reply: '',
      commentNo: '',
      replyCheck: false,
    }
  },
  methods: {
    sendComment(){
      const {comment} = this;
      this.$emit("sendComment", {comment});
    },
    writeReply(comment){
      this.replyCheck = true;
      this.commentNo = comment.boardCommentNo;
    },
    sendReply(){
      const {reply, commentNo} = this;
      this.$emit("sendReply", {reply, commentNo})
    }

  }

}
</script>

<style scoped>
v-col{
  font-size: 50px;
}
</style>