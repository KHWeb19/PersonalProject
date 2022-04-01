<template>
    <div align="center">
        <h2>Vue + Spring 게시판 읽기</h2>
        <jpa-board-read-1 v-if="jpaBoard1" :jpaBoard1="jpaBoard1"/>
        <p v-else>로딩중 ....... </p>
        <router-link :to="{ name: 'JpaBoardModifyPage1', params: { boardNo1 } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'JpaBoardListPage1' }">
            게시물 보기
        </router-link>
    </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import JpaBoardRead1 from '@/components/jpaBoard1/JpaBoardRead1.vue'

export default {
    name: 'JpaBoardReadPage1',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        JpaBoardRead1
    },
    computed: {
        ...mapState(['jpaBoard1'])
    },
    created () {
        this.fetchJpaBoard(this.boardNo1)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchJpaBoard']),
        onDelete () {
            const { boardNo1 } = this.jpaBoard1
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/62th/board1/${boardNo1}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'JpaBoardListPage1' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }
    }
}

</script>