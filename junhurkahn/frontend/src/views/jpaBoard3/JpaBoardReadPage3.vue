<template>
    <div align="center">
        <h2>생일관리 읽기</h2>
        <jpa-board-read-3 v-if="jpaBoard3" :jpaBoard3="jpaBoard3"/>
        <p v-else>로딩중 ....... </p>
        <router-link :to="{ name: 'JpaBoardModifyPage3', params: { boardNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'JpaBoardListPage3' }">
            게시물 보기
        </router-link>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import JpaBoardRead3 from '@/components/jpaBoard3/JpaBoardRead3.vue'


export default {
    name: 'JpaBoardReadPage3',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        JpaBoardRead3,
        
    },
    computed: {
        ...mapState(['jpaBoard3'])
    },
    created () {
        this.fetchJpaBoard3(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchJpaBoard3']),
        onDelete () {
            const { boardNo } = this.jpaBoard3
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/62th/board3/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'JpaBoardListPage3' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }
    }
}
</script>