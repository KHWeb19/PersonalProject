<template>
    <v-container>
        <v-row justify="center">
            <img class="titleImg" src="@/assets/title/studyTitle.png" width=155 >
        </v-row>
        <v-row>
            <study-reading v-if="study" :study="study"/>
            <study-comment-list @submit="onCommentSubmit" :studyComments="studyComments" />
        </v-row>
    </v-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import axios from 'axios'
import StudyReading from '@/components/board/study/StudyReading.vue'
import StudyCommentList from '@/components/board/study/StudyCommentList.vue'

export default {
    name:'StudyReadPage',
        props: {
        studyNo: {
            type: String,
            required: true
        }
    },
    mounted() {
        this.fetchStudyCommentsList(this.studyNo)
    },
    computed: {
        ...mapState(['study' ,'studyComments'])
    },
    components: {
        StudyReading,
        StudyCommentList,
    },
    created () {
        this.fetchStudy(this.studyNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    console.log(this.studyNo)
                    this.$router.push()
                })
    },
    
    methods: {
        ...mapActions(['fetchStudy', 'fetchStudyCommentsList']),
         onCommentSubmit (payload) {

            const { comment, commentWriter } = payload

            let formData = new FormData()

            formData.append('comment', comment)
            formData.append('commentWriter', commentWriter)
            console.log(formData)
            
            axios.post(`http://localhost:7777/board/study/${this.studyNo}/comment/register`, formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                   .then(() => {
                alert('댓글이 작성되셨습니다.')
                history.go(0)
            })
            .catch (() => {
                console.log(this.studyNo)
                alert('문제 발생!')
             })
        }
        
    }

}
</script>

<style scoped>
.titleImg{
    margin-top:3%;
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