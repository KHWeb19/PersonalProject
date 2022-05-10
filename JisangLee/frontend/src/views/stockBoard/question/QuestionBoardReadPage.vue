<template>
<div align="center">
     <br><br>
        <span id="shadow" class="shadow">질문</span>
        <br><br>
    <div align="center"> 
        <question-board-read v-if="questionBoard" :questionBoard="questionBoard"/>
        <router-link v-if="this.$store.state.userInfo.nickname == questionBoard.writer" style=text-decoration:none; :to="{ name: 'QuestionBoardModifyPage', params: { boardNo } }">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            
        <v-btn type="button" tile color="grey darken-2 white--text" width="100" :style="{fontSize:'medium'}"><v-icon>mdi-eraser</v-icon>    
        수정</v-btn>    
        </router-link>   
        <v-btn v-if="this.$store.state.userInfo.nickname == questionBoard.writer" type="button" tile color="grey darken-3 white--text" width="100" :style="{fontSize:'medium'}" @click="onDelete"><v-icon>mdi-trash-can-outline</v-icon>
            삭제</v-btn>
        <v-btn v-if="this.$store.state.userInfo.nickname == questionBoard.writer" type="button" tile color="grey darken-4 white--text" width="100" :style="{fontSize:'medium'}" onclick="location.href='http://localhost:8080/stock/QuestionList'"><v-icon>mdi-clipboard-list</v-icon>
            목록</v-btn>
        <v-btn v-if="this.$store.state.userInfo.nickname != questionBoard.writer" type="button" tile color="grey darken-4 white--text" width="100" :style="{fontSize:'medium'}" onclick="location.href='http://localhost:8080/stock/QuestionList'"><v-icon>mdi-clipboard-list</v-icon>
            목록</v-btn>
        <v-container>
        <v-row>
            <question-comment-list @submit="onCommentSubmit" :questionComments="questionComments" />
        </v-row>
    </v-container>
    </div>
</div>
</template>

<script>

import swal from 'sweetalert';
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import QuestionBoardRead from '@/components/stockBoard/question/QuestionBoardRead.vue'
import QuestionCommentList from '@/components/stockBoard/question/QuestionCommentList.vue'

export default {

    name: 'QuestionBoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    mounted() {
        this.fetchQuestionCommentsList(this.boardNo)
    },
    components: {
        QuestionBoardRead,
        QuestionCommentList,
    },
    computed: {
        ...mapState(['questionBoard','questionComments'])
    },
    created () {
        this.fetchQuestionBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchQuestionBoard','fetchQuestionCommentsList']),
        onDelete () {
            const { boardNo } = this.questionBoard
            axios.delete(`http://localhost:7777/questionboard/${boardNo}`)
                    .then(() => {
                        swal({                                                                              
                            text: "게시물이 삭제되었습니다!",
                            icon: "success"
                            })
                        this.$router.push({ name: 'QuestionBoardListPage' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        },
        onCommentSubmit (payload) {
            const { comment, commentWriter } = payload
            let formData = new FormData()
            formData.append('comment', comment)
            formData.append('commentWriter', commentWriter)
            console.log(formData)
            
            axios.post(`http://localhost:7777/questionboard/${this.boardNo}/comment/register`, formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                   .then(() => {
                swal({                                                                              
                    text: "댓글이 작성되었습니다!",
                    icon: "success"
                    })
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
