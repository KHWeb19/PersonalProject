<template>
<v-container>
     <p>proto type</p>
    <v-row align="center" justify="center">
        <!--name:homeview변경예정-->
    <router-link style="text-decoration: none;" :to="{name:'K2ProductView'}">
    <v-btn class="blue lighten-5">모든 판매 상품 보러가기</v-btn>
    </router-link></v-row>
    <br>
     <v-divider></v-divider>
   <br>
    <!--
     <v-divider></v-divider>
     <div id="brandlist" align="center">
     <v-layout wrap>
         <v-flex>
              <tr height="100" >
            
                <td align="center" width="200">HEMES</td>
                <td align="center" width="200">VITTON</td>
                <td align="center" width="200">CHANEL</td>
                <td align="center" width="200">GUCCI</td>
                <td align="center" width="200">FENDI</td>
                <td align="center" width="200">PRADA</td>
                <td align="center" width="200">Dior</td>
         </tr>-->
         <!--위에 아이콘 때려 박기-->
      <!--   <tr height="100">
                <td>VANCLEE</td>
                <td>Tiffany</td>
                <td>Cartier</td>
                <td>Bottega</td>
                <td>YSL</td>
                <td>Supreme</td>
               <td>BURBERRY</td>
         </tr>   
        
           <tr height="100">
                <td>THOM BROWNE</td>
                <td>BALENCIAGA</td>
                <td>ROLEX</td>
                <td>IWC</td>
                <td>PIAGET</td>
                <td>OMEGAL</td>
                <td>TAG HEUER</td>
           </tr>  

        
           </v-flex>    boardNo이 아닌 String으로 해서 DB로 부터 끌고 오면 될 것
        </v-layout>
     </div>-->

     <div align="center"  class="flex-container">
          <table >
               
          <td align="center"  width="200" class="hover flex" >
                <tr align="center" height="100">HERMES</tr>
                <tr align="center" height="100">VITTON</tr>
                <tr align="center" height="100">CHANEL</tr>

         </td>
               
         <td align="center" width="200" class="hover flex">
                <tr align="center" height="100">GUCCI</tr>
                <tr align="center" height="100">FENDI</tr>
                <tr align="center" height="100">PRADA</tr>
               
            
         </td>
         
         <td align="center" width="200" class="hover flex">
                <tr align="center" height="100">Dior</tr>
                <tr align="center" height="100">VANCLEE</tr>
                <tr align="center" height="100">Tiffany</tr>

         </td>
         
         <td align="center" width="200" class="hover flex">
                <tr align="center" height="100">Cartier</tr>
                <tr align="center" height="100">Bottega</tr>
                <tr align="center" height="100">YSL</tr>
         </td>   
        
           <td align="center" width="200" class="hover flex">
                <tr align="center" height="100">Supreme</tr>
                <tr align="center" height="100">BURBERRY</tr>
                <tr align="center" height="100">THOM BROWNE</tr>
           </td>

           <td align="center" width="200" class="zoom6">
                <tr align="center" height="100">BALENCIAGA</tr>
                <tr align="center" height="100">ROLEX</tr>
                <tr align="center" height="100">IWC</tr>
           </td>

           <td align="center" width="200" class="zoom7">
                <tr align="center" height="100">PIAGET</tr>
                <tr align="center" height="100">OMEGAL</tr>
                <tr align="center" height="100">TAG HEUER</tr>
           </td>  
          </table>
     </div>
 

    
  
    </v-container>
</template>
<script>
export default {
    name:'HomeSellList',
    data(){
        return{}
       
        }
    }
</script>
<style scoped>
.branlist{
text-align: center;
}

</style>