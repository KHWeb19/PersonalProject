<template>
    <div>   
         <!-- 리스트로 돌아가기 -->
        <router-link :to="{ name: 'PhotoBoardListPage' }">
            <p>사진게시판</p>
        </router-link>
        
        <photo-board-read v-if=photoBoard :photoBoard="photoBoard"/>

         <!-- 댓글-->
        <photo-board-comment :boardNo="this.boardNo"/>

        <div class = "button">
            <router-link v-if="$store.state.userInfo.nickname == photoBoard.writer" 
                            :to="{ name: 'PhotoBoardModifyPage', params: { boardNo } }">
                게시물 수정
            </router-link>
            
            <button v-if="$store.state.userInfo.nickname == photoBoard.writer" @click="onDelete">삭제</button>
            
            <router-link :to="{ name: 'PhotoBoardListPage' }">
                목록 보기
            </router-link>
        </div>
        
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