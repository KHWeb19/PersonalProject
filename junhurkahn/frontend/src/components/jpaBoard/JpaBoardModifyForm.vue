<template>
    <div>

        <form @submit.prevent="onSubmit">

             <table>
           <div class="box">

                <tr>
                    
                    <td>
                         <input type="text" class="form-control" :value="jpaBoard.boardNo" disabled/>
                    </td>
                </tr>
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
                         <input type="text" class="form-control" :value="jpaBoard.regDate" readonly/>
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
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'JpaBoardReadPage',
                                    params: { boardNo: jpaBoard.boardNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
        
    </div>
    
    
</template>

<script>

export default {
    name: 'JpaBoardModifyForm',
    props: {
        jpaBoard: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            writer: '',
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { title, writer, content } = this
            this.$emit('submit', { title, content,writer })
        }
    },
    created () {
        this.title = this.jpaBoard.title
        this.writer = this.jpaBoard.writer
        
        this.content = this.jpaBoard.content

    }
}
</script>

<style scoped>
 .box{
          background:white;
          
          border: #356859 4px solid;
        }

</style>