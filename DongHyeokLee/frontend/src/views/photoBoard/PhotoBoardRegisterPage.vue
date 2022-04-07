<template>
    <div align="center">
        <h2>게시물 작성</h2>
        <photo-board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import axios from 'axios'
import PhotoBoardRegisterForm from '@/components/photoBoard/PhotoBoardRegisterForm.vue'


export default {
    name: 'PhotoBoardRegisterPage',
    components: {
        PhotoBoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer, files } = payload
             
            let formData = new FormData()
            const fileName = files[0].name
            
            for (let idx = 0; idx < files.length; idx++) {
                formData.append('fileList', files[idx])
            }
           
            axios.all([
                 axios.post('http://localhost:7777/photoBoard/register', { title, writer, content, fileName}),
                 axios.post('http://localhost:7777/photoBoard/uploadImg', formData,{
                     headers: {
                         'Content-Type' : 'multipart/form-data'
                     }
                 })
            ])
                    .then(axios.spread(() => {
                            alert('등록 성공')

                        this.$router.push({
                            name: 'PhotoBoardListPage'
                        })
                    
                    })
                )
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}

</script>