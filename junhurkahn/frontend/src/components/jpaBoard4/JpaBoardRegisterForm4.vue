<template>
    <form @submit.prevent="onSubmit">
       <table >
           <div class="box">
    
              <tr>
              
                <td>
                     <input type="text"  v-model="title" class="form-control">
                </td>
            </tr>


              <tr>
               
                <td>
                    <input type="text"  v-model="writer1" class="form-control">
                </td>
            </tr>

            <tr>
               
                <td>
                    <input type="text"  v-model="writer" class="form-control">
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
            <router-link :to="{ name: 'JpaBoardListPage4' }">
                취소
            </router-link>
        </div>
    
    </form>
    
</template>

<script>
export default {
    name: 'JpaBoardRegisterForm4',
    data () {
        return {
            title: '사이트 이름를 작성하세요.',
            writer: '사이트 주소를 작성',
            writer1: '사이트 아이디를 작성',
            content: '본문을 작성하세요.'
        }
    },
    methods: {
        onSubmit () {
            const { title, writer, writer1, content } = this
            this.$emit('submit', { title, writer, content, writer1,  })
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