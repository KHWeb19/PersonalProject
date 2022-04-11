<template>
    <div>   
         <!-- 리스트로 돌아가기 -->
        <router-link :to="{ name: 'PhotoBoardListPage' }">
            <p>사진게시판</p>
        </router-link>
        
        <photo-board-read v-if=photoBoard :photoBoard="photoBoard"/>
        <!-- 버튼 -->
        <div class = "button">
            <router-link v-if="$store.state.userInfo.nickname == photoBoard.writer" 
                            :to="{ name: 'PhotoBoardModifyPage', params: { boardNo } }">
                 수정
            </router-link>
            <!-- 삭제해도 db에서 fileName은 날아가는데 vue에 저장 된 파일 자체는 안 날아가는 형태라 고민되네 -->
            <button v-if="$store.state.userInfo.nickname == photoBoard.writer" @click="onDelete">삭제</button>
            
        </div>
        <!-- 댓글-->
        <photo-board-comment :boardNo="this.boardNo"/>
        
    </div>
</template>

<script>

import { mapActions, mapState } from 'vuex'
import axios from 'axios'

import PhotoBoardRead from '@/components/photoBoard/PhotoBoardRead.vue'
import PhotoBoardComment from '@/views/photoBoard/PhotoBoardComment.vue'

export default {
    name: 'PhotoBoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        PhotoBoardRead,
        PhotoBoardComment
    },
    computed: {
        ...mapState(['photoBoard'])
    },
    created () {
        this.fetchPhotoBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })   
    },
    methods: {
        ...mapActions(['fetchPhotoBoard']),
          onDelete () {
            const boardNo= this.boardNo
            axios.delete(`http://localhost:7777/photoBoard/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'PhotoBoardListPage' })
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
    padding: 10px;
    margin-left: 64%;
}

a{
    text-decoration: none;
    
}

p{
    font-size: 1em;
    margin-top:25px;
    margin-left:450px;
}

    
</style>