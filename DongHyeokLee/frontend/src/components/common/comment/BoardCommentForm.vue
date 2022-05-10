<template>
    <div class="comments">
        <!-- 댓글 등록-->
        <form @submit.prevent="onSubmit">
           <h4 class="commentsList">댓글</h4>
           <div class="commenter"> <strong>{{ this.writer }}</strong> </div>     
                <input type="text" class="commentRegister" v-model="comment" placeholder="댓글을 작성하세요"/>
            <v-btn class="register-btn" type="submit" color="amber lighten-2">
                <strong>등록</strong>
            </v-btn>  
        </form>
        <!-- 댓글 리스트 -->
        <div class="button" border="1" v-for="(comments, index) in commentList" :key="index" >
            
                <div>
                    <v-icon v-if="comments.parCommentNo != null">
                        mdi-arrow-right-bottom
                    </v-icon>
                    <strong class="writer"> {{ comments.writer }} </strong>
                    <span class="date"> 
                       {{ comments.regDate.substring(0, 10) }}
                       {{new Date(comments.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(12, 8)}} 
                     </span>
                     <v-btn v-if="comments.parCommentNo == null"
                            class="reply"
                            @click="onReply(index)"
                            depressed small>
                         답글
                     </v-btn>
                </div>

                
                    <!-- 수정 버튼 누르기 전-->  
                <div class="content1" v-if ="edit[index] == null">
                    <input class="commentContent" v-model="comments.comment" disabled/>
                    <!-- 수정 버튼 -->
                    <div v-if="comments.writer == writer" class="comment">
                        <v-btn class="modify-btn" 
                                depressed small 
                                @click="onEdit(index)" 
                                color="amber lighten-2">
                            <strong>수정</strong> 
                        </v-btn>
                        <!-- 삭제 버튼 -->
                        <v-btn depressed small 
                                @click="onDelete(comments.commentNo)">
                            <v-icon>
                            mdi-delete    
                            </v-icon> 
                        </v-btn> 
                    </div>
                </div>  
                 
                    <!-- 수정 버튼 누른 후 -->
                <div class="content2" v-if ="edit[index] == true && comments.writer == writer" >
                    <input class="modify" v-model="ediComment"> 
                    <!-- 수정 확인 버튼 -->
                     <v-btn class="check-btn" depressed small 
                            @click="onModify(comments.commentNo,ediComment,index)" 
                            color="amber lighten-2">
                        <strong>완료</strong>
                    </v-btn>
                    <!-- 수정 취소 버튼 -->
                    <v-btn depressed small 
                           @click="onCancel(index)">
                        취소
                    </v-btn> 
                </div>
                <!-- 대댓글 -->
                 <div v-if="replys[index] == true">
                     <input class="reply" v-model="reply"> 
                     <v-btn @click="onReplySumit(comments.commentNo)">
                         등록
                     </v-btn>
                     <v-btn @click="onReturn(index)">
                         취소
                     </v-btn>
                </div>
        </div>
        
        
    </div>
</template>

<script>
import axios from 'axios'


export default {
    name: 'PhotoBoardCommentsListForm',
    data () {
        return {
            comment:'',
            writer: this.$store.state.userInfo.nickname,
            nickname:'',
            commnetNo:'',
            edit:[],
            replys:[],
            ediComment: '',
            reply:'',
            parCommentNo:''
            
        }
    },
    props: {
      commentList: {
            type: Array,
            required: true
        },
        boardNo: {
            type: String,
            required: true
        },
        boardName:{
            type: String,
            required: true
        }
    },
    
    methods: {
        onSubmit () {
            const { writer, comment } = this
            this.$emit('submit', { writer, comment })
           
        },
        onDelete (payload) {
        const commentNo = payload
        const boardName = this.boardName
        axios.delete(`http://localhost:7777/${boardName}/${commentNo}`)
                .then(() => {
                    alert('삭제 성공')
                    this.$router.go()
                })
                .catch(() => {
                    alert('삭제 실패! 문제 발생!')
                })
        },
        onModify( numOfComment, ediComment , index) {
            const commentNo = numOfComment
            const comment = ediComment
            const boardName = this.boardName
            axios.put(`http://localhost:7777/${boardName}/${commentNo}`,
                {comment,writer: this.writer , boardNo: this.boardNo, regDate: this.commentList[index].regDate})
                .then(res => {
                    if(res.data){
                    alert('수정 성공!')
                    this.$router.go()
                    }    
                })
                .catch(() => {
                    alert('수정 실패!')
                })

        },
        onEdit(payload) {
            //payload를 index로 해줬으면 뭔가 뭐가 들어갔는지 알기 쉬웠을 듯
            this.edit[payload] = true
            //수정하면 빈칸되서 이걸로 넣어줌
            this.ediComment = this.commentList[payload].comment
            this.$forceUpdate();
        },
        onCancel(index) {
            //여긴 왜 index지 index냐 아님 payload로 통일하는건가 vue는
            this.edit[index] = null
            this.$forceUpdate();
        },
        onReply(index){
            this.replys[index] = true
            this.$forceUpdate();
        },
        onReturn(index){
            this.replys[index] = null
            this.$forceUpdate();
        
        },
        onReplySumit (payload) {
        const { writer, reply } = this
        const commentNo = payload
        axios.post(`http://localhost:7777/${this.boardName}/reply/register/${this.boardNo}`, { writer, reply, commentNo })
                .then(() => {
                    alert('댓글 등록')
                    this.$router.go()
                })
                .catch(() => {
                    alert('문제 발생!')
                })
        }
        


    }
}

</script>

<style scoped>

.writer{
    color:black;
    margin-top: 20px;
    margin-right: 5px;
    background-color:#FFD54F;
    
}
.comments{
    margin-left: 30%;
    margin-top: 10px;
}
.commentRegister {
    border: 3px solid grey;
    width: 600px;
    outline: none;
    color:black
}
.modify{
    border: 3px solid grey;
    width: 600px;
    outline: none;
    color:black
}
.commentContent{
    width: 600px;

}
.commentsList{
    margin-top: 10px;
    color: black;
    background-color:#EEEEEE;
    width:50px;
    
}
.commenter{
    color:black;
}
.cancel-btn {
    color:grey;
    font-size: 13px;
}
.register-btn{
    color:black;
    margin-left: 50%;
    margin-top: 5px;
}

.content1,
.content2{
    width: 600px;
    border-top: 1px solid;
    color: black;  
}
.comment{
    margin-left: 180px;
}
.modify-btn{
    margin-left: 315px;
}
.check-btn{
    margin-left: 495px;
}
.date {
    color: black;
    font-size: 0.95em;
}
.button{
    margin-top: 20px;
}
.reply{
    margin-left: 300px;
}
    
    
</style>