<template>
    <div align="center">
        <h2>게시물 작성</h2>
         <board-register-form :listPage="`${listPage}`"
                             :accept="accept" 
                             @submit="onSubmit"/>   
    </div>
</template>

<script>

import axios from 'axios'
import BoardRegisterForm from '@/components/common/board/BoardRegisterForm.vue'


export default {
    name: 'VideoBoardRegisterPage',
    components: {
        BoardRegisterForm
    },
     data () {
        return{
            listPage : 'VideoBoardListPage',
            accept: '.mp4'
        }
    },
    methods: {
    onSubmit (payload) {
            const { title, content, writer, files } = payload
            let formData = new FormData()
            let board = {
                    title,
                    content,
                    writer
            }
    
            formData.append('files',files)
            formData.append('board',new Blob([JSON.stringify(board)],{type: "application/json"}))
            
                 axios.post('http://localhost:7777/videoBoard/register', formData,{
                     headers: {
                         'Content-Type' : 'multipart/form-data'
                        }
                    }).then((res)=>{
                       
                        if(res.data != null){
                        alert('등록 완료')
                         this.$router.push({
                        name: 'VideoBoardListPage'
                        })
                        }
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }   
    }
}

</script>

<style scoped>
h2{
    padding:20px;
    background-color:#FFD54F;
    margin-bottom:50px;
    font-family: 'Nanum Brush Script', cursive;
}    
    
</style>