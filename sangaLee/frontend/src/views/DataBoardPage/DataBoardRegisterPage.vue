<template>
<div class="main">
    <h2>자료 업로드</h2>
    <v-content>
        <data-board-register-form @submit="onSubmit"/>
    </v-content>
</div>
</template>

<script>

import DataBoardRegisterForm from '@/components/DataBoard/DataBoardRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'DataBoardRegisterPage',
    components: {
        DataBoardRegisterForm
    },
    data() {
        return {
            files: '',
            response: ''
        }
    },
    methods: {
        handleFileUpload () {
            this.files = this.$refs.files.files
        },
        submitFiles () {
            let formData = new FormData()

            for (let idx = 0; idx < this.files.length; idx++) {
                formData.append('fileList', this.files[idx])
            }

            axios.post('http://localhost:7777/file/uploadImg', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
            .then (res => {
                alert('처리 결과: ' + res.data)
            })
            .catch (res => {
                alert('처리 결과: ' + res.message)
            })
        },
        onSubmit (payload) {
            const { title, writer, content } = payload
            axios.post('http://localhost:7777/DataBoard/register', { title, writer, content })
                    .then(() => {
                        alert('게시물 등록 성공!')

                        this.$router.push({
                            name: 'DataBoardListPage'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}

</script>
<style scoped>
.main {
background-color: #EBECF0;
height: 100vh;
}
h2 {
    text-align: center;
    padding: 60px;
    color: #6768ab;
}
</style>