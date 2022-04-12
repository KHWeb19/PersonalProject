<template>
    <v-container >
        <v-row justify="center">
            <img class="title" src="@/assets/title/communityTitle.png" width=250 >
        </v-row>
        <v-row>
            <community-board-write @submit="onBoardSubmit"/>
        </v-row>
    </v-container>
</template>

<script>
import CommunityBoardWrite from '@/components/board/community/CommunityBoardWrite.vue'
import axios from 'axios'

export default {
  components: { CommunityBoardWrite },
    name: 'CommunityWritePage',
    methods: {
        onBoardSubmit (payload) {
            const { title, content, writer, brackets, file} = payload

            let formData = new FormData()

            if (file != null ){formData.append('file', file)}
            formData.append('title',title)
            formData.append('content', content)
            formData.append('writer', writer)
            formData.append('brackets', brackets)

            console.log(formData)
       
            axios.post('http://localhost:7777/board/community/register', formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                    .then(() => {
                        alert('게시글이 등록되셨습니다.')

                        this.$router.push({
                            name: 'CommunityPage'
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
.title{
    margin-top:5%;
    margin-bottom: 5%;
}
@media (max-width:700px){
    .title {
        margin-top:10%;
        margin-left:20px;
        margin-bottom:10%;
        width:200px;
    }
}
</style>