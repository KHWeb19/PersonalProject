<template>
  <body>
    <v-container>
    <form id="contents">
      <h2>글 읽기</h2>
        <v-row justify="center">
           <v-col xs="18" sm="8" md="8">
             <v-card class="pa-3">
               <v-text-field :value="board.title" label="제목" type="text" readonly></v-text-field>
               <v-text-field :value="board.writer" label="작성자" type="text" readonly></v-text-field>
               <v-textarea :value="board.content" label="내용" type="text" height="300px" readonly></v-textarea><br>
             </v-card>
           </v-col>
        </v-row>
    </form><br>
   </v-container>
  </body>
</template>

<script>

export default {
  name: 'BoardRead',
  props: {
    board: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>
h2 { font-size: 30px;}
#contents { text-align: center; }
#btn { text-align: right; font-size: 18px;}
#btnComment { background: blue; }
</style>
