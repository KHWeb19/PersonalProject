<template>
<div>
    <v-container>
        <header-view></header-view>
        <br>
        
           <div align="center">
        <question-board-regester @submitContents="contentsSubmit"
         @submitFiles="filesSubmit"/>
    </div>

        </v-container>
        <footer-view/>
</div>
</template>
<script>
import QuestionBoardRegester from '@/components/QuestionBoard/QuestionBoardRegister.vue'
import HeaderView from '@/components/home/headerView.vue'
import axios from 'axios'
import { mapState } from 'vuex'
import FooterView from '@/components/home/footerView.vue'
export default {
    name:'K1QuestionRegisterPage',
    components:{ 
    HeaderView,
    QuestionBoardRegester,
        FooterView
    },
data () {
    return {
      boardNo:null,
      files:[],
    }
},
computed: {
    ...mapState([ 'userInfo' ])
  },
     methods: {
        contentsSubmit (payload) {
            const id=this.userInfo.id
            const { title, content, type, writer} = payload
            console.log('contents의 값이 넘어왔습니다.'+content)
            axios.post('http://localhost:7777/QuestionBoard/register', { id, type, title, writer, content })
                    .then(res => {
                        // alert('등록 성공! - ' + res)
                        this.boardNo=res.data.boardNo
                        
                       // this.$router.push({
                         //   name: 'BoardListPage',
                           // params: { boardNo: res.data.boardNo.toString() }
                        //})
                    })
                },
                filesSubmit(files){
                this.files=files
                console.log('값이 넘어왔습니다'+files)
                setTimeout(()=>{
                    const formData=new FormData()
                    for (let i=0; i<this.files.length; i++){
                        formData.append('fileList',this.files[i])
                    }

                    formData.append('boardNo',this.boardNo)
                    formData.append('id', this.userInfo.id)
                    

                    axios.post('http://localhost:7777/fileUpload/QuestionBoard',formData,{
                        headers:{ 'Content-Type': 'multipart/form-data'}
                        })
                        .then(res=>{
                             console.log(res.data)
                             alert('등록 성공! - ' + res)
                                 this.$router.push({
                                     name:'K1QuestionView'
                                 })
                        }).catch(err=>{
                             console.log(err)
                        })
                },1000)
                }
     }
}
        
</script>