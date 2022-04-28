<template>
  <v-dialog v-model="dialog" max-width="350">
    <template v-slot:activator="{ on }">
      <v-list-item v-on="on" @click="readComment">
        수정
      </v-list-item>
    </template>

    <v-card class=" rounded-xl pa-4">
      <v-card-title class="headline secondary--text font-weight-bold">
        <p>댓글 수정</p>
      </v-card-title>
      <v-text-field v-model="content" class="px-3" color="secondary"></v-text-field>

      <v-card-text></v-card-text>

      <v-divider></v-divider>
      <v-card-actions>
        <v-btn @click="btnCancle" class="secondary--text font-weight-bold" text >
          Cancle
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn @click="modifyComment" class="secondary--text font-weight-bold" text>
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
  name: 'ModifyComment',
  props: {
    commentNo: {

    },
    boardNo: {

    }
  },
  data () {
    return {
      dialog: false,
      content: null
    }
  },
  computed: {
    ...mapState([ 'checkbrandComments', 'checkbrandComment' ])
  },
  mounted () {
    this.fetchCheckBrandComment(this.commentNo)
  },
  methods: {
    ...mapActions([ 'fetchCheckBrandComment', 'fetchCheckBrandComments' ]),
    btnCancle () {
      this.dialog = false
    },
    modifyComment () {
      const content  = this.content
      axios.patch(`http://localhost:7777/BrandCheck/comment/modify/${this.commentNo}`, { content }).then(() => {
        alert('수정이 완료되었습니다')

        this.fetchCheckBrandComments(this.boardNo)

        this.dialog = false
      })
    },
    readComment () {
      this.fetchCheckBrandComment(this.commentNo)
      this.content = this.checkbrandComment.content
    }
  }
}
</script>