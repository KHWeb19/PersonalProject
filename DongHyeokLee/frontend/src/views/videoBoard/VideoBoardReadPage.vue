<template>
    <div>   
        <h2 class="bar"></h2>
         <!-- 리스트로 돌아가기 -->
        <router-link :to="{ name: 'VideoBoardListPage' }">
            <v-btn class="list-btn" color="amber lighten-2">
            <strong class="text">영상게시판</strong>
            </v-btn>
        </router-link>
        
        <video-board-read v-if=videoBoard :videoBoard="videoBoard"/>

        <div class = "button">
            <router-link v-if="$store.state.userInfo.nickname == videoBoard.writer" 
                         :to="{ name: 'VideoBoardModifyPage', params: { boardNo } }">
                 <v-btn class="modify-btn"
                       color="amber lighten-2">
                  <strong>수정</strong>
                </v-btn>
            </router-link>
            <!-- 삭제해도 db에서 fileName은 날아가는데 vue에 저장 된 파일 자체는 안 날아가는 형태라 고민되네 -->
            <v-btn v-if="$store.state.userInfo.nickname == videoBoard.writer" 
                   @click="onDelete"
                   class="remove-btn">
                <strong>삭제</strong>
            </v-btn>
        </div>
          <!-- 댓글-->
        <video-board-comment :boardNo="this.boardNo"/>
    </div>
</template>

<script>

import { mapActions, mapState } from 'vuex'
import axios from 'axios'

import VideoBoardRead from '@/components/videoBoard/VideoBoardRead.vue'
import VideoBoardComment from '@/views/videoBoard/VideoBoardComment.vue'

export default {
    name: 'VideoBoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        VideoBoardRead,
        VideoBoardComment
    },
    computed: {
        ...mapState(['videoBoard'])
    },
    created () {
        this.fetchVideoBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })   
    },
    methods: {
        ...mapActions(['fetchVideoBoard']),
          onDelete () {
            const boardNo= this.boardNo
            axios.delete(`http://localhost:7777/videoBoard/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'VideoBoardListPage' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }
    }
}
</script>

<style scoped>

.button {
    padding: 5px;
    margin-left: 60%;
}
a{
    text-decoration: none;  
}
p{
    font-size: 1em;
    margin-top:25px;
    margin-left:450px;
}
.list-btn{
    margin-top:20px;
    margin-left:30%;
}
.modify-btn{
    margin-right: 5px;
}
.remove-btn{
    color:grey;
}
.bar{
    height:80px;
    padding: 20px;   
    background-color:#FFD54F;
    margin-bottom:50px;
}
.text{
    font-family: 'Nanum Brush Script', cursive;
    font-size:18px;
}

    
</style>