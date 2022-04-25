<template>
    <v-container >
        <v-row justify="center">
            <img class="title" src="@/assets/title/projectTitle.png" width=155 >
        </v-row>
        <v-row>
            <study-modify :study="study" @submit="onStudyModify"/>
        </v-row>
    </v-container>
</template>

<script>

import axios from 'axios'

import StudyModify from '@/components/board/study/StudyModify.vue'
import { mapActions, mapState } from 'vuex'


export default {
  components: { StudyModify },

    name: 'StudyWritePage',
    props: {
        studyNo :{
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['study'])
    },
    methods: {
        ...mapActions(['fetchStudy']),
        onStudyModify (payload) {
           const { fileName, writer, studyName, viewCnt, people, content, openLink} = payload
           console.log(payload)

            let formData = new FormData()

            formData.append('fileName', fileName)
            formData.append('writer',writer)
            formData.append('content', content)
            formData.append('studyName', studyName)
            formData.append('people', people)
            formData.append('openLink', openLink)
            formData.append('viewCnt',viewCnt)

       
            axios.put(`http://localhost:7777/board/study/${this.studyNo}`,formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                    .then((res) => {
                        alert('게시글이 수정되셨습니다.')

                     this.$router.push({
                            name: 'StudyReadPage',
                            params: { studyNo: res.data.studyNo.toString() }
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