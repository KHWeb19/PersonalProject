<template>
    <div align="center">
        <board-modify-form v-if="photoBoard" 
                                :board="photoBoard"
                                :boardNo="boardNo"
                                :readPage="`${this.readPage}`" 
                                :accept ="accept"
                                @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import BoardModifyForm from '@/components/common/board/BoardModifyForm.vue'

export default {
    name: 'PhotoBoardModifyPage',
    components: {
        BoardModifyForm
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    data () {
        return {
            readPage: 'PhotoBoardReadPage',
            accept: '.jpg',
           

        }
    },
    computed: {
        ...mapState(['photoBoard'])
    },
    methods: {
        ...mapActions(['fetchPhotoBoard']),
        onSubmit (payload) {
            const { title, content, files } = payload
            // 파일 다시 첨부 했을 경우
           
                let formData = new FormData()
                let board = {
                    title,
                    content,
                    writer: this.photoBoard.writer,
                    regDate: this.photoBoard.regDate,
                    count: this.photoBoard.count,
                    fileName: this.photoBoard.fileName
                }
               
                if(files != null) {formData.append('files',files)}
                formData.append('board',new Blob([JSON.stringify(board)],{type: "application/json"}))
             
                 axios.put(`http://localhost:7777/photoBoard/${this.boardNo}`, formData,{
                     headers: {
                         'Content-Type' : 'multipart/form-data'
                        }
                    }).then((res)=>{
                           alert('등록 완료')
                           this.$router.push({
                            name: 'PhotoBoardReadPage', 
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                   
                           
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        
        
        }
    },
    created () {
        this.fetchPhotoBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })
    }
}

</script>

<style scoped>

</style>