<template>
    <div align="center">
        <h2>장보기 목록 읽기</h2>
        <jpa-board-read-2 v-if="jpaBoard2" :jpaBoard2="jpaBoard2"/>
        <p v-else>로딩중 ....... </p>
        <router-link :to="{ name: 'JpaBoardModifyPage2', params: { boardNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'JpaBoardListPage2' }">
            게시물 보기
        </router-link>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import JpaBoardRead2 from '@/components/jpaBoard2/JpaBoardRead2.vue'

export default {
    name: 'JpaBoardReadPage2',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        JpaBoardRead2
        
    },
    computed: {
        ...mapState(['jpaBoard2'])
    },
    created () {
        this.fetchJpaBoard2(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchJpaBoard2']),
        onDelete () {
            const { boardNo } = this.jpaBoard2
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/62th/board2/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'JpaBoardListPage2' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }
    }
}
</script>