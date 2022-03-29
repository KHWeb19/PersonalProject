<template>
    <div align="center">
        <free-board-read v-if="freeBoard" :freeBoard="freeBoard"/>
        <p v-else>로딩중 ....... </p>
        <router-link :to="{ name: 'FreeBoardModifyPage', params: { boardNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'FreeBoardListPage' }">
            게시물 보기
        </router-link>
    </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import FreeBoardRead from '@/components/freeBoard/FreeBoardRead.vue'

export default {
    name: 'FreeBoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        FreeBoardRead
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
            const { boardNo } = this.freeBoard
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