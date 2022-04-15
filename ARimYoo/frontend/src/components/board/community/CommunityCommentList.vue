<template>
    <v-container>
        <v-form @submit.prevent="onCommentSubmit">
            <table>
                <v-row justify="center">
                    <v-col cols="1" style="font-size:15pt" class="label">
                        Comment
                    </v-col>
                    <v-col cols="8">
                        <v-textarea color="red darken-3" cols="80" rows="1" v-model="comment"/>
                    </v-col>
                    <v-col cols="1">
                        <v-btn  type="submit" class="commentBtn" color="red darken-3" dark>input</v-btn>
                    </v-col>
                </v-row>
                    <v-row v-for="commentList in communityComments" 
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
                        <template v-if="commentList.commentWriter == commentWriter">
                                    <v-btn class="comDeleteBtn" @click=comDelete(commentList.commentId) color="red darken-3" fab x-small dark>
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
import axios from 'axios'

export default {
    name:'CommentList',
    props: {
        communityComments : {
            type:Array
        },
    },
    data () {
        return {
            comment:''
        }
    },
    created () {
       this.commentWriter= this.$store.state.userInfo.name
    },
    methods: {
        comDelete (commentId) {
      
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/board/community/comment/${commentId}`, {commentId})
                    .then(() => {
                        alert('댓글이 삭제되었습니다.')
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
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');
table {
    position: relative;
    background-color: rgb(245, 244, 244);
    padding-left: 2%;
    padding-right: 2%;
    padding-top:3%;
    padding-bottom:3%;
    margin-left:auto;
    margin-right:auto;

}
.label{
    font-family: 'Noto Sans KR', sans-serif;
    margin-right:4%;
}
.v-textarea {
    font-family: 'Noto Sans KR', sans-serif;
}
.commentList {
    font-family: 'Noto Sans KR', sans-serif;
}
.comDeleteBtn {
    position:absolute;
    margin-top:1%;
    left:85%;
 
}
</style>