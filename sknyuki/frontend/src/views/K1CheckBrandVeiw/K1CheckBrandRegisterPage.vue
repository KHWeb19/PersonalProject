<template>
    <v-container>
        <header-view></header-view>
        <br>
        <drop-down></drop-down>
           <div align="center">
        <k-1-check-brand-register @submitContents="contentsSubmit"
         @submitFiles="filesSubmit"/>
    </div>

        </v-container>
</template>
<script>
import K1CheckBrandRegister from '@/components/BrandCheckBoard/K1CheckBrandRegister.vue'
import HeaderView from '@/components/home/headerView.vue'
import DropDown from '@/components/KategoriePage1/DropDown.vue'
import axios from 'axios'
export default {
    name:'K1CheckBrandRegisterPage',
    components:{ 
    HeaderView,
    DropDown,
    K1CheckBrandRegister
    },
data () {
    return {
      boardNo:null,
      files:[],
    }
},
     methods: {
        contentsSubmit (payload) {
            const { title, content, writer} = payload
            console.log('contents의 값이 넘어왔습니다.'+content)
            //spring 작업시 경우에 따라서 회원정보의 id값도 넘겨줘야함
            axios.post('http://localhost:7777/CheckBrandBoard/register', { title, writer, content })
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

                    axios.post('http://localhost:7777/fileUpload/CheckBrandBoard',formData,{
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