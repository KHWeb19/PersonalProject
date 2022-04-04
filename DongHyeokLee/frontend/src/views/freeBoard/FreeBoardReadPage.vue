<template>
    <div>
        <router-link :to="{ name: 'FreeBoardListPage' }">
            <p>자유게시판</p>
        </router-link>
        <free-board-read v-if="freeBoard" :freeBoard="freeBoard"/>
        <p v-else>로딩중 ....... </p>
        <!-- 댓글-->
        <free-board-comments-list :boardNo="this.boardNo"/>  
        <!--게시판 수정 -->
        <div class = "button">
        <router-link :to="{ name: 'FreeBoardModifyPage', params: { boardNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'FreeBoardListPage' }">
            게시물 보기
        </router-link>
        </div>
    
        
    </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import FreeBoardRead from '@/components/freeBoard/FreeBoardRead.vue'
import FreeBoardCommentsList from '@/views/comments/freeBoard/FreeBoardCommentsList.vue'

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
        FreeBoardCommentsList
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