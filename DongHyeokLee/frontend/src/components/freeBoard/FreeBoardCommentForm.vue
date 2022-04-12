<template>
    <div class="comments"> 
        <!-- 댓글 등록-->
        <form @submit.prevent="onSubmit">
           <h4 class="commentsList">댓글</h4>
           <div class="commenter"> <strong>{{ this.writer }}</strong> </div>     
                <input type="text" class="commentRegister" v-model="content" placeholder="댓글을 작성하세요"/>
            <v-btn class="register-btn" type="submit" color="amber lighten-2">
                <strong>등록</strong>
            </v-btn>  
        </form>
        <!-- 댓글 리스트 -->
        <div class="button" border="1" v-for="(comments, index) in freeBoardComments" :key="index" >
                <div>
                    <strong class="writer"> {{ comments.writer }} </strong>
                    <span class="date"> 
                       {{ comments.regDate.substring(0, 10) }} 
                        {{ new Date(comments.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(16, 8)}}
                     </span>
                </div>
                    <!-- 수정 버튼 누르기 전-->
                <div class="content1" v-if ="edit[index] == null && comments.writer == writer">
                     <input  v-model="comments.content" disabled/>
                    <!-- 수정 버튼 -->
                    <v-btn class="modify-btn" depressed small 
                           @click="onEdit(index)" color="amber lighten-2">
                       <strong>수정</strong> 
                    </v-btn>
                    <!-- 삭제 버튼 -->
                    <v-btn depressed small 
                           @click="onDelete(comments.commentNo)">
                        <v-icon >
                        mdi-delete    
                        </v-icon> 
                    </v-btn> 
                </div>  
                 
                    <!-- 수정 버튼 누른 후 -->
                <div class="content2" v-if ="edit[index] == true && comments.writer == writer" >
                    <input  v-model="ediContent"> 
                    <!-- 수정 확인 버튼 -->
                     <v-btn class="check-btn" depressed small 
                            @click="onModify(comments.commentNo,ediContent,index)" 
                            color="amber lighten-2">
                        <strong>완료</strong>
                    </v-btn>
                    <!-- 수정 취소 버튼 -->
                    <v-btn depressed small 
                           @click="onCancel(index)">
                       <strong>취소</strong>
                    </v-btn> 
                </div>
        </div>
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
    margin-left: 52%;
    margin-top: 5px;
}
.content1, 
.content2{
    width: 600px;
    border-top: 1px solid;
    color: black;  
    
}
.modify-btn{
    margin-left: 315px;
}
.check-btn{
    margin-left: 313px;
}
.date {
    color: black;
    font-size: 0.95em;
}
.button{
    margin-top: 20px;
}
    
</style>