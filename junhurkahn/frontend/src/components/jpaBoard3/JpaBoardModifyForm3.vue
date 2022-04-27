<template>
    <div>
        <form @submit.prevent="onSubmit">
             <table>
           <div class="box">
                <tr>
                   
                    <td>
                         <input type="text" class="form-control" :value="jpaBoard3.boardNo" disabled/>
                    </td>
                </tr>
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
                        <input type="text" class="form-control" :value="jpaBoard3.regDate" disabled/>
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
                <router-link :to="{ name: 'JpaBoardReadPage3',
                                    params: { boardNo: jpaBoard3.boardNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardModifyForm3',
    props: {
        jpaBoard3: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            writer:'',
            writer1:'',
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { title, content, writer, writer1 } = this
            this.$emit('submit', { title, content, writer, writer1 })
        }
    },
    created () {
        this.title = this.jpaBoard3.title
        this.content = this.jpaBoard3.content
        this.writer = this.jpaBoard3.writer
        this.writer1 = this.jpaBoard3.writer1

    }
}
</script>

<style scoped>

 .box{
          background:white;
          
         border: #356859 4px solid;
        }

</style>