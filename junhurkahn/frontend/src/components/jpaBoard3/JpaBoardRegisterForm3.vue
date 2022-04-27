<template>
    <form @submit.prevent="onSubmit">
        <table>
           <div class="box">
            <tr>
               
                <td>
                   <input type="text"  v-model="title" class="form-control">
                </td>
            </tr>
            <tr>
                
                <td>
                   <input type="text"  v-model="writer" class="form-control">
                </td>
            </tr>

             <tr>
               
                <td>
                    <input type="text"  v-model="writer1" class="form-control">
                </td>
            </tr>




            <tr>
               
                <td>
                     <textarea cols="100" rows="30" v-model="content" class="form-control">
                    </textarea>
                </td>
            </tr>
           </div>
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'JpaBoardListPage3' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'JpaBoardRegisterForm3',
    data () {
        return {
            title: '이름을 작성하세요.',
            writer: '생년월일을 작성',
            writer1: 'D-day 작성하세요',
            content: '메모를 작성하세요.'
        }
    },
    methods: {
        onSubmit () {
            const { title, writer, writer1, content } = this
            this.$emit('submit', { title, writer, writer1, content })
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