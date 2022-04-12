<template>
    <div>
        <form @submit.prevent="onSubmit">
            <h2 class="theme">게시물 수정</h2>
            <table align="center" border="1">
                 <tr>
                    <td>
                    <strong class="writer"> {{ this.writer }} </strong> 
                    </td>
                </tr>
                <tr> 
                    <th>
                        <input id="title" type="text" v-model="title" cols="70" placeholder="제목을 입력하세요"/>
                    </th>
                </tr>
                <tr> 
                    <th> 
                        <textarea cols="70" rows="15" v-model="content" placeholder="본문을 작성하세요">
                        </textarea>
                    </th>
                </tr>
            </table>

            <div class="button">
                <v-btn type="submit"
                       class="check"
                       color="amber lighten-2">
                    <strong>완료</strong>
                </v-btn>
                <v-btn>
                <router-link class="cancel"
                             :to="{ name: 'FreeBoardListPage' }">
                   <strong> 취소</strong>
                </router-link>
                </v-btn>
            </div>
        </form>
    </div>
</template>

<script>

export default {
    name: 'FreeBoardModifyForm',
    props: {
        freeBoard: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            content: '',
            writer: this.$store.state.userInfo.nickname
        }
    },
    methods: {
        onSubmit () {
            const { title, content } = this
            this.$emit('submit', { title, content })
        }
    },
    created () {
        this.title = this.freeBoard.title
        this.content = this.freeBoard.content
    }
}
</script>

<style scoped>
.theme{
        padding:15px;
        color:black;
        background-color:#FFD54F;
        margin-bottom:50px;
        font-family: 'Nanum Brush Script', cursive;
}
#title{
    color:black;
}
.writer{
    color:black;
    background-color: #EEEEEE;
}
table{
    border-color: transparent;
}
th {
    padding: 10px;
    border-bottom: 1px solid black;
    color: black;
}
td {
    padding: 10px;
    border-bottom: 1px solid black;
    color: black;
}
textarea {
    border: 1px solid transparent;
    color: black;
    outline: none;    
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
.check{
    margin-right: 5px;
}
.cancel{
    color: grey;
}

    
</style>