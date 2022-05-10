<template>
<div>
<v-container>
      <header-view></header-view>
      <product-board-register @submitContents="contentsSubmit"
         @submitFiles="filesSubmit"/>
   
</v-container>
<footer-view/>
</div>
</template>

<script>
import HeaderView from '@/components/home/headerView.vue'
import ProductBoardRegister from '@/components/ProductBoard/ProductBoardRegister.vue'
import axios from 'axios'
import { mapState } from 'vuex'
import FooterView from '@/components/home/footerView.vue'
export default {
    name:'K2ProductRegisterPage',
    components:{ 
    HeaderView,
    ProductBoardRegister,
        FooterView,
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
            const { type, name, size, price, brandrank, accessories, status ,soldCheck} = payload
            console.log('contents의 값이 넘어왔습니다.'+payload)
            axios.post('http://localhost:7777/ProductBoardS/register', { id, type, name, size, price, brandrank, accessories, status, soldCheck})
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
                   // formData.append('id', this.userInfo.id)
                    

                    axios.post('http://localhost:7777/fileUpload/ProductBoardS',formData,{
                        headers:{ 'Content-Type': 'multipart/form-data'}
                        })
                        .then(res=>{
                             console.log(res.data)
                             alert('등록 성공! - ' + res)
                                 this.$router.push({
                                     name:'K2ProductView'
                                 })
                        }).catch(err=>{
                             console.log(err)
                        })
                },1000)
                }
     }
}
        
</script>