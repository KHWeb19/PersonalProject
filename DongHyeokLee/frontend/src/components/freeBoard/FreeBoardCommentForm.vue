<template>
    <div class="comments">       
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
                     <v-btn v-if="comments.writer == writer" @click="onEdit(index)" text dark>
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
                     <v-btn v-if="comments.writer == writer " @click="onModify(comments.commentNo,ediContent,index)" text dark>
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
        
    </div>
  
</template>

<script>
import axios from 'axios'


export default {
    name: 'FreeBoardCommentsListForm',
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
      freeBoardComments: {
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
            axios.delete(`http://localhost:7777/freeBoardComments/${commentNo}`)
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
             axios.put(`http://localhost:7777/freeBoardComments/${commentNo}`,
                    { content, writer: this.writer , boardNo: this.boardNo, regDate: this.freeBoardComments[index].regDate})
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
                this.edit[payload] = true
                this.ediContent = this.freeBoardComments[payload].content
                this.$forceUpdate();
        },
            onCancel(index) {
                this.edit[index] = null
                this.$forceUpdate();
            }
       
        } 
       
    }

</script>

<style scoped>
.writer{
    color:white;
}
.comments{
    margin-left: 30%;
    margin-top: 10px;
}
.commentRegister {
    border: 3px solid white;
    width: 550px;
    outline: none;
    color:white
}
.commentsList{
    margin-top: 10px;
    color: white;
    
}
.commenter{
    color:white;
}
.modify-icon,
.select-icon, 
.cancel-icon,
.delete-icon {
   font-size: 17px;
}
.cancel-btn {
    color:grey;
    font-size: 13px;
}
.register-btn{
    color:white;
}
.register-icon{
    font-size: 17px;
}
.delete-btn{
    color: grey;
}
.content1, .content2
,.content3, .content4 {
    width: 500px;
    border-bottom: 1px solid;
    color: white;
    
}
.date {
    color: grey;
    font-size: 0.95em;
}
    
</style>