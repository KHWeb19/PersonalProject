<template>
    <div>
           <table>
             <div class="box">
                 
            <tr>
                
                <td>
                     <input type="text" class="form-control" :value="jpaBoard1.boardNo" readonly/>
                </td>
            </tr>
            <tr>
               
                <td>
                    <input type="text" class="form-control" :value="jpaBoard1.title" readonly/>
                </td>
            </tr>


                <tr>
                
                <td>
                    <input type="text"  :value="jpaBoard1.writer1" class="form-control" readonly/>
                </td>
            </tr>
            
            <tr>
                
                <td>
                    <input type="text"  :value="jpaBoard1.writer" class="form-control" readonly/>
                </td>
            </tr>
            <tr>
                
                <td>
                     <input type="text" class="form-control" :value="jpaBoard1.regDate" readonly/>
                </td>
            </tr>

              <tr>
                
                <td>
                     <input type="text" class="form-control" :value="jpaBoard1.files" readonly/>
                </td>
            </tr>

            <tr>
               
                <td>
                     <textarea cols="100" rows="30"  class="form-control" :value="jpaBoard1.content" readonly>
                    </textarea>
                </td>
                
            </tr>
             </div>
        </table>
    </div>
    
</template>

<script>
export default {
    name: 'JpaBoardRead1',
    props: {
        jpaBoard1: {
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