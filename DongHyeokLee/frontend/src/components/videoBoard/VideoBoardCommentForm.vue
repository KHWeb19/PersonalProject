<template>
    <div class="comments">       
        <!-- 댓글 리스트 -->
        <h2>댓글</h2>
        
        <div border="1" v-for="(comments, index) in videoBoardComments" :key="index" >
                
                <div>
                   {{ comments.writer }}
                   {{ comments.regDate.substring(0, 10) }} 
                   {{ new Date(comments.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(11, 8)}}
                <div>
                    <!-- 수정 버튼 누르기 전-->
                <div v-if ="edit[index] == null">
                    <!-- 작성자 아닌 경우 -->
                    <div v-if="comments.writer != writer">
                    {{ comments.content }} 
                    </div>
                    <!-- 작성자인 경우 -->
                    <div v-else >
                    <input v-model="comments.content" disabled/>
                    </div>
                </div>
                    <!-- 수정 버튼 누른 후 -->
                <div v-if ="edit[index] == true" >
                    <!-- 장석자 아닌 경우 -->
                    <div v-if="comments.writer != writer">
                        {{ comments.content }} 
                    </div>
                    <!-- 작성자인 경우 -->
                    <div v-else>
                        <input v-model="ediContent">
                    </div>
                </div>
                
                    <!-- 수정 버튼 -->
                <div v-if="comments.writer == writer && edit[index] == null">
                    <v-btn  @click="onEdit(index)">
                        <v-icon>
                        수정 
                        </v-icon> 
                    </v-btn>
                    <!-- 삭제 버튼 -->
                    <v-btn @click="onDelete(comments.commentNo)">
                        <v-icon>
                        mdi-delete    
                        </v-icon> 
                    </v-btn> 
                 </div>
                    <!-- 수정 확인 버튼 -->
                 <div v-if="comments.writer == writer && edit[index] == true">
                     <v-btn v-if="comments.writer == writer " @click="onModify(comments.commentNo,ediContent,index)">
                        <v-icon>
                        완료
                        </v-icon> 
                    </v-btn>
                    <!-- 수정 취소 버튼 -->
                    <v-btn v-if="comments.writer == writer" @click="onCancel(index)">
                        <v-icon>
                        취소
                        </v-icon> 
                    </v-btn> 
                 </div> 

            </div>
        </div>
        </div>
       
        <!-- 댓글 등록-->
        <form @submit.prevent="onSubmit">
           <h2> {{ this.writer }}</h2>
            <v-container fluid>
                <v-row>
                <v-col cols="12" md="6">
                    <v-textarea v-model="content"></v-textarea>
                <v-btn type="submit">등록</v-btn>
                </v-col>
                </v-row>
            </v-container>
        </form>
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
    
</style>