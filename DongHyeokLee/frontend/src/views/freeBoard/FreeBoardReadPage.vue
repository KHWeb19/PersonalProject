<template>
    <div class="read">
        <h2 class="bar"></h2>
        <!-- 리스트로 돌아가기 -->
        <router-link class="list-btn-wrap" :to="{ name: 'FreeBoardListPage' }">
            <v-btn class="list-btn" color="amber lighten-2">
               <strong class="text">자유게시판</strong>
            </v-btn>
        </router-link>
        
        <free-board-read v-if="freeBoard" :freeBoard="freeBoard"/>
        <p v-else>로딩중 ....... </p>
        <!-- 버튼 -->
        <div class = "button">
            <router-link v-if="$store.state.userInfo.nickname == freeBoard.writer" 
                            :to="{ name: 'FreeBoardModifyPage', params: { boardNo } }">
                <v-btn class="modify-btn" color="amber lighten-2">
                <strong>수정</strong>
                </v-btn>
            </router-link>
            
            <v-btn class="delete-btn" v-if="$store.state.userInfo.nickname == freeBoard.writer" @click="onDelete">
                <strong>삭제</strong>
            </v-btn>
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
    margin-left: 900px;
}
a{
    text-decoration: none;
}
a:hover{
    text-decoration: none; 
}

.modify-btn {
    color: black;
    margin-right: 5px;   
}
.delete-btn{
    color: grey;  
}
.list-btn-wrap{
    padding: 20px;
    margin-left:425px; 
    
}
.bar{
    height:80px;
    padding: 20px;   
    background-color:#FFD54F;
    margin-bottom:50px;
}
.text{
     font-family: 'Nanum Brush Script', cursive;
     font-size: 18px;
}



    
</style>