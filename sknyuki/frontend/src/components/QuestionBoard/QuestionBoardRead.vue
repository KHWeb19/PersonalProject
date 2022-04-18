<template>
   <div class="app">
        <h3 style="padding:30px 0px 30px 0px; font-weight:bold" align="left">질문 게시판 ReadPage</h3>

        
                 <h3 align="left">제목 : </h3>
                <v-text-field
                dense
                style="width:600px; font-size:20px;"
                outlined type="text" :value="QuestionBoard.title" readonly />
                
                 <br>


                 <h3 align="left">등록일자 : </h3>
                <v-text-field
                dense
                 style="width:300px; font-size:20px;"
                outlined type="text" :value="QuestionBoard.regDate" readonly/>
                
                
            
                <br>

                <h3 align="left">작성자 : </h3>
                <v-text-field 
                dense 
                style="width:300px; font-size:20px;"
                outlined type="text" :value="QuestionBoard.writer" readonly/>
          

                
               
                 <br>
                 <v-card class="mx-auto mt-2 mb-10" width="400" flat>
                     <v-img :src="showFile()" ></v-img>
                 </v-card>
                 <br>

              <h3 align="left">내용 : </h3>
                <v-textarea
                    outlined
                    id="textarea-rows"
                    placeholder=""
                    rows="8" :value="QuestionBoard.content" readonly>
                </v-textarea>


    
    </div>
</template>
<script>
export default {
    name:'QuestionBoardRead',
    props: {
        QuestionBoard: {
            type: Object,
        
        },
        boardNo: String,
    },
    methods:{
        showFile () {
      try {
        return require(`../../../../backend/demo/images/Question/${this.boardNo}.jpg`)
     } catch (e) {
        return   alert('문제 발생!')
     }
        }
    }
}
</script>
<style scoped>
.app {
  padding:0px 200px 0px 200px;
}
</style>