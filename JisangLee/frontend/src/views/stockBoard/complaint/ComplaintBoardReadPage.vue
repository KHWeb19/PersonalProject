<template>
<div align="center">
     <br><br>
        <span id="shadow" class="shadow">하소연</span>
        <br><br>
    <div align="center">
        <complaint-board-read v-if="complaintBoard" :complaintBoard="complaintBoard"/>
        <router-link v-if="this.$store.state.userInfo.nickname == complaintBoard.writer" style=text-decoration:none; :to="{ name: 'ComplaintBoardModifyPage', params: { boardNo } }">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            
        <v-btn type="button" tile color="grey darken-2 white--text" width="100" :style="{fontSize:'medium'}"><v-icon>mdi-eraser</v-icon>    
        수정</v-btn>    
        </router-link>   
        <v-btn v-if="this.$store.state.userInfo.nickname == complaintBoard.writer" type="button" tile color="grey darken-3 white--text" width="100" :style="{fontSize:'medium'}" @click="onDelete"><v-icon>mdi-trash-can-outline</v-icon>
            삭제</v-btn>
        <v-btn v-if="this.$store.state.userInfo.nickname == complaintBoard.writer" type="button" tile color="grey darken-4 white--text" width="100" :style="{fontSize:'medium'}" onclick="location.href='http://localhost:8080/stock/ComplaintList'"><v-icon>mdi-clipboard-list</v-icon>
            목록</v-btn>
        <v-btn v-if="this.$store.state.userInfo.nickname != complaintBoard.writer" type="button" tile color="grey darken-4 white--text" width="100" :style="{fontSize:'medium'}" onclick="location.href='http://localhost:8080/stock/ComplaintList'"><v-icon>mdi-clipboard-list</v-icon>
            목록</v-btn>
        <v-container>
        <v-row>
            <complaint-comment-list @submit="onCommentSubmit" :complaintComments="complaintComments" />
        </v-row>
    </v-container>
    </div>
</div>
</template>

<script>

import swal from 'sweetalert';
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import ComplaintBoardRead from '@/components/stockBoard/complaint/ComplaintBoardRead.vue'
import ComplaintCommentList from '@/components/stockBoard/complaint/ComplaintCommentList.vue'

export default {

    name: 'ComplaintBoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    mounted() {
        this.fetchComplaintCommentsList(this.boardNo)
    },
    components: {
        ComplaintBoardRead,
        ComplaintCommentList,
    },
    computed: {
        ...mapState(['complaintBoard','complaintComments'])
    },
    created () {
        this.fetchComplaintBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchComplaintBoard','fetchComplaintCommentsList']),
        onDelete () {
            const { boardNo } = this.complaintBoard
            axios.delete(`http://localhost:7777/complaintboard/${boardNo}`)
                    .then(() => {
                        swal({                                                                              
                            text: "게시물이 삭제되었습니다!",
                            icon: "success"
                            })
                        this.$router.push({ name: 'ComplaintBoardListPage' })
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
            
            axios.post(`http://localhost:7777/complaintboard/${this.boardNo}/comment/register`, formData, { headers: {
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
                swal('문제 발생!')
             })
        }   
    } 
}

</script>
