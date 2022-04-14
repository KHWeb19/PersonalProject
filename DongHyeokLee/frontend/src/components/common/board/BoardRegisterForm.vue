<template>
    <form @submit.prevent="onSubmit">
        <table align="center" border="1">
            <tr>
                <th>
                   <strong> {{ this.writer }} </strong> 
                </th>
            </tr>
            <tr>
                <td>
                    <input type="text" v-model="title" cols="70" placeholder="제목을 입력하세요"/>
                </td>
            </tr>
            <tr>
                <td>
                    <textarea cols="70" rows="17" v-model="content" placeholder="본문을 작성하세요">
                    </textarea>
                </td>
            </tr>
        </table>

        

        <v-container>
            <div>
                <label>
                    <input type="file" id="files" ref="files" :accept="accept" v-on:change="handleFileUpload()" /> 
                </label>
            </div>
        </v-container>

        <div class="button">
            <v-btn type="submit" 
                   class="register"
                   color="amber lighten-2" >
               <strong>등록</strong>
            </v-btn>
            <v-btn>
            <router-link class="cancel" :to="{ name: listPage }">
               <strong>취소</strong>
            </router-link>
            </v-btn>
        </div>
    </form>
</template>

<script>

export default {
    name: 'BoardRegisterForm',
    props: {
        listPage:{
            type: String
        },
        accept:{
            type: String
        }
    },
    data () {
        return {
            title: '',
            writer: this.$store.state.userInfo.nickname,
            content: '',
            files:''
        }
    },
    methods: {
        onSubmit () {
            const { title, writer, content, files } = this
            console.log(files)
            if(files){
            this.$emit('submit', { title, writer, content, files })
            }else{
                alert('파일을 첨부하세요')
            }

        },
          handleFileUpload () {
                this.files = this.$refs.files.files[0]

                this.fileName = this.files.name

                let fileLength = this.fileName.length
                let fileDot = this.fileName.lastIndexOf(".")
                let fileType = this.fileName.substring(fileDot+1, fileLength)
                //console.log(fileType + " " + this.accept )
                //let fileTyepLowerCase = fileType.toLowerCase()
                //console.log(fileTyepLowerCase)
               //vue에서 gif 대문자로 GIF가 되면 오류생겨서 확장자 이래 3개만 받음 
               
               if(this.accept === "." + fileType){
                    alert('첨부 되었습니다')
                    
                } else{
                    alert('확장자를 확인하세요')
                    this.$refs.files.value = ''
                  //확장자 다를경우 파일 초기화  
                } 
        }
    }
}
</script>


<style scoped>

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
a{
    text-decoration: none;
}
a:hover{
    text-decoration: none; 
}
input {
    outline: none;
    width: 100%;
}
.button {
    padding: 20px;
}
.cancel{
    color: grey;
}
.register{
    margin-right: 5px;
}

</style>