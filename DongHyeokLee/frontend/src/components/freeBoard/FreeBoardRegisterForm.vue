<template>
    <form @submit.prevent="onSubmit">
        <h2 id="theme">게시물 작성</h2>
        <table align="center" border="1">
            <tr>
                <th>
                   <strong class="writer"> {{ this.writer }} </strong> 
                </th>
            </tr>
            <tr> 
                <td>
                    <input id="title" type="text" v-model="title" cols="70" placeholder="제목을 입력하세요(~18자)"/>
                </td>
            </tr>
             <tr>
                <td>
                    <textarea cols="70" rows="17" v-model="content" placeholder="본문을 작성하세요">
                    </textarea>
               </td>
            </tr>
        </table>
        

        <div class="button">
            <v-btn type="submit"
                   class="register"
                   color="amber lighten-2">
                등록
            </v-btn>
            <v-btn>
                <router-link class="cancel" 
                            :to="{ name: 'FreeBoardListPage' }">
                <strong>취소</strong>
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
    padding:30px;
    color: black;
    background-color:#FFD54F;
}
#title{
    color:black;
}
th {
    padding: 10px;
    border-bottom: 1px solid #EEEEEE;
    color: black;
}
td {
    padding: 10px;
    border-bottom: 1px solid #EEEEEE;
    color: black;
}
textarea {
    border: 1px solid transparent;
    color: black;
    outline: none;    
}
table {
    border-color:  transparent ;
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
.cancel{
    color: grey;
}
.writer{
    background-color:#EEEEEE;
}
.register{
    margin-right:5px;

}

</style>