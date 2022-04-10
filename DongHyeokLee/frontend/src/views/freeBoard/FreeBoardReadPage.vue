<template>
    <div>
        <!-- 리스트로 돌아가기 -->
        <router-link :to="{ name: 'FreeBoardListPage' }">
            <p>자유게시판</p>
        </router-link>
        
        <free-board-read v-if="freeBoard" :freeBoard="freeBoard"/>
        <p v-else>로딩중 ....... </p>
       
        <div class = "button">
            <router-link class="modify-btn" v-if="$store.state.userInfo.nickname == freeBoard.writer" 
                            :to="{ name: 'FreeBoardModifyPage', params: { boardNo } }">
                수정
            </router-link>
            
            <button class="delete-btn" v-if="$store.state.userInfo.nickname == freeBoard.writer" @click="onDelete">삭제</button>
        
            <router-link class="list-btn" :to="{ name: 'FreeBoardListPage' }">
                목록
            </router-link>
          
        </div>

           <!-- 댓글-->
        <free-board-comment :boardNo="this.boardNo"/>  
    
        
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
        padding: 10px;
         margin-left: 57%;
    }

    a{
        text-decoration: none;
    }

    a:hover{
        text-decoration: none; 
    }


    p{
        font-size: 1em;
        padding:  15px;
        margin-left:400px;
    }
    .modify-btn {
        color: black;
        
        
    }
    .delete-btn{
        color: red;
       
    }
    
    
</style>