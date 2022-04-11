<template>
    <div>
        <form @submit.prevent="onSubmit">
            <h2 id="theme">게시물 수정</h2>
            <table align="center" border="1">
                 <tr>
                    <td id="writer">
                    <strong> {{ this.writer }} </strong> 
                    </td>
                </tr>
                <tr> 
                    <td>
                        <input id="title" type="text" v-model="title" cols="70" placeholder="제목을 입력하세요"/>
                    </td>
                </tr>
                <tr> 
                    <td> 
                        <textarea cols="70" rows="15" v-model="content" placeholder="본문을 작성하세요">
                        </textarea>
                    </td>
                </tr>
            </table>

            <div class="button">
                <v-btn type="submit" text dark>
                    완료
                </v-btn>
                <v-btn text>
                <router-link :to="{ name: 'FreeBoardListPage' }" class="black--text">
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
#theme{
        padding:15px;
        color:white;
}
#title{
    color:white;
}
#writer{
    color:grey;
}
table{
    border-color: transparent;
}
th {
    padding: 10px;
    border-bottom: 1px solid white;
    color: white;
}
td {
    padding: 10px;
    border-bottom: 4px solid white;
    color: white;
}
textarea {
    border: 1px solid transparent;
    color: white;
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

    
</style>