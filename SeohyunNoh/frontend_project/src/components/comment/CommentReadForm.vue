<template>

  <v-card class="mb-10">
    <comment-register-form :qnaNo="qnaNo"/>

    <v-card v-if="!comments || (Array.isArray(comments) && comments.length ===0)" 
      class="pa-5" flat>
      <p class="ma-2">등록된 댓글이 없습니다.</p>
    </v-card>

    <v-card v-else v-for="item in comments" :key="item.commentNo" class="mx-4"  flat>
      <v-list>
        <v-list-item>
          <v-list-item-avatar width="50px">
            {{ item.id }}
          </v-list-item-avatar>
      
          <v-tooltip left>
            <template v-slot:activator="{on}">
              <v-list-item v-on="on">
                {{ item.content }}
              </v-list-item>
            </template>
            <span>
              {{new Date(item.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(0, 11)}}
              {{new Date(item.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(12, 8)}}
            </span>
          </v-tooltip>
             
          <v-menu offset-y>
            <template v-slot:activator="{ on }">
              <v-btn v-if="userInfo.id == item.id" v-on="on" icon>
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </template>
            <v-list>

              <comment-modify-form :commentNo="item.commentNo" :qnaNo="qnaNo"/>

              <v-list-item @click="removeDialog(item.commentNo)">
                삭제
              </v-list-item>
            </v-list>
          </v-menu>
          
        </v-list-item>
      </v-list>
      <v-divider></v-divider>
    </v-card>

    <v-dialog v-model="dialog" max-width="350">
      <v-card class="basil">
        <v-card-title class="basil--text">
          <p>정말 삭제하시겠습니까?</p>
        </v-card-title>

        <v-card-text></v-card-text>

        <v-card-actions>
          <v-btn @click="btnCancle" class="basil--text" text >
            Cancle
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn @click="btnRemove" class="basil--text" text>
            Delete
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

  </v-card>  
</template>


<script>
import CommentRegisterForm from '@/components/comment/CommentRegisterForm.vue'
import CommentModifyForm from '@/components/comment/CommentModifyForm.vue'

import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  components: {
    CommentRegisterForm,
    CommentModifyForm
  },
  props: {
    qnaNo: {
      
    }
  },
  data () {
    return {
      dialog: false,
      commentNo: null
    }
  },
  computed: {
    ...mapState([ 'comments', 'userInfo' ])
  },
  mounted () {
    this.fetchComments(this.qnaNo)
  },
  methods: {
    ...mapActions([ 'fetchComments', 'fetchComment' ]),
    removeDialog (commentNo) {
      this.dialog = true
      this.commentNo = commentNo
    },
    btnCancle () {
      this.dialog = false
    },
    btnRemove () {
      axios.delete(`http://localhost:7777/comment/remove/${this.commentNo}`).then(() => {
        alert('댓글이 삭제되었습니다!')
        this.fetchComments(this.qnaNo)
        this.dialog = false
      })
    },
  }
}
</script>