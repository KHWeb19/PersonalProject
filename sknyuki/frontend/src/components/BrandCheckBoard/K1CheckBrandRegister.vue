<template>
    <form @submit.prevent="onSubmit">

        <div class="app">
            <h3 style="padding:30px 0px 30px 0px; font-weight:bold" align="center">게시글 작성</h3>
            

            <h3 align="left">제목 : </h3>
             <v-text-field
              label="TITLE"
              placeholder="입력하시오"
              outlined 
              dense
              style="width:300px; font-size:20px;"
              v-model="title"
            ></v-text-field>
            


            <h3 align="left">작성자 : </h3>
              <v-text-field
              label="WRITER"
              placeholder="입력하시오"
              outlined 
              dense
              style="width:300px; font-size:20px;"
              v-model="writer"
            ></v-text-field>
                


           <h3 align="left"> 업로드할 이미지 : </h3>
             <input class="input" type="file"
             ref="files"
             multiple
              @change="onInputImage()"/>
           
           

            <h3 align="left" >내용 : </h3>           
           
            <v-textarea
            counter
            outlined
            dense
            label="CONTENT"
            style="font-size:20px"
            placeholder="내용을 입력하시오"
             rows="8" cols="100" v-model="content"
          ></v-textarea>
     


            <div class="버튼">
                <v-btn text color="black" rounded x-large
                    style="padding: 10px; width: 90px;" type="submit" >등록하기
                </v-btn>

                <br>

                <router-link style="text-decoration: none; color:black" :to="{ name: 'K1CheckBrandView' }">
                    <v-btn text color="black" rounded x-large
                        style="padding: 10px; width: 90px;" type="submit">목록으로
                    </v-btn>
                </router-link>
            </div>
        </div>
        
        
    </form>
</template>

<script>

//import UploadFile1 from '@/components/uploadfile1.vue'

export default {
    name: 'BoardRegisterForm',
    components:{
      //  UploadFile1
    },
    data () {
        return {
            title: '',
            writer: '',
            content: '',
            files:'',
        }
    },
    methods: {
    onInputImage(){
        this.files=this.$refs.files.files
        console.log(this.files)
         let formData = new FormData()

            for (let idx = 0; idx < this.files.length; idx++) {
                formData.append('fileList', this.files[idx])
                  
            }console.log(formData)
    },
            onSubmit () {
            var result = confirm('등록 하시겠습니까?')
            if(result) {
                const { title, writer, content, formData } = this
                this.$emit('submit', { title, writer, content, formData })
                console.log(this.title,this.writer,this.content,formData)
            }
         }
    }
}
</script> 

<style scoped>
.app {
  padding:0px 200px 100px 200px;
}
</style>