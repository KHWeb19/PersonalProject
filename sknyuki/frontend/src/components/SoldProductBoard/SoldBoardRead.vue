<template>

    <div class="app">
            <h3 style="padding:30px 0px 30px 0px; font-weight:bold" align="center">게시물 확인</h3>
  <v-sheet class="mt-5 mb-10">
    <v-row>
      <v-col cols="12" md="8">
          <v-card class="mx-10" flat>
      <v-img position="relative" class="ml-10" :src="showFile()" width="100%">
      <v-img :src="showsoldout()" width="100%" 
      style=" top: 20%;
              position: absolute" />
      </v-img>
             </v-card>
      </v-col>
      <v-col cols="12" md="4">
      
        <v-card align="center" class="mt-5 pa-2">
          <h3>상세 목록</h3>
           <table class="table">
             <tr>
                <td><h4>구매자:</h4></td>
                <td>
                     <input type="text" :value="ProductBoardB.id" readonly/>
                </td>
            </tr>
            <tr>
                <td><h4>브랜드:</h4></td>
                <td>
                     <input type="text" :value="ProductBoardB.type" readonly/>
                </td>
            </tr>
             <tr>
                <td><h4>등급:</h4></td>
                <td>
                     <input type="text" :value="ProductBoardB.brandrank" readonly/>
                </td>
            </tr>
            <tr>
                <td><h4>제품명:</h4></td>
                <td>
                    <input type="text" :value="ProductBoardB.name" readonly/>
                </td>
            </tr>
            <tr>
                <td><h4>사이즈:</h4></td>
                <td>
                     <input type="text" :value="ProductBoardB.size" readonly/>
                </td>
            </tr>
            <tr>
                <td><h4>가격:</h4></td>
                <td>
                     <input type="text" :value="ProductBoardB.price" readonly/>
                </td>
            </tr>
            <tr>
                <td><h4>부속품:</h4></td>
                <td>
                     <input type="text" :value="ProductBoardB.accessories" readonly/>
                </td>
            </tr>
           
             <tr>
                <td><h4>세부상태:</h4></td>
                <td>
                    <textarea cols="50" rows="10" :value="ProductBoardB.status" readonly>
                    </textarea>
                </td>
            </tr>


        </table>  
        </v-card>
        <rank-description/>
      </v-col>
    </v-row>
  </v-sheet>
    </div>
      
</template>
<script>
import RankDescription from '@/components/RankDescription.vue'

export default {
    name:'SoldBoardRead',
         props: {
        ProductBoardB: {
            type: Object,
        },
        boardNo: String,  
},
    components:{
     RankDescription, 
    },

      methods:{
        showFile () {
      try {
          return require(`../../../../backend/demo/images/ProductBoardS/${this.boardNo}.jpg`)
     } catch (e) {
          console.log(e)
          console.log(this.boardNo)
    }  
},
showsoldout(){
  return require('../../assets/SOLD OUT/sold out.png')
}
    }
    
}
</script>
<style scoped>
.table{
border-collapse: separate;
border-spacing: 0 10px;
}
</style>