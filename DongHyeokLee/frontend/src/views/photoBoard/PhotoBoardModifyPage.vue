<template>
    <div align="center">
        <photo-board-modify-form v-if="photoBoard" :photoBoard="photoBoard" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import PhotoBoardModifyForm from '@/components/photoBoard/PhotoBoardModifyForm.vue'

export default {
    name: 'PhotoBoardModifyPage',
    components: {
        PhotoBoardModifyForm
    },
    props: {
        boardNo: {
            type: String,
            required: true
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
            if(files){
                let formData = new FormData()
                const fileName = files[0].name
                for (let idx = 0; idx < files.length; idx++) {
                    formData.append('fileList', files[idx])
                }  
            
            axios.all([
                axios.put(`http://localhost:7777/photoBoard/${this.boardNo}`,
                { title, writer: this.photoBoard.writer, content, regDate: this.photoBoard.regDate, fileName }),
                axios.post('http://localhost:7777/photoBoard/uploadImg', formData,{
                     headers: {
                         'Content-Type' : 'multipart/form-data'
                     }
                })
            ])
                    .then(axios.spread((res) => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'PhotoBoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                )
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
            //파일 다시 첨부 안할 경우
            }else{
                   axios.put(`http://localhost:7777/photoBoard/${this.boardNo}`,
                { title, writer: this.photoBoard.writer, content, regDate: this.photoBoard.regDate })
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'PhotoBoardReadPage',
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

</style>