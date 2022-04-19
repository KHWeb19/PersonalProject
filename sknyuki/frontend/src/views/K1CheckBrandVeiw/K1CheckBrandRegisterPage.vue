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
import { mapState } from 'vuex'
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
computed: {
    ...mapState([ 'userInfo' ])
},
     methods: {
        contentsSubmit (payload) {
            const id=this.userInfo.id
           const { title, writer, type, content} = payload
            console.log('contents의 값이 넘어왔습니다.'+content)
            console.log('id의 값은?'+id)
            console.log(typeof(title))
            axios.post('http://localhost:7777/BrandCheckBoard/register', { id, title, writer, type,content})
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        this.boardNo=res.data.boardNo
                        
//console.log(res)
                        
                    
                    })
                },
                filesSubmit(files){
                this.files=files
               // console.log('값이 넘어왔습니다'+files)
                setTimeout(()=>{
                    const formData=new FormData()
                    for (let i=0; i<this.files.length; i++){
                        formData.append('fileList',this.files[i])
                    }

                    formData.append('boardNo',this.boardNo)
                    console.log(this.boardNo)
                   formData.append('id', this.userInfo.id)
                   console.log(this.id)
                    

                    axios.post('http://localhost:7777/fileUpload/BrandCheckBoard',formData,{
                        headers:{ 'Content-Type': 'multipart/form-data'}
                        })
                        .then(res=>{
                             console.log(res.data)
                               alert('등록 성공! - ' + res)
                                 this.$router.push({
                            name: 'K1CheckBrandView'
                        })
                        }).catch(err=>{
                            alert('문제발생')
                             console.log(err)
                             
                        })
                },1000)
                 
                }
     }
}
        
</script>