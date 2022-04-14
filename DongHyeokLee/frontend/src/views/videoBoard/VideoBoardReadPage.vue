<template>
    <div>   
      <board-read v-if=videoBoard   :board="videoBoard"
                                    :boardNo="boardNo"
                                    :boardName="`${this.boardName}`"
                                    :listPage="listPage"
                                    :accept="accept"
                                    :modifyPage="modifyPage"/>
        <!-- 댓글 -->              
        <video-board-comment :boardNo="this.boardNo"/>
    </div>
</template>

<script>

import { mapActions, mapState } from 'vuex'
import axios from 'axios'

import BoardRead from '@/components/common/board/BoardRead.vue'
import VideoBoardComment from '@/views/videoBoard/VideoBoardComment.vue'

export default {
    name: 'VideoBoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    data () {
    return {
        listPage: 'VideoBoardListPage',
        modifyPage: 'VideoBoardModifyPage',
        boardName: 'videoBoard',
        accept: 'mp4'
    }
    },
    components: {
        BoardRead,
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