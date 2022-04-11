<template>
    <div id="read">
        <!-- 리스트로 돌아가기 -->
        <router-link id="list-btn" :to="{ name: 'FreeBoardListPage' }">
           <strong>자유게시판</strong>
        </router-link>
        
        <free-board-read v-if="freeBoard" :freeBoard="freeBoard"/>
        <p v-else>로딩중 ....... </p>
        <!-- 버튼 -->
        <div class = "button">
            <router-link v-if="$store.state.userInfo.nickname == freeBoard.writer" 
                            :to="{ name: 'FreeBoardModifyPage', params: { boardNo } }">
                <v-btn class="modify-btn">
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

#read{
   /* background-image: url(@/assets/img/homeBackground.png);*/
    background-size: cover;
    padding: 20px;
}

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
}
.delete-btn{
    color: black;  
}
#list-btn{
    padding: 20px;
    margin-left:425px;
}
    
</style>