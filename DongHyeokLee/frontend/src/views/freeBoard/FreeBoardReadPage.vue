<template>
    <div>
        <router-link :to= "{ name: 'FreeBoardListPage' }">
            <p>자유게시판</p>
        </router-link>
        <free-board-read v-if="freeBoard" :freeBoard="freeBoard"/>
        <p v-else>로딩중 ....... </p>
        <router-link :to="{ name: 'FreeBoardModifyPage', params: { boardNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'FreeBoardListPage' }">
            게시물 보기
        </router-link>
        
            <free-board-comments-list-form :freeBoardComments="freeBoardComments" @submit="onSubmit"/>
        
        
    </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import FreeBoardRead from '@/components/freeBoard/FreeBoardRead.vue'
import FreeBoardCommentsListForm from '@/components/comments/freeBoard/FreeBoardCommentsListForm.vue'

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
        FreeBoardCommentsListForm
    },
    computed: {
        ...mapState(['freeBoard']),
        ...mapState(['freeBoardComments'])
    },
    created () {
        this.fetchFreeBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
    },
    mounted () {
        this.fetchFreeBoardCommentsList()
    },
    methods: {
        ...mapActions(['fetchFreeBoard']),
        ...mapActions(['fetchFreeBoardCommentsList']),
        onDelete () {
            const { boardNo } = this.freeBoard
            axios.delete(`http://localhost:7777/freeBoard/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'FreeBoardListPage' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        },
        onSubmit (payload) {
            const { writer, content } = payload
            const boardNo = this.freeBoard
            axios.post('http://localhost:7777/freeBoardComments/register', { writer, content, boardNo })
                    .then(() => {
                        alert('게시물 등록 성공!')
                        this.$router.go()
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}

</script>

<style scoped>

a{
    text-decoration: none;
    
}

p{
    font-size: 1em;
    padding:  15px;
    margin-left:400px;
}

    
</style>