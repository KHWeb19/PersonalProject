<template>
    <v-container>
        <v-row justify="center">
            <img class="title" src="@/assets/title/communityTitle.png" width=250 >
        </v-row>
        <v-row>
            <community-board-read v-if="communityBoard" :communityBoard="communityBoard"/>
            <community-comment-list @submit="onCommentSubmit" :communityComments="communityComments" />
        </v-row>
    </v-container>
</template>

<script>
import CommunityBoardRead from '@/components/board/community/CommunityBoardReading.vue'
import CommunityCommentList from '@/components/board/community/CommunityCommentList.vue'
import { mapActions, mapState } from 'vuex'
import axios from 'axios'

export default {
    name:'CommunityReadPage',
        props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    mounted() {
        this.fetchCommunityCommentsList(this.boardNo)
    },
    computed: {
        ...mapState(['communityBoard' ,'communityComments'])
    },
    components: {
        CommunityBoardRead,
        CommunityCommentList,
    },
    created () {
        this.fetchCommunityBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    console.log(this.boardNo)
                    this.$router.push()
                })
    },
    
    methods: {
        ...mapActions(['fetchCommunityBoard', 'fetchCommunityCommentsList']),
         onCommentSubmit (payload) {

            const { comment, commentWriter } = payload

            let formData = new FormData()

            formData.append('comment', comment)
            formData.append('commentWriter', commentWriter)
            console.log(formData)
            
            axios.post(`http://localhost:7777/board/community/${this.boardNo}/comment/register`, formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                   .then(() => {
                alert('댓글이 작성되셨습니다.')
                history.go(0)
            })
            .catch (() => {
                console.log(this.boardNo)
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
        margin-top:50px;
        margin-left:20px;
        width:200px;
    }
}

</style>