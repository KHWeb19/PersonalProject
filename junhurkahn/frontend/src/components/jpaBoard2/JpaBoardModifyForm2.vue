<template>
    <div>
        <form @submit.prevent="onSubmit">
             <table >
           <div class="box">

                <tr>
                  
                    <td>
                         <input type="text" class="form-control" :value="jpaBoard2.boardNo" disabled/>
                    </td>
                </tr>
                <tr>
                    
                    <td>
                        <input type="text"  v-model="content" class="form-control">
                    </td>
                </tr>
                <tr>
                   
                    <td>
                        <input type="text" class="form-control" :value="jpaBoard2.regDate" readonly/>
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
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'JpaBoardReadPage2',
                                    params: { boardNo: jpaBoard2.boardNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardModifyForm2',
    props: {
        jpaBoard2: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
          
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { title, content } = this
            this.$emit('submit', { title, content })
        }
    },
    created () {
        this.title = this.jpaBoard2.title
        this.content = this.jpaBoard2.content
        
    }
}
</script>

<style scoped>

 .box{
          background:white;
          
          border: #356859 4px solid;
 }
</style>