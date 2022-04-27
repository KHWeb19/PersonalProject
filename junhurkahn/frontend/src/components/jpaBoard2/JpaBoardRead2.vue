<template>
    <div>
          <table>
             <div class="box">

            <tr>
               
                <td>
                     <input type="text" class="form-control" :value="jpaBoard2.boardNo" readonly/>
                </td>
            </tr>
            <tr>
               
                <td>
                    <input type="text"   :value="jpaBoard2.content" class="form-control">
                </td>
            </tr>
            <tr>
               
                <td>
                        <input type="text" class="form-control" :value="jpaBoard2.regDate" readonly/>
                </td>
            </tr>
            <tr>
             
                <td>
                       <textarea cols="100" rows="30"  class="form-control" :value="jpaBoard2.title" >
                    </textarea>
                   
                </td>
            </tr>
             </div>
        </table>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardRead2',
    props: {
        jpaBoard2: {
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