<template>
    <div>
          <table >
             <div class="box">

            <tr>
              
                <td>
                  <input type="text" class="form-control" :value="jpaBoard4.boardNo" readonly/>
                </td>
            </tr>
            <tr>
               
                <td>
                    <input type="text" class="form-control" :value="jpaBoard4.title" readonly/>
                </td>
            </tr>

               <tr>
              
                <td>
                  <input type="text" class="form-control" :value="jpaBoard4.writer1" readonly/>
                </td>
            </tr>


            <tr>
              
                <td>
                     <input type="text" class="form-control" :value="jpaBoard4.writer" readonly/>
                </td>
            </tr>
            
            <tr>
                <td>
                      <v-img  class="form-control" :value="jpaBoard.files" > </v-img>
                </td>
            <tr>
              
                <td>
                    <input type="text" class="form-control" :value="jpaBoard4.regDate" readonly/>
                </td>
            </tr>
            <tr>
            
                <td>
                     <textarea cols="100" rows="30"  class="form-control" :value="jpaBoard4.content" readonly>
                    </textarea>
                </td>
            </tr>
             </div>
        </table>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardRead4',
    props: {
        jpaBoard4: {
            type: Object,
            required: true
        }
    }
}
</script>

<style scoped>

 .box{
          background:white;
          
          border: #356859 4px solid;
        }

</style>