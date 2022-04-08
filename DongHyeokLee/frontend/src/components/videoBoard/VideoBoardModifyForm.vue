<template>
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>
                        <input type="hidden" :value="videoBoard.boardNo" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>
                        <input type="text" v-model="title"/>
                    </td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td>
                        <input type="text" :value="videoBoard.writer" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td>
                        <input type="text" :value="videoBoard.regDate" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td>
                        <textarea cols="50" rows="20" v-model="content">
                        </textarea>
                    </td>
                </tr>
            </table>

        <v-container>
            <h3>파일 업로드 </h3>
            <div>
                <label>Files
                    <input type="file" id="files" ref="files" accept=".jpg, .png, .gif" v-on:change="handleFileUpload()"/>
                    <!-- 여러개 파일 이름을 어떻게 저장 해야할지 감 안 잡혀서 multiple 기능 제거 -->
                </label>
            </div>
        </v-container>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'VideoBoardReadPage',
                                    params: { boardNo: videoBoard.boardNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>

export default {
    name: 'VideoBoardModifyForm',
    props: {
        videoBoard: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            content: '',
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
                if(fileType == "mp4"){
                    alert('첨부 되었습니다')
                    
                } else{
                    alert('확장자를 확인하세요')
                    this.$refs.files.value = ''
                  //확장자 다를경우 파일 초기화  
                }  
        }
    },
    created () {
        this.title = this.videoBoard.title
        this.content = this.videoBoard.content
    }
}
</script>