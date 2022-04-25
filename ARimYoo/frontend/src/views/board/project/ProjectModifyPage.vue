<template>
    <v-container >
        <v-row justify="center">
            <img class="title" src="@/assets/title/projectTitle.png" width=200 >
        </v-row>
        <v-row>
            <project-modify :project="project" @submit="onProjectModify"/>
        </v-row>
    </v-container>
</template>

<script>

import axios from 'axios'

import { mapActions, mapState } from 'vuex'
import ProjectModify from '@/components/board/project/ProjectModify.vue'


export default {
  components: { ProjectModify },

    name: 'ProjectWritePage',
    props: {
        projectNo :{
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['project'])
    },
    methods: {
        ...mapActions(['fetchProject']),
        onProjectModify (payload) {
           const { fileName, writer, projectName, viewCnt, people, content, openLink} = payload
           console.log(payload)

            let formData = new FormData()

            formData.append('fileName', fileName)
            formData.append('writer',writer)
            formData.append('content', content)
            formData.append('projectName', projectName)
            formData.append('people', people)
            formData.append('openLink', openLink)
            formData.append('viewCnt',viewCnt)

       
            axios.put(`http://localhost:7777/board/project/${this.projectNo}`,formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                    .then((res) => {
                        alert('게시글이 수정되셨습니다.')

                     this.$router.push({
                            name: 'ProjectReadPage',
                            params: { projectNo: res.data.projectNo.toString() }
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