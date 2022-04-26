<template>
    <form @submit.prevent="onSubmit">
        <table>
           <div class="box">
            <tr>
              
                <td>
                   <input type="text"  v-model="content" class="form-control" >
                </td>
            </tr>
            <tr>
               
                <td>
                    <textarea cols="100" rows="30" v-model="title" class="form-control">
                    </textarea>
                </td>
            </tr>
           </div>
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'JpaBoardListPage2' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'JpaBoardRegisterForm2',
    data () {
        return {
            title: '물건목록을 작성하세요.',
            content: '본문을 작성하세요.'
        }
    },
    methods: {
        onSubmit () {
            const { title, content } = this
            this.$emit('submit', { title,  content })
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