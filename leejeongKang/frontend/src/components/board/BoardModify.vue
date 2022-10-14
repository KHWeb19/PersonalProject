<template>
    <body>
      <v-container>
      <form @submit.prevent="onSubmit">
        <h2>게시글 수정</h2>
          <v-text-field v-model="title" label="제목" placeholder="제목을 입력하세요" type="text" :rules="user_title_rule"></v-text-field>
          <v-text-field :value="board.writer" label="작성자" readonly></v-text-field>
          <v-textarea v-model="content" label="내용" placeholder="내용을 입력하세요" type="text"
                    height="300px" ></v-textarea><br><br><br>
          <div id ='btn'>
            <v-btn class="white--text" id="BtnModify" type="submit">수정</v-btn>
          </div><br><br><br><br><br>
      </form>
  </v-container>
</body>
</template>

<script>
export default {
  name: 'BoardModify',
  props: {
    board: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      title: '',
      content: ''
    }
  },
  methods: {
    onSubmit () {
      const { title, content } = this
      this.$emit('submit', { title, content })
    }
  },
  created () {
    this.title = this.board.title
    this.content = this.board.content
  }
}
</script>

<style scoped>
h2 { font-size: 30px; text-align: center; }
#btn { text-align: center; font-size: 20px; }
#BtnModify { background-color: navy; width: 500px; height: 55px;}
</style>
