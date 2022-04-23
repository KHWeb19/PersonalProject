<template>
    <v-container >
        <v-row justify="center">
            <img class="title" src="@/assets/title/studyTitle.png" width=155 >
        </v-row>
        <v-row>
            <study-write @submit="onStudySubmit"/>
        </v-row>
    </v-container>
</template>

<script>

import axios from 'axios'
import StudyWrite from '@/components/board/study/StudyWrite.vue'


export default {
  components: { StudyWrite },

    name: 'StudyWritePage',
    methods: {
        onStudySubmit (payload) {
           const { studyName, content, writer, people,openLink, file} = payload

            let formData = new FormData()

            if (file != null ){formData.append('file', file)}
            formData.append('writer',writer)
            formData.append('content', content)
            formData.append('studyName', studyName)
            formData.append('people', people)
            formData.append('openLink', openLink)


            console.log(formData)
       
            axios.post('http://localhost:7777/board/study/register', formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                    .then(() => {
                        alert('게시글이 등록되셨습니다.')

                        this.$router.push({
                            name: 'StudyPage'
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