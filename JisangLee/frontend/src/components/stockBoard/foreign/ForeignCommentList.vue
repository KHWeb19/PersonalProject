<template>
    <v-container>
        <v-form @submit.prevent="onCommentSubmit">
            <table>
                <v-row justify="center">
                    <v-col cols="1" style="font-size:15pt" class="label">
                        Comment
                    </v-col>   
                    <v-col cols="8">
                        <v-textarea color="grey lighten-5" cols="58" rows="1" v-model="comment"/>
                    </v-col>
                    <v-col cols="1">
                        <v-btn  type="submit" class="commentBtn" color="blue-grey lighten-3 black--text" fab x-small dark><v-icon> mdi-arrow-left-bottom-bold</v-icon></v-btn>
                    </v-col>                                                                                                       
                </v-row>
                    <v-row v-for="commentList in foreignComments" 
                        :key="commentList.commentId" justify="center" class="commentList">
                        <v-col cols="2">
                            {{ commentList.commentWriter}}
                        </v-col>
                        <v-col cols="5">
                            {{ commentList.comment }}
                        </v-col>
                        <v-col cols="2">
                            {{ commentList.date}}
                        </v-col>
                        &nbsp;&nbsp;  
                        <template v-if="commentList.commentWriter == commentWriter">
                            <v-btn class="comDeleteBtn" @click=comDelete(commentList.commentId) color="blue-grey darken-2" fab x-small dark>
                                <v-icon>
                                    mdi-trash-can-outline
                                </v-icon>
                            </v-btn> 
                        </template>
                    </v-row>
            </table>
        </v-form>
    </v-container>
</template>

<script>
import swal from 'sweetalert';
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
export default {
    name:'CommentList',
    props: {
        foreignComments : {
            type:Array
        },
    },   
    data () {
        return {
            comment:''
        }
    },
    created () {
       this.commentWriter= this.$store.state.userInfo.nickname
    },
    computed: {
        ...mapState(['ForeignCommentsList'])
    },
    methods: {
        ...mapActions(['fetchForeignCommentsList']),
        comDelete (commentId) {
            axios.delete(`http://localhost:7777/foreignboard/comment/${commentId}`, {commentId})
                    .then(() => {
                        swal({
                            text: "댓글이 삭제되었습니다!",
                            icon: "success"
                            })
                        history.go(0)
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                        console.log(commentId, this.boardNo)
                    })
        },
        onCommentSubmit () {
            const { comment, commentWriter } = this
            this.$emit('submit', {comment, commentWriter})
            console.log(comment, commentWriter)
            }
        },
}  
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Cute+Font&display=swap');
table {
    position: relative;
    background-color:rgb(40, 44, 53) ;
    font-size: 20px;
    color: white;
    padding-left: 0%;
    padding-right: 0%;
    padding-top:0%;
    padding-bottom:0%;
    margin-left:auto;
    margin-right:auto;
}
.label{
    font-family: 'Cute Font', cursive;
    margin-right:0%;
}
.v-textarea {
    font-family: 'Noto Sans KR', sans-serif;
}
.commentList {
    font-family: 'Cute Font', cursive;
}
.commentBtn{
    position:absolute;
    margin-top:3%;
    left:85%;
}
.comDeleteBtn {
    position:absolute;
    margin-top:3%;
    margin-left:7%;
    left:80%; 
}
</style>