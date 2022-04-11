<template>
    <div class="comments">       
        <!-- 댓글 등록-->
        <form @submit.prevent="onSubmit">
           <h4 class="commentsList">댓글</h4>
           <div class="commenter"> <strong>{{ this.writer }}</strong> </div>     
        <input type="text" class="commentRegister" v-model="content" placeholder="댓글을 작성하세요"/>
        <v-btn class="register-btn" type="submit" text>
            <v-icon class="register-icon">
            등록
            </v-icon>
        </v-btn>
        </form>      
        <!-- 댓글 리스트 -->
        <div border="1" v-for="(comments, index) in freeBoardComments" :key="index" >
                <div class="writer">
                    <strong> {{ comments.writer }} </strong>
                    <span class="date"> 
                       <strong> {{ comments.regDate.substring(0, 10) }} 
                        {{ new Date(comments.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(16, 8)}}
                       </strong>
                     </span>
                </div>
                    <!-- 수정 버튼 누르기 전-->
                <div v-if ="edit[index] == null">
                    <div>
                     <input class="content1" v-model="comments.content" disabled/>
                    <!-- 수정 버튼 -->
                     <v-btn v-if="comments.writer == writer" @click="onEdit(index)" text>
                        <v-icon class="modify-icon">
                        수정 
                        </v-icon> 
                    </v-btn>
                    <!-- 삭제 버튼 -->
                    <v-btn v-if="comments.writer == writer" @click="onDelete(comments.commentNo)" text>
                        <v-icon class="delete-icon">
                        mdi-delete    
                        </v-icon> 
                    </v-btn>
                    </div>  
                </div>  
                    <!-- 수정 버튼 누른 후 -->
                <div v-if ="edit[index] == true" >
                    <div>
                        <input class="content2" v-model="ediContent"> 
                    <!-- 수정 확인 버튼 -->
                     <v-btn v-if="comments.writer == writer " @click="onModify(comments.commentNo,ediContent,index)" text>
                        <v-icon class="select-icon">
                        완료
                        </v-icon> 
                    </v-btn>
                    <!-- 수정 취소 버튼 -->
                    <v-btn class="cancel-btn" v-if="comments.writer == writer" @click="onCancel(index)" text>
                        <v-icon class="cancel-icon">
                        취소
                        </v-icon> 
                    </v-btn> 
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'


export default {
    name: 'VideoBoardCommentsListForm',
    data () {
        return {
            content:'',
            writer: this.$store.state.userInfo.nickname,
            nickname:'',
            commnetNo:'',
            edit:[],
            ediContent: ''
        }
    },
    props: {
      videoBoardComments: {
            type: Array,
            required: true
        },
          boardNo: {
            type: String,
            required: true
        }
    },
    
    methods: {
        onSubmit () {
            const { writer, content } = this
            this.$emit('submit', { writer, content })
        },
            onDelete (payload) {
            const commentNo = payload
            axios.delete(`http://localhost:7777/videoBoardComments/${commentNo}`)
                    .then(() => {
                        this.$router.go()
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        },
            onModify ( numOfComment, ediContent , index) {
                const commentNo = numOfComment
                const content = ediContent
             axios.put(`http://localhost:7777/videoBoardComments/${commentNo}`,
                    { content, writer: this.writer , boardNo: this.boardNo, regDate: this.videoBoardComments[index].regDate})
                    .then(res => {
                        if(res.data){
                        alert('게시물 수정 성공!')
                        this.$router.go()
                        }    
                           
                        
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })

        },
            onEdit(payload) {
                //payload를 index로 해줬으면 뭔가 뭐가 들어갔는지 알기 쉬웠을 듯
                this.edit[payload] = true
                //수정하면 빈칸되서 이걸로 넣어줌
                this.ediContent = this.videoBoardComments[payload].content
                this.$forceUpdate();
        },
            onCancel(index) {
                //여긴 왜 index지 index냐 아님 payload로 통일하는건가 vue는
                this.edit[index] = null
                this.$forceUpdate();
            }
       
        } 
       
    }

</script>

<style scoped>

.comments{
    margin-left: 30%;
    margin-top: 10px;
}
.commentRegister {
    border: 3px solid black;
    width: 550px;
    outline: none;
    color:black
}
.commentsList{
    margin-top: 10px;
    color: black;
    
}
.commenter{
    color:black;
}
.cancel-btn {
    color:black;
    font-size: 13px;
}
.register-btn{
    color:black;
}
.register-icon{
    font-size: 17px;
}
.delete-btn{
    color: grey;
}
.modify-icon,
.select-icon, 
.cancel-icon,
.delete-icon {
   font-size: 17px;
}
.content1, 
.content2 {
    width: 500px;
    border-bottom: 1px solid;
    color: black;  
}
.date {
    color: grey;
    font-size: 0.95em;
}
    
</style>