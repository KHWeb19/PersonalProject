<template>

  <v-card class="mb-10" >
    
  
    <add-question-comment :boardNo="boardNo"/>
  

    <v-card v-if="!QuestionComments || (Array.isArray(QuestionComments) && QuestionComments.length ===0)" 
      class="pa-5"  flat>
      <p class="ma-2">등록된 댓글이 없습니다.</p>
    </v-card>

    <v-card v-else v-for="item in QuestionComments" :key="item.commentNo" class="mx-4" flat>
      <v-list >
        <v-list-item>
          <v-list-item-avatar>
            {{ item.id }}
          </v-list-item-avatar>
          
          
              <v-list-item >
                {{ item.content }}
              </v-list-item>
           
          
          <v-menu offset-y>
            <template v-slot:activator="{ on }">
              <v-btn v-if="userInfo.id == item.id" v-on="on" icon>
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </template>
            <v-list>

          
              <modify-question-comment :commentNo="item.commentNo" :boardNo="boardNo"/>
              

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
      <v-card class="rounded-xl pa-4">
        <v-card-title class="secondary--text font-weight-bold">
          <p>정말 삭제하시겠습니까?</p>
        </v-card-title>

        <v-card-text></v-card-text>

        <v-card-actions>
          <v-btn @click="btnCancle" class="secondary--text font-weight-bold" text >
            Cancle
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn @click="btnRemove" class="secondary--text font-weight-bold" text>
            Delete
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

  </v-card>  
</template>


<script>
import AddQuestionComment from '@/components/comment/AddQuestionComment'
import ModifyQuestionComment from '@/components/comment/ModifyQuestionComment'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'


export default {
  components: {
    AddQuestionComment,
    ModifyQuestionComment
    
  },
  name:'ReadQuestionComment',
  props: {
    boardNo: {
      type: String,
            required: true
    }
  },
  data () {
    return {
      dialog: false,
      commentNo: null
    }
  },
  computed: {
    ...mapState([ 'QuestionComments', 'userInfo' ])
  },
  mounted () {
    this.fetchQuestionComments(this.boardNo)
  },
  methods: {
    ...mapActions([ 'fetchQuestionComments', 'fetchQuestionComment' ]),

    removeDialog (commentNo) {
      this.dialog = true
      this.commentNo = commentNo
    },
    btnCancle () {
      this.dialog = false
    },
    btnRemove () {
      axios.delete(`http://localhost:7777/Question/comment/remove/${this.commentNo}`).then(() => {
        alert('댓글이 삭제되었습니다!')

        this.fetchQuestionComments(this.boardNo)

        this.dialog = false
      })
    },
  }
}
</script>