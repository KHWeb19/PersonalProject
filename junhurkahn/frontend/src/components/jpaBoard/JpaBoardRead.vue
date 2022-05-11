<template>
    <div>
       <table>
             <div class="box">
            <tr>
                
                <td>
                      <input type="text" class="form-control" :value="jpaBoard.boardNo" readonly/>
                </td>

            </tr>
            <tr>
               
                <td>
                      <input type="text" class="form-control" :value="jpaBoard.title" readonly/>
                </td>
            </tr>
            <tr>
               
                <td>
                      <input type="text"  :value="jpaBoard.writer" class="form-control" readonly/>
                </td>
            </tr>

          

            <tr>
             
                <td>
                     <input type="text" class="form-control" :value="jpaBoard.regDate" readonly/>
                </td>
            </tr>

            <tr>
                <td>
                 
              
          <v-img  class="form-control" :value="jpaBoard.files" > </v-img>
    
                  
                 </td>
            </tr>
               

             <tr>  
                <td>
                       <textarea cols="100" rows="30"  class="form-control" :value="jpaBoard.content" readonly>
                    </textarea>
                </td>
                
            </tr>
            
            


            
            
             </div>
             
        </table>
    </div>

    
    
</template>

<script>

export default {
    name: 'JpaBoardRead',
    props: {
        jpaBoard: {
            type: Object,
            required: true
        }
    },
    
  
    
}

</script>

<style scoped>
 .box{
          background:white;
          
          border: #356859 4px solid;
        }

</style>