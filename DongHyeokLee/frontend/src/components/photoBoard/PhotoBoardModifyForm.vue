<template>
    <div>
        <form @submit.prevent="onSubmit">
        <table align="center" border="1">
            <tr>
                <th>
                   <strong> {{ this.writer }} </strong> 
                </th>
            </tr>
            <tr>
                <td>
                    <input type="text" v-model="title" placeholder="제목을 입력하세요"/>
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
                    <input type="file" id="files" ref="files" accept=".jpg, .png, .gif" v-on:change="handleFileUpload()"/>
                    <!-- 여러개 파일 이름을 어떻게 저장 해야할지 감 안 잡혀서 multiple 기능 제거 -->
                </label>
            </div>
        </v-container>

            <div class="button">
                <button type="submit"> 완료</button>
                <router-link class="cancel" :to="{ name: 'PhotoBoardReadPage',
                                    params: { boardNo: photoBoard.boardNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>

export default {
    name: 'PhotoBoardModifyForm',
    props: {
        photoBoard: {
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
            const { title, content, files} = this
            //수정시 file을 재첨부 유무
            if(files){
                this.$emit('submit', { title, content, files })
            }else{
                this.$emit('submit', { title, content })
            }
        },
        handleFileUpload () {
                this.files = this.$refs.files.files
                let fileLength = this.files[0].name.length
                let fileDot = this.files[0].name.lastIndexOf(".")
                let fileType = this.files[0].name.substring(fileDot+1, fileLength)
                //let fileTyepLowerCase = fileType.toLowerCase()
                //console.log(fileTyepLowerCase)
                //vue에서 gif 대문자로 GIF가 되면 오류생겨서 확장자 이래 3개만 받음
                if(fileType == "jpg" || fileType == "png" || fileType == "gif"){
                    alert('첨부 되었습니다')
                    
                } else{
                    alert('확장자를 확인하세요')
                    this.$refs.files.value = ''
                  //확장자 다를경우 파일 초기화  
                }  
        }
    },
    created () {
        this.title = this.photoBoard.title
        this.content = this.photoBoard.content
    }
}
</script>

<style scoped>

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
    border-bottom: 3px solid black;
    color: black;
}
textarea {
    border: 1px solid transparent;
    color: black;
    outline: none;    
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
    
</style>