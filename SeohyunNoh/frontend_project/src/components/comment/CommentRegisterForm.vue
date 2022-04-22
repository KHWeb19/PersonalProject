<template>
  <v-card flat>
    <v-toolbar flat v-if="!isLogin">
      <v-text-field flat label="댓글을 입력하려면 로그인해주세요." solo hide-details disabled></v-text-field>
      <!-- <p>댓글을 입력하려면 로그인 해주세요</p> -->
    </v-toolbar>

    <v-toolbar v-else flat>
      <v-text-field flat v-model="content" class="basil--text" label="댓글을 입력해 주세요."
        solo hide-details></v-text-field>
      <v-btn plain class="basil--text" @click="addComment" >
        등록
      </v-btn>
    </v-toolbar>
  </v-card>  

</template>


<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  data () {
    return {
      content: null
    }
  },
  props: {
    qnaNo: {
      
    }
  },
  computed: {
    ...mapState([ 'userInfo' ,'isLogin'])
  },
  methods: {
    ...mapActions([ 'fetchComments' ]),
    addComment () {
      const id = this.$store.state.userInfo.id
      const content = this.content
      const qnaNo = this.qnaNo
      axios.post('http://localhost:7777/comment/register', { id, content, qnaNo })
        .then(() => {
        alert('댓글이 등록되었습니다!')

        this.fetchComments(qnaNo)
        this.content = null
      }).catch(res => {
        alert(res)
      })
      
    }
  }
}
</script>