<template>
    <div align="center">
        <h2>Vue + Spring 게시판 읽기</h2>
        <tip-read-form v-if="tipBoard" :tipBoard="tipBoard"/>
        <p v-else>로딩중 ....... </p>

        <router-link :to="{ name: 'TipModifyPage', params: { boardNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'livingTipBoardList' }">
            돌아가기
        </router-link>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import TipReadForm from '@/components/livingTip/TipReadForm.vue'
export default {
    name: 'TipReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        TipReadForm
    },
    computed: {
        ...mapState(['tipBoard'])
    },
    created () {
        this.fetchTipBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchTipBoard']),
        onDelete () {
            const { boardNo } = this.tipBoard
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/tipboard/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'livingTipBoardList' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }        
    }
}
</script>