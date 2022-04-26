<template>
    <div>
         <table>
             <div class="box">

            <tr>
              
                <td>
                    <input type="text" class="form-control" :value="jpaBoard3.boardNo" readonly/>
                </td>
            </tr>
            <tr>
               
                <td>
                    <input type="text" class="form-control" :value="jpaBoard3.title" readonly/>
                </td>
            </tr>
            <tr>
              
                <td>
                      <input type="text" class="form-control" :value="jpaBoard3.writer" readonly/>
                </td>
            </tr>

               <tr>
           
                <td>
                       <input type="text" class="form-control" :value="jpaBoard3.writer1" readonly/>
                </td>
            </tr>
            <tr>
             
                <td>
                    <input type="text" class="form-control" :value="jpaBoard3.regDate" readonly/>
                </td>
            </tr>
            <tr>
               
                <td>
                    <textarea cols="100" rows="30"  class="form-control" :value="jpaBoard3.content" readonly>
                    </textarea>
                </td>
            </tr>
             </div>
        </table>
    </div>
    
</template>

<script>
export default {
    name: 'JpaBoardRead3',
    props: {
        jpaBoard3: {
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