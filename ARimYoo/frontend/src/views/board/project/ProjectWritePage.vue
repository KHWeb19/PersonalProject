<template>
    <v-container >
        <v-row justify="center">
            <img class="title" src="@/assets/title/projectTitle.png" width=200 >
        </v-row>
        <v-row>
            <project-write @submit="onProjectSubmit"/>
        </v-row>
    </v-container>
</template>

<script>

import axios from 'axios'
import ProjectWrite from '@/components/board/project/ProjectWrite.vue'


export default {
  components: { ProjectWrite },

    name: 'ProjectWritePage',
    methods: {
       onProjectSubmit (payload) {
           const { projectName, content, writer, people,openLink, file, memberNo} = payload

            let formData = new FormData()

            if (file != null ){formData.append('file', file)}
            formData.append('writer',writer)
            formData.append('content', content)
            formData.append('projectName', projectName)
            formData.append('people', people)
            formData.append('openLink', openLink)
            formData.append('memberNo', memberNo)


            console.log(formData)
       
            axios.post('http://localhost:7777/board/project/register', formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                    .then(() => {
                        alert('게시글이 등록되셨습니다.')

                        this.$router.push({
                            name: 'ProjectPage'
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
    margin-top:4%;
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