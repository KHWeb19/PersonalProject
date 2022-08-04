<template>
  <form @submit.prevent="onSubmit">
    <v-container>
    <v-row justify="center">
      <v-col xs="18" sm="8" md="8">
        <v-card class="pa-3">
          <v-subheader style="dark">댓글</v-subheader>
            <v-divider :inset="false"></v-divider>
            <ul v-for="comment in comments"
              :key="comment.commentNo" justify="center" class="comment">
              <v-col>
               <li>
                  <strong>{{ comment.commentWriter }}</strong>
                  <v-spacer></v-spacer>{{ comment.comment }}
                  <v-spacer></v-spacer>{{ comment.regDate }}
               </li>
               <a v-if="comment.commentWriter == commentWriter"
                     @click="onDelete(comment.commentNo)">삭제
               </a>
              </v-col>
            </ul>
            <v-divider :inset="false"></v-divider><br>
              <textarea class="textareaComment" v-model="comment" type="text" placeholder="댓글을 입력하세요."></textarea>
            <div id ='btn'>
            <v-btn class='white--text' id="BtnRegister" type="submit">댓글 등록</v-btn>
            </div>
        </v-card>
      </v-col>
    </v-row>
    </v-container>
  </form>
</template>

<script>
import axios from 'axios'
export default {
  name: 'CommentRegister',
  props: {
    comments: {
      type: Array
    },
    userInfo: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      comment: '',
      commentWriter: this.$store.state.userInfo.id
    }
  },
  methods: {
    onSubmit () {
      const { comment, commentWriter } = this
      this.$emit('submit', { comment, commentWriter })
    },
    onDelete (commentNo) {
      axios.delete(`http://localhost:7777/comment/${commentNo}`, { commentNo })
        .then(() => {
          alert('댓글 삭제 성공')
          this.$router.go()
        })
        .catch(() => {
          alert('실패..문제 해결하세요')
          console.log(commentNo)
        })
    }
  }
}
</script>

<style scoped>
.textareaComment {
    width: 100%;
    height: 100px;
    border: 1px solid #bbb;
    margin: 10px 0;
}
#btn { text-align: center; font-size: 20px; }
#BtnRegister { background-color: navy; width: 500px; height: 45px;}
.comment.regDate { font-size: 5px; }
.deleteComment { font-style: red; }
</style>
