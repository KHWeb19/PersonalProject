<template>
    <div align="center">
        <h2>사이트 아이디 읽기</h2>
        <jpa-board-read-4 v-if="jpaBoard4" :jpaBoard4="jpaBoard4"/>
        <p v-else>로딩중 ....... </p>
        <router-link :to="{ name: 'JpaBoardModifyPage4', params: { boardNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'JpaBoardListPage4' }">
            게시물 보기
        </router-link>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import JpaBoardRead4 from '@/components/jpaBoard4/JpaBoardRead4.vue'


export default {
    name: 'JpaBoardReadPage4',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        JpaBoardRead4,
        
    },
    computed: {
        ...mapState(['jpaBoard4'])
    },
    created () {
        this.fetchJpaBoard4(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchJpaBoard4']),
        onDelete () {
            const { boardNo } = this.jpaBoard4
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/62th/board4/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'JpaBoardListPage4' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }
    }
}
</script>