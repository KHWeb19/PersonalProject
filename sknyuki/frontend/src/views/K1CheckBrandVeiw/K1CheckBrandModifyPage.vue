<template>
    <v-container>
        <header-view></header-view>
        <br>
        <drop-down></drop-down>
           <div align="center">
        <k-1-check-brand-modify @submitContents="modifyContentsSubmit"
         @submitFiles="modifyFilesSubmit"/>
    </div>



 <!--back작업시 변경 지금은 도안을 보기위해 항상 열어둔 상태 
<k-1-check-brand-modify v--if="BrandCheckboard" :BrandCheckboard="BrandCheckboard"/>
<p v-else>로딩중 .....</p>-->



  
        </v-container>
</template>
<script>
import HeaderView from '@/components/home/headerView.vue'
import DropDown from '@/components/KategoriePage1/DropDown.vue'
import K1CheckBrandModify from '@/components/BrandCheckBoard/K1CheckBrandModify.vue'
import axios from 'axios'
//import { mapActions, mapState } from 'vuex'


export default {
    name:'K1CheckBrandModifyPage',
    components:{ 
    HeaderView,
    DropDown,
    K1CheckBrandModify,
    },
    props:{
         boardNo: {
            type: String,
            required: true
        },
        data () {
    return {
      boardNo:null,
      id: null,
        }
    },
  //       computed: {
   //     ...mapState(['BrandCheckboard'])
    },
     created () {
    this.boardNo = this.$route.query.boardNo
    this.id = this.$route.query.id
    console.log(this.id, this.boardN)},
    methods:{
   //      ...mapActions(['fetchBrandCheckboard']),

         modifyContentsSubmit(payload){
             const{title,content}=payload
             console.log('content의 값이 넘어왔습니다.'+title)
axios.patch(`http://localhost:7777/CheckBrand/modify/${this.boardNo}`, { title, content }).then(() => {
        
        this.fetchBrandCheckboard(this.boardNo)
      })
         },
         modifyFilesSubmit(files){
             console.log('수정한 사진이 넘어왔습니다'+files)
     setTimeout(()=>{
                    const formData=new FormData()
                    for (let i=0; i<this.files.length; i++){
                        formData.append('fileList',this.files[i])
                    }

                    formData.append('boardNo',this.boardNo)
                    formData.append('id', this.id)
                    

                    axios.post('http://localhost:7777/fileUpload/CheckBrandBoard',formData,{
                        headers:{ 'Content-Type': 'multipart/form-data'}
                        })
                        .then(res=>{
                             console.log("등록 성공"+res.data)
                              alert('수정이 완료되었습니다!')
                              // alert('등록 성공! - ' + res)
                                // this.$router.push({
                         //   name: 'K1CheckBrandVeiw',
                           // query: { boardNo: this.boardNo, id: this.id }
                        //})
                        }).catch(err=>{
                             console.log(err)
                             
                        })
                },1000)
         }
    }
}
</script>