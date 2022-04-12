<template>
    <v-container>
        <header-view></header-view>
        <br>
        <drop-down></drop-down>
           <div align="center">
        <question-board-regester @submitContents="contentsSubmit"
         @submitFiles="filesSubmit"/>
    </div>

        </v-container>
</template>
<script>
import QuestionBoardRegester from '@/components/QuestionBoard/QuestionBoardRegister.vue'
import HeaderView from '@/components/home/headerView.vue'
import DropDown from '@/components/KategoriePage1/DropDown.vue'
import axios from 'axios'
//import { mapState } from 'vuex'
export default {
    name:'K1QuestionRegisterPage',
    components:{ 
    HeaderView,
    DropDown,
    QuestionBoardRegester
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
            const { title, content, writer} = payload
            console.log('contents의 값이 넘어왔습니다.'+content)
            axios.post('http://localhost:7777/CheckBrandBoard/register', { id, title, writer, content })
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
                        }).catch(err=>{
                             console.log(err)
                        })
                },1000)
                }
     }
}
        
</script>