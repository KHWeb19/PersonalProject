<template>
<form @submit.prevent="onSubmit">
     <div class="app">
        <h3 style="padding:30px 0px 30px 0px; font-weight:bold" align="left">게시글 수정</h3>

                

                
             
                 <h3 align="left">제목 : </h3>
                <v-text-field
                dense
                label="TITLE"
                style="width:600px; font-size:20px;"
                placeholder="수정할 내용을 입력하시오"
                outlined 
                 v-model="title" />
                
                 <br>


                 <h3 align="left">등록일자 : </h3>
                <v-text-field
                label="UpLoadDate"
                dense
                 style="width:300px; font-size:20px;"
                outlined type="text" :value="QuestionBoard.regDate" readonly/>
                
                
            
                <br>

                <h3 align="left">작성자 : </h3>
                <v-text-field 
                label="WRITER"
                dense 
                style="width:300px; font-size:20px;"
                outlined type="text" :value="QuestionBoard.writer" readonly/>
               

               <!-- <h3 align="left">제목 : </h3>
                <v-text-field
                label="TITLE"
                outlined 
                dense
                style="width:600px; font-size:20px;"
                v-model="title" />
                
                 <br>


                 <h3 align="left">등록일자 : </h3>
                <v-text-field
                dense
                label="UpLoadDate"
                outlined 
                style="width:300px; font-size:20px;"
                type="text"/>
                
                
            
                <br>

                <h3 align="left">작성자 : </h3>
                <v-text-field 
                label="WRITER"
                dense 
                style="width:300px; font-size:20px;"
                outlined type="text"/>-->
                <upload-file-1 @selectFile="selectFile"></upload-file-1>

                <h3 align="left">내용 : </h3>
                <v-textarea
                    counter
                    outlined
                    label="CONTENT"
                    id="textarea-rows"
                    style="font-size:20px"
                    placeholder="수정할 내용을 입력하시오"
                    rows="8" 
                    cols="100"
                    v-model="content">
                </v-textarea>

               

               <!-- <h3 align="left">내용 : </h3>
                <v-textarea
                    counter
                    outlined
                    label="CONTENT"
                    id="textarea-rows"
                    placeholder="수정할 내용을 입력하시오"
                    rows="8" 
                    cols="100"
                    v-model="content">
                </v-textarea>-->
    
     <div class="버튼">
                <v-btn text color="black" rounded x-large
                    style="padding: 10px; width: 90px;" type="submit" >등록하기
                </v-btn>

                <br>

                <router-link style="text-decoration: none; color:black" :to="{ name: 'K1QuestionReadPage', params: { boardNo: QuestionBoard.boardNo.toString() }}">
                    <v-btn text color="black" rounded x-large
                        style="padding: 10px; width: 90px;">수정 취소
                    </v-btn>
                </router-link>
            </div>
    
    </div>
</form>
</template>
<script>
import UploadFile1 from '@/components/uploadfile1.vue'
export default {
    name:'QuestionBoardModify',
      components:{
        UploadFile1
    },
     props: {
        QuestionBoard: {
            type: Object,
            required: true
        }
        },
    data () {
        return {
            title: '',
            content: '',
            files:[],
        }
},
methods: {
        selectFile(files){
            this.files=files
        },
        
            onSubmit () {
            var result = confirm('수정 내용을 등록 하시겠습니까?')
            if(result) {
                const { title, content} = this
                this.$emit('submitContents', { title, content})
                //console.log(this.title,this.content)

                this.$emit("submitFiles",this.files)
                //console.log(this.files)
                }
            },
               created () {
        //this.id = this.QuestionBoard.id
        this.boardNo =this.QuestionBoard.boardNo
        this.title = this.QuestionBoard.title
        this.content = this.QuestionBoard.content
    }
         }
     }
</script>
<style scoped>
.app {
  padding:0px 200px 0px 200px;
}
</style>