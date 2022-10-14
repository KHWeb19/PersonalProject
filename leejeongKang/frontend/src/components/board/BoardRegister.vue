<template>
    <body>
      <v-container>
      <form @submit.prevent="onSubmit">
        <h2>글 등록</h2>
          <v-text-field v-model="title" label="제목" placeholder="제목을 입력하세요" type="text" :rules="user_title_rule"></v-text-field>
          <v-text-field label="작성자" :value="this.$store.state.userInfo.id" type="text" readonly></v-text-field>
          <v-textarea v-model="content" label="내용" placeholder="내용을 입력하세요" type="text"
                    height="300px" ></v-textarea><br><br><br>
          <div id ='btn'>
            <v-btn class="white--text" id="BtnRegister" type="submit">글 등록</v-btn>
          </div><br><br><br><br><br>
      </form>
  </v-container>
</body>
</template>

<script>
export default {
  name: 'BoardRegister',
  props: {
    userInfo: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      title: '',
      writer: this.$store.state.userInfo.id,
      content: ''
    }
  },
  methods: {
    onSubmit () {
      const { title, writer, content } = this
      this.$emit('submit', { title, writer, content })
    }
  }
}
</script>

<style scoped>
h2 { font-size: 30px;}
#btn { text-align: center; font-size: 20px; }
#BtnRegister { background-color: navy; width: 500px; height: 55px;}
</style>
