<template>
    <div>   
         <!-- 리스트로 돌아가기 -->
        <router-link :to="{ name: 'VideoBoardListPage' }">
            <p>사진게시판</p>
        </router-link>
        
        <video-board-read v-if=videoBoard :videoBoard="videoBoard"/>

         <!-- 댓글-->
        <video-board-comment :boardNo="this.boardNo"/>

        <div class = "button">
            <router-link v-if="$store.state.userInfo.nickname == videoBoard.writer" 
                            :to="{ name: 'VideoBoardModifyPage', params: { boardNo } }">
                게시물 수정
            </router-link>
            <!-- 삭제해도 db에서 fileName은 날아가는데 vue에 저장 된 파일 자체는 안 날아가는 형태라 고민되네 -->
            <button v-if="$store.state.userInfo.nickname == videoBoard.writer" @click="onDelete">삭제</button>
            
            <router-link :to="{ name: 'VideoBoardListPage' }">
                목록 보기
            </router-link>
        </div>
        
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
    margin-left: 30%;
}

a{
    text-decoration: none;
    
}

p{
    font-size: 1em;
    padding:  15px;
    margin-left:400px;
}

    
</style>