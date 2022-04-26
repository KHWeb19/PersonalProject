<template>
  <v-container>
    <v-row justify="end" style="margin-right: 3px">
      <v-btn class="yellow orange lighten-2" style="font-size: 20px" @click="createBoard">글 생성</v-btn>
    </v-row>

    <v-row id="wrapper">
      <v-col v-if="!boardList || (Array.isArray(boardList) && boardList.length === 0)">
        내용이 없습니다!!!
      </v-col>
      <v-col cols="3" v-else v-for="board in paginatedData" :key="board.boardNo">
        <v-card style="height: 400px" @click="showDetail(board)">
          <table style="width: 100%">
            <tr>
              <td colspan="2" align="center">
                <v-img :src="require(`@/assets/uploadImg/${board.imgSrc}`)" id="img"></v-img>
              </td>
            </tr>
            <tr>
              <td style="width: 25%; height: 75%">&nbsp;&nbsp;제 목</td>
              <td>{{ board.title }}</td>
            </tr>
            <tr>
              <td style="width: 25%; height: 75%;">&nbsp;&nbsp;장소 </td>
              <td>{{ board.place }}</td>
            </tr>
            <tr>
              <td style="width: 25%; height: 75%">&nbsp;&nbsp;작성자</td>
              <td>{{ board.writer }}</td>
            </tr>
          </table>
        </v-card>
      </v-col>
    </v-row>

    <v-row id="pageNum" justify="center">
      <v-btn :disabled="pageNum === 0" @click="prevPage">이전</v-btn>
      <span id="page">&nbsp;&nbsp;{{pageNum +1 }}  /  {{pageCount}}&nbsp;&nbsp;</span>
      <v-btn :disabled="pageNum >= pageCount -1" @click="nextPage">다음</v-btn>
    </v-row>

    <v-dialog max-width="800" v-model="create">
      <v-card>
        <v-card-title>
          <span style="font-size: 40px; color: darkolivegreen"><br/>글 생성</span>
        </v-card-title>

        <v-card-text>
          <v-container>
            <form>
              <table style="width: 100%;" class="createBoard">
                <tr class="createBoard" style="height: 50px">
                  <td class="createBoard">제목&nbsp;&nbsp;</td>
                  <td class="createBoard"><input type="text" value="제목" v-model="title"></td>
                </tr>

                <tr class="createBoard" style="height: 50px">
                  <td class="createBoard">장소&nbsp;&nbsp;</td>
                  <td class="createBoard"><input type="text" value="장소" v-model="place"></td>
                </tr>

                <tr class="createBoard" style="height: 50px">
                  <td class="createBoard">작성자&nbsp;&nbsp;</td>
                  <td class="createBoard">{{writer}}</td>
                </tr>

                <tr class="createBoard" style="height: 50px">
                  <td class="createBoard">작성내용</td>
                  <td class="createBoard"><textarea style="width: 100%; height: 350px; margin-top: 5px" v-model="boardContent">이러쿵 저러쿵!</textarea></td>
                </tr>
              </table>
            </form>

            <div style="margin-top: 10px">
              <label>
                <input style="font-size: 30px" type="file" id="files" ref="files" multiple v-on:change="fileUpload()">
              </label>
            </div>

          </v-container>
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="orange lighten-3" @click="closeDialog">Close</v-btn>
          <v-btn @click="onSubmit" type="submit" color="orange lighten-3" >Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>


</template>

<script>
import axios from "axios";

export default {
  name: "BoardListForm",
  data(){
    return{
      create: false,
      files: '',
      response: '',
      title: '',
      place: '',
      writer: localStorage.getItem('session'),
      boardContent: '',
      pageNum: 0,
    }
  },
  props:{
    boardList: {
      type: Array
    },
    pageSize: {
      type: Number,
      required: false,
      default: 8
    }
  },
  methods:{
    createBoard(){
      this.create = true;
    },
    fileUpload(){
      this.files = this.$refs.files.files
    },
    showDetail(board){
      //console.log(boardNo);
      if(localStorage.getItem('session') === board.writer){
        //alert(board.writer)
        //alert(localStorage.getItem('session'))
        this.isMember = true;
      }

      this.$router.push({name: 'BoardReadView', params: {boardNo: board.boardNo.toString(), isMember: this.isMember}})
   },
    closeDialog() {
      this.create = false;
      this.title = '';
      this.boardContent = '';
      this.files = '';
    },
    onSubmit() {
      let formData = new FormData;

      if (this.files.length === 0) {
        alert("사직을 하나 이상 입력해주세요!!!")
      } else {
        for (let i = 0; i < this.files.length; i++) {
          console.log(this.files[i])
          formData.append('fileList', this.files[i])
        }

        formData.append('title', this.title)
        formData.append('place', this.place)
        formData.append('writer', this.writer)
        formData.append('boardContent', this.boardContent)

        axios.post('http://localhost:7777/board/register', formData, {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        })
            .then((res) => {
              this.response = res.data
            })
            .catch((res) => {
              this.response = res.message
            })

        alert('처리 완료')

        this.create = false;
        this.title = '';
        this.boardContent = '';
        this.files = '';
      }
    },
    nextPage () {
      this.pageNum += 1;
    },
    prevPage () {
      this.pageNum -= 1;
    }
  },
  computed: {
    pageCount(){
      let listLeng = this.boardList.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);

      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize,
          end = start + this.pageSize;
      return this.boardList.slice(start, end);
    }
  }
}
</script>

<style scoped>
#img{
  width: 410px;
  height: 250px;
  display: block;
  margin-bottom: 15px;
}
.createBoard{
  font-size: 35px;
  border : 1px solid black;
  border-collapse : collapse;
}
td{
  font-size: 25px;
}
#wrapper{
  height: 850px;
  min-height: 100%;
  padding-bottom: 30px;
}
#pageNum{
  height: 30px;
  position : relative;
  transform : translateY(-100%);
}
#page{
  font-size: 20px;
}
</style>