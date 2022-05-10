<template>
    <div>
        <h2 class="theme">게시물 수정</h2>
        <form @submit.prevent="onSubmit">
        <table align="center" border="1">
            <tr>
                <th>
                   <strong class="writer"> {{ this.writer }} </strong> 
                </th>
            </tr>
            <tr>
                <td>
                    <input type="text" v-model="title"/>
                </td>
            </tr>
            <tr>
                <td>
                    <textarea cols="70" rows="17" v-model="content">
                    </textarea>
                </td>
            </tr>
        </table>

        <v-container>
            <div>
                <label>
                    <input type="file" id="files" ref="files" :accept="accept" v-on:change="handleFileUpload()"/>
                </label>
            </div>
        </v-container>

            <div class="button">
                <v-btn type="submit"
                       class="check"
                       color="amber lighten-2">
                    <strong>완료</strong>
                </v-btn>
               
                <router-link :to="{ name: readPage,
                             params: { boardNo: board.boardNo.toString() } }">
                     <v-btn class="cancel">                
                        취소
                     </v-btn>
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>

export default {
    name: 'BoardModifyForm',
    props: {
        board: {
            type: Object,
        },
        accept:{
            type: String
        },
        readPage:{
            type: String
        },
        boardNo: {
            type: String,
            required: true
        },
    },
    data () {
        return {
            title: '',
            content: '',
            files:'',
            writer: this.$store.state.userInfo.nickname
        }
    },
    methods: {
        onSubmit () {
            const { title, content, files} = this
            //수정시 file을 재첨부 유무
            if(files){
                this.$emit('submit', { title, content, files })
            }else{
                this.$emit('submit', { title, content })
            }
        },
        handleFileUpload () {
                this.files = this.$refs.files.files[0]
                
                this.fileName = this.files.name
                
                let fileLength = this.fileName.length
                let fileDot = this.fileName.lastIndexOf(".")
                let fileType = this.fileName.substring(fileDot+1, fileLength)
    
               if(this.accept === "." + fileType){
                    alert('첨부 되었습니다')
                    
                } else{
                    alert('확장자를 확인하세요')
                    this.$refs.files.value = ''
                } 
        }
    },
    created () {
        this.title = this.board.title
        this.content = this.board.content
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
.cancel{
    color: grey;
}
input {
    outline: none;
    width: 100%;
}
.check{
    margin-right:5px;
}
    
</style>