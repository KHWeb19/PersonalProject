<template>
  <v-dialog v-model="dialog" max-width="350">
    <template v-slot:activator="{ on }">
      <v-list-item v-on="on" @click="readComment">
        수정
      </v-list-item>
    </template>

    <v-card color="basil">
      
      <v-text-field v-model="content" class="px-3"></v-text-field>

      <v-card-text></v-card-text>

      <v-card-actions>
        <v-btn @click="btnCancle"  text >
          Cancle
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn @click="modifyComment" text>
          Modify
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>


<script>
import axios from 'axios'

import { mapActions, mapState } from 'vuex'

export default {
  name: 'CommentModifyForm',
  props: {
    commentNo: {
    },
    qnaNo: {
    }
  },
  data () {
    return {
      dialog: false,
      content: null
    }
  },
  computed: {
    ...mapState([ 'comments', 'comment' ])
  },
  mounted () {
    this.fetchComment(this.commentNo)
  },
  methods: {
    ...mapActions([ 'fetchComment', 'fetchComments' ]),
    btnCancle () {
      this.dialog = false
    },
    modifyComment () {
      const content  = this.content
      axios.patch(`http://localhost:7777/comment/modify/${this.commentNo}`, { content })
        .then(() => {
        alert('수정이 완료되었습니다')
        this.fetchComments(this.qnaNo)
        this.dialog = false
      })
    },
    readComment () {
      this.fetchComment(this.commentNo)
      this.content = this.comment.content
    }
  }
}
</script>