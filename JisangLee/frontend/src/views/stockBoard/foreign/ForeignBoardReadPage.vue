<template>
<div align="center">
     <br><br>
        <span id="shadow" class="shadow">해외 주식 분석</span>
        <br><br>
    <div align="center"> 
        <foreign-board-read v-if="foreignBoard" :foreignBoard="foreignBoard"/>
        <router-link v-if="this.$store.state.userInfo.nickname == foreignBoard.writer" style=text-decoration:none; :to="{ name: 'ForeignBoardModifyPage', params: { boardNo } }">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            
        <v-btn type="button" tile color="grey darken-2 white--text" width="100" :style="{fontSize:'medium'}"><v-icon>mdi-eraser</v-icon>    
        수정</v-btn>    
        </router-link>   
        <v-btn v-if="this.$store.state.userInfo.nickname == foreignBoard.writer" type="button" tile color="grey darken-3 white--text" width="100" :style="{fontSize:'medium'}" @click="onDelete"><v-icon>mdi-trash-can-outline</v-icon>
            삭제</v-btn>
        <v-btn v-if="this.$store.state.userInfo.nickname == foreignBoard.writer" type="button" tile color="grey darken-4 white--text" width="100" :style="{fontSize:'medium'}" onclick="location.href='http://localhost:8080/stock/ForeignList'"><v-icon>mdi-clipboard-list</v-icon>
            목록</v-btn>
        <v-btn v-if="this.$store.state.userInfo.nickname != foreignBoard.writer" type="button" tile color="grey darken-4 white--text" width="100" :style="{fontSize:'medium'}" onclick="location.href='http://localhost:8080/stock/ForeignList'"><v-icon>mdi-clipboard-list</v-icon>
            목록</v-btn>
        <v-container>
        <v-row>
            <foreign-comment-list @submit="onCommentSubmit" :foreignComments="foreignComments" />
        </v-row>
    </v-container>
    </div>
</div>
</template>

<script>

import swal from 'sweetalert';
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import ForeignBoardRead from '@/components/stockBoard/foreign/ForeignBoardRead.vue'
import ForeignCommentList from '@/components/stockBoard/foreign/ForeignCommentList.vue'

export default {

    name: 'ForeignBoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    mounted() {
        this.fetchForeignCommentsList(this.boardNo)
    },
    components: {
        ForeignBoardRead,
        ForeignCommentList,
    },
    computed: {
        ...mapState(['foreignBoard','foreignComments'])
    },
    created () {
        this.fetchForeignBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchForeignBoard','fetchForeignCommentsList']),
        onDelete () {
            const { boardNo } = this.foreignBoard
            axios.delete(`http://localhost:7777/foreignboard/${boardNo}`)
                    .then(() => {
                        swal({                                                                              
                            text: "게시물이 삭제되었습니다!",
                            icon: "success"
                            })
                        this.$router.push({ name: 'ForeignBoardListPage' })
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
            
            axios.post(`http://localhost:7777/foreignboard/${this.boardNo}/comment/register`, formData, { headers: {
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
