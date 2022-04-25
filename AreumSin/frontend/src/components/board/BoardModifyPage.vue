<template>
  <v-container>
    <v-row justify="end">
      <v-btn class="red white--text" style="margin-bottom: 35px; margin-right: 5px" @click="onModify">수정 완료</v-btn>
      <v-btn class="red white--text" style="margin-bottom: 35px; margin-right: 5px" @click="showList" >돌아가기</v-btn>
    </v-row>

    <v-card class="pa-10">
      <v-row>
        <v-col cols="3">제목</v-col>
        <v-col cols="9">
          <input type="text" v-model="title">
        </v-col>
      </v-row>

      <v-row>
        <v-col cols="3">장소</v-col>
        <v-col cols="9"><input type="text" v-model="place"></v-col>
      </v-row>

      <v-row>
        <v-col cols="3">작성자</v-col>
        <v-col cols="9">{{boardRead.writer}}</v-col>
      </v-row>

      <v-row>
        <v-col cols="3">내용</v-col>
        <v-col><textarea v-model="boardContent"></textarea></v-col>
      </v-row>


      <v-row v-if="!boardReadImg">
        이미지는 없어요!
      </v-row>

      <v-row v-else v-for="(boardImg,index) in boardReadImg" :key="index">
        <v-col>
          {{boardReadImg}}
          <input type="checkbox" v-model="checkbox" :value="index">
          <v-img :src="require(`@/assets/uploadImg/${boardImg.imgSrc}`)" id="img"></v-img>
        </v-col>
      </v-row>

      <v-btn @click="test">체크</v-btn>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "BoardModifyPage",
  data(){
    return{
      isMember: false,
      title: '',
      place: '',
      boardContent: '',
      checkbox: []
    }
  },
  props: {
    boardRead: {
      type: Object,
      required: true
    },
    boardReadImg: {
      type: Array
    }
  },
  methods: {
    test(){
      alert(this.checkbox)
    },
    onModify(){
      //let BoardImg = {};
      let board = [];
      for(let i = 0; i < this.checkbox.length; i++){

        board.push(this.boardReadImg[this.checkbox[i]].boardImgNo);

        //alert(this.boardReadImg[this.checkbox[i]].boardImgNo)
        //board.push(BoardImg)
        //BoardImg.boardImg += board[i];
      }
      const {title, place, boardContent} = this

      //BoardImg = JSON.stringify(board);
      //console.log({title, place, boardContent, image})
      this.$emit('onModify', {title, place, boardContent, board});
      //alert(board)

      //this.$emit('onModify',{board})
    },
    showList(){
      this.$router.push({name: 'BoardView'})
    }
  },
  created() {
    this.title = this.boardRead.title;
    this.place = this.boardRead.place;
    this.boardContent = this.boardRead.boardContent
  }
}
</script>

<style scoped>
*{
  font-size: 30px;
}
</style>