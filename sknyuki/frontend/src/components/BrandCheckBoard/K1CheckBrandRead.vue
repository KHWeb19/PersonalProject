<template>
     <div class="app">
        <h3 style="padding:30px 0px 30px 0px; font-weight:bold" align="left">판별 게시판 ReadPage</h3>

                

                
               
                 <h3 align="left">제목 : </h3>
                <v-text-field
                dense
                style="width:600px; font-size:20px;"
                outlined type="text" :value="BrandCheckBoard.title" readonly />
                
                 <br>


                 <h3 align="left">등록일자 : </h3>
                <v-text-field
                dense
                 style="width:300px; font-size:20px;"
                outlined type="text" :value="BrandCheckBoard.regDate" readonly/>
                
                
            
                <br>

                <h3 align="left">작성자 : </h3>
                <v-text-field 
                dense 
                style="width:300px; font-size:20px;"
                outlined type="text" :value="BrandCheckBoard.writer" readonly/>
               

              <!--  <h3 align="left">제목 : </h3>
                <v-text-field
                dense
                style="width:600px; font-size:20px;"
                outlined type="text"  value="title test" />
                
                 <br>


                 <h3 align="left">등록일자 : </h3>
                <v-text-field
                dense
                 style="width:300px; font-size:20px;"
                outlined type="text"/>
                
                
            
                <br>

                <h3 align="left">작성자 : </h3>
                <v-text-field 
                dense 
                style="width:300px; font-size:20px;"
                outlined type="text"/>-->
               



                <br>
                 <v-card class="mx-auto mt-2 mb-10" width="400" flat>
                     <v-img :src="showFile()" ></v-img>
                 </v-card>
                <br>

               <h3 align="left">내용 : </h3>

                 <v-text-field
                dense
                style="width:600px; font-size:20px;"
                outlined type="text" :value="BrandCheckBoard.type" readonly />

                <v-textarea
                    outlined
                    id="textarea-rows"
                    placeholder=""
                    rows="8" :value="BrandCheckBoard.content" readonly>
                </v-textarea>

                <!--<h3 align="left">내용 : </h3>
                <v-textarea
                    outlined
                    id="textarea-rows"
                    placeholder=""
                    rows="8" >
                </v-textarea>-->
    </div>
</template>
<script>
export default {
    name:'K1CheckBrandRead',
    props: {
        BrandCheckBoard: {
            type: Object,
        },
        boardNo: String,  
},

    methods:{
        showFile () {
      try {
          return require(`../../../../backend/demo/images/BrandCheck/${this.boardNo}_${this.BrandCheckBoard.id}.jpg`)
     } catch (e) {
          console.log(e)
          console.log(this.boardNo)
        return   alert('문제 발생!')
        
    }    
},
    }
}
</script>
<style scoped>
.app {
  padding:0px 200px 0px 200px;
}
</style>