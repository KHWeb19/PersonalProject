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
                       <input type="text"  v-model="writer" class="form-control" >
                </td>
            </tr>

             <tr>
               
                <td>
                   <input type="text"  v-model="writer1" class="form-control" >
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
            <router-link :to="{ name: 'JpaBoardListPage1' }">
                취소
            </router-link>
        </div>
        
    </form>
</template>

<script>
export default {
    name: 'JpaBoardRegisterForm1',
    data () {
        return {
            title: '은행이름을 작성하세요.',
            writer: '계좌 번호작성하시오',
            writer1: '소유자 이름을 작성하시오',
            content: '본문을 작성하세요.'
        }
    },
    methods: {
        onSubmit () {
            const { title, writer, content, writer1 } = this
            this.$emit('submit', { title, writer, content, writer1 })
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