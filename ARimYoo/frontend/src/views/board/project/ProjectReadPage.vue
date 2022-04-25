<template>
    <v-container>
        <v-row justify="center">
            <img class="titleImg" src="@/assets/title/projectTitle.png" width=200 >
        </v-row>
        <v-row>
            <project-reading v-if="project" :project="project"/>
            <project-comment-list @submit="onCommentSubmit" :projectComments="projectComments" />
        </v-row>
    </v-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import axios from 'axios'
import ProjectReading from '@/components/board/project/ProjectReading.vue'
import ProjectCommentList from '@/components/board/project/ProjectCommentList.vue'

export default {
    name:'ProjectReadPage',
        props: {
        projectNo: {
            type: String,
            required: true
        }
    },
    mounted() {
        this.fetchProjectCommentsList(this.projectNo)
    },
    computed: {
        ...mapState(['project' ,'projectComments'])
    },
    components: {
        ProjectReading,
        ProjectCommentList 
    },
    created () {
       this.fetchProject(this.projectNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    console.log(this.projectNo)
                    this.$router.push()
                })
    },
    
    methods: {
        ...mapActions(['fetchProject', 'fetchProjectCommentsList']),
         onCommentSubmit (payload) {

            const { comment, commentWriter } = payload

            let formData = new FormData()

            formData.append('comment', comment)
            formData.append('commentWriter', commentWriter)
            console.log(formData)
            
            axios.post(`http://localhost:7777/board/project/${this.projectNo}/comment/register`, formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                   .then(() => {
                alert('댓글이 작성되셨습니다.')
                history.go(0)
            })
            .catch (() => {
                console.log(this.projectNo)
                alert('문제 발생!')
             })
        }
        
    }

}
</script>

<style scoped>
.titleImg{
    margin-top:4%;
    margin-bottom: 5%;
}

@media (max-width:700px){
    .titleImg {
        margin-top:50px;
        margin-left:20px;
        width:200px;
    }
}

</style>