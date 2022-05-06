<template>
<div>
    <v-container>
        <header-view></header-view>
        <br>
           <div align="center">
      
      <question-board-modify v-if="QuestionBoard" :QuestionBoard="QuestionBoard" 
@submitContents="modifyContentsSubmit" 
@submitFiles="modifyFilesSubmit"/>
<p v-else>로딩중 .....</p>
           </div>
        </v-container>
        <footer-view/>
</div>
</template>
<script>
import HeaderView from '@/components/home/headerView.vue'
import QuestionBoardModify from '@/components/QuestionBoard/QuestionBoardModify.vue'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import FooterView from '@/components/home/footerView.vue'


export default {
    name:'K1QuestionModifyPage',
    components:{ 
    HeaderView,
    QuestionBoardModify,
        FooterView,
    },
    props:{
         boardNo: {
            type: String,
            required: true
         }
        },
        data () {
    return {
      files:[],
        }
    },
         computed: {
      ...mapState(['QuestionBoard','userInfo'])
    },
          created () {
            console.log(this.boardNo)
        this.fetchQuestionBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                    
                })
    },
   

    methods:{
        ...mapActions(['fetchQuestionBoard']),
        modifyContentsSubmit (payload) {
            const { type, title, content } = payload

            axios.put(`http://localhost:7777/QuestionBoard/${this.boardNo}`,
                { title, type, writer: this.QuestionBoard.writer, id: this.BrandCheckBoard.id,content, regDate: this.BrandCheckBoard.regDate })
                    .then(() => {
                        alert('게시물 수정 성공!')
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        },
   
 
         modifyFilesSubmit(files){
           this.files=files
             console.log('수정한 사진이 넘어왔습니다'+files)
     setTimeout(()=>{
                    const formData=new FormData()
                    for (let i=0; i<this.files.length; i++){
                        formData.append('fileList',this.files[i])
                    }

                    formData.append('boardNo',this.boardNo)
                    formData.append('id', this.userInfo.id)
                    //formData.append('id', this.id)
                    console.log(this.boardNo)
                    

                    axios.post('http://localhost:7777/fileUpload/QuestionBoard',formData,{
                        headers:{ 'Content-Type': 'multipart/form-data'}
                        })
                        .then(res=>{
                             console.log("등록 성공"+res.data)
                              alert('수정이 완료되었습니다!')
                               alert('등록 성공! - ' + res)
                                 this.$router.push({
                            name: 'K1QuestionView',
                           
                        })
                        }).catch(err=>{
                             console.log(err)
                             
                        })
                },1000)
         },
    },
      
    }
</script>