<template>
    <form @submit.prevent="onSubmit">
        <h2 id="theme">게시물 작성</h2>
        <table align="center" border="1">
            <tr> 
                <td>
                    <input type="text" v-model="title" cols="70" placeholder="제목을 입력하세요"/>
                </td>
            </tr>
            <tr>
                <td>
                   <strong> {{ this.writer }} </strong> 
                </td>
            </tr>
            <tr> 
                <td> 
                    <p>본문</p>
                     <textarea cols="70" rows="15" v-model="content" placeholder="본문을 작성하세요">
                    </textarea>
                </td>
            </tr>
        </table>

        <div class="button">
            <v-btn type="submit" color="cyan lighten-3" dark>
                등록
            </v-btn>
            <v-btn text>
            <router-link :to="{ name: 'FreeBoardListPage' }" class="black--text">
                취소
            </router-link>
            </v-btn>
        </div>
    </form>
</template>

<script>

export default {
    name: 'FreeBoardRegisterForm',
    data () {
        return {
            title: '',
            writer: this.$store.state.userInfo.nickname,
            content: ''
        }
    },
    methods: {
        onSubmit () {
            if(this.title == '' && this.content == ''){
                alert('제목과 본문을 입력하세요')
            }else{
            const { title, writer, content } = this
            this.$emit('submit', { title, writer, content })
            }
        }
    }
}
</script>


<style scoped>
    #theme{
        padding:15px;
    }
    td {
        padding: 10px;
        border-bottom: 1px solid;
    }
    textarea {
        border: 1px solid;
    }
   input {
       outline: none;
       width: 100%;
   }
   .button {
       padding: 20px;
   }
    a{
        text-decoration: none;
        
    }
    a:hover{
        text-decoration: none; 
    }

</style>