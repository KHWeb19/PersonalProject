<template>
    <div>
        <!-- 리스트로 돌아가기 -->
        <router-link :to="{ name: 'FreeBoardListPage' }">
            <p>자유게시판</p>
        </router-link>
        
        <free-board-read v-if="freeBoard" :freeBoard="freeBoard"/>
        <p v-else>로딩중 ....... </p>
       
        <!-- 댓글-->
        <free-board-comment :boardNo="this.boardNo"/>  
        
        <div class = "button">
            <router-link v-if="$store.state.userInfo.nickname == freeBoard.writer" 
                            :to="{ name: 'FreeBoardModifyPage', params: { boardNo } }">
                게시물 수정
            </router-link>
            
            <button v-if="$store.state.userInfo.nickname == freeBoard.writer" @click="onDelete">삭제</button>
            
            <router-link :to="{ name: 'FreeBoardListPage' }">
                목록 보기
            </router-link>
        </div>
    
        
    </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import FreeBoardRead from '@/components/freeBoard/FreeBoardRead.vue'
import FreeBoardComment from '@/views/freeBoard/FreeBoardComment.vue'

export default {
    name: 'FreeBoardReadPage',
    data () {
        return {
            writer:'',
            content:''

        }
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        FreeBoardRead,
        FreeBoardComment
    },
     computed: {
        ...mapState(['freeBoard'])
    },
    created () {
        this.fetchFreeBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
         
    },
    methods: {
        ...mapActions(['fetchFreeBoard']),
        onDelete () {
            const boardNo= this.boardNo
            axios.delete(`http://localhost:7777/freeBoard/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'FreeBoardListPage' })
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