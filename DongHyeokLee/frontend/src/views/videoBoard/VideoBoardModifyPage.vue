<template>
    <div align="center">
        <video-board-modify-form v-if="videoBoard" :videoBoard="videoBoard" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import VideoBoardModifyForm from '@/components/videoBoard/VideoBoardModifyForm.vue'

export default {
    name: 'VideoBoardModifyPage',
    components: {
        VideoBoardModifyForm
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['videoBoard'])
    },
    methods: {
        ...mapActions(['fetchVideoBoard']),
        onSubmit (payload) {
            const { title, content, files } = payload
            if(files){
                //파일 변경시
                let formData = new FormData()
                const fileName = files[0].name
                for (let idx = 0; idx < files.length; idx++) {
                    formData.append('fileList', files[idx])
                }  
            
            axios.all([
                axios.put(`http://localhost:7777/videoBoard/${this.boardNo}`,
                { title, writer: this.videoBoard.writer, content, regDate: this.videoBoard.regDate, fileName }),
                axios.post('http://localhost:7777/videoBoard/uploadImg', formData,{
                     headers: {
                         'Content-Type' : 'multipart/form-data'
                     }
                })
            ])
                    .then(axios.spread((res) => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'VideoBoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                )
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
                    //파일 변경 안할 경우
            }else{
                   axios.put(`http://localhost:7777/videoBoard/${this.boardNo}`,
                { title, writer: this.videoBoard.writer, content, regDate: this.videoBoard.regDate })
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'VideoBoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })

            }
        
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

h1 {
    padding:15px;
}
    
</style>